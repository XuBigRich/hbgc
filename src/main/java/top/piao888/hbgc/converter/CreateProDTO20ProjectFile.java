package top.piao888.hbgc.converter;

import org.springframework.web.multipart.MultipartFile;
import top.piao888.hbgc.domain.Projectfile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CreateProDTO20ProjectFile.java
 * @Description TODO
 * @createTime 2019年05月08日 12:49:00
 */
public class CreateProDTO20ProjectFile {
    public static List<Projectfile> convert(MultipartFile[] multipartFiles){
        List multipartFiles1=Arrays.asList(multipartFiles);
        List<Projectfile> projectfiles = (List) multipartFiles1.stream().map((e)->convert((MultipartFile)e)).collect(Collectors.toList());
        return projectfiles;
    }
    public static Projectfile convert(MultipartFile multipartFile) {
        String[] filename=multipartFile.getOriginalFilename().split("\\.");
        /*文件名*/
        String fn= filename[0];
        /*文件大小*/
        BigDecimal siz= BigDecimal.valueOf(multipartFile.getSize());
        /*文件类型*/
        String tp=filename[1];
        /*文件字节码*/
        byte[]  txt= new byte[0];
        try {
            txt = multipartFile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Projectfile projectfile=new Projectfile();
        projectfile.setFn(fn);
        projectfile.setSiz(siz);
        projectfile.setTp(tp);
        projectfile.setTxt(txt);
        projectfile.setTim(new Date());
        return projectfile;
    }
}
