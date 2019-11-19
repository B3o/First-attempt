package day6.example2;

/**
 * @author Bmo
 * @date 2019/11/18 14:30
 */

public class Product {
    private String name;//商品名称
    private Integer num; //库存
    private Integer maxNum; //最大商品数量

    public Product() {
    }

    public Product(String name, Integer num, Integer maxNum) {
        this.name = name;
        this.num = num;
        this.maxNum = maxNum;
    }

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
}
