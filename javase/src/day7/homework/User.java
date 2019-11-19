package day7.homework;

import java.io.Serializable;

/**
 * @author Bmo
 * @date 2019/11/19 18:38
 */
public class User implements Serializable {
    private int role;
    private String username;
    private String password;

    public User(int role, String username, String password) {
        this.role = role;
        this.username = username;
        this.password = password;
    }
    public int getRole() {
        return role;
    }

    public String getRoleStr() {
        switch (role) {
            case 1:
                return "超级管理员";
            case 2:
                return "管理员";
            case 3:
                return "普通用户";
            case 4:
                return "游客";
            default:
                return "";
        }
    }

    public void setRole(int role) {
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
