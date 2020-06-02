package top.piao888.hbgc.contruller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TJContruller.java
 * @Description TODO
 * @createTime 2019年04月24日 18:04:00
 */
@RequestMapping("tj")
public class TJContruller {
    @GetMapping("/lixiang")
    public String lixiang(){
        return null;
    }
    @GetMapping("/rcgzTJ")
    public String rcgzTJ(){
        return null;
    }
    @GetMapping("/yanshou")
    public String yanshou(){
        return null;
    }
    @GetMapping("/zijin")
    public String zijin(){
        return null;
    }
}
