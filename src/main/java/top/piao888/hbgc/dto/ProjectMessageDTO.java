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
    private String statDes;
    /*项目级别base pid=8*/
    private String levelDes;
    /*项目状态*/
    private Long kid;
    /*项目类型*/
    private Long tid;
    /*项目id*/
    private Long pid;
}
