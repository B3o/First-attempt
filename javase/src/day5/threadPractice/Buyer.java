package day5.threadPractice;

/**
 * @author Bmo
 * @date 2019/11/17 13:11
 */
public class Buyer implements Runnable{
    private String name;
    private String address;
    private String email;
    private String phone;
    private Account account;

    public Buyer(String name, String address, String email, String phone, Account account) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    //打印用户信息（基本信息+用户名下账户）
    public void printCustomerInfo()
    {
        System.out.println(" Information about a Buyer");
        System.out.println(" Name                - " + name);
        System.out.println(" address             - " + address);
        System.out.println(" email               - " + email);
        System.out.println(" phone #             - " + phone);
        if(account != null){
            account.printInfo();
        }
        else{
            System.out.println("The Buyer has no accounts");
        }

    }


    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            account.deposit(1000);
            System.out.println("在第" + (i+1) + "次存款后，余额还有：" + account.getBalance());
        }
    }
}
