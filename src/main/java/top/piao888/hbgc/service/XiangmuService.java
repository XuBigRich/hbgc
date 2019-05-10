package top.piao888.hbgc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.piao888.hbgc.cache.CacheManager;
import top.piao888.hbgc.converter.ProjectDTO2OProjectRes;
import top.piao888.hbgc.domain.Base;
import top.piao888.hbgc.domain.Money;
import top.piao888.hbgc.domain.Project;
import top.piao888.hbgc.domain.Projectfile;
import top.piao888.hbgc.dto.ProjectDTO;
import top.piao888.hbgc.dto.ProjectMessageDTO;
import top.piao888.hbgc.mapper.MoneyMapper;
import top.piao888.hbgc.mapper.ProjectMapper;
import top.piao888.hbgc.mapper.ProjectfileMapper;
import top.piao888.hbgc.util.ProjectUtill;
import top.piao888.hbgc.vo.Project.ProjectRes;

import java.util.ArrayList;
import java.util.List;
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
    private ProjectfileMapper projectfileMapper;
    /*
    * 立项项目信息查询 （project）  按照项目名称 项目类型  状态查询
    * 展示  ID:pno  项目类型：tid（外键）名称：name  状态：kid（外键）  审批阶段:stat  级别：vid（外键）   tim：申报时间
    * */
    public List<ProjectMessageDTO> xmlx(ProjectMessageDTO projectMessageDTO){
        List<Project> projectList=projectMapper.selectBynamOrTidOrKid(projectMessageDTO);
        ProjectMessageDTO resultDTO=new ProjectMessageDTO();
        List<ProjectMessageDTO> resultDTOList=new ArrayList<>();
        for(Project project:projectList){
            BeanUtils.copyProperties(project,resultDTO);
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
    * 项目申请
    * */
    @Transactional(propagation=Propagation.REQUIRED,readOnly = false,isolation = Isolation.DEFAULT)
    public void createProject(ProjectDTO ProjectDTO){
        Project project=new Project();
        Money money=new Money();
        List<Projectfile> projectfiles;
        Integer allCount= projectMapper.selectAllCount();
        String Pno=ProjectUtill.getPno(allCount);
        //设置项目编码P2012000001类似的格式
        ProjectDTO.setPno(Pno);
        BeanUtils.copyProperties(ProjectDTO,project);
        projectMapper.insert(project);
        Long pid=project.getPid();
        // 制造 异常 测试 事务
//        int f=1/0;
        ProjectDTO.setPid(pid.longValue());
        BeanUtils.copyProperties(ProjectDTO,money);
        moneyMapper.insert(money);
        projectfiles=ProjectDTO.getProjectfiles();
        projectfiles=projectfiles.stream().peek(e->e.setPid(pid.longValue())).collect(Collectors.toList());
        for(int i=0;i<projectfiles.size();i++){
            projectfileMapper.insert(projectfiles.get(i));
        }
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
    public void updateProject(ProjectDTO projectDTO){
        Project project=new Project();
        Money money=new Money();
        List<Projectfile> projectfiles;
        BeanUtils.copyProperties(projectDTO,project);
        projectMapper.updateByPrimaryKey(project);
        BeanUtils.copyProperties(projectDTO,money);
        moneyMapper.updateByPrimaryKey(money);
        projectfiles=projectDTO.getProjectfiles();
        projectfiles=projectfiles.stream().peek(e->e.setPid(projectDTO.getPid().longValue())).collect(Collectors.toList());
        for(int i=0;i<projectfiles.size();i++){
            projectfileMapper.insert(projectfiles.get(i));
        }
    }
    public void deleteProjectfile(Long pfid) {
        projectfileMapper.deleteByPrimaryKey(pfid);
    }
}
