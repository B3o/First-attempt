package day5.homework1;

/**
 * @author Bmo
 * @date 2019/11/17 21:06
 */
public class PublicBox {
    private int pen = 0;
    public synchronized void produce() {
        while (pen == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pen++;
        System.out.println("生产出了钢笔,钢笔还有" + pen);
        notify();
    }

    public synchronized  void consume() {
        while (pen == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        pen--;
        System.out.println("消费了钢笔,钢笔还剩" + pen);
        notify();
    }

    public static void main(String[] args) {
        PublicBox box = new PublicBox();
        Consumer consumer = new Consumer(box);
        Producer producer = new Producer(box);
        Thread conThread = new Thread(consumer);
        Thread proThread = new Thread(producer);
        proThread.start();
        conThread.start();
    }
}
