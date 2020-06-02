package top.piao888.hbgc.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.piao888.hbgc.converter.LXCXForm2OProjectMessageDTO;
import top.piao888.hbgc.dto.ProjectMessageDTO;
import top.piao888.hbgc.vo.request.ProjectUpSelectVo;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName XiangmuServiceTest.java
 * @Description TODO
 * @createTime 2019年04月29日 16:56:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class XiangmuServiceTest extends TestCase {
    @Autowired
    private XiangmuService xiangmuService;
    @Autowired
    private CacheServiceImpl cacheService;
    @Test
    public void testXmlx() {
        cacheService.init();
        ProjectUpSelectVo projectUpSelectVo=new ProjectUpSelectVo();
        projectUpSelectVo.setKid(47L);
        projectUpSelectVo.setTid(23L);
        projectUpSelectVo.setName("猜");
        ProjectMessageDTO projectMessageDTO=LXCXForm2OProjectMessageDTO.convert(projectUpSelectVo);
        List<ProjectMessageDTO> projectMessageDTOList=xiangmuService.xmcx(projectMessageDTO,null);
        for(ProjectMessageDTO projectMessageDTO1:projectMessageDTOList){
            System.out.println(projectMessageDTO1);
        }
    }
}