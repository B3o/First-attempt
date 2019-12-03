package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    static PreparedStatement pstmt = null;
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

    /**
     * 增 删 改 通用方法(只有sql和参数  可以通过参数传递不同sql和参数)
     * @return
     */
    public static int update(String sql, Object ... o) throws SQLException {//后期参数的顺序一定要跟?的顺序一致
        conn = getConn();
        pstmt = conn.prepareStatement(sql);
//        如果有参数需要处理
        if (o != null) {
            for (int i = 0; i < o.length; ++i) {
                //通过传入的参数给?赋值  由于之前顺序固定,所以传值顺序和参数的顺序是一致的
                pstmt.setObject((i + 1), o[i]);
            }
        }
        int result = pstmt.executeUpdate();
        close(pstmt, conn);
        return result;
    }
}
