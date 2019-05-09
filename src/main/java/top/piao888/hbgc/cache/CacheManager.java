package top.piao888.hbgc.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author admin
 * @version 1.0.0
 * @createTime 2019年04月30日 11:43:00
 */
public class CacheManager<T> {
    /*
    * 緩存  使用线程安全的 ConcurrentHashMap
    * */

    public static final Map<String,Object> CACHE=new ConcurrentHashMap<>();

    /**
     * 查询
     * @param key 常量key
     * @return 被缓存的常量值
     */
    public static Object get(String key){
        return CACHE.get(key);
    }

    /**
     * 添加或更新
     * @param key 常量key
     * @param value 要缓存的常量值
     */
    public static void addOrUpdate(String key,Object value){
        CACHE.put(key,value);
    }

//    public static void
}
