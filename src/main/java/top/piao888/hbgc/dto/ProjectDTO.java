package top.piao888.hbgc.dto;

import lombok.Data;
import top.piao888.hbgc.domain.Projectfile;

import java.util.Date;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ProjectDTO.java
 * @Description TODO
 * @createTime 2019年05月02日 08:36:00
 */
@Data
public class ProjectDTO {
    /*	primary key */
    private Long pid;
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
    /*跟踪状态ID 外键：未启动、建设中、已完成          --pid=6 bid=52-57*/
    private Long sid;
    /*申请补助金类型ID 外键：                       --pid=10 bid=67-69*/
    private Long aid;
    /*审批状态ID，外键，初核，复核……                -- pid=6 bid= 52-57*/
    private Long stat;
    /*项目状态ID，外键                        --pid =4  bid=46 - 48*/
    private Long kid;
    /*项目概述 */
    private String mary;
    /*项目名称*/
    private String name;
    /*项目编码P2012000001类似的格式   *   */
    private String pno;
    /*上报年度，即提交年度，提交时修改  *   */
    private String year;
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
    /*投资总金额*/
    private Long total;
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
    //=========================================================================================
    /*项目ID，外键*/
    //private Long pid;
    //=========================================================================================
     private List<Projectfile> projectfiles;
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
