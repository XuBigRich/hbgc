package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Step;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface StepMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(Step record);

    Step selectByPrimaryKey(Long sid);

    List<Step> selectAll();

    int updateByPrimaryKey(Step record);
}