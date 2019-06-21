package top.piao888.hbgc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.piao888.hbgc.domain.Funs;

@Mapper
public interface FunsMapper {
    int deleteByPrimaryKey(Long fid);

    int insert(Funs record);

    Funs selectByPrimaryKey(Long fid);

    List<Funs> selectAll();

    int updateByPrimaryKey(Funs record);

    List<Funs> selectMenu();
}