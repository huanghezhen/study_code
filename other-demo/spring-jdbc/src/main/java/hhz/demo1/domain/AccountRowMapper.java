package hhz.demo1.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: AccountRowMapper
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/15 16:42
 */
public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
