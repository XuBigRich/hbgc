package top.piao888.hbgc.vo;

import lombok.Data;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName LXCXForm.java
 * @Description 项目立项查询
 * @createTime 2019年04月28日 18:50:00
 */
@Data
public class ProjectUpSelectVo {
    /*项目名称*/
    private String name;
    /*项目状态*/
    private Long kid;
    /*项目类型*/
    private Long tid;

}
