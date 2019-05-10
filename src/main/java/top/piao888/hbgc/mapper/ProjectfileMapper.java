package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Projectfile;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ProjectfileMapper {
    int deleteByPrimaryKey(Long pfid);

    int insert(Projectfile record);

    Projectfile selectByPrimaryKey(Long pfid);

    List<Projectfile> selectByPid(Long pid);

    List<Projectfile> selectAll();

    int updateByPrimaryKey(Projectfile record);
}