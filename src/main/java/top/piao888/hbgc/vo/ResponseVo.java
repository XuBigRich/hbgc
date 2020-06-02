package top.piao888.hbgc.vo;

import lombok.Data;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ResultVo.java
 * @Description TODO
 * @createTime 2019年04月27日 14:49:00
 */
@Data
public class ResponseVo<T> {
    private Integer code;
    private String message;
    private T object;

}
