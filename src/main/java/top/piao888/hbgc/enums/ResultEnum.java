package top.piao888.hbgc.enums;

import lombok.Getter;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ResultEnmus.java
 * @Description TODO
 * @createTime 2019年04月23日 15:50:00
 */
@Getter
public enum ResultEnum {
    LOGIN_FAIL_ACT(0,"用户未激活！"),
    LOGIN_FAIL(1,"账号或密码错误！"),
    SENA_FAIL(2,"账号申报错误！")
    ;
    private Integer code;
    private String message;

    ResultEnum(int code, String message) {
        this.code=code;
        this.message=message;
    }
}
