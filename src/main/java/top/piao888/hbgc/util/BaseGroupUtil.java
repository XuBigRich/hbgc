package top.piao888.hbgc.util;

import top.piao888.hbgc.cache.CacheManager;
import top.piao888.hbgc.domain.Base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BaseGroup.java
 * @Description TODO
 * @createTime 2019年04月30日 17:15:00
 */
public class BaseGroupUtil {
    public static List<Base> group(Long pbid){
        List<Base> bgroup= new ArrayList<>();
        for(String key:CacheManager.CACHE.keySet()){  //获取缓存中 所有key
            Base base=(Base)CacheManager.get(key);    //获取缓存中 所有value
            if(pbid==base.getPbid()){                  //判断当前value的pbid是否与 需要的pbid相等
                bgroup.add(base);                       //相等 就加入list中
            }
        }
        return bgroup;                                  //返回
    }
}
