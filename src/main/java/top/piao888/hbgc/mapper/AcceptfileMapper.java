package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Acceptfile;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface AcceptfileMapper {
    int deleteByPrimaryKey(Long afid);

    int insert(Acceptfile record);

    Acceptfile selectByPrimaryKey(Long afid);

    List<Acceptfile> selectAll();

    int updateByPrimaryKey(Acceptfile record);
}