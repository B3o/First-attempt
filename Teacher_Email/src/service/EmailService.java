package service;

import dao.EmailDao;
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
 */
public class EmailService {
    EmailDao ed = new EmailDao();
    public boolean addEmail(String fromUser, String toUser, String title, String content) {
        int from = ed.addFromEmail(fromUser, toUser, title, content);
        int to = ed.addToEmail(fromUser, toUser, title, content);
        if (from > 0 && to > 0) {
            return true;
        }
        return false;
    }
    public List<Email> queryToUser(String username) {
        return ed.queryToUser(username);
    }
    public boolean delete(String id) {
        int result = ed.delete(Integer.parseInt(id));
        if (result > 0) {
            return true;
        }
        return false;
    }
    public boolean delAll(String[] ids) {
        for (String id : ids) {
            int i = ed.delete(Integer.parseInt(id));
            if (i <= 0) return false;
        }
        return true;
    }
    public List<Email> querySearchUser(String username, String search) {
//        dao
        return ed.querySearchUser(username, search);
    }
}
