package top.piao888.hbgc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.piao888.hbgc.cache.CacheManager;
import top.piao888.hbgc.constant.BaseConstant;
import top.piao888.hbgc.constant.RedisConstant;
import top.piao888.hbgc.constant.RolesConstant;
import top.piao888.hbgc.constant.StepConstant;
import top.piao888.hbgc.converter.ProjectDTO2OProjectRes;
import top.piao888.hbgc.domain.*;
import top.piao888.hbgc.dto.ProjectDTO;
import top.piao888.hbgc.dto.ProjectMessageDTO;
import top.piao888.hbgc.mapper.*;
import top.piao888.hbgc.util.ProjectUtill;
import top.piao888.hbgc.vo.Project.ProjectRes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName XiangmuService.java
 * @Description TODO
 * @createTime 2019年04月28日 18:35:00
 */
@Service
public class XiangmuService {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private MoneyMapper moneyMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private ProjectfileMapper projectfileMapper;
    @Autowired
    private AccsMapper accsMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private StepMapper stepMapper;
    @Autowired
    private ApplyMapper applyMapper;
    /*
    * 立项项目信息查询 （project）  按照项目名称 项目类型  状态查询
    * 展示  ID:pno  单位类型：tid（外键）名称：name  状态：kid（外键）  审批阶段:stat  级别：vid（外键）   tim：申报时间
    * */
    public List<ProjectMessageDTO> xmcx(ProjectMessageDTO projectMessageDTO,Cookie cookie){
        String sessionkey=cookie.getValue();
        String session=redisTemplate.opsForValue().get(sessionkey);
        /*session缓存的是aid*/
        Long result= Long.parseLong(session);
        List<ProjectMessageDTO> resultDTOList=new ArrayList<>();
        Accs accs=accsMapper.selectByPrimaryKey(result);
        Long did=accs.getDid();
        Dept dept=deptMapper.selectByPrimaryKey(did);
        Long rid=accs.getRid();   //单位类型   申报-建设-牵头-生态办
        Long bid=dept.getBid();  //所属区县
        projectMessageDTO.setBid(bid);
        /*1.县牵头部门登录后，可以查看属于该部门的待审项目。
        县牵头部门登录后,可以查看项目资金信息，查看历史审批记录。
        县牵头部门可以进行项目审核，在审核过程中除填写审核意见外，可上传附件。*/
        if(rid==BaseConstant.DWLB3){
            /*如果当前状态是项目申请状态 由牵头部门确定*/
         /*   if(kid=25&&curdid=xxx){}
            projectMessageDTO.
            resultDTOList=cx(projectMessageDTO);*/
        }
        /*2.县生态办和市牵头部门登录后，可以查看到该县区申报项目和下属单位申报项目。
        县生态办和市牵头部门登录后，可以查看县级或市级项目资金、项目审核、历史审核记录，项目信息。
        县生态办和市牵头部门审核后，不能再次审核，项目进入市生态办审核,审核时可上传附件。*/
        if(rid==BaseConstant.DWLB4||rid==BaseConstant.DWLB5){
            resultDTOList=cx(projectMessageDTO);
        }
        //3.如果是市生态办  可以查看到该环节的所有待审项目。
        if(rid==BaseConstant.DWLB6){
            resultDTOList=cx(projectMessageDTO);
        }
        //4.如果是申报单位 只可以查看自己的申报项目
        if(rid==BaseConstant.DWLB1){
           projectMessageDTO.setAaid(result);
           resultDTOList=cx(projectMessageDTO);
        }
        /*如果是超级管理员 那可就牛逼了*/
        if(rid==RolesConstant.XTGLY) resultDTOList=cx(projectMessageDTO);
        return resultDTOList;
    }
    /*由项目查询调用 负责根据条件查询*/
    public List<ProjectMessageDTO> cx(ProjectMessageDTO projectMessageDTO){
        List<Project> projectList=projectMapper.selectBynamOrTidOrKid(projectMessageDTO);
        ProjectMessageDTO resultDTO=new ProjectMessageDTO();
        List<ProjectMessageDTO> resultDTOList=new ArrayList<>();
        for(Project project:projectList){
            BeanUtils.copyProperties(project,resultDTO);
            /*CacheManager 会 缓存 Base表中的bid 和name*/
            //这个地方作用是通过bid 展现出 他是什么级别的项目
            String LevelDes=((Base)(CacheManager.get(project.getVid().toString()))).getName();
            String StatDes=((Base)CacheManager.get(project.getStat().toString())).getName();
            resultDTO.setLevelDes(LevelDes);
            resultDTO.setStatDes(StatDes);
            resultDTOList.add(resultDTO);
        }
        return resultDTOList;
    }
    /*
    * 项目立项->资金信息
    * */
    public Money selectMoney(Long pid){
        return  moneyMapper.selectByPrimaryKey(pid);
    }
    /*
    * 项目创建申请
    * */
    @Transactional(propagation=Propagation.REQUIRED,readOnly = false,isolation = Isolation.DEFAULT)
    public void createProject(ProjectDTO ProjectDTO,Cookie cookie){
        /*从seesion中取出当前用户登陆信息*/
        Long result= Long.parseLong(redisTemplate.opsForValue().get(cookie.getValue()));
        Accs accs=accsMapper.selectByPrimaryKey(result);
        /*审批状态  未上报  */
        ProjectDTO.setStat(BaseConstant.SPZT6);  //初始默认值未上报
        /*项目状态ID，外键       草拟                 --pid =4  bid=46 - 48*/
        ProjectDTO.setKid(BaseConstant.CN);
        Project project=new Project();
        Money money=new Money();
        List<Projectfile> projectfiles;
        /*查询出 所有 项目*/
        Integer allCount= projectMapper.selectAllCount();
        String Pno=ProjectUtill.getPno(allCount);
        //设置项目编码P2012000001类似的格式
        ProjectDTO.setPno(Pno);
        BeanUtils.copyProperties(ProjectDTO,project);
        /*添加项目*/
        projectMapper.insert(project);
        Long pid=project.getPid();
        // 制造 异常 测试 事务
//        int f=1/0;
        ProjectDTO.setPid(pid.longValue());
        BeanUtils.copyProperties(ProjectDTO,money);
        /*添加项目资金*/
        moneyMapper.insert(money);
        projectfiles=ProjectDTO.getProjectfiles();
        if(projectfiles!=null){
            projectfiles=projectfiles.stream().peek(e->e.setPid(pid.longValue())).collect(Collectors.toList());
            for(int i=0;i<projectfiles.size();i++){
                /*添加项目附件*/
                projectfileMapper.insert(projectfiles.get(i));
            }
        }
        /*项目申报表 建立项目与单位 关系*/
        Apply apply=new Apply();
        BeanUtils.copyProperties(ProjectDTO,apply);
        apply.setAaid(accs.getAid());
        apply.setDid(accs.getDid());
        applyMapper.insert(apply);
    }
    /*
     * 当申请 单位点击申报时  添加项目审批环节表   （由申报单位操作）
     * */
    public void createstep() {
        Step step = new Step();
//        step.setPid(pid);
        step.setTim(new Date());
        stepMapper.insert(step);
    }
    /*
    * 当公示三天后 市环保单位 点击立项 建立  项目进度报告表  (由市环保单位操作)
    * */
    public void createreport(){
        Report report=new Report();
    }


    public ProjectDTO beforeUpdateProject(Long pid){
        ProjectDTO projectDTO=new ProjectDTO();
        Project project=projectMapper.selectByPrimaryKey(pid);
        Money money= moneyMapper.selectByPrimaryKey(pid);
        List<Projectfile> projectfiles=projectfileMapper.selectByPid(pid);
        BeanUtils.copyProperties(project,projectDTO);
        BeanUtils.copyProperties(money,projectDTO);
        projectDTO.setProjectfiles(projectfiles);
       return projectDTO;
    }

    /**
     * 查询区县牵头部门
     * @param bid
     * @return
     */
    public Map selectHeadDept(Long bid){
        Dept dept=new Dept();
        dept.setBid(bid);
        dept.setTid(BaseConstant.DWLB3);
        List<Dept> depts=deptMapper.selectByBidAndTid(dept);
        Map map=new HashMap();
//        depts.stream().peek(e->map.put(e.getDid(),e.getName())).collect(Collectors.toList());
        for(int i=0;i<depts.size();i++){
            map.put(depts.get(i).getDid(),depts.get(i).getName());
        }
        return map;
    }

    /**
     * 修改项目
     * @param projectDTO  项目修改内容
     */
    public void updateProject(ProjectDTO projectDTO){
        Project project=new Project();
        Money money=new Money();
        List<Projectfile> projectfiles;
        BeanUtils.copyProperties(projectDTO,project);
        projectMapper.updateByPrimaryKey(project);
        BeanUtils.copyProperties(projectDTO,money);
        moneyMapper.updateByPrimaryKey(money);
        projectfiles=projectDTO.getProjectfiles();
        if(projectfiles!=null) {
            projectfiles = projectfiles.stream().peek(e -> e.setPid(projectDTO.getPid().longValue())).collect(Collectors.toList());
            for (int i = 0; i < projectfiles.size(); i++) {
                projectfileMapper.insert(projectfiles.get(i));
            }
        }
    }

    /**
     * 选择牵头单位  根据项目pid 选择
     * @param pid 项目 id
     * @return 项目 区域所对应的牵头部门
     */
 /*   public List<Dept> qtdw(Long pid){
        *//*通过pid查出项目*//*
        Project project=projectMapper.selectByPrimaryKey(pid);
        *//*项目级别 市级级/县级*//*
        Long vid=project.getVid();
        *//*初始化一个部门 选择 由那个 部门作为牵头单位*//*
        Dept dept=new Dept();
        *//*如果是县级项目*//*
        if(vid==BaseConstant.XMJB1){
            *//*所属区县ID，外键  *//*
            dept.setBid(project.getCid());
            *//*单位类别ID，外键，申报单位、建设单位，*//*
            dept.setTid(BaseConstant.DWLB3);
            List<Dept> depts=deptMapper.selectByBidAndTid(dept);
            return depts;
        }

        if(vid==BaseConstant.XMJB2){
            dept.setTid(BaseConstant.DWLB5);
            List<Dept> depts=deptMapper.selectByBidAndTid(dept);
            return depts;
        }
        *//*此处应该返回错误信息*//*
        return null;
    }*/

    /**
     * 删除附件文件
     * @param pfid 文件id
     */
    public void deleteProjectfile(Long pfid) {
        projectfileMapper.deleteByPrimaryKey(pfid);
    }


    /**
     * 项目立项申请--由申报单位操作  操作:点击项目申请后
     * project表 项目状态由 草拟变为 立项申请
     * apply表 添加申报人待审部门 添加最终审核部门
     * step表 建立信息
     * @param pid 项目 id
     */
    public void proApplication(Long pid){
        //=====project表项目状态由 草拟变为 立项申请
        /*通过pid查出项目*/
        Project project=projectMapper.selectByPrimaryKey(pid);
        project.setKid(BaseConstant.LXSQ);
        /*更新项目状态 变为立项申请状态 */
        projectMapper.updateByPrimaryKey(project);
        /*获取项目类型*/
        Long vid= project.getVid();
        //=====apply表 添加申报人待审部门 添加最终审核部门
        /*通过pid查出项目申报表*/
        /*如果是县级*/
        Apply apply=applyMapper.selectByPrimaryKey(pid);
        if(vid==BaseConstant.XMJB2){
            apply.setCurdid(project.getFdid());
        }
        /*如果是市级*/
        if(vid==BaseConstant.XMJB2){
            apply.setCurdid(project.getCdid());
        }
        apply.setLastid(BaseConstant.HZHBJ);
        apply.setTim(new Date());
        applyMapper.updateByPrimaryKey(apply);
        //=====step表 建立信息
        Step step=new Step();
        /*当前审批部门ID*/
        step.setPid(pid);
        step.setTid(StepConstant.LXSP);
    }

    /**
     * 项目审批--由各单位操作  点击后project状态改变apply添加申报人待审部门 等信息(点击审批通过才会触发)
     * @param step  项目审批环节表
     */
    public void proCheck(Step step){
        Project project=projectMapper.selectByPrimaryKey(step.getPid());
        Apply apply=applyMapper.selectByPrimaryKey(step.getPid());
        project.setKid(BaseConstant.LXCPZ);
        Long vid= project.getVid();
        Long pdid=null;
        /*更新项目状态 变为立项申请状态 */
        projectMapper.updateByPrimaryKey(project);
        /*如果是县级*/
        if(vid==BaseConstant.XMJB1){
            pdid= selectUpDept(project.getFdid());
        }
        /*如果是市级*/
        if(vid==BaseConstant.XMJB2){
            pdid= selectUpDept(project.getCdid());
        }
        if(pdid!=null){
        apply.setCurdid(pdid);
        applyMapper.updateByPrimaryKey(apply);
        }
//        step.setPid(pid);
//        step.set
    }
    /**
     * 查询当前审批部门的上级部门
     * @param did 单位id
     * @return
     */
    public Long selectUpDept(Long did){
        Dept dept=deptMapper.selectByPrimaryKey(did);
        return dept.getPdid();
    }
}
