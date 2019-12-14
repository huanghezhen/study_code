package hhz.demo7.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

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
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {


    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String name;
    @Value("${jdbc.password}")
    private String password;

    @Bean("runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean("dataSource")
    public DataSource createDataSource() {
        ComboPooledDataSource comboPooledDataSource = null;
        try {
            comboPooledDataSource = new ComboPooledDataSource();
            comboPooledDataSource.setDriverClass(driver);
            comboPooledDataSource.setJdbcUrl(url);
            comboPooledDataSource.setUser(name);
            comboPooledDataSource.setPassword(password);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return comboPooledDataSource;
    }
}
