package day7.exam;

import java.util.List;

/**
 * @author Bmo
 * @date 2019/11/19 16:00
 */
public class TestPaper {
    private Integer id;
    private String name;
    private List<Question> list;

    public TestPaper() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getList() {
        return list;
    }

    public void setList(List<Question> list) {
        this.list = list;
    }

    public TestPaper(Integer id, String name, List<Question> list) {
        this.id = id;
        this.name = name;
        this.list = list;
    }
}
