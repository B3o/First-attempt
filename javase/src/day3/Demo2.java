package day3;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/13 15:55
 */
public class Demo2 {
    public static void main(String[] args) {
        String str, target;
        Boolean flag = false;
        int idx = 0;
        ArrayList<Integer> result = new ArrayList<>();
        System.out.println("输入字符串：");
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        System.out.println("输入要查找的词汇：");
        target = sc.next();
        int subLen = 0;
        int sumSubLen = 0;
        while (-1 != (idx = str.indexOf(target))) {
            idx = str.indexOf(target);
            result.add(idx + sumSubLen);
            subLen = idx + target.length();
            sumSubLen += subLen;
            str = str.substring(subLen);
        }
        if (result == null || result.size() == 0) {
            System.out.println("结果搜索不到");
            return;
        }
        for (int tmp : result) {
            System.out.print(tmp + "  ");
        }
    }
}
