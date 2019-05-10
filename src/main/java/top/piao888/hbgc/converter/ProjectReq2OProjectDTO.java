package top.piao888.hbgc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;
import top.piao888.hbgc.constant.ProjectStat;
import top.piao888.hbgc.dto.ProjectDTO;
import top.piao888.hbgc.vo.Project.ProjectReq;

import java.util.*;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName  ProjectReq2OProjectDTO.java
 * @Description TODO
 * @createTime 2019年05月02日 10:26:00
 */
public class ProjectReq2OProjectDTO {
    public static ProjectDTO convert(ProjectReq ProjectReq){
        ProjectDTO ProjectDTO=new ProjectDTO();
        BeanUtils.copyProperties(ProjectReq,ProjectDTO);
        //设置 跟踪状态ID 外键：未启动、建设中、已完成
        ProjectDTO.setSid(ProjectStat.GZZT1);
        //设置项目年
        ProjectDTO.setYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        //计算项目总投资金额
        Long countTotal=countTotal(ProjectReq.getCou(),ProjectReq.getPro(),ProjectReq.getCity(),ProjectReq.getDist(),ProjectReq.getCom());
        ProjectDTO.setTotal(countTotal);
        //设置上传文件
        MultipartFile[] files= ProjectReq.getFiles();
        ProjectDTO.setProjectfiles(CreateProDTO20ProjectFile.convert(files));
        return ProjectDTO;
    }
    public  static Long countTotal(Long cou,Long pro,Long city,Long dist,Long com){
        return cou+pro+city+dist+com;
    }
}
