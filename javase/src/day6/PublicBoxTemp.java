package day6;

/**
 * @author Bmo
 * @date 2019/11/18 11:07
 */
public class PublicBoxTemp {
    private int pen = 0;

    public int getPen() {
        return pen;
    }

    public void setPen(int pen) {
        this.pen = pen;
    }

    public synchronized void consume() {
        while (pen == 0) {
            try {
                System.out.println("钢笔没了，我不买了");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费成功 目前还有" + pen + "只钢笔");
        --pen;
        notify();
    }

    public synchronized  void produce() {
        while (pen == 10) {
            try {
//                System.out.println("库存爆了，让我等消费者来买");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pen++;
            System.out.println("生产成功 目前还有" + pen + "只钢笔");
            notify();
        }
    }

    public static void main(String[] args) {
        PublicBox box = new PublicBox();
        Customer customer = new Customer(box);
        Producer producer = new Producer(box);
        Thread customerThread = new Thread(customer);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        customerThread.start();
    }
}
