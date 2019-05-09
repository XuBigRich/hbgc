package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Sena;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface SenaMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(Sena record);

    Sena selectByPrimaryKey(Long sid);

    List<Sena> selectAll();

    int updateByPrimaryKey(Sena record);


}