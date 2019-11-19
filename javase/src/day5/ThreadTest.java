package day5;

import org.junit.Test;


/**
 * @author Bmo
 * @date 2019/11/15 15:22
 */
public class ThreadTest extends Thread{
    public ThreadTest(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println(this.getName());
        }
    }

}
