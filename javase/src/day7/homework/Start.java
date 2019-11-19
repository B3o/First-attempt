package day7.homework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author Bmo
 * @date 2019/11/19 19:11
 */
public class Start {
    Menu menu = new Menu();
    public static void main(String[] args) {

    }
    public void storeInfo() throws IOException {
        File file = new File("F:\\practiceIO\\userInfo.dll");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(menu);
    }
}
