package top.piao888.hbgc.contruller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.piao888.hbgc.service.XTService;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserContruller.java
 * @Description 系统管理
 * @createTime 2019年04月24日 16:40:00
 */
@RequestMapping("/xt")
public class XTContruller {
    private XTService xtService;
    /*
    * 部门管理
    * */
    @GetMapping("/allDept")
    public String allDept(){

        return null;
    }
    /*
    * 用户管理
    * */
    @GetMapping("/allUser")
    public String allUser(){
        return null;
    }
    /*
    * 角色-权限管理
    * */
    @GetMapping("/allRoles")
    public String allRoles(){
        return null;
    }
    /*
    * 申报账号管理
    * */
    @GetMapping("/senaManage")
    public String senaManage(){
        return null;
    }
    /*
    * 数据字典管理
    * */
    @GetMapping("/allbase")
    public String allbase(){
        return null;
    }
}
