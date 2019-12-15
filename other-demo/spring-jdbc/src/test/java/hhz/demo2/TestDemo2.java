package hhz.demo2;

import hhz.demo2.domain.Account;
import hhz.demo2.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: TestDemo2
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/15 18:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class TestDemo2 {

    @Autowired
    private AccountService accountService;

    @Test
    public void transfer() {
        accountService.transfer("张三", "李四", 1f);

    }

    @Test
    public void get() {
        Account account = accountService.fineAccountById(1);
        System.out.println(account);
    }
}
