package top.piao888.hbgc.contruller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.piao888.hbgc.converter.CreateProVO2OCreateProDTO;
import top.piao888.hbgc.converter.LXCXForm2OProjectMessageDTO;
import top.piao888.hbgc.domain.Money;
import top.piao888.hbgc.dto.ProjectDTO;
import top.piao888.hbgc.dto.ProjectMessageDTO;
import top.piao888.hbgc.service.XiangmuService;
import top.piao888.hbgc.util.ResultVoUtil;
import top.piao888.hbgc.vo.CreateProjectVo;
import top.piao888.hbgc.vo.ProjectUpSelectVo;
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
    public ResponseVo beforecreatecount(CreateProjectVo createProjectVo){
        return new ResponseVo();
    }
    /*创建区级项目前*/
    @GetMapping("beforecreatecity")
    public ResponseVo beforecreatecity(CreateProjectVo createProjectVo){

        return new ResponseVo();
    }
    /*创建市级项目*/
    @PostMapping("createcity")
    public ResponseVo createProject(CreateProjectVo createProjectVo){
        ProjectDTO ProjectDTO = CreateProVO2OCreateProDTO.convert(createProjectVo);
        xiangmuService.createProject(ProjectDTO);
        return new ResponseVo();
    }
    @GetMapping("/allDept")
    public String allDept(){
        return null;
    }
    /*查询所有项目*/
    @PostMapping("/findProject")
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
    public ResponseVo beforeUpdateProject(Long pid){
       ProjectDTO projectDTO= xiangmuService.beforeUpdateProject(pid);
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
