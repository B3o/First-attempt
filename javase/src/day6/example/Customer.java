package day6.example;

import java.util.Random;

/**
 * @author Bmo
 * @date 2019/11/18 13:33
 */
public class Customer implements Runnable {
    Product p;

    public Customer(Product p) {
        this.p = p;
    }

    @Override
    public void run() {

        /*
        while (true) {
            synchronized (p) {
                String name = Thread.currentThread().getName();
                Random r = new Random();
                int num = r.nextInt(p.getMaxNum()) + 1;
                if (num > p.getNum()) {
                    System.out.println(name + "准备购买" + name + "发现库存不足，已提醒消费者");
                    p.notifyAll();
                    try {
                        p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                p.setNum(p.getNum() - num);
                System.out.println(name + "买了" + num + "个商品，库存是" + p.getNum());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*/
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
}
