package top.piao888.hbgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import top.piao888.hbgc.domain.Accept;
@Mapper
public interface AcceptMapper {
    int deleteByPrimaryKey(Long pid);

    int insert(Accept record);

    Accept selectByPrimaryKey(Long pid);

    List<Accept> selectAll();

    int updateByPrimaryKey(Accept record);
}