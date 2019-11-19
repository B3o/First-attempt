package day7;

import java.io.*;

/**
 *拷贝一张图片，从一个目录到另外一个目录下(PS:是拷贝是不是移动)
 * @author Bmo
 * @date 2019/11/19 9:46
 */
public class Question6 {
    public static void main(String[] args) {
        File target = new File("C:\\Users\\Bmo\\Pictures\\妙语连珠\\5d3ab75658080.jpg");
        try {
            copyFile(target, "F:\\practiceIO");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void copyFile(File target, String outPath) throws Exception {
        if (!target.exists()) {
            System.out.println("待拷贝文件不存在，程序结束");
            return;
        }
        File outFile = new File(outPath + File.separator + target.getName());
        if (!outFile.exists()) {
            outFile.createNewFile();
            System.out.println("副本创建成功");
        }
        FileInputStream fis = new FileInputStream(target);
        FileOutputStream fos = new FileOutputStream(outFile, true);
        int len = 0;
        byte[] buff = new byte[1024];
        while ((len = fis.read(buff)) != -1) {
            fos.write(buff);
        }
        fos.flush();
        fis.close();
        fos.close();
        System.out.println("复制成功");
    }
}
