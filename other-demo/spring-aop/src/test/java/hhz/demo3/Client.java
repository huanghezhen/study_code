package hhz.demo3;

import hhz.demo3.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: Clent
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/15 15:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class Client {
    @Autowired
    private AccountService accountService;

    @Test
    public void testSave() {
        accountService.save();
    }
}
