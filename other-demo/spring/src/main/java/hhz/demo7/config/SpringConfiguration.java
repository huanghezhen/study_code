package hhz.demo7.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @ClassName: SpringConfiguration
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 13:54
 */
@Configuration
@ComponentScan("hhz.demo7")
public class SpringConfiguration {

    @Bean("runner")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean("dataSource")
    public DataSource createDataSource() {
        ComboPooledDataSource comboPooledDataSource = null;
        try {
            comboPooledDataSource = new ComboPooledDataSource();
            comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
            comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf-8&useSSL=false");
            comboPooledDataSource.setUser("root");
            comboPooledDataSource.setPassword("123456");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return comboPooledDataSource;
    }
}
