package hhz.demo1.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName: ConnectionUtils
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 15:39
 */
@Component
public class ConnectionUtils {
    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    @Autowired
    private DataSource dataSource;

    public Connection getThreadConnection() {
        Connection conn = connectionThreadLocal.get();
        try {
            if (conn == null) {
                conn = dataSource.getConnection();
                connectionThreadLocal.set(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void removeConnection() {
        connectionThreadLocal.remove();
    }
}
