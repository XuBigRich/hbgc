package top.piao888.hbgc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.piao888.hbgc.domain.Base;
import top.piao888.hbgc.mapper.BaseMapper;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BaseService.java
 * @Description TODO
 * @createTime 2019年04月30日 14:04:00
 */
@Service
public class BaseServiceImpl {
    @Autowired
    private BaseMapper baseMapper;

    /*
    * 查询出Base表中所有信息
    * */
    public List<Base> getBaseAll(){
        List<Base> baseList= baseMapper.selectAll();
        return baseList;
    }
}
