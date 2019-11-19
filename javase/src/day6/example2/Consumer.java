package day6.example2;

/**
 * @author Bmo
 * @date 2019/11/18 14:31
 */

import java.util.Random;

public class Consumer implements  Runnable{
    Product p; //共同拥有的商品对象

    @Override
    public void run() {
        while(true){
            synchronized (p) {
                String name = Thread.currentThread().getName();
                Random r = new Random();
                int randomNumber = r.nextInt(p.getMaxNum()) + 1;  //随机消费数
                if (randomNumber > p.getNum()) {
                    System.out.println(name + "准备购买" + randomNumber + "个商品，但是库存不足");
                    //提醒生产者生产
                    try {
                        p.notifyAll();
                        p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                p.setNum(p.getNum() - randomNumber); //修改库存数量
                System.out.println(name + "买了" + randomNumber + "个商品，库存是" + p.getNum());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Consumer() {
    }

    public Consumer(Product p) {
        this.p = p;
    }
}
