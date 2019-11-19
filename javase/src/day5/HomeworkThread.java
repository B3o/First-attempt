package day5;

/**
 * @author Bmo
 * @date 2019/11/15 11:03
 */
public class HomeworkThread extends Thread {
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(3000);//设置vip号的诊断时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+i);
        }

    }
    public static void main(String[] args){
        HomeworkThread homeWorkThead = new HomeworkThread();
        Thread thread = new Thread(homeWorkThead,"vip号");
        //设置主线程为普通号
        Thread.currentThread().setName("普通号");
        thread.setPriority(10);//设置vip号的优先级
        thread.start();
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+i);
            if(i==10){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
