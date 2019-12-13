package hhz.demo4.ui;

import hhz.demo4.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/13 17:59
 */
public class Client {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("bean.xml");


        AccountService accountService1 = (AccountService) applicationContext.getBean("accountService4");
        accountService1.saveAccount();

        AccountService accountService2 = (AccountService) applicationContext.getBean("accountService42");
        accountService2.saveAccount();
    }
}
