package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Reportfile;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ReportfileMapper {
    int deleteByPrimaryKey(Long rfid);

    int insert(Reportfile record);

    Reportfile selectByPrimaryKey(Long rfid);

    List<Reportfile> selectAll();

    int updateByPrimaryKey(Reportfile record);
}