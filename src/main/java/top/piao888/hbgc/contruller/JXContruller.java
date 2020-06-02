package top.piao888.hbgc.contruller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName JXContruller.java
 * @Description TODO
 * @createTime 2019年04月24日 18:10:00
 */
@RequestMapping("/jx")
public class JXContruller {
    @GetMapping("/appraiser")
    public String appraiser(){
        return null;
    }
    @GetMapping("/allWater")
    public String allWater(){
        return null;
    }
    @GetMapping("/allPicture")
    public String allPicture(){
        return null;
    }
}
