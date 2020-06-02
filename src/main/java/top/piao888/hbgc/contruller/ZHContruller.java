package top.piao888.hbgc.contruller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ZHContruller.java
 * @Description TODO
 * @createTime 2019年04月24日 18:08:00
 */
@RequestMapping("/zh")
public class ZHContruller {
    @GetMapping("/allCha")
    public String allCha(){
        return null;
    }
}
