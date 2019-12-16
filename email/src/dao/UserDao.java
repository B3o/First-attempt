package dao;

import entity.User;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Bmo
 * @date 2019/12/8 11:34
 */
public class UserDao {
    //登陆
    public User queryByUsernamePassword(String username, String password) {
        String sql = "select * from mail_users where username = ? and password = ?";
        ResultSet rs = DBUtil.query(sql, username, password);
        User u = null;
        try {
            if (rs.next()) {
                Integer id = rs.getInt("id");
                String un = rs.getString("username");
                String pw = rs.getString("password");
                u = new User(id, un, pw);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    //添加新用户
    public int addUser(String username, String password) {
        String sql = "insert into mail_users values(0, ?, ?)";
        return DBUtil.update(sql, username, password);
    }

    public List<User> queryAll(){
        List<User> users = new ArrayList<>();
        String sql = "select * from mail_users";
        ResultSet rs = DBUtil.query(sql);
        try {
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                User u = new User(id, username, password);
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
