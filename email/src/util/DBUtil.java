package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Bmo
 * @date 2019/11/29 14:29
 */
public class DBUtil {
    public static Connection conn = null;
    public static PreparedStatement pstsm = null;
    public static ResultSet rs = null;
    private static String username;
    private static String password;
    private static String url;
    private static String driver;
    static {
        //类加载执行一次,加载一次配置文件 获取结果 给变量赋值
        //会把经常修改的内容通过配置文件的方式进行存储
        //读取配置文件    参数是配置文件路径
        InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("config/jdbc.properties");
        //创建配置文件对象  properties对象
        Properties pro = new Properties();
        //通过输入流读取
        try {
            pro.load(is);
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    static ThreadLocal<Connection> tl = new ThreadLocal<>();

    public static void close(AutoCloseable ... closes) {
        for (AutoCloseable auto : closes) {
            if (auto != null) {
                try {
                    auto.close();
                    tl.set(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static Connection getConn() {
        try {
            if (tl.get() == null) {
                conn = DriverManager.getConnection(url, username, password);
                tl.set(conn);
            } else {
                conn = tl.get();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static ResultSet query(String sql, Object ... obj) {
        conn = getConn();
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
            close(pstsm, conn);
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
