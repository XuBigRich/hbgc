package top.piao888.hbgc.service;

import org.springframework.beans.factory.annotation.Autowired;
import top.piao888.hbgc.domain.Sena;
import top.piao888.hbgc.mapper.SenaMapper;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName XTService.java
 * @Description TODO
 * @createTime 2019年04月26日 19:40:00
 */
public class XTService {
    @Autowired
    private SenaMapper senaMapper;
    /*查询所有未审核的申报的账号*/
    public void ssena(){
//        Sena sena=senaMapper.selectByPrimaryKey();
    }
}
