package day6.IOpractise;

import java.io.File;

/**
 * @author Bmo
 * @date 2019/11/18 16:32
 *  递归实现输入任意目录，列出文件以及文件夹，效果看图
 */
public class Question2 {
    public static void main(String[] args) {
        printFiles("C:\\Users\\Bmo\\Desktop\\sc1911\\一阶段\\复习");
    }
    public static void printFiles(String path) {
        File file = new File(path);
        if(file.isDirectory()) {
            for (File tmp : file.listFiles()) {
                printFiles(tmp.getAbsolutePath());
            }
        }
        System.out.println(file.toString());
    }
}
