package dao;

import entity.EUser;
import entity.User;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述: 针对用户表的数据访问层 负责执行持久化操作(CRUD)
 * @author Bmo
 * @date 2019/12/5 15:31
 */
public class UserDao {
    //登陆
    public User queryByUsernamePassword(String username, String password) {
        String sql = "select * from users where username = ? and password = ?";
        ResultSet rs = DBUtil.query(sql, username, password);
        User u = null;
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String un = rs.getString("username");
                String pw = rs.getString("password");
                Date time = rs.getDate("birthday");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                u = new User(id, un, pw, time, sex, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    //查询所有用户信息
    public List<User> queryAll() {
        List<User> users = new ArrayList<>();
        ResultSet rs = DBUtil.query("select * from users");
        try {
            while(rs.next()) {
                int id = rs.getInt("id");
                String un = rs.getString("username");
                String pw = rs.getString("password");
                Date time = rs.getDate("birthday");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                User u = new User(id, un, pw, time, sex, age);
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    //根据id查询对象2
    public User queryById(String id) {
        ResultSet rs = DBUtil.query("select * from users where id = ?", id);
        User u = null;
        try {
            while (rs.next()) {
                int id_num = rs.getInt("id");
                String un = rs.getString("username");
                String pw = rs.getString("password");
                Date time = rs.getDate("birthday");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                u = new User(id_num, un, pw, time, sex, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    //修改用户
    public int updateById(String id, String un, String pw, String time, String sex, Integer age) {
        String sql = "update users set username = ?, password = ?, " +
                "birthday = to_date(?, 'yyyy-mm-dd'), sex = ?, age = ? where id = ?";
         return DBUtil.update(sql, un, pw, time, sex, age, id);
    }
    //添加用户
    public int addUser(String un, String pw, String time, String sex, Integer age) {
        String sql = "insert into users values(id_seq.nextval, ?, ?, \n" +
                "to_date(?, 'yyyy-mm-dd'), ?, ?)";
        return DBUtil.update(sql, un, pw, time, sex, age);
    }
    //删除用户
    public int delUser(String id) {
        if (id == null || "".equals(id)) return -1;
        return DBUtil.deleteUser(Integer.valueOf(id));
    }
    public int register(String un, String pw, String path) {
        String sql = "insert into e_user values(email_seq.nextval, ?, ?, null, ?)";
        return DBUtil.update(sql, un, pw, path);
    }
//带图片的登陆
    public EUser login(String un, String pw) {
        String sql = "select * from e_user where username = ? and password = ?";
        ResultSet rs = DBUtil.query(sql, un, pw);
        EUser eUser = null;
        try {
            if (rs.next()) {
                Integer id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String path = rs.getString("head");
                eUser = new EUser(id, username, password, email, path);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eUser;
    }
    //带图片的展示数据
    public List<EUser> queryUserList() {
        List<EUser> eusers = new ArrayList<>();
        ResultSet rs = DBUtil.query("select * from e_user");
        try {
            while(rs.next()) {
                int id = rs.getInt("id");
                String un = rs.getString("username");
                String pw = rs.getString("password");
                String email = rs.getString("email");
                String head = rs.getString("head");
                EUser u = new EUser(id, un, pw, email, head);
                eusers.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eusers;
    }
}
