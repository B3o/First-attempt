package day6.example2;

/**
 * @author Bmo
 * @date 2019/11/18 14:31
 */

public class Producer implements  Runnable{
    Product p; //共同拥有的商品对象


    public Producer() {
    }

    public Producer(Product p) {
        this.p = p;
    }
    /*
     * 当库存不足的时候，生产者需要进行生产
     * */
    @Override
    public void run() {
        while(true) {
            synchronized (p) {
                if (p.getNum() < p.getMaxNum()) { //消费者提醒，库存小于最大数量
                    int number = p.getMaxNum() - p.getNum();
                    String name = Thread.currentThread().getName();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + "生产了" + p.getName() + "商品，生产了" + number + "个数量，库存是" + p.getMaxNum());
                }
                p.setNum(p.getMaxNum()); //修改库存为最大值
                System.out.println("生产结束，消费者可以购买");
                //提醒消费者消费
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
