package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Report;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ReportMapper {
    int deleteByPrimaryKey(Long rid);

    int insert(Report record);

    Report selectByPrimaryKey(Long rid);

    List<Report> selectAll();

    int updateByPrimaryKey(Report record);
}