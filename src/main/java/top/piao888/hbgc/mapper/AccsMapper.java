package top.piao888.hbgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import top.piao888.hbgc.domain.Accs;
@Mapper
public interface AccsMapper {
    int deleteByPrimaryKey(Long aid);

    int insert(Accs record);

    Accs selectByPrimaryKey(Long aid);

    List<Accs> selectAll();

    int updateByPrimaryKey(Accs record);

    Accs login(Accs accs);
}