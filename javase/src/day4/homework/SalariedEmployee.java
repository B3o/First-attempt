package day4.homework;

/**
 * @author Bmo
 * @date 2019/11/14 22:52
 */
public class SalariedEmployee extends ColaEmployee{
    int monthlySalary;
    @Override
    public double getSalary(int month) {
        String[] birthStrs = birthday.split("-");
        String birthMonth = birthStrs[1];
        if (month == Integer.valueOf(birthMonth)) return monthlySalary + 100;
        return monthlySalary;
    }

    public static void main(String[] args) {
        String a = "08";
        int b = Integer.valueOf(a);
        System.out.println(b);
    }
}
