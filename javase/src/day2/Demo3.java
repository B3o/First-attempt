package day2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/12 11:11
 */
public class Demo3 {
    ArrayList<String[]> userInfos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public  void register() {
        String name, pass;
        String num = "";
        System.out.println("请填写个人注册信息");
        System.out.print("用户名：");
        name = sc.nextLine();
        System.out.print("密码：");
        pass = sc.nextLine();
        Random r = new Random();
        for(int i = 0; i < 4; ++i) {
            num += r.nextInt(10);
        }
        userInfos.add(new String[]{name, pass, num});
        System.out.println("注册成功，请记好您的会员卡号");
        System.out.println("\t用户名\t密码\t会员卡号");
        System.out.println(name + "\t\t" + pass + "\t\t" + num);
    }
    public void lottery() {
        System.out.println("");
    }
    public static void main(String[] args) {
        Demo3 start = new Demo3();
        do {
            start.register();
            System.out.print("继续吗？（y/n）");
        } while (!"n".equals(new Scanner(System.in).next()));
        System.out.println("系统退出 谢谢使用！");



    }
}
