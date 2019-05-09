package top.piao888.hbgc.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.piao888.hbgc.constant.CookieConstant;
import top.piao888.hbgc.constant.RedisConstant;
import top.piao888.hbgc.util.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AuthorizeAspect.java
 * @Description TODO
 * @createTime 2019年05月01日 18:14:00
 */
//@Aspect
@Component
@Slf4j
public class AuthorizeAspect {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Pointcut("execution(public * top.piao888.hbgc.contruller.*.*(..))"+"&&!execution(public * top.piao888.hbgc.contruller.LASContruller.*(..))"+"&&!execution(public * top.piao888.hbgc.contruller.TestContruller.*(..))")
    public void verify(){}
    @Before("verify()")
    public void doverify(){
        ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //查询cookie
        Cookie cookie=CookieUtil.get(request,CookieConstant.TOKEN);
        if(cookie==null){
            log.warn("【登陆校验】 Cookie中查不到token)");
        }
        String result= redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        if(StringUtils.isEmpty(result)){
            log.warn("【登陆校验】 Redis中查不到token");
        }
    }
}
