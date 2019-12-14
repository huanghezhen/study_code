package hhz.demo7.service;

import hhz.demo7.config.SpringConfiguration;
import hhz.demo7.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName: AccountServiceTest
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 14:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;


    @Test
    public void TestFindAll() {
        List<Account> allAccount = accountService.findAllAccount();
        System.out.println(allAccount);
    }
}
