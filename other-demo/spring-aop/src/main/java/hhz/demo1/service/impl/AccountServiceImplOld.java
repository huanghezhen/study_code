package hhz.demo1.service.impl;

import hhz.demo1.domain.Account;
import hhz.demo1.mapper.AccountMapper;
import hhz.demo1.service.AccountService;
import hhz.demo1.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: AccountServiceImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 11:31
 */
@Service("accountServiceOld")
public class AccountServiceImplOld implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private TransactionManager transactionManager;

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

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            transactionManager.begin();
            Account source = accountMapper.getAccountByName(sourceName);
            Account target = accountMapper.getAccountByName(targetName);
            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);
            accountMapper.updateAccount(source);

            if (true) {
                throw new RuntimeException("模拟报错");
            }

            accountMapper.updateAccount(target);
            transactionManager.commit();
            System.out.println("提交事务");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transactionManager.rollback();
            System.out.println("回滚事务");
        }finally {
            transactionManager.release();
        }
    }
}
