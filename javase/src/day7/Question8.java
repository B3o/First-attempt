package day7;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 *     统计一个文件calcCharNum.txt（见附件）中各个字母出现次数：
 *     A(8),B(16),C(10)...,a(12),b(10),c(3)....，括号内代表字符出现次数;
 * @author Bmo
 * @date 2019/11/19 10:36
 */
public class Question8 {
    public static void main(String[] args) {
        File file = new File("F:\\practiceIO\\calcCharNum.txt");
        try {
//            calcCharNum(file);
            calcCharNumFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void calcCharNumFile(File file) throws IOException {
        if (!file.exists()){
            System.out.println("文件不存在，程序退出");
            return;
        }
        HashMap<String, Integer> result = new HashMap<>();
        FileReader fr = new FileReader(file);
        int len = 0;
        while ((len = fr.read()) != -1) {
            char tmp = (char) len;
            String tmpStr = new String(tmp + "");
//            if (!((len >= 65 && len <= 90) || ((len >= 97) && (len <= 122)))){
//                continue;
//            }
            if (!result.containsKey(tmpStr)) {
                result.put(tmpStr, 1);
            }else {
                result.put(tmpStr, result.get(tmpStr) + 1);
            }
        }
        for (Map.Entry entry: result.entrySet()) {
            System.out.println(entry);
        }
    }

    public static void calcCharNum(File file) throws IOException {
        if (!file.exists()){
            System.out.println("文件不存在，程序退出");
            return;
        }
        HashMap<String, Integer> result = new HashMap<>();
        FileInputStream fis = new FileInputStream(file);
        int len = 0;
        while ((len = fis.read()) != -1) {
            char tmp = (char) len;
            String tmpStr = new String(tmp + "");
            if (!((len >= 65 && len <= 90) || ((len >= 97) && (len <= 122)))){
                continue;
            }
            if (!result.containsKey(tmpStr)) {
                result.put(tmpStr, 1);
            }else {
                result.put(tmpStr, result.get(tmpStr) + 1);
            }
        }
        for (Map.Entry entry: result.entrySet()) {
            System.out.println(entry);
        }
    }
    public static void calcCharNumFiletoCharacter(File file) throws IOException {
        if (!file.exists()){
            System.out.println("文件不存在，程序退出");
            return;
        }
        HashMap<String, Integer> result = new HashMap<>();
        FileReader fr = new FileReader(file);
        int len = 0;
        while ((len = fr.read()) != -1) {
            char tmp = (char) len;
            String tmpStr = new String(tmp + "");
//            if (!((len >= 65 && len <= 90) || ((len >= 97) && (len <= 122)))){
//                continue;
//            }
            if (!result.containsKey(tmpStr)) {
                result.put(tmpStr, 1);
            }else {
                result.put(tmpStr, result.get(tmpStr) + 1);
            }
        }
        for (Map.Entry entry: result.entrySet()) {
            System.out.println(entry);
        }
    }
}
