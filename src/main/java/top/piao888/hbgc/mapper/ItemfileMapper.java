package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Itemfile;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ItemfileMapper {
    int deleteByPrimaryKey(Long ifid);

    int insert(Itemfile record);

    Itemfile selectByPrimaryKey(Long ifid);

    List<Itemfile> selectAll();

    int updateByPrimaryKey(Itemfile record);
}