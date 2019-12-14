package hhz.demo5.service;

import hhz.demo5.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ClassName: AccountServiceTest
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 13:23
 */
public class AccountServiceTest {



    @Test
    public void testFindAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean5.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        List<Account> allAccount = accountService.findAllAccount();
        System.out.println(allAccount);
    }

    @Test
    public void testFindOne() {

    }


    @Test
    public void testSave() {

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

    }
}
