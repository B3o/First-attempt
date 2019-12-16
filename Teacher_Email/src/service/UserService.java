package service;

import dao.UserDao;
import pojo.User;

import java.util.List;

/**
 * @author Bmo
 * @date 2019/12/12 10:25
 */
public class UserService {
    UserDao ud = new UserDao();
    public boolean register(String un, String pw, String em) {
        //依赖于DAO层(对数据库CRUD)
        if (ud.register(un, pw, em) > 0) {
            return true;
        } else {
            return false;
        }
    }
    public User login(String un, String pw) {
        return ud.login(un, pw);
    }
    public List<User> queryAll() {
        return ud.queryAll();
    }
}
