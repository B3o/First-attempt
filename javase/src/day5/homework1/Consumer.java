package day5.homework1;

/**
 * @author Bmo
 * @date 2019/11/17 13:07
 */
public class Consumer implements Runnable {
    private PublicBox box;

    public Consumer(PublicBox box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            try {
                System.out.println("消费者第" + (i + 1) + "次开始消费");
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            box.consume();
        }
    }
}
