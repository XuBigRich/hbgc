package top.piao888.hbgc.converter;

import org.springframework.beans.BeanUtils;
import top.piao888.hbgc.domain.Projectfile;
import top.piao888.hbgc.dto.ProjectDTO;
import top.piao888.hbgc.dto.ProjectMessageDTO;
import top.piao888.hbgc.vo.Project.ProjectRes;
import top.piao888.hbgc.vo.request.ProjectUpSelectVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ProjectDTO2OResponseProjectVO.java
 * @Description TODO
 * @createTime 2019年05月09日 18:36:00
 */
public class ProjectDTO2OProjectRes {
    public static ProjectRes convert(ProjectDTO projectDTO){
        ProjectRes projectRes=new ProjectRes();
        List list=new ArrayList();
        BeanUtils.copyProperties(projectDTO,projectRes);
       for(Projectfile projectfile:projectDTO.getProjectfiles()){
           Map map=new HashMap();
           map.put(projectfile.getPfid(),projectfile.getFn()+"."+projectfile.getTp());
           list.add(map);
       }
        projectRes.setFile(list);
        return projectRes;
    }
}
