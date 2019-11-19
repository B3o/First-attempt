package day3.homework;

import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/13 17:08
 */
public class Homework2 {
    public static void main(String[] args) {
        int formatTime;
        String num;
        int cut = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要格式化的数字：");
        num  = sc.next();
        formatTime = num.length() / 3;
        if (num.length() % 3 == 0) --formatTime;
        if (formatTime == 0) {
            System.out.println(num);
            return;
        }
        for (int i = 0; i < formatTime; ++i) {
            if (i == 0) {
                int firstCut = num.length() % 3;
                count += firstCut;
                if (firstCut == 0) firstCut = 3;
                sb.append(num.substring(0, firstCut));
            } else {
                sb.append(num.substring(count, count + 3));
                count += 3;
            }
            sb.append(",");
        }
        sb.append(num.substring(num.length() - 3, num.length()));
        System.out.println(sb);
    }
}
