package day6.example;

/**
 * @author Bmo
 * @date 2019/11/18 14:22
 */
public class TestProduct {
    public static void main(String[] args) {
        Product p = new Product("鞋子",0,10);
        Producer producer = new Producer(p);
        Customer c = new Customer(p);
        Thread t1 = new Thread(producer,"生产者");
        Thread t2 = new Thread(c,"消费者1");
        Thread t3 = new Thread(c,"消费者2");
        Thread t4 = new Thread(c,"消费者3");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
