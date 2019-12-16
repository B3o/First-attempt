package service;

import dao.UserDao;
import entity.EUser;

import java.util.List;

/**
 * @author Bmo
 * @date 2019/12/16 11:18
 */
public class UserService {
    UserDao ud = new UserDao();
    public boolean register(String username, String password, String path) {
        int result = ud.register(username, password, path);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
    public EUser login(String un, String pw) {
        return ud.login(un, pw);
    }
    public List<EUser> queryAll() {
        return ud.queryUserList();
    }
}
