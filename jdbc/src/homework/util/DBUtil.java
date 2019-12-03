package homework.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Bmo
 * @date 2019/11/29 14:29
 */
public class DBUtil {
    public static Connection conn;
    public static PreparedStatement pstsm;
    private static String username;
    private static String password;
    private static String url;
    private static String driver;
    static {
        InputStream is = ClassLoader.getSystemResourceAsStream("config/jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void close(AutoCloseable ... closes) {
        for (AutoCloseable auto : closes) {
            if (auto != null) {
                try {
                    auto.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static Connection getConn() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static ResultSet query(String sql, Object ... obj) {
        getConn();
        ResultSet rs = null;
        try {
             pstsm = conn.prepareStatement(sql);
             for (int i = 0; i < obj.length; i++) {
                 pstsm.setObject((i+1), obj[i]);
             }
             rs = pstsm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public static int update(String sql, Object ... obj) {
        int result = -1;
        getConn();
        try {
            pstsm = conn.prepareStatement(sql);
            for(int i = 0; i < obj.length; ++i) {
                pstsm.setObject((i+1), obj[i]);
            }
            result = pstsm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn);
        }
        return result;
    }
    public static int deleteUser(int id) {
        int result = -1;
        String sql = "delete from users where id = ?";
        result = update(sql, id);
        if (result > 0) {
            System.out.println("删除成功!");
        } else {
            System.out.println("删除失败");
        }
        return result;
    }

}
