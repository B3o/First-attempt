package day7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 统计一个文件calcCharNum.txt（见附件）中字母'A'和'a'出现的总次数
 * @author Bmo
 * @date 2019/11/19 10:09
 */
public class Question7 {
    public static void main(String[] args) {
        File file = new File("F:\\practiceIO\\calcCharNum.txt");
        try {
            calcCharNum(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void calcCharNum(File file) throws IOException {
        int timesa = 0, timesA = 0;
        if (!file.exists()) {
            System.out.println("文件不存在，程序退出");
            return;
        }
        FileInputStream fis = new FileInputStream(file);
        int len = 0;
        /*
        byte[] buff = new byte[1];
        while ((len = fis.read(buff)) != -1) {
            String tmp = new String(buff);
            if ("a".equals(tmp)) {
                ++timesa;
            } else if ("A".equals(tmp)) {
                ++timesA;
            }
        }
        */
        while ((len = fis.read()) != -1) {
            if ("a".equals(new String((char)(len) + ""))) {
                ++timesa;
            }
            if ("A".equals(new String((char)(len) + ""))) {
                ++timesA;
            }
        }
        System.out.println("a出现的次数是：" + timesa);
        System.out.println("A出现的次数是：" + timesA);
    }
}
