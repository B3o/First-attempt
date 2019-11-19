package day4;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bmo
 * @date 2019/11/14 11:19
 */
public class TestJunit {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        for(Map.Entry<String, Object> entry :map.entrySet()){
            System.out.println(entry.getKey()+"::::"+entry.getValue());
        }
    }
}
