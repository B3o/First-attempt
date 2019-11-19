package day5.homework1;

/**
 * @author Bmo
 * @date 2019/11/17 13:07
 */
public class Producer implements Runnable {
    private PublicBox box;

    public Producer(PublicBox box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            try {
                System.out.println("生产者第" + (i + 1) + "次生产");
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            box.produce();
        }
    }
}
