package day6;

/**
 * @author Bmo
 * @date 2019/11/18 11:07
 */
public class Producer implements Runnable{
    PublicBox box;

    public Producer(PublicBox box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            try {
                System.out.println("消费者第" + (i + 1) + "次开始生产");
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            box.produce();
        }
    }
}
