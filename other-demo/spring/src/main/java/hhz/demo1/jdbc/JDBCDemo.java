package hhz.demo1.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName: JDBCDemo
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/13 14:27
 */
public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/demo1?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "123456";

        DriverManager.registerDriver(new Driver());
        Connection conn = DriverManager.getConnection(url, username, password);
        PreparedStatement pstm = conn.prepareStatement("select * from user");
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
        }
        resultSet.close();
        pstm.close();
        conn.close();
    }
}
