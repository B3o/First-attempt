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
 * @date 2019/11/28 16:48
 */
public class DButil {
    //请求地址
    private static String url;
    //驱动包地址
    private static String driver;
    //数据库账号
    private static String username;
    //数据库密码
    private static String password;
    //获取连接方法
    private static Connection conn;
    static {
        //类加载执行一次,加载一次配置文件 获取结果 给变量赋值
        //会把经常修改的内容通过配置文件的方式进行存储
        //读取配置文件    参数是配置文件路径
        InputStream is = DButil.class.getClassLoader().getResourceAsStream("config/jdbc.properties");
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
    public static Connection getConnection() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //关闭资源方法
    //AutoCloseable 是ResultSet Connection PreparedStatement 父类
    //如果 不知道可能会传递的参数个数     可以使用数组
    // 可以使用... 这样可以任意个参数     able相当于数组  数组个数由参数个数决定
    public static void close(AutoCloseable ... able) {
        //able就是一个AutoCloseable数组
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
    //增 删 改 通用方法(只有sql 和参数)
    //查询通用方法(因为都有同一个返回值 ResultSet)
}
