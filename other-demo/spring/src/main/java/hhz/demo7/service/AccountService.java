package hhz.demo7.service;

import hhz.demo7.domain.Account;

import java.util.List;

/**
 * @ClassName: AccountService
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 11:15
 */
public interface AccountService {
    List<Account> findAllAccount();

    Account findAccount(Integer id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer id);
}
