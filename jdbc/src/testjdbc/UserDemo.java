package testjdbc;

import entity.User;
import util.MyDBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * 代码存在大量冗余,并且还有SQL注入的隐患
 * @author Bmo
 * @date 2019/11/28 14:22
 */
public class UserDemo {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        UserDemo start = new UserDemo();
        System.out.println("欢迎进入系统");
        System.out.println("1.注册");
        System.out.println("2.登陆");
        System.out.println("3.展示用户");
        System.out.println("4.修改用户");
        System.out.println("5.删除用户");
        int num = sc.nextInt();
        switch (num) {
            case 3:
                show();
                break;
            case 5:
                delete();
                break;
        }
    }

    /**
     * 通过jdbc查询用户信息
     * @return
     */
    public static List<User> queryAll() {
        List<User> users = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        Statement state = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String username = "sc1911";
            String password = "1";
            conn = DriverManager.getConnection(url, username, password);
            state = conn.createStatement();
            rs = state.executeQuery("select * from users");
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String un = rs.getString("username");
                String pw = rs.getString("password");
                //rs.getDate(); 只要年月日 时分秒
                //rs.getTimestamp();代表时间戳  年月日 时分秒 毫秒
                Date birthday = rs.getDate("birthday");
                String sex = rs.getString("sex");
                Integer age = rs.getInt("age");
                User user = new User(id, username, password, birthday, sex, age);
                users.add(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (state != null) state.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    /**
     * 展示用户信息
     */
    public static void show() {
        List<User> list = queryAll();
        for (User user : list) {
            System.out.println(user.toString());
        }
    }
    public static int deleteUser(int id) {
        int result = -1;
        try {
            result = MyDBUtil.update("delete from users where id = ?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 通过jdbc 删除某个用户
     */
    public static void delete() {
        show();
        System.out.println("请输入你要删除的用户");
        Integer id = sc.nextInt();
        int result = deleteUser(id);
        if (result > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
 /*   public static int deleteUser(Integer id) {
        Connection conn = null;
//        Statement state = null;
        PreparedStatement pstmt = null;
        //受影响的行数
        int result = 0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost" +
                    ":1521:orcl", "sc1911", "1");
//            state = conn.createStatement();
            //创建pstmt 需要传入sql 进行预编译
            pstmt = conn.prepareStatement("delete from users where id = ?");
//            result = state.executeUpdate("delete from users where id =" + id);
            pstmt.setInt(1, id);
            result = pstmt.executeUpdate();
            System.out.println("user表 有" + result + "行数据被改变!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
//                if (state != null) state.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static void modifyUser() {
        String username = "sc1911";
        String password = "1";
        String driver = "oracle.jdbc.dirver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//        0.导入驱动包
//        1.加载驱动包
        try {
            Class.forName(driver);
            //2.建立连接
            Connection conn = DriverManager.getConnection(url, username, password);
            //3.获取对象
//            PreparedStatement pstsm = conn.prepareStatement("select * from users");
            Statement stsm = conn.createStatement();
            //4.执行sql语句
            //使用ResultSet接受
            ResultSet rs = stsm.executeQuery("select * from users");
            //5.while遍历结果集
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

}
