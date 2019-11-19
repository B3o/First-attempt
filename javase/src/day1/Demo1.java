package day1;

import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/11 9:31
 */
public class Demo1 {
    public static void main(String[] args) {
        int choice, money, total = 0;
        String otherStr = "";
        System.out.print("请输入消费金额：");
        Scanner sc = new Scanner(System.in);
        money = sc.nextInt();
        total += money;
        System.out.println("......描述信息省略");
        System.out.print("是否参加优惠换购活动：");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                if (money < 50) {
                    warningInfo();
                    break;
                }
                otherStr = "百事可乐饮料1瓶";
                total += 2;
                break;
            case 2:
                if (money < 100) {
                    warningInfo();
                    break;
                }
                otherStr = "500ml可乐一瓶";
                total += 3;
                break;
            case 3:
                if (money < 100) {
                    warningInfo();
                    break;
                }
                otherStr = "5公斤面粉";
                total += 10;
                break;
            case 4:
                if (money < 200) {
                    warningInfo();
                    break;
                }
                otherStr = "1个苏泊尔炒菜锅";
                total += 10;
                break;
            case 5:
                if (money < 200) {
                    warningInfo();
                    break;
                }
                otherStr = "欧莱雅爽肤水一瓶";
                total += 20;
                break;
        }
        System.out.println("本次成功消费金额：" + total);
        if (otherStr != "") {
            System.out.println("成功换购：" + otherStr);
        }
    }
    public static void warningInfo() {
        System.out.println("消费金额不足，无法换购此商品");
    }
}
