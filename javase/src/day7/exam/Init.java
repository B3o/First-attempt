package day7.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化数据
 * @author Bmo
 * @date 2019/11/19 16:04
 */
public class Init {
    public static List<TestPaper> listPaper = new ArrayList<>();
    static {
        TestPaper java = new TestPaper();
        java.setId(1);
        java.setName("java周考试卷");
        List<Question> listJava = new ArrayList<>();


        listJava.add(new Question(1, "已知：int[] a = new int[100];在下列给出的数组元素中，非法的是。",
                "A、a[0]", "B、a[1]", "C、a[99]", "D、a[100]", "D"));
        listJava.add(new Question(2, "下列选项中关于Java中super关键字的说法错误的是",
                "A. super关键字是在子类对象内部指代其父类对象的引用",
          "B. super关键字不仅可以指代子类的直接父类，还可以指代父类的父类",
          "C.子类可以通过super关键字调用父类的方法",
          "D.子类可以通过super关键字调用父类的属性", "B"));
        java.setList(listJava);
        listPaper.add(java);
    }
}
