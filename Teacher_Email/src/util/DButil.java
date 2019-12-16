package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 描述： JDBC工具类
 *
 * @author songsong
 * @create 2019/11/28 16:47
 */
public class DButil {
    public static Connection conn=null;
    public static PreparedStatement pstmt=null;
    public static ResultSet rs=null;
    private static String url;//请求地址
    private static String driver;//驱动包地址
    private static String username;//数据库账号
    private static String password;//数据库密码
    static{
        //类加载执行一次,加载一次配置文件，获取结果 给变量赋值
        //会把经出修改的内容通过配置文件的方式进行储存
        //读取配置文件 参数是配置文件路径
        InputStream is=DButil.class.getClassLoader()
                .getResourceAsStream("config/jdbc.properties");
        //创建配置文件对象 properties对象
        Properties pro=new Properties();
        try {
            //通过输入流读取
            pro.load(is);
            //pro.getProperty("key")===> value
            username=pro.getProperty("username");
            password=pro.getProperty("password");
            url=pro.getProperty("url");
            driver=pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //ThreadLocal   本地线程
    //当我第一获取getConnection 先判断线程中是否存在连接
    //若果存在了不需要创建新的  只要通过从线程中取
    //如果不存在  创建新的连接  把连接存入线程
    static ThreadLocal<Connection> tl=new ThreadLocal<>();

    //获取连接方法
    public static Connection getConnection(){
        try {
            if(tl.get()==null){
                conn=DriverManager.getConnection(url,username,password);
                tl.set(conn);
            }else{
                conn=tl.get();
            }
            System.out.println(conn+"-----------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //关闭资源方法
    //AutoCloseable 是ResultSet Connection PreparedStatement  父类
    //如果  不知道可能会传递的参数个数  可以使用数组
    // 可以使用 ... 这样可以任意个参数   able相当于数组  数组个数由参数个数决定
    public static void close(AutoCloseable ... able){//相当于传传入一个可变长度的数组
        //able就是一个AutoCloseable 数组
        try {
            for(AutoCloseable auto:able){
                if(auto!=null)auto.close();
                //让本地线程清空
                tl.set(null);  // connection   提示你关闭的连接
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public static void test(){
//        Connection conn=null;
//        PreparedStatement pstmt=null;
//        ResultSet rs=null;
//        close(pstmt,rs,conn,conn,rs,pstmt);
//    }
    //增  删 改 通用方法（只有sql 和参数,可以通过参数传递不同sql和参数 ）
    public  static int update(String sql,Object ... o){ //后期参数的顺序一定要跟?的顺序一致
        conn=getConnection();  //1-2 步
        int result= 0;
        try {
            pstmt=conn.prepareStatement(sql); //3步
            //如果有参数需要处理
            if(o!=null) {
                for (int i=0;i<o.length;i++) {
                    //通过传入的参数给?赋值  由于之前顺序固定   传值的顺序和参数的顺序是一致的
                    pstmt.setObject((i+1),o[i]);
                }
            }
            result = pstmt.executeUpdate();//4步
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(pstmt,conn);     //6步
        return result;
    }
    //查询通用方法  （因为都有同一个返回值  ResultSet）
    public static ResultSet select(String  sql,Object ... o){
        conn=getConnection();
        try {
            pstmt=conn.prepareStatement(sql);
            //如果有参 需要处理
            if(o!=null){
                for(int i=0;i<o.length;i++){
                    pstmt.setObject((i+1),o[i]);
                }
            }
            rs=pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //这里不能关闭资源  因为后面的方法需要处理rs
        return rs;
    }
}
