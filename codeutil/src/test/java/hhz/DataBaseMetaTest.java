package hhz;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @ClassName: DataBaseMetaTest
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2020/1/2 17:02
 */
public class DataBaseMetaTest {
    private Connection connection;

    @Before
    public void init() throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        /*String url = "jdbc:mysql://114.116.80.254:7002?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "kz_admin";
        String password = "kz_admin123";*/

        String url = "jdbc:mysql://127.0.0.1:3306?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "123456";

        Properties properties = new Properties();
        properties.put("remarksReporting", "true");
        properties.put("user", username);
        properties.put("password", password);

        Class.forName(driver);
        connection = DriverManager.getConnection(url, properties);

    }

    @Test
    public void dataMeta01() throws Exception {
        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println(metaData.getUserName());
        System.out.println(metaData.getDatabaseProductName());
    }

    @Test
    public void dataMeta02() throws Exception {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet catalogs = metaData.getCatalogs();
        while (catalogs.next()) {
            System.out.println(catalogs.getString(1));
        }
    }

    @Test
    public void dataMeta03() throws Exception {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet ihrm = metaData.getTables("pay", null, null, new String[]{"TABLE"});
        while (ihrm.next()) {
            System.out.println(ihrm.getString("TABLE_NAME"));
        }
    }

    @Test
    public void dataMeta04() throws Exception {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet columns = metaData.getColumns("pay", null, "t_mq_queue_info", null);
        while (columns.next()) {
            System.out.println(columns.getString("COLUMN_NAME"));
        }
    }
}
