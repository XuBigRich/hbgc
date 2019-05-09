package top.piao888.hbgc.converter;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import top.piao888.hbgc.dto.ProjectMessageDTO;
import top.piao888.hbgc.vo.ProjectUpSelectVo;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName LXCXForm2OProjectMessage.java
 * @Description TODO
 * @createTime 2019年04月29日 13:49:00
 */
/*
*  ID:项目编码pno  项目类型：tid（外键）名称：name  状态：kid（外键）  审批阶段:stat
 *  级别：vid（外键）   tim：申报时间
* */
@Data
public class LXCXForm2OProjectMessageDTO {
    public static ProjectMessageDTO convert(ProjectUpSelectVo projectUpSelectVo){
        ProjectMessageDTO projectMessageDTO=new ProjectMessageDTO();
        BeanUtils.copyProperties(projectUpSelectVo,projectMessageDTO);
        return projectMessageDTO;
    }
}
