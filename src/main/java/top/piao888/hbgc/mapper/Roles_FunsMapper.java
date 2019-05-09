package top.piao888.hbgc.mapper;

import top.piao888.hbgc.domain.Roles;
import top.piao888.hbgc.domain.Roles_Funs;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Roles_FunsMapper.java
 * @Description TODO
 * @createTime 2019年02月27日 16:23:00
 */
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface Roles_FunsMapper {
    //增
    void insert(Roles_Funs roles_funs);
    //删
    void deleeteByRidOrFid(long rid);
    //改
    void updateByFid(Roles_Funs roles_funs);
    void updateByRid(Roles_Funs roles_funs);
    //查
    List<Roles_Funs> selectByRidOrFid(Roles_Funs roles_funs);
}
