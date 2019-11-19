package day3.homework;

/**
 * @author Bmo
 * @date 2019/11/13 19:03
 */
public class Question5 {
    public static void main(String[] args) {
        String target = "      miao  v        ";
        char[] chars = target.toCharArray();
        int i = 0, j = target.length() - 1;
        while (chars[i] == ' ') i++;
        while (chars[j] == ' ') j--;
        System.out.println(target.substring(i, ++j));
    }
}
