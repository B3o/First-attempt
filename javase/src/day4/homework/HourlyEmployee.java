package day4.homework;

/**
 * @author Bmo
 * @date 2019/11/14 22:52
 */
public class HourlyEmployee extends ColaEmployee{
    double hourlySalary;
    int workHour;
    @Override
    public double getSalary(int month) {
        String[] birthStrs = birthday.split("-");
        String birthMonth = birthStrs[1];
        boolean addSal = false;
        int moreHour = 0;
        if (month == Integer.valueOf(birthMonth)) addSal = true;
        if (workHour > 160) {
            moreHour = workHour - 160;
            if (addSal) {
                return ((160 * hourlySalary + moreHour) * (hourlySalary * 1.5)) + 100;
            } else
                return (160 * hourlySalary + moreHour) * (hourlySalary * 1.5);
        } else {
            if (addSal) {
                return (hourlySalary * workHour) + 100;
            } else {
                return hourlySalary * workHour;
            }
        }
    }
}
