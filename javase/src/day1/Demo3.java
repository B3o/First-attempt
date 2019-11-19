package day1;

import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/11 17:10
 */
public class Demo3 {
    public static int calc(int num) {
        if (num == 1) return num;
        else return num * calc(num - 1);
    }

    public static void main(String[] args) {
        int sum = 0, n;
        System.out.print("请输入n：");
        n = new Scanner(System.in).nextInt();
        for (int i = 1; i <= n; i++) {
            sum += calc(i);
        }
        System.out.println(sum);
    }
}
