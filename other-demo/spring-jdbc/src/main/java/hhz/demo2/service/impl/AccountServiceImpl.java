package hhz.demo2.service.impl;

import hhz.demo2.domain.Account;
import hhz.demo2.mapper.AccountMapper;
import hhz.demo2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: AccountServiceImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/15 18:16
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account fineAccountById(Integer id) {
        return accountMapper.findAccountById(id);
    }

    @Override
    @Transactional
    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountMapper.findAccountByName(sourceName).get(0);
        Account target = accountMapper.findAccountByName(targetName).get(0);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountMapper.updateAccount(source);
        if (true) {
            throw new RuntimeException("模拟报错");
        }
        accountMapper.updateAccount(target);
    }
}
