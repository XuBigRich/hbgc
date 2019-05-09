package top.piao888.hbgc.mapper;

import java.util.List;

import top.piao888.hbgc.domain.Roles;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface RolesMapper {
    int deleteByPrimaryKey(Long rid);

    int insert(Roles record);

    Roles selectByPrimaryKey(Long rid);

    List<Roles> selectAll();

    int updateByPrimaryKey(Roles record);

    List<Roles> selectFunsByRid(Long rid);
}