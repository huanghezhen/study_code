package hhz.demo1;

import hhz.demo1.domain.Account;
import hhz.demo1.domain.AccountRowMapper;
import hhz.demo1.mapper.AccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName: TestDemo1
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/15 16:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class TestDemo1 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void jdbcTest() {
        jdbcTemplate.execute("insert into account(name,money) values ('ccc',200)");
    }

    @Test
    public void save() {
        jdbcTemplate.update("insert into account(name,money) values (?,?)","hhh",222);
    }

    @Test
    public void update() {
        jdbcTemplate.update("update account set name = ? , money = ? where id = ?", "1", 2, 5);
    }
    @Test
    public void delete() {
        jdbcTemplate.update("delete from account where id = ?", 3);
    }

    @Test
    public void getData() {
        List<Account> query = jdbcTemplate.query("select * from account", new AccountRowMapper());
        System.out.println(query);
    }

    @Test
    public void getData1() {
        List<Account> query = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<>(Account.class));
        System.out.println(query);
    }

    @Test
    public void getAccount() {
        Account accountById = accountMapper.findAccountById(1);
        System.out.println(accountById);
        List<Account> accountByName = accountMapper.findAccountByName("张三");
        System.out.println(accountByName);
    }

    @Test
    public void updateAccount() {

    }
}
