package day5.threadPractice;

/**
 * @author Bmo
 * @date 2019/11/17 20:26
 */
public class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account() {
        balance = 0;
    }
    public void printInfo() {
        System.out.println("Balance on" + "account ="+ balance);
    }

    /**
     * 存款
     * @param amount
     */
    public synchronized void deposit(double amount) {
        double tmp = balance;
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp += amount;
        balance = tmp;
    }
    public synchronized void withdraw(double amount) {
        double tmp = balance;
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp -= amount;
        balance = tmp;
    }
}
