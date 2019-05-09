package top.piao888.hbgc.contruller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.piao888.hbgc.service.test.testService;
import top.piao888.hbgc.vo.test.TestVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestContruller.java
 * @Description TODO
 * @createTime 2019年04月24日 10:17:00
 */
@Controller
@RequestMapping("/test")
public class TestContruller {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestContruller.class);
    @Autowired
    private testService test;


    /*测试权限（写定的条件）*/
    @ResponseBody
    @RequestMapping("/qx")
    public List hello(){
        System.out.println(test.qx().size());
        return test.qx();
    }
    /*
     * 测试jdbcTemplate
     * */
    @ResponseBody
    @GetMapping("/accs")
    public List test(){
        return test.getList();
    }
    /*
    * 测试Post传输 文件集合
    * */
    @PostMapping("fileatxt")
    public void fileatxt(TestVO testVO){
     /*   for(File file:testVO.getFiles()){
            System.out.println(file.getName());
        }
        System.out.println(testVO.getTid());*/
        System.out.println(testVO);
    }

    @GetMapping("/upload")
    public String upload() {
        return "test/upload";
    }
    //===========================================================
    //Spring 自带的下载方式
    //===========================================================
    @PostMapping("upload")
    @ResponseBody
    public String  file(@RequestParam("file") MultipartFile file){
            if (file.isEmpty()) {
                return "上传失败，请选择文件";
            }
        String fileName = file.getOriginalFilename();
        String filePath = "D:\\上传\\";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }
    //===========================================================
    //Spring 自带的下载方式  多文件
    //===========================================================
    @PostMapping("uploads")
    @ResponseBody
    public String multiUpload(@RequestParam("files") MultipartFile[] multipartfiles)
            throws IllegalStateException, IOException {
        //保存文件的目录
        String filePath = "D:\\上传\\";
        if (null != multipartfiles && multipartfiles.length > 0) {
            //遍历并保存文件
            for (MultipartFile file : multipartfiles) {
                file.transferTo(new File(filePath + file.getOriginalFilename()));
            }
        }
        LOGGER.info("上传成功");
        return "上传成功";
    }
        //===========================================================
    //解析request 获取上传与下载信息
    //===========================================================
    @PostMapping("rupload")
    @ResponseBody
    public void  file(HttpServletRequest httpServletRequest) throws IOException, ServletException {
        System.out.println(httpServletRequest.toString());
        Enumeration<String> enumeration=httpServletRequest.getHeaderNames();
        Part part=httpServletRequest.getPart("file");
        part.write("D:\\上传\\"+getFileName(part.getHeader("content-disposition")));
        while(enumeration.hasMoreElements()){
           String name= enumeration.nextElement();
            System.out.println(name);
        }
    }
    public static String getFileName(String header){
        System.out.println("=====================================");
        System.out.println(header);
        String [] tempArr1=header.split(";");
        String[] tempArr2 = tempArr1[2].split("=");
        String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
        return fileName;
    }
}
