package day7;

import java.io.File;

/**
 * @author Bmo
 * @date 2019/11/19 17:55
 */
public class FileTest {
    public static void main(String[] args) {
//        checkFile(new File("F:\\practiceIO\\examResult\\java周考试卷.txt"));
    }
    public static void checkFile(File file, int time){
        File parentDir = file.getParentFile();

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParentFile());


    }
}
