package top.piao888.hbgc.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CreateProjectVo.java
 * @Description TODO
 * @createTime 2019年05月02日 08:58:00
 */
@Data
public class CreateProjectVo {
    /*项目类型ID，外键  -- pid 1  bid= 12-23*/
    private Long tid;
    /*所属区县ID，外键  --pid=3   bid=33-45*/
    private Long cid;
    /*县牵头部门ID，部门外键   -- bid=72*/
    private Long fdid;
    /*市牵头部门ID，部门外键  -- bid=74*/
    private Long cdid;
    /*建设单位ID，部门外键 -- bid=71  80-81*/
    private Long bid;
    /*项目级别ID，外键，分为：区县级项目，市级项目   -- pid=8  bid=61-62*/
    private Long vid;
    /*申请补助金类型ID 外键：                       --pid=10 bid=67-69*/
    private Long stat=0L;
    /*项目状态ID，外键                        --pid =4  bid=46 - 48*/
    private Long kid;
    /*项目概述 */
    private String mary;
    /*项目名称*/
    private String name;
    /*项目地址*/
    private String ress;
    /*纬度*/
    private String lat;
    /*经度*/
    private String lon;
    /*预计 开工时间*/
    private Date star;
    /*预计 结束时间(验收时间)*/
    private Date en;
    /*投资构成说明*/
    private String detail;
    /*申请补助金*/
    private Long mon;
    /*项目负责人*/
    private String head;
    /*负责人联系电话*/
    private String mob;
    /*项目概述*/
    private String des;

    //==============================
    /*primary key  */
    // private Long pfid;
    /*项目ID，外键*/
    //private Long pid;
    //==============================
/*    *//*文件名称*//*
    private String fn;*/
    /*文件对象*/
    private MultipartFile[] files;
 /*   *//*文件类型*//*
    private String tp;
    *//*文件大小*//*
    private String siz;*/
    //==============================
    /*项目ID，外键*/
    //private Long pid;
    //==============================
    /*国家拨款*/
    private Long cou;
    /*省拨款*/
    private Long pro;
    /*市拨款*/
    private Long city;
    /*县拨款*/
    private Long dist;
    /*企业配套资金private */
    private Long com;
}
