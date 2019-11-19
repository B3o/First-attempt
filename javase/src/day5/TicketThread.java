package day5;

import org.junit.Test;

/**
 * @author Bmo
 * @date 2019/11/15 16:03
 */
public class TicketThread extends Thread {
    private int ticket = 10;
    @Override
    public void run() {
        while (true) {
            Thread th = Thread.currentThread();
            System.out.println(th.getName() + "出售" + ticket-- + "号票");
            if (ticket < 1) {
                System.err.println("票已售完");
                break;
            }
        }
    }
}
