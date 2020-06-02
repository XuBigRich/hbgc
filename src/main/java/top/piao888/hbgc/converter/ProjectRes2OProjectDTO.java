package top.piao888.hbgc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;
import top.piao888.hbgc.constant.ProjectStat;
import top.piao888.hbgc.dto.ProjectDTO;
import top.piao888.hbgc.vo.Project.ProjectReq;
import top.piao888.hbgc.vo.Project.ProjectRes;

import java.util.Calendar;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ProjectRes2OProjectDTO.java
 * @Description TODO
 * @createTime 2019年05月10日 17:07:00
 */
public class ProjectRes2OProjectDTO {
    public static ProjectDTO convert(ProjectRes projectRes){
    ProjectDTO projectDTO=new ProjectDTO();
    BeanUtils.copyProperties(projectRes,projectDTO);
    //计算项目总投资金额
    Long countTotal=countTotal(projectRes.getCou(),projectRes.getPro(),projectRes.getCity(),projectRes.getDist(),projectRes.getCom());
        projectDTO.setTotal(countTotal);
    projectDTO.setYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
    //设置上传文件
    MultipartFile[] files= projectRes.getFiles();
    if(files!=null) {
        projectDTO.setProjectfiles(CreateProDTO20ProjectFile.convert(files));
    }
    return projectDTO;
}
    public  static Long countTotal(Long cou,Long pro,Long city,Long dist,Long com){
        return cou+pro+city+dist+com;
    }
}

