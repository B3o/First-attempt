package service;

import dao.MailDao;
import entity.Mail;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author Bmo
 * @date 2019/12/15 17:58
 */
public class MailService {
    MailDao md = new MailDao();
    ObjectMapper mapper = new ObjectMapper();
    public List<Mail> queryReceiverMails(int page, String receiver) {
        return md.queryMails(page, receiver);
    }
    public int queryTotalPages(String receiver) {
        return md.queryMailsRowNum(receiver);
    }

    public boolean sendEmail(String title, String content, String sender, String receiver) {
        int result = md.addMail(title, content, sender, receiver);
        if (result > 0) {
            return true;
        }else {
            return false;
        }
    }
    public boolean delReceive(String id) {
        int result = md.delReceive(Integer.parseInt(id));
        if (result > 0) {
            return true;
        }
        return false;
    }
    public boolean delAllReceive(String[] ids) {
        if (ids == null || ids.length == 0) return false;
        for (String id : ids) {
            int i = md.delReceive(Integer.parseInt(id));
            if (i <= 0) return false;
        }
        return true;
    }
}
