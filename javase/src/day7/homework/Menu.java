package day7.homework;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author Bmo
 * @date 2019/11/19 18:40
 */
public class Menu implements Serializable {
    HashMap<String, User> users = new HashMap<>();
    User currentUser;

    public void register() {
        Scanner sc = new Scanner(System.in);
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
        System.out.print("请设置你的密码：");
        password = sc.next();
        User user = new User(role, username, password);
        users.put(username, user);
        try {
            storeInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            printLoginMenu();
        } else {
            System.err.println("密码错误，请重试");
        }
    }

    public void printLoginMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            if (currentUser.getRole() == 1 || currentUser.getRole() == 2){
                System.out.println("\t\t1.展示用户列表");
                System.out.println("\t\t2.删除用户");
                System.out.println("\t\t3.修改密码");
                System.out.println("\t\t0.退出登陆");
            } else {
                System.out.println("\t\t1.展示用户列表");
                System.out.println("\t\t2.修改密码");
                System.out.println("\t\t0.退出登陆");
            }
            System.out.println("请输入你下一步的操作：");
            choice = sc.nextInt();
            if (currentUser.getRole() == 1 || currentUser.getRole() == 2) {
                switch (choice) {
                    case 1:
                        listUser();
                        break;
                    case 2:
                        deleteUser();
                        break;
                    case 3:
                        modifyUser();
                        break;
                    default:
                        currentUser = null;
                        break;
                }
            } else {
                switch (choice) {
                    case 1:
                        listUser();
                        break;
                    case 2:
                        modifyUser();
                        break;
                    default:
                        currentUser = null;
                        break;
                }
            }
        } while (choice != 0);
    }
    public void listUser() {
        Scanner sc = new Scanner(System.in);
        User tempUser;
        Iterator usersLit = users.entrySet().iterator();
        System.out.println("用户名-----------角色");
        while (usersLit.hasNext()) {
            Map.Entry<String, User> entry = (Map.Entry<String, User>) usersLit.next();
            tempUser = entry.getValue();
            System.out.println(tempUser.getUsername() + "-----------" + tempUser.getRoleStr());
        }
    }
    public void modifyUser() {
        Scanner sc = new Scanner(System.in);
        String password;
        System.out.println("请问你要把密码修改为什么呢？");
        password = sc.next();
        currentUser.setPassword(password);
        users.remove(currentUser.getUsername());
        users.put(currentUser.getUsername(), currentUser);
        try {
            storeInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("修改成功！");
    }
    public void deleteUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("===========目前所有用户：");
        this.listUser();
        System.out.print("请输入你要删除的用户的用户名：");
        String username = sc.next();
        if (username.equals(currentUser.getUsername())) {
            System.err.println("你不能删除自己！");
            return;
        }
        users.remove(username);
        try {
            storeInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("删除成功");
    }

    public void storeInfo() throws IOException {
        Scanner sc = new Scanner(System.in);
        File file = new File("F:\\practiceIO\\userInfo.dll");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
        fos.close();
    }


}
