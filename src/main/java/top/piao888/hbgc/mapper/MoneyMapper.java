package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Money;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface MoneyMapper {
    int deleteByPrimaryKey(Long pid);

    int insert(Money record);

    Money selectByPrimaryKey(Long pid);

    List<Money> selectAll();

    int updateByPrimaryKey(Money record);
}