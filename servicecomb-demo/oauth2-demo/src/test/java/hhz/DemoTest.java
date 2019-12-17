package hhz;

import hhz.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: DemoTest
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/17 12:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {
    @Autowired
    private UserService userService;
    @Test
    public void get() {
        System.out.println(userService.getCount());
    }
}
