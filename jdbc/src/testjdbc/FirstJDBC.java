package testjdbc;

import java.sql.*;

/**
 * @author Bmo
 * @date 2019/11/28 10:48
 */
public class FirstJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //0.导入驱动包
        //1.加载驱动类
         Class.forName("oracle.jdbc.driver.OracleDriver");
         //2.通过DriverManager创建连接
        String url = "jdbc:oracle:thin://localhost:1521:orcl";
        String username = "sc1911";
        String password = "1";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3.通过连接对象创建Statement对象
        Statement state = conn.createStatement();
        //4.通过statement对象创建sql语句
//        state.execute();
        //用于执行 增 删 改 查   返回值不适合程序后期的操作 一般用的很少
//        state.executeUpdate();
        //用于执行 增INSERT 删DELETE 改UPDATE 或者是不返回结果的DDL语句
        //返回值int类型   代表受影响的行数
//        state.executeQuery();
        //用于执行查询语句   返回值 ResultSet   查询的所有数据,保存在结果集里
        ResultSet rs = state.executeQuery("select * from users");
        while (rs.next()) {
            /*
                rs.getInt(数字) 每行数据的第几列
                rs.getInt(字符串) 字符串代表列名
            */
            Integer id = rs.getInt(1);
            String un = rs.getString("username");
            String pw = rs.getString(3);
            System.out.println(id + "===" + un + "===" + pw);
        }
        //6.关闭资源
        rs.close();
        state.close();
        conn.close();
    }
}
