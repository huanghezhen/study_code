package hhz.demo1.ui;

import hhz.demo1.factory.BeanFactory;
import hhz.demo1.service.AccountService;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/13 14:43
 */
public class Client {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            AccountService accountService = (AccountService) BeanFactory.getBean("accountService");
            System.out.println(accountService);
        }
    }
}
