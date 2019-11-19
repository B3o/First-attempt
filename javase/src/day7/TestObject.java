package day7;

import org.junit.Test;

import java.io.*;

/**
 * @author Bmo
 * @date 2019/11/19 14:44
 */
public class TestObject {
    public static void main(String[] args) throws IOException {
        //1.序列化
        FileOutputStream fos = new FileOutputStream("F:\\practiceIO\\User.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        //2.直接使用方法实现序列化
        User user = new User(1, "admin", "123", "超级管理员");
        oos.writeObject(user);
        System.out.println("success");
        //3.关闭资源
        oos.close();
        fos.close();
    }
    @Test
    public void testObjectInputStream() throws Exception{
        FileInputStream fis = new FileInputStream("F:\\practiceIO\\User.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        User user = (User)ois.readObject();
        System.out.println(user.toString());

        ois.close();
        fis.close();
    }
}
