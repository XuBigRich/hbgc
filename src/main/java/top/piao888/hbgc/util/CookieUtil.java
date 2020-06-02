package top.piao888.hbgc.util;

import top.piao888.hbgc.constant.CookieConstant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CookieUtill.java
 * @Description TODO
 * @createTime 2019年04月23日 15:38:00
 */
public class CookieUtil {
    public static void set(HttpServletResponse res,String key,String value,int maxAge){
       Cookie cookie=new Cookie(key,value);
       cookie.setMaxAge(maxAge);
       res.addCookie(cookie);
    }
    public static Cookie get(HttpServletRequest res){
       Cookie[] cookies= res.getCookies();
       for(Cookie cookie:cookies){
           if(cookie.getName().contains(CookieConstant.TOKEN)){
               return cookie;
           }
       }
        return null;
    }
}
