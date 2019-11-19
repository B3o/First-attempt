package day6.example;

/**
 * @author Bmo
 * @date 2019/11/18 13:33
 */
public class Producer implements Runnable{
    Product p;

    public Producer(Product p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (p) {
                if (p.getNum() < p.getMaxNum()) {
                    int num = p.getMaxNum() - p.getNum();
                    String name = Thread.currentThread().getName();
                    System.out.println("生产者生产了" + num + "个" + name + "目前有" + p.getMaxNum());
                    p.setNum(p.getMaxNum());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    p.notifyAll();
                    p.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
