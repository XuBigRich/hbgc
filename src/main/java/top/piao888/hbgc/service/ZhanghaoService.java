package top.piao888.hbgc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import top.piao888.hbgc.constant.BaseConstant;
import top.piao888.hbgc.constant.CookieConstant;
import top.piao888.hbgc.constant.RedisConstant;
import top.piao888.hbgc.domain.*;
import top.piao888.hbgc.enums.ResultEnum;
import top.piao888.hbgc.exception.HbgcException;
import top.piao888.hbgc.mapper.*;
import top.piao888.hbgc.util.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ZhanghaoService.java
 * @Description TODO
 * @createTime 2019年02月27日 14:42:00
 */
@Service
public class ZhanghaoService {
    @Autowired
    private AccsMapper accsMapper;
    @Autowired
    private FunsMapper funsMapper;
    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private BaseMapper baseMapper;
    @Autowired
    private SenaMapper senaMapper;
    /*
     * 登陆
     * */
    public Accs login(HttpServletResponse response,String username, String pas){
        /*查询库中有没有这个用户*/
        Accs accs=new Accs();
        accs.setUsername(username);
        accs.setPassword(pas);
        Accs accs1 =accsMapper.login(accs);
        if(accs1==null){
            throw new HbgcException(ResultEnum.LOGIN_FAIL);
        }

        /*鉴定权限*/
        if(accs1.getStat()==0)throw new HbgcException(ResultEnum.LOGIN_FAIL_ACT);

        /*设置cookie*/
        String token=UUID.randomUUID().toString();
        String cookiename=CookieConstant.TOKEN;
        String cookievalue=String.format(RedisConstant.TOKEN_PREFIX,token);
        Integer cookieexpire=CookieConstant.EXPIRE;
        CookieUtil.set(response,cookiename,cookievalue,cookieexpire);
        /*将cookie信息保存在redis中*/
        String redisKey=cookievalue;
        String aid=accs1.getAid().toString();
        Integer expire= RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(redisKey,aid,expire,TimeUnit.SECONDS);
        return accs1;
    }
/*
* 使用 servlet 提供的session
* */
    public Accs login(HttpServletRequest request, String username, String pas){
        /*查询库中有没有这个用户*/
        Accs accs=new Accs();
        accs.setUsername(username);
        accs.setPassword(pas);
        Accs accs1 =accsMapper.login(accs);
        if(accs1==null){
            throw new HbgcException(ResultEnum.LOGIN_FAIL);
        }

        /*鉴定权限*/
        if(accs1.getStat()==0)throw new HbgcException(ResultEnum.LOGIN_FAIL_ACT);
            /*沙雕输出*/
        System.out.println(accs1.getDept().getName());
        /*通过request方式请求一个session 并由服务器给客户端设置一个 cookie*/
        request.getSession().setAttribute("aid",accs1.getAid());  //配合Utill包中RedisSessionConfig类使用
        return accs1;
    }


    /*
    * 获取权限菜单
    * */
    public List menu(Long rid){
//        List<Funs> funs =roles_funsMapper.selectMenu(rid);
//        List<Funs> funs1=funsMapper.selectMenu();
        List<Roles> roless=rolesMapper.selectFunsByRid(rid);
        Roles rfs=roless.get(0);
        Funs funs;
        /*获取主菜单*/
        List<Funs> menu=funsMapper.selectMenu();
       for(int f=0;f<menu.size();f++){
           for(int i=0;i<rfs.getFuns().size();i++){
               funs= rfs.getFuns().get(i);
                if(funs.getPfid()==menu.get(f).getFid()){
                    menu.get(f).getChildFuns().add(funs);
                }
           }
       }
        return menu;
    }
    /*
    * 查询区域
    * */
    public Map<String,Long>  qycx(){
        List<Base> baseList=baseMapper.selectByPbid(BaseConstant.QH);
        Map<String,Long> qy=new HashMap<>();
        for(int i=0;i<baseList.size();i++) {
            qy.put(baseList.get(i).getName(),baseList.get(i).getBid());
        }
       return qy;
    }
    /*
    * 申报账号
    * */
    public void sbzh(Sena sena){
        int result=senaMapper.insert(sena);
        if(result==0||result>1){
            throw new HbgcException(ResultEnum.SENA_FAIL);
        }
    }
}
