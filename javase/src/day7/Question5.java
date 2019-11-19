package day7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Bmo
 * @date 2019/11/19 9:41
 * 在程序中写一个"HelloJavaWorld你好世界"输出到操作系统文件Hello.txt文件中
 */
public class Question5 {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\practiceIO\\Hello.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("文件新创建成功");
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write("HelloJavaWorld你好世界".getBytes("utf-8"));
        //这两行不要忘了
        fos.flush();
        fos.close();
        System.out.println("输出成功！");
    }
}
