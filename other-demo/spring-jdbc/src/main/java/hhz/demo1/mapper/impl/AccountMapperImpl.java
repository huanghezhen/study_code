package hhz.demo1.mapper.impl;

import hhz.demo1.domain.Account;
import hhz.demo1.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: AccountMapperImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/15 16:53
 */
@Repository
public class AccountMapperImpl implements AccountMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountById(Integer id) {
        return jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), id).get(0);
    }

    @Override
    public List<Account> findAccountByName(String name) {
        return jdbcTemplate.query("select * from account where name = ?", new BeanPropertyRowMapper<>(Account.class), name);
    }

    @Override
    public int updateAccount(Account account) {
        return jdbcTemplate.update("update account set name = ? , money = ? where id = ?", account.getName(), account.getName(), account.getId());
    }
}
