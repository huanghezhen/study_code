package hhz.demo6.mapper;

import hhz.demo6.domain.Account;

import java.util.List;

/**
 * @ClassName: AccountMapper
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 11:33
 */
public interface AccountMapper {
    List<Account> findAllAccount();

    Account findAccount(Integer id);

    int saveAccount(Account account);

    int updateAccount(Account account);

    int deleteAccount(Integer id);
}
