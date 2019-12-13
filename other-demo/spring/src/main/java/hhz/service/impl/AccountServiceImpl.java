package hhz.service.impl;

import hhz.mapper.AccountMapper;
import hhz.mapper.impl.AccountMapperImpl;
import hhz.service.AccountService;

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
