package day3.homework;

/**
 * @author Bmo
 * @date 2019/11/13 18:53
 */
public class Question4 {
    public static void main(String[] args) {
        String target = "miao-wei-ke-tang";
        String[] strs = target.split("-");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; ++i) {
            if (i == 0) {
                sb.append(strs[0]);
                continue;
            } else {
//                String firstStr = strs[i].charAt(0) + "";
//                sb.append(firstStr.toUpperCase());
                sb.append((char)((int)strs[i].charAt(0) - 32));
                sb.append(strs[i].substring(1));
            }
        }
        System.out.println(sb);
    }
}
