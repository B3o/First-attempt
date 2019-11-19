package day3;

import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/13 11:40
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        StringBuilder sb = new StringBuilder("");
        int len;
        System.out.println("请输入要格式化的数字：");
        input = sc.next();
        System.out.println("格式化后的长度：");
        len = sc.nextInt();
        if (input.length() < len) {
            for (int i = len - input.length(); i > 0; --i) {
                sb.append("0");
            }
            sb.append(input);
        }
        System.out.println(sb);

    }
}
