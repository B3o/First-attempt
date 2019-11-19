package day3.homework;

import java.util.ArrayList;

/**
 * @author Bmo
 * @date 2019/11/13 18:46
 */
public class Homework3 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, 1, 10, 4, 5, 8};
        int maxIdx = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; ++i) {
            String num = nums[i] + "";
            if (num.startsWith("-")) continue;
            if (num.length() > maxLen) {
                maxIdx = i;
                maxLen = num.length();
            }
        }
        System.out.println("max num:" + nums[maxIdx]);

    }
}
