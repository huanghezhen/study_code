package hhz.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @ClassName: Config
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/15 16:25
 */
@Configuration
@ComponentScan("hhz.demo1")
public class Config {

    @Bean
    public JdbcTemplate jdbcTemplate(DriverManagerDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("123456");
        return driverManagerDataSource;
    }
}
