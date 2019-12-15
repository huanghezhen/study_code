package hhz.demo2.service.impl;

import hhz.demo2.service.AccountService;

/**
 * @ClassName: AccountServiceImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/15 10:55
 */
public class AccountServiceImpl implements AccountService {

    @Override
    public void saveAccount() {
        System.out.println("saveAccount");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("updateAccount "+i);

    }

    @Override
    public int deleteAccount() {
        System.out.println("deleteAccount");
        return 0;
    }
}
