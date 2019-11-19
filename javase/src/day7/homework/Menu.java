package day7.homework;

import java.io.*;
import java.util.*;

/**
 * @author Bmo
 * @date 2019/11/19 18:40
 */
public class Menu implements Serializable {
    HashMap<String, User> users = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    User currentUser;

    public void register() {
        String username, password;
        int role;
        System.out.println("(1.超级管理员 2.管理员  3.普通用户  4.游客)");
        System.out.print("请选择你想成为的身份：");
        role = sc.nextInt();
        System.out.print("请输入用户名：");
        username = sc.next();
        if (users.containsKey(username)) {
            System.err.println("该用户名已存在，请重新注册");
            return;
        }
        System.out.print("请设置你的密码");
        password = sc.next();
        User user = new User(role, username, password);
        users.put(username, user);
    }
    public void login() {
        String username, password;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名：");
        username = sc.next();
        if (!users.containsKey(username)) {
            System.err.println("用户名不存在，请重新输入");
            return;
        }
        System.out.print("请输入密码：");
        password = sc.next();
        if (password.equals(users.get(username).getPassword())) {
            System.out.println("登陆成功");
            currentUser = users.get(username);
            //打印菜单方法
        } else {
            System.err.println("密码错误，请重试");

        }
    }

    public void printLoginMenu() {
        if (currentUser.getRole() == 1 || currentUser.getRole() == 2){
            System.out.println("\t\t1.展示用户列表");
            System.out.println("\t\t2.删除用户");
            System.out.println("\t\t3.修改用户");
            System.out.println("\t\t0.退出登陆");
        } else {
            System.out.println("\t\t1.展示用户列表");
            System.out.println("\t\t2.修改用户");
            System.out.println("\t\t0.退出登陆");
        }
        System.out.println("请输入你下一步的操作：");
        int choice = sc.nextInt();
        if (currentUser.getRole() == 1 || currentUser.getRole() == 2) {
            switch (choice) {
                case 1:
                    this.listUser();
                    break;
                case 2:
                    //删除用户
                    break;
                case 3:
                    //修改用户
                    break;
                default:
                    return;
            }
        } else {
            switch (choice) {
                case 1:
                    this.listUser();
                    break;
                case 2:
                    //修改用户
                    break;
                default:
                    return;
            }
        }

    }
    public void listUser() {
        User currentUser;
        Iterator usersLit = users.entrySet().iterator();
        System.out.println("用户名-----------角色");
        while (usersLit.hasNext()) {
            Map.Entry<String, User> entry = (Map.Entry<String, User>) usersLit.next();
            currentUser = entry.getValue();
            System.out.println(currentUser.getUsername() + "-----------" + currentUser.getRoleStr());
        }
    }
    public void modifyUser() {
        System.out.println("个人练习");
    }


}
