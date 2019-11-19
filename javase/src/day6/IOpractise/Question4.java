package day6.IOpractise;



import java.io.*;


/**
 * 从磁盘读取一个文件到内存中，再打印到控制台
 * @author Bmo
 * @date 2019/11/18 17:16
 */
public class Question4 {
    public static void main(String[] args) {
        printContent(new File("D:\\QQtemp\\84262602\\FileRecv\\weekendTest\\Product.java"));
    }
    public static void printContent(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] buf = new byte[1024];
            StringBuilder sb = new StringBuilder();
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                sb.append(new String(buf, 0, len));
            }
            System.out.println(sb);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
