import day6.example2.*;

public class TestProduct {
    public static void main(String[] args) {
        Product p = new Product("鞋子",0,10);
        Producer producer = new Producer(p);
        Consumer c = new Consumer(p);
        Thread t1 = new Thread(producer,"生产者");
        Thread t2 = new Thread(c,"消费者1");
//        Thread t3 = new Thread(c,"消费者2");
//        Thread t4 = new Thread(c,"消费者3");
        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
    }
}
