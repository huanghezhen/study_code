package hhz.demo3.ui;

import hhz.demo3.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: Clinet
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/13 15:29
 */
public class Client {
    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("bean.xml");


        AccountService accountService1 = (AccountService) applicationContext.getBean("accountService3");
        accountService1.saveAccount();
        //AccountService accountService2 = (AccountService) applicationContext.getBean("accountService3");

        //System.out.println(accountService1 == accountService2);

        applicationContext.close();

    }
}
