package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Funss;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface FunssMapper {
    int deleteByPrimaryKey(Long fid);

    int insert(Funss record);

    Funss selectByPrimaryKey(Long fid);

    List<Funss> selectAll();

    int updateByPrimaryKey(Funss record);

    List<Funss> selectMenu();
}