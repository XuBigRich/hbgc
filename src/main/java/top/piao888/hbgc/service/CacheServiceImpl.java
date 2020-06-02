package top.piao888.hbgc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import top.piao888.hbgc.cache.CacheManager;
import top.piao888.hbgc.constant.BaseConstant;
import top.piao888.hbgc.domain.Base;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CacheServiceImpl.java
 * @Description TODO
 * @createTime 2019年04月30日 13:57:00
 */
//作为组件被容器扫描
@Component
public class CacheServiceImpl {
    @Autowired
    private BaseServiceImpl baseService;
//    @Scheduled(cron = "0 * * * * ?")
//定义每过3秒执行任务
    @Scheduled(fixedRate = 3000)
    /*缓存Base*/
    public void init(){
        List<Base> baseList=baseService.getBaseAll();
        for(Base base:baseList) {
                CacheManager.addOrUpdate(base.getBid().toString(), base);
        }
    }
}
