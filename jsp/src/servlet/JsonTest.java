package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Person;

import java.io.IOException;

/**
 * @author Bmo
 * @date 2019/12/11 14:30
 */
public class JsonTest {
    public static void main(String[] args) {
        String json = "{\"name\":\"张三\",\"age\":18,\"gender\":\"男\",\"birthday\":\"2019-12-11 06:00:52\"}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            Person person = mapper.readValue(json, Person.class);
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
