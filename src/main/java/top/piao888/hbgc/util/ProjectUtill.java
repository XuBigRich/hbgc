package top.piao888.hbgc.util;

import java.util.Calendar;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PnoUtill.java
 * @Description TODO
 * @createTime 2019年05月07日 18:30:00
 */
public class ProjectUtill {
    public static String getPno(Integer count){
        String PNO="P%s";
        Integer PNONUBER=Calendar.getInstance().get(Calendar.YEAR)*1000000+count;
        return String.format(PNO,String.valueOf(PNONUBER));
    }
}
