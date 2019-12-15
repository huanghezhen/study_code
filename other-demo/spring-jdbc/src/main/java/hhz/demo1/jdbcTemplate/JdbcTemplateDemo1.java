package hhz.demo1.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @ClassName: JdbcTemplateDemo1
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/15 16:12
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) throws Exception {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("123456");


        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);
        jt.execute("insert into account(name,money) values ('ccc',200)");


    }
}
