package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Bmo
 * @date 2019/11/28 19:27
 */
public class MyDBUtil {
    private static String url;
    private static String username;
    private static String password;
    private static String driver;
    private static Connection conn;
    static {
        InputStream is = ClassLoader.getSystemResourceAsStream("config/jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn() throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
    public static void close(AutoCloseable ... able) {
        for (AutoCloseable auto : able) {
            if (auto != null) {
                try {
                    auto.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
