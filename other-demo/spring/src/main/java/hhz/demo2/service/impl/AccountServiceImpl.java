package hhz.demo2.service.impl;

import hhz.demo2.mapper.AccountMapper;
import hhz.demo2.mapper.impl.AccountMapperImpl;
import hhz.demo2.service.AccountService;

/**
 * @ClassName: AccountServiceImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/13 14:40
 */
public class AccountServiceImpl implements AccountService {

    private AccountMapper accountMapper = new AccountMapperImpl();
    public void saveAccount() {
        accountMapper.saveAccount();
    }
}
