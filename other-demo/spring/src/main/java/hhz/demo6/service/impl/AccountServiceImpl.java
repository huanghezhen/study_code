package hhz.demo6.service.impl;

import hhz.demo6.domain.Account;
import hhz.demo6.mapper.AccountMapper;
import hhz.demo6.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: AccountServiceImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 11:31
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountMapper.findAllAccount();
    }

    @Override
    public Account findAccount(Integer id) {
        return accountMapper.findAccount(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountMapper.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountMapper.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) {
        accountMapper.deleteAccount(id);
    }
}
