package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Apply;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ApplyMapper {
    int deleteByPrimaryKey(Long pid);

    int insert(Apply record);

    Apply selectByPrimaryKey(Long pid);

    List<Apply> selectAll();

    int updateByPrimaryKey(Apply record);
    List<Apply> selectByAaid(Long pid);
}