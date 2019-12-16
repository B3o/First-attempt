package dao;

import pojo.Email;
import pojo.User;
import util.DButil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Bmo
 * @date 2019/12/12 10:25
 */
public class UserDao {
    public int register(String un, String pw, String em) {
        String sql = "insert into e_user values(email_seq.nextval,?,?,?)";
        return DButil.update(sql, un, pw, em);
    }
    public User login(String un, String pw) {
        String sql = "select * from e_user where username = ? and password = ?";
        ResultSet rs = DButil.select(sql, un, pw);
        User u = null;
        try {
            if (rs.next()) {
                Integer id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String email = rs.getString(4);
                u = new User(id, username, password, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DButil.close(DButil.rs, DButil.pstmt, DButil.conn);
        return u;
    }
    public List<User> queryAll(){
        List<User> users = new ArrayList<>();
        String sql = "select * from e_user";
        ResultSet rs = DButil.select(sql);
        try {
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String email = rs.getString(4);
                User u = new User(id, username, password, email);
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}
