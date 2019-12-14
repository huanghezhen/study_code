package hhz.demo5.mapper.impl;

import hhz.demo5.domain.Account;
import hhz.demo5.mapper.AccountMapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: AccountMapperImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 11:36
 */
public class AccountMapperImpl implements AccountMapper {

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAllAccount() {

        List<Account> accountList = null;
        try {
            accountList = runner.query("select * from account", new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    @Override
    public Account findAccount(Integer id) {
        Account account = null;
        try {
            account = runner.query("select * from account where id = ?", new BeanHandler<>(Account.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public int saveAccount(Account account) {
        int ret = 0;
        try {
            ret = runner.update("insert into account(name,money) values (?,?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public int updateAccount(Account account) {
        int ret = 0;
        try {
            ret = runner.update("update account set name = ?,money = ? where id = ?", account.getName(), account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public int deleteAccount(Integer id) {
        int ret = 0;
        try {
            ret = runner.update("delete from account where id = ?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
