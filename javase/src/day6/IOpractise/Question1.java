package day6.IOpractise;

import java.io.File;
import java.io.IOException;

/**
 * @author Bmo
 * @date 2019/11/18 16:11
 * 在电脑D盘下创建一个文件为HelloWorld.txt文件，判断他是文件还是目录，在创建一个目
 * 录IOTest,之后将HelloWorld.txt移动到IOTest目录下去；之后遍历IOTest这个目录下的文
 * 件
 */
public class Question1 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "helloworld.txt");
        File dir = new File("D:" + File.separator + "IOTest");
        if (file.exists()) {
            System.out.println("文件已存在，创建失败");
        } else {
            file.createNewFile();
            System.out.println("创建成功");
        }
        if (file.isFile()) {
            System.out.println("它是一个文件");
        } else {
            System.out.println("它是一个目录");
        }
        dir.mkdir();
        file.renameTo(dir);
        String[] arr = dir.list();
        for (String tmp : arr) {
            System.out.println(tmp);
        }
//        for (File tmp : dir.listFiles()) {
//            System.out.println(tmp.getName());
//        }


    }
}
