package day2;

import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/12 9:55
 */
public class Demo2 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你要插入的数字：");
        int insertNum = sc.nextInt();
        int[] result = new int[arr.length + 1];
        for (int i = 0; i < result.length; i++) {
            if (i <= 1) {
                result[i] = arr[i];
            }
            if (i == 2) {
                result[i] = insertNum;
            }
            if (i > 2) {
                result[i] = arr[i - 1];
            }
        }
        for (int tmp : result) {
            System.out.print(tmp + " ");
        }
    }
}
