package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Dept;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DeptMapper {
    int deleteByPrimaryKey(Long did);

    int insert(Dept record);

    Dept selectByPrimaryKey(Long did);

    List<Dept> selectAll();

    int updateByPrimaryKey(Dept record);
/*根据地区与单位类别查询*/
    List<Dept> selectByBidAndTid(Dept record);
}