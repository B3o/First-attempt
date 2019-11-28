package day7;

import java.io.File;

/**
 * @author Bmo
 * @date 2019/11/19 17:55
 */
public class FileTest {
    public static void main(String[] args) {
       checkFile(new File("F:\\practiceIO\\examResult\\java周考试卷.txt"), 0);
    }
    public static void checkFile(File file, int time){
        String addStr;
        String fileName;
        if (time == 0) {
            addStr = "";
            fileName = file.getAbsolutePath();
        }else {
            addStr = "_" + time;
            String[] fileNameSpilt = file.getName().split("\\.");
            fileName = file.getParent() + File.separator + fileNameSpilt[0] + addStr + fileNameSpilt[1];

        }
        File parentDir = file.getParentFile();
        File[] files = parentDir.listFiles();
        for (File temp : files) {
            if (file.getName().equals(temp.getName())) {

            }
            System.out.println(temp.getName());
        }
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParentFile());


    }
}
