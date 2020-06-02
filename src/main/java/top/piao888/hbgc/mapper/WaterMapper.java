package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Water;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface WaterMapper {
    int deleteByPrimaryKey(Long wid);

    int insert(Water record);

    Water selectByPrimaryKey(Long wid);

    List<Water> selectAll();

    int updateByPrimaryKey(Water record);
}