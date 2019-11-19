package day7;

import java.io.*;

/**
 * @author Bmo
 * @date 2019/11/19 14:09
 */
public class TestInputStream {
    public static void main(String[] args) throws IOException{
        //字节转字符
        FileInputStream fis = new FileInputStream("F:\\practiceIO\\calcCharNum.txt");
        //isr就是一个字符流  继承自Reader
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        FileOutputStream fos = new FileOutputStream("F:\\practiceIO\\reader.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        String mess = "";
        while ((mess = br.readLine()) != null) {
            bw.write(mess);
            bw.write("\r\n");
        }
        //先关缓冲流 再关字符流 最后关字节流
        br.close();
        bw.close();
        isr.close();
        osw.close();
        fis.close();
        fos.close();
    }
}
