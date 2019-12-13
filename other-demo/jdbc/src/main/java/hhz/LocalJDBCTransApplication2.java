package hhz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * @ClassName: LocalJDBCTransApplication
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/13 11:52
 */
public class LocalJDBCTransApplication2 {

    private static final Logger log = LoggerFactory.getLogger(LocalJDBCTransApplication2.class);

    public static void main(String[] args) throws Exception {
        Connection connection = getConnection();
        connection.setAutoCommit(false);

        String query = "select * from user where id = 12 for update";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        long moneyTow = 0;
        while (rs.next()) {
            int id = rs.getInt(1);
            long money = rs.getLong(2);
            if (id == 2) {
                moneyTow = money;
            }
            log.info("{} has {}", id, money);
        }

        String minusSQL = "update user set money = ? where id = ?";
        PreparedStatement minusPS = connection.prepareStatement(minusSQL);

        minusPS.setLong(1,moneyTow + 100);
        minusPS.setInt(2,2);
        minusPS.executeUpdate();

        connection.commit();

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
