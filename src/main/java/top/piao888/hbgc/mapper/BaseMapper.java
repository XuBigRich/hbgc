package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Base;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface BaseMapper {
    int deleteByPrimaryKey(Long bid);

    int insert(Base record);

    Base selectByPrimaryKey(Long bid);

    List<Base> selectAll();

    List<Base> selectByPbid(Long pbid);

    int updateByPrimaryKey(Base record);
}