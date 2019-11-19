package day6.IOpractise;

import java.io.File;
import java.io.FileFilter;

/**
 * @author Bmo
 * @date 2019/11/18 16:48
 */
public class Question3 {
    public static void main(String[] args) {
        listJava("C:\\Users\\Bmo\\Desktop\\sc1911\\一阶段\\复习");
    }
    public static void listJava(String path) {
        File file = new File(path);
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                    return pathname.getName().endsWith(".java");
            }
        };
        if (file.isDirectory()) {
            for (File tmp : file.listFiles()) {
                listJava(tmp.getAbsolutePath());
            }
            for (File tmp : file.listFiles(fileFilter)) {
                System.out.println(tmp.getAbsolutePath());
            }
        }


    }

}

