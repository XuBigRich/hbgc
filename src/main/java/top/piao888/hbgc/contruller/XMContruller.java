package top.piao888.hbgc.contruller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.piao888.hbgc.converter. ProjectReq2OProjectDTO;
import top.piao888.hbgc.converter.LXCXForm2OProjectMessageDTO;
import top.piao888.hbgc.converter.ProjectDTO2OProjectRes;
import top.piao888.hbgc.converter.ProjectRes2OProjectDTO;
import top.piao888.hbgc.domain.Money;
import top.piao888.hbgc.dto.ProjectDTO;
import top.piao888.hbgc.dto.ProjectMessageDTO;
import top.piao888.hbgc.service.XiangmuService;
import top.piao888.hbgc.util.ResultVoUtil;
import top.piao888.hbgc.vo.Project.ProjectReq;
import top.piao888.hbgc.vo.Project.ProjectRes;
import top.piao888.hbgc.vo.request.ProjectUpSelectVo;
import top.piao888.hbgc.vo.ResponseVo;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName XMContruller.java
 * @Description TODO
 * @createTime 2019年04月24日 18:12:00
 */
@RestController
@RequestMapping("/xm")
public class XMContruller {
    @Autowired
    private XiangmuService xiangmuService;
    /*创建市级项目前*/
    @GetMapping("beforecreatecount")
    public ResponseVo beforecreatecount(ProjectReq ProjectReq){
        return new ResponseVo();
    }
    /*创建区级项目前*/
    @GetMapping("beforecreatecity")
    public ResponseVo beforecreatecity(ProjectReq ProjectReq){

        return new ResponseVo();
    }
    /*创建市级项目*/
    @PostMapping("createcity")
    public ResponseVo createProject(ProjectReq ProjectReq){
        ProjectDTO ProjectDTO =  ProjectReq2OProjectDTO.convert(ProjectReq);
        xiangmuService.createProject(ProjectDTO);
        return new ResponseVo();
    }
    @GetMapping("/alldept")
    public String allDept(){
        return null;
    }
    /*查询所有项目*/
    @PostMapping("/findproject")
    public ResponseVo<List> findProject(ProjectUpSelectVo projectUpSelectVo){
        ProjectMessageDTO projectMessageDTO=LXCXForm2OProjectMessageDTO.convert(projectUpSelectVo);
        List<ProjectMessageDTO> projectMessageDTOList=xiangmuService.xmlx(projectMessageDTO);
        return ResultVoUtil.success(projectMessageDTOList);
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
    @GetMapping("updateproject")
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
