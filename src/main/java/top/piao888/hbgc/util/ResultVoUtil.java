package top.piao888.hbgc.util;

import top.piao888.hbgc.vo.ResponseVo;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ResultVoUtil.java
 * @Description TODO
 * @createTime 2019年04月27日 14:51:00
 */
public class ResultVoUtil {
    public static ResponseVo success(Object object){
        ResponseVo<Object> resultVo = new ResponseVo();
        resultVo.setCode(200);
        resultVo.setMessage("成功");
        resultVo.setObject(object);
        return resultVo;
    }
    public static ResponseVo success(){
        return success(null);
    }
}
