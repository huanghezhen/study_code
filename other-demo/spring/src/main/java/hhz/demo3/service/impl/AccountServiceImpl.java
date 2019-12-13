package hhz.demo3.service.impl;

import hhz.demo3.service.AccountService;

/**
 * @ClassName: AccountServiceImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/13 14:40
 */
public class AccountServiceImpl implements AccountService {

    public void saveAccount() {
        System.out.println("saveAccount 执行");
    }

    public void init() {
        System.out.println("初始化");
    }

    public void destroy() {
        System.out.println("销毁");
    }
}
