package day5.homework1;

import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/11 18:58
 */
public class Question2 {
    public static void main(String[] args) {
        String str;
        int time = 0;
        Boolean flag = false;
        Scanner sc = new Scanner(System.in);
        int[] score = new int[5];
        for (int i = 0; i < 5; ++i) {
            System.out.print("您正在玩第" + (i+1) + "局，成绩为：");
            score[i] = sc.nextInt();
            if (i == 4) break;
            System.out.print("继续玩下一局吗？（yes/no）");
            str = sc.next();
            if ("no".equals(str)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("您已经中途退出游戏");
            System.out.println("对不起，您未能晋级，继续加油啊！");
            return;
        } else {
            for (int temp : score) {
                if (temp >= 80) {
                    ++time;
                }
            }
        }
        switch (time) {
            case 5:
            case 4:
                System.out.println("您为一级，晋级成功！");
                break;
            case 3:
                System.out.println("您为二级，晋级成功！");
                break;
                default:
                    System.out.println("对不起，您未能晋级，继续加油啊！");
        }
    }
}
