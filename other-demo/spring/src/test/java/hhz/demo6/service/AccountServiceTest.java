package hhz.demo6.service;

import hhz.demo6.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ClassName: AccountServiceTest
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 13:41
 */
public class AccountServiceTest {
    @Test
    public void testFindAll() {
        ApplicationContext as = new ClassPathXmlApplicationContext("bean6.xml");
        AccountService accountService = as.getBean("accountService", AccountService.class);
        List<Account> allAccount = accountService.findAllAccount();
        System.out.println(allAccount);
    }
}
