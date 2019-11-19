package day5;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Bmo
 * @date 2019/11/15 10:16
 */
public abstract class YoungMan {
    public static void main(String[] args) {


    }
    public static int Calc() {
        int sum = 0;
        for (int i = 1; i <= 100; ++i) {
            if (i % 3 == 0) {
                sum -= i;
            } else {
                sum += i;
            }
        }
        return sum;
    }

}
