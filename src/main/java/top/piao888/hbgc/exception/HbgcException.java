package top.piao888.hbgc.exception;

import top.piao888.hbgc.enums.ResultEnum;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Hbgc.java
 * @Description TODO
 * @createTime 2019年04月23日 15:47:00
 */
public class HbgcException extends RuntimeException {
    private Integer code;
    private String message;
    public HbgcException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();

    }
}
