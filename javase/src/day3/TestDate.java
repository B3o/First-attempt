package day3;

import java.time.LocalDate;

/**
 * @author Bmo
 * @date 2019/11/13 14:53
 */
public class TestDate {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        LocalDate ld2 = LocalDate.of(2018, 11, 12);
        System.out.println(ld2);
    }
}
