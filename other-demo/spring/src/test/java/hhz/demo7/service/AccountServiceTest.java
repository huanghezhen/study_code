package hhz.demo7.service;

import hhz.demo7.config.SpringConfiguration;
import hhz.demo7.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @ClassName: AccountServiceTest
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 14:14
 */
public class AccountServiceTest {
    @Test
    public void TestFindAll() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        List<Account> allAccount = accountService.findAllAccount();
        System.out.println(allAccount);
    }
}
