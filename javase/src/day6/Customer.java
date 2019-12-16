package day6;

/**
 * @author Bmo
 * @date 2019/11/18 11:07
 */
public class Customer implements Runnable{
    PublicBox box;
    int equals;

    public Customer(PublicBox box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("消费者第" + (i + 1) + "次开始消费");
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            box.consume();
        }
    }
}
