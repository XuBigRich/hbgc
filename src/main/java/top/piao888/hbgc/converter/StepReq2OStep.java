package top.piao888.hbgc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;
import top.piao888.hbgc.domain.Step;
import top.piao888.hbgc.dto.ProjectDTO;
import top.piao888.hbgc.vo.Project.ProjectRes;
import top.piao888.hbgc.vo.request.StepReq;

import java.util.Calendar;
import java.util.Date;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName StepReq2OStep.java
 * @Description TODO
 * @createTime 2019年05月21日 19:25:00
 */
public class StepReq2OStep {
    public static Step convert(StepReq stepReq){
        Step step=new Step();
        BeanUtils.copyProperties(stepReq,step);
        step.setTim(new Date());
        return step;
    }
}
