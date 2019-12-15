package hhz.demo2.mapper;


import hhz.demo2.domain.Account;

import java.util.List;

/**
 * @ClassName: AccountMapper
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/15 16:51
 */
public interface AccountMapper {
    Account findAccountById(Integer id);

    List<Account> findAccountByName(String name);

    int updateAccount(Account account);
}
