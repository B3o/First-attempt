package day6;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Bmo
 * @date 2019/11/18 14:50
 */
public class TestPool {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; ++i) {
            ex.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
