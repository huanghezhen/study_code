package hhz.demo2.mapper.impl;

import hhz.demo2.domain.Account;
import hhz.demo2.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * @ClassName: AccountMapperImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/15 16:53
 */
@Repository
public class AccountMapperImpl extends JdbcDaoSupport implements AccountMapper {

    @Autowired
    public AccountMapperImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public Account findAccountById(Integer id) {
        return getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), id).get(0);
    }

    @Override
    public List<Account> findAccountByName(String name) {
        return getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<>(Account.class), name);
    }

    @Override
    public int updateAccount(Account account) {
        return getJdbcTemplate().update("update account set name = ? , money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }
}
