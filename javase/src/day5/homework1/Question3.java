package day5.homework1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/11 19:15
 */
public class Question3 {
    public static void main(String[] args) {
        int[] clicks = new int[4];
        int time = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; ++i) {
            System.out.print("第" + (i+1) + "个游戏的点击率");
            clicks[i] = sc.nextInt();
            if (clicks[i] > 100) ++time;
        }
        System.out.println("点击率大于100的游戏数是：" + time);
        System.out.println("点击率大于100的游戏所占比例为：" + new DecimalFormat("##.#%").format(time/4.0));
    }
}
