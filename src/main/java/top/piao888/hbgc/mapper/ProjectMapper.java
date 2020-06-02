package top.piao888.hbgc.mapper;

import java.util.List;
import top.piao888.hbgc.domain.Project;
import top.piao888.hbgc.dto.ProjectMessageDTO;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ProjectMapper {
    int deleteByPrimaryKey(Long pid);

    int insert(Project record);

    Project selectByPrimaryKey(Long pid);

    List<Project> selectAll();

    int updateByPrimaryKey(Project record);

    List<Project> selectBynamOrTidOrKid(ProjectMessageDTO projectMessageDTO);

    Integer selectAllCount();
}