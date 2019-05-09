package top.piao888.hbgc.converter;

import org.springframework.beans.BeanUtils;
import top.piao888.hbgc.constant.SenaConstant;
import top.piao888.hbgc.domain.Sena;
import top.piao888.hbgc.vo.ApplyAccountVo;

import java.util.Date;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ApplyForm.java
 * @Description TODO
 * @createTime 2019年04月24日 14:18:00
 */
public class ApplyForm2OSena {
    public static Sena convert(ApplyAccountVo applyForm) {
        Sena sena=new Sena();
        BeanUtils.copyProperties(applyForm,sena); // 表单 与 javaBean 的类型与名字 一致才可以复制
        sena.setTim(new Date());
        sena.setStat(SenaConstant.stat);
        return sena;
    }
}
