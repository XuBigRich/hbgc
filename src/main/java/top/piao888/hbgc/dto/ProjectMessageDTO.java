package top.piao888.hbgc.dto;

import lombok.Data;
import top.piao888.hbgc.domain.Money;

@Data
public class ProjectMessageDTO {
    /*项目编码P2012000001类似的格式*/
    private String pno;
    /*项目名称*/
    private String name;
    /*项目状态base  pid=9*/
    private String stat;
    /*项目状态描述base  pid=9*/
    private String statDes;
    /*项目级别描述base pid=8*/
    private String levelDes;
    /*项目状态*/
    private Long kid;
    /*项目类型*/
    private Long tid;
    /*项目id*/
    private Long pid;
    /*当前登陆账号所属区县*/
    private Long bid;
    /*县牵头部门*/
    private Long fdid;
    /*市牵头部门*/
    private Long cdid;
    /*项目申请人aid*/
    private Long aaid;
}
