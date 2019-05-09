package top.piao888.hbgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import top.piao888.hbgc.service.CacheServiceImpl;
//开启定时任务
@EnableScheduling
@SpringBootApplication
//@ComponentScan(basePackages={"top.piao888.hbgc.domain"})
@MapperScan("top.piao888.hbgc.mapper")
public class HbgcApplication {
    public static void main(String[] args) {
        SpringApplication.run(HbgcApplication.class, args);
    }

}

