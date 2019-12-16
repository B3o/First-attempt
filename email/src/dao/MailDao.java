package dao;

import entity.Mail;
import entity.User;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bmo
 * @date 2019/12/8 21:53
 */
public class MailDao {

    public List<Mail> queryMails(int rowNum, String receiver) {
        List<Mail> mails = new ArrayList<>();
        String sql = "select * from\n" +
                "(\n" +
                "       select temp.*, rownum r from\n" +
                "       (\n" +
                "       select mails.*, readed from mails, mail_receive\n" +
                "       where mails.id = mail_receive.id and mails.receiver = ?\n" +
                "       order by time desc\n" +
                "       )temp \n" +
                ")where r > 5*? and r <= 5*?";
        ResultSet rs = DBUtil.query(sql, receiver, rowNum - 1, rowNum);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  hh:mm:ss");
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                String sender = rs.getString(4);
    //            String receiver = rs.getString(5);
                String time = sdf.format(rs.getTimestamp(6));
                Boolean readed = (rs.getInt(7) == 1 ? true : false);
                Mail mail = new Mail(id, title, content, sender, receiver, time, readed);
                mails.add(mail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mails;
    }
    public int queryMailsRowNum(String receiver) {
        String sql = "select ceil(count(1)/5.0) from mails where receiver = ?";
        ResultSet rs = DBUtil.query(sql, receiver);
        int result = 1;
        try {
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
    public int addMail(String title, String content, String sender, String receiver) {
        String sql = "insert into mails values(0, ?, ?, ?, ?,sysdate)";
        return  DBUtil.update(sql, title, content, sender, receiver);
    }
    public int delReceive(Integer id) {
        String sql = "delete from mail_receive where id = ?";
        return DBUtil.update(sql, id);
    }
    public int delSender(Integer id) {
        String sql = "";
        return 0;
    }

    public List<Mail> searchMails(String search, String receiver, int rowNum) {
        List<Mail> mails = new ArrayList<>();
        String sql = " select * from\n" +
                "(\n" +
                "       select temp.*, rownum r from\n" +
                "       (\n" +
                "       select mails.*, readed from mails, mail_receive\n" +
                "       where mails.id = mail_receive.id and mails.receiver = ?\n" +
                "       and (etitle like ? or sender like ? or econtent like ?)\n" +
                "       order by time desc\n" +
                "       )temp \n" +
                ")temp2 where temp2.r > ?*5 and temp2.r <= ?*5";
        ResultSet rs = DBUtil.query(sql, receiver,"%" + search + "%", "%" + search + "%" ,"%" + search + "%", rowNum - 1, rowNum);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  hh:mm:ss");
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                String sender = rs.getString(4);
                //            String receiver = rs.getString(5);
                String time = sdf.format(rs.getTimestamp(6));
                Boolean readed = (rs.getInt(7) == 1 ? true : false);
                Mail mail = new Mail(id, title, content, sender, receiver, time, readed);
                mails.add(mail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mails;
    }

    public int searchTotalPage(String search, String receiver) {
        String sql = "       select ceil(count(1)/5.0) from mails, mail_receive\n" +
                "       where mails.id = mail_receive.id and mails.receiver = ?\n" +
                "       and (etitle like ? or sender like ? or econtent like ?)";
        ResultSet rs = DBUtil.query(sql, receiver, "%" + search + "%", "%" + search + "%", "%" + search + "%");
        int result = 1;
        try {
            if (rs.next()) {
                result =  rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 0) {
            result = 1;
        }
        return result;
    }
}
