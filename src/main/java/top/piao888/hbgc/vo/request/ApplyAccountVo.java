package top.piao888.hbgc.vo.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ApplyDTO.java
 * @Description TODO
 * @createTime 2019年04月23日 19:18:00
 */
@Data
public class ApplyAccountVo {
    @NotEmpty(message = "unit必填")
    private String unit;
    @NotEmpty(message = "mob必填")
    private String mob;
    @NotEmpty(message = "code必填")
    private String code;
    @NotEmpty(message = "job必填")
    private String job;
    @NotEmpty(message = "fade必填")
    private String fade;
    @NotEmpty(message = "tel必填")
    private String tel;
    @NotEmpty(message = "ress必填")
    private String ress;
    @NotEmpty(message = "em必填")
    private String em;
    private Long bid;  // 表单类型 与 javaBean类型 一致才可以复制
    @NotEmpty(message = "username必填")
    private String username;
    @NotEmpty(message = "tact必填")
    private String tact;
    @NotEmpty(message = "password必填")
    private String password;
    private String des;

}
