package top.piao888.hbgc.service;


import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
//@ComponentScan(basePackages={"top.piao888.hbgc.domain"})
public class ZhanghaoServiceTest {
    @Autowired
    private ZhanghaoService zhanghaoService;
    @Test
    public void testMenu() {
        zhanghaoService.menu(83L);
    }
}
