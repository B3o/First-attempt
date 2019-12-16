package dao;

import pojo.Email;
import util.DButil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Bmo
 * @date 2019/12/12 15:41
 * 数据访问层
 */
public class EmailDao {
    public int addFromEmail(String fromName, String toName, String title, String content) {
        String sql = "insert into e_mail values(email_seq.nextval,?,?,?,?,0,sysdate)";
        return DButil.update(sql, fromName, toName, title, content);

    }
    public int addToEmail(String fromName, String toName, String title, String content) {
        String sql = "insert into f_email values(email_seq.nextval,?,?,?,?,0,sysdate)";
        return DButil.update(sql, toName, fromName, title, content);
    }
    public List<Email> queryToUser(String username) {
        String sql = "select * from f_email where fromname = ?";
        ResultSet rs = DButil.select(sql, username);
        List<Email> list = new ArrayList<>();
        try {
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String fromName = rs.getString(2);
                String toName = rs.getString(3);
                String title = rs.getString(4);
                String content = rs.getString(5);
                String status = rs.getString(6);
                Date time = rs.getTimestamp(7);
                Email e = new Email(id, fromName, toName, title, content, status, time);
                list.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //根据id删除邮件
    public int delete(Integer id) {
        String sql = "delete from f_email where id = ?";
        return DButil.update(sql, id);
    }
    public List<Email> querySearchUser(String username, String search) {
        String sql = "select * from f_email where fromname = ? and (toname like ? or title like ? or content like ?)";
        ResultSet rs = DButil.select(sql, username, "%" + search + "%", "%" + search + "%", "%" + search + "%");
        List<Email> list =  new ArrayList<>();
        try {
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String fromName = rs.getString(2);
                String toName = rs.getString(3);
                String title = rs.getString(4);
                String content = rs.getString(5);
                String status = rs.getString(6);
                Date time = rs.getTimestamp(7);
                Email e = new Email(id, fromName, toName, title, content, status, time);
                list.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
