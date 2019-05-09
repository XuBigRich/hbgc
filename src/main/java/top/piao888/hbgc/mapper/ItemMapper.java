package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Item;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ItemMapper {
    int deleteByPrimaryKey(Long iid);

    int insert(Item record);

    Item selectByPrimaryKey(Long iid);

    List<Item> selectAll();

    int updateByPrimaryKey(Item record);
}