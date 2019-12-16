package service;

import dao.UserDao;
import entity.User;

import java.util.List;

/**
 * @author Bmo
 * @date 2019/12/15 17:38
 */
public class UserService {
    UserDao ud = new UserDao();
    public User login(String un, String pw) {
       return ud.queryByUsernamePassword(un, pw);
    }
    public boolean register(String un, String pw) {
        if (ud.addUser(un, pw) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<User> queryAll() {
        return ud.queryAll();
    }
}
