package top.piao888.hbgc.contruller;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.piao888.hbgc.constant.BaseConstant;
import top.piao888.hbgc.converter.*;
import top.piao888.hbgc.domain.Base;
import top.piao888.hbgc.domain.Money;
import top.piao888.hbgc.domain.Step;
import top.piao888.hbgc.dto.ProjectDTO;
import top.piao888.hbgc.dto.ProjectMessageDTO;
import top.piao888.hbgc.service.XiangmuService;
import top.piao888.hbgc.util.CookieUtil;
import top.piao888.hbgc.util.ResultVoUtil;
import top.piao888.hbgc.vo.Project.ProjectReq;
import top.piao888.hbgc.vo.Project.ProjectRes;
import top.piao888.hbgc.vo.request.ProjectUpSelectVo;
import top.piao888.hbgc.vo.ResponseVo;
import top.piao888.hbgc.vo.request.StepReq;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName XMContruller.java
 * @Description TODO
 * @createTime 2019年04月24日 18:12:00
 */
@Controller
@RequestMapping("/xm")
public class XMContruller {
    @Autowired
    private XiangmuService xiangmuService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    /*创建市级项目前*/
    @GetMapping("beforecreatecount")
    public ResponseVo beforecreatecount(ProjectReq ProjectReq){
        return new ResponseVo();
    }
    /*创建区级项目前*/
    @GetMapping("beforecreatecity")
    public ResponseVo beforecreatecity(ProjectReq projectReq,Cookie cookie){
        projectReq.setVid(61L);

        ProjectDTO projectDTO =  ProjectReq2OProjectDTO.convert(projectReq);
        xiangmuService.createProject(projectDTO,cookie);
        return new ResponseVo();
    }
    /*创建县级项目*/
    @GetMapping("createdistprojectbefore")
    @ResponseBody
    public ResponseVo createDistProjectbefore(){
        Map vid=new HashMap();
        vid.put("vid",BaseConstant.XMJB1);
        vid.put("dname","杭州市城建局");
        vid.put("did",77);
        return ResultVoUtil.success(vid);
    }
    /*创建市级项目*/
    @GetMapping("createcityprojectbefore")
    public ResponseVo createCityProjectbefore(){
        Map vid=new HashMap();
        vid.put("vid",BaseConstant.XMJB2);
        return ResultVoUtil.success(vid);
    }
    /*选择县级地区牵头部门   使用Ajax发送请求 时调用*/
    @GetMapping("selectHeadDept")
    public ResponseVo selectHeadDept(Long bid){
        Map dept=xiangmuService.selectHeadDept(bid);
        return ResultVoUtil.success(dept);
    }
    /*项目审批*/
    @GetMapping("proCheck")
    public ResponseVo proCheck(StepReq stepReq){
        Step step=StepReq2OStep.convert(stepReq);
        xiangmuService.proCheck(step);
        return null;
    }
    /*创建市级项目*/
    @PostMapping("createproject")
    public ResponseVo createProject(ProjectReq projectReq,HttpServletRequest request){
        Cookie[] cookie=request.getCookies();
        ProjectDTO projectDTO =  ProjectReq2OProjectDTO.convert(projectReq);
        xiangmuService.createProject(projectDTO,cookie[0]);
        return new ResponseVo();
    }

    @GetMapping("/alldept")
    public String allDept(){
        return null;
    }
    /*项目立项按钮 会查询所有项目 并 可以通过查询条件查询*/
    @GetMapping("/allProject")
    public String findProject(HttpServletRequest req, ProjectUpSelectVo projectUpSelectVo, Model model){
        Cookie cookie= CookieUtil.get(req);
        ProjectMessageDTO projectMessageDTO=LXCXForm2OProjectMessageDTO.convert(projectUpSelectVo);
        List<ProjectMessageDTO> projectMessageDTOList=xiangmuService.xmcx(projectMessageDTO,cookie);
        HashMap hashMap=new HashMap();
        hashMap.put("project",projectMessageDTOList);
        hashMap.put("state",null);
        model.addAttribute(hashMap);
        return "projectapproval";
    }
    /*资金信息*/
    @GetMapping("findmoney")
    public ResponseVo<Money> findMoney(Long pid){
        Money money=xiangmuService.selectMoney(pid);
        return ResultVoUtil.success(money);
    }
    /*项目修改前*/
    @GetMapping("updatebeforeproject")
    public ResponseVo beforeUpdateProject(Long pid){
        ProjectDTO projectDTO= xiangmuService.beforeUpdateProject(pid);
        ProjectRes projectRes=ProjectDTO2OProjectRes.convert(projectDTO);
        return ResultVoUtil.success(projectRes);
    }
    /*项目修改*/
    @PostMapping("updateproject")
    public ResponseVo UpdateProject(ProjectRes projectRes){
        ProjectDTO projectDTO=ProjectRes2OProjectDTO.convert(projectRes);
        xiangmuService.updateProject(projectDTO);
        return ResultVoUtil.success(projectRes);
    }
    @GetMapping("deleteprojectfile")
    public void deleteprojectfile(Long pfid){
       xiangmuService.deleteProjectfile(pfid);
    }
    @GetMapping("/riChang")
    public String riChang(){
        return null;
    }
    @GetMapping("/allYan")
    public String allYan(){
        return null;
    }
}
