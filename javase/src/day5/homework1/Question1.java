package day5.homework1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/11 18:46
 */
public class Question1 {
    public static void main(String[] args) {
        double count, sum = 0;
        String str = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择您玩的游戏类型：");
        System.out.println("\t\t1.牌类");
        System.out.println("\t\t2.休闲竞技类");
        int choice = sc.nextInt();
        System.out.println("请输入您的游戏时长：");
        int time = sc.nextInt();
        if (time > 10) {
            count = 0.5;
        }else {
            count = 0.8;
        }
        switch (choice) {
            case 1:
                sum = time * 10 * count;
                str = "牌类游戏";
                break;
            case 2:
                sum = time * 20 * count;
                str = "休闲竞技类";
                break;
        }
        System.out.printf("您玩的游戏是%s,时长是：%d小时",str, time);
        System.out.println("可以享受"+ new DecimalFormat("#.##").format(count * 10)
                +"折优惠，您需要支付"+ new DecimalFormat("#.##").format(sum) +"个游戏币");
    }
}
