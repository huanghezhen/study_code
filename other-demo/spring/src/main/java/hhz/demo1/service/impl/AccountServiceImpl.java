package hhz.demo1.service.impl;

import hhz.demo1.factory.BeanFactory;
import hhz.demo1.mapper.AccountMapper;
import hhz.demo1.service.AccountService;

/**
 * @ClassName: AccountServiceImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/13 14:40
 */
public class AccountServiceImpl implements AccountService {

    private AccountMapper accountMapper = (AccountMapper) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountMapper.saveAccount();
    }
}
