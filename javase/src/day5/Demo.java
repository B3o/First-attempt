package day5;

/**
 * @author Bmo
 * @date 2019/11/16 10:11
 */
public class Demo{
    public int add(int a ,int b){
        try{ return a+b;
            }catch(Exception e){
            System.out.println("catch语句块");
        }finally{
        System.out.println("finally语句块");
        } return 0;
} public static void main(String[] args){
    Demo demo = new Demo();
    System.out.println("和是："+demo.add(9,34));
}
}