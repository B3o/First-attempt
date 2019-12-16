package day8;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/12/4 14:52
 */
public class Guess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int randomNum = new Random().nextInt(80) + 1;
        int guessNum = -1;
        do {
            System.out.print("请输入你要猜的数字:");
            guessNum = sc.nextInt();
            if (guessNum < randomNum) {
                System.out.println("请猜大一点的数.");
            } else if (guessNum > randomNum) {
                System.out.println("请猜小一点的数.");
            }
        } while (randomNum != guessNum);
        System.out.println("终于猜对了,游戏结束");
    }
}
