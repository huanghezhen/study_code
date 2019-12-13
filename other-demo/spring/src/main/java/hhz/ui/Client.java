package hhz.ui;

import hhz.service.AccountService;
import hhz.service.impl.AccountServiceImpl;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/13 14:43
 */
public class Client {
    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountServiceImpl();
        accountService.saveAccount();
    }
}
