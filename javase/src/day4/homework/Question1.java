package day4.homework;

/**
 * @author Bmo
 * @date 2019/11/14 22:42
 */
public class Question1 {
    static int time = 0;
    private Question1() {
        Question1.time++;
    }
    public Question1 getInstance() throws Exception {
        if (time >= 11) {
            throw new Exception("最多创建11个对象");
        }else {
            return new Question1();
        }
    }
}
