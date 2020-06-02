package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Stepfile;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface StepfileMapper {
    int deleteByPrimaryKey(Long sfid);

    int insert(Stepfile record);

    Stepfile selectByPrimaryKey(Long sfid);

    List<Stepfile> selectAll();

    int updateByPrimaryKey(Stepfile record);
}