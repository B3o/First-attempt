package homework;

/**
 * @author Bmo
 * @date 2019/11/29 15:58
 */
public class Test {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; ++i) {
            if (i % 3 == 0) {
                sum -= i;
            } else {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
