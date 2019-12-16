package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Bmo
 * @date 2019/12/11 11:17
 * Java对象转为Json
 */
public class JacksonTest {
    public static void main(String[] args) {
        /*
        ArrayList<Person> persons = new ArrayList<>();
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(18);
        p.setGender("男");
        p.setBirthday(new Date());
        //2.创建Jackson核心对象   ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3.转换
        try {
            String json = mapper.writeValueAsString(p);
            System.out.println(json);
//            mapper.writeValue(new File("D:\\LOLFolder\\a.txt"), persons);
//            mapper.writeValue(new FileWriter("D:\\LOLFolder\\a.txt"), persons);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

    }
}
