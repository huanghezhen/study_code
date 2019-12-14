package hhz.demo1.service;

import hhz.demo1.domain.Account;
import hhz.demo1.factory.BeanFactory;
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
 * @Date: 2019/12/14 15:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean1.xml")
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private BeanFactory beanFactory;


    @Test
    public void testFindAll() {
        List<Account> allAccount = accountService.findAllAccount();
        System.out.println(allAccount);
    }

    @Test
    public void transfer() {
        beanFactory.getAccountServiceProxy().transfer("张三","李四",100f);
    }
}
