package hhz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName: LocalJDBCTransApplication
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/13 11:52
 */
public class LocalJDBCTransApplication {

    private static final Logger log = LoggerFactory.getLogger(LocalJDBCTransApplication.class);

    public static void main(String[] args) throws Exception {
        Connection connection = getConnection();
        connection.setAutoCommit(false);


        String plusSQL = "update user set money = money - 100 where id = ?";
        PreparedStatement plusPS = connection.prepareStatement(plusSQL);

        String minusSQL = "update user set money = money + 100 where id = ?";
        PreparedStatement minusPS = connection.prepareStatement(minusSQL);

        plusPS.setInt(1,1);
        plusPS.executeUpdate();

        minusPS.setInt(1,2);
        minusPS.executeUpdate();

        connection.commit();

        plusPS.close();
        minusPS.close();
        connection.close();
    }

    private static Connection getConnection() throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/demo1?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "123456";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            log.error(e.getLocalizedMessage());
        }
        return DriverManager.getConnection(url,username,password);
    }
}
