package day7.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/19 19:11
 */
public class Start {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = null;
        try {
            menu = getStoreInfo();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (menu == null) {
            menu = new Menu();
        }
        int choice;
        do {
            System.out.println("欢迎进入人员管理系统");
            System.out.println("1.注册     2.登陆   0.退出");
            System.out.print("请选择你下一步操作：");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    menu.register();
                    break;
                case 2:
                    menu.login();
                    break;
            }
        } while (choice != 0);
    }
    public static Menu getStoreInfo() throws IOException, ClassNotFoundException {
        File file = new File("F:\\practiceIO\\userInfo.dll");
        if (!file.exists()) {
            System.err.println("序列化文件不存在，反序列化失败！");
            return null;
        }
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Menu temp = (Menu)ois.readObject();
        ois.close();
        fis.close();
        return temp;
    }
}
