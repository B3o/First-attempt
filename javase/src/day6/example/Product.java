package day6.example;

/**
 * @author Bmo
 * @date 2019/11/18 13:53
 */
public class Product {
    private String name;
    private Integer num;
    private Integer maxNum;

    public Product() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public Product(String name, Integer num, Integer maxNum) {
        this.name = name;
        this.num = num;
        this.maxNum = maxNum;
    }
}
