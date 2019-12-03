package homework.entity;

import java.util.Date;

/**
 * @author Bmo
 * @date 2019/11/29 15:05
 */
public class User {
    private int id;
    private String name;
    private Date hireDate;
    private String sex;
    private int salary;
    private String department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSex() {
        return sex;
    }

    public String setSex(String sex) {
        if ("0".equals(sex)) {
            return "男";
        } else if ("1".equals(sex)) {
            return "女";
        } else {
            return "未知";
        }
    }

    public User(int id, String name, Date hireDate, String sex, int salary, String department) {
        this.id = id;
        this.name = name;
        this.hireDate = hireDate;
        this.sex = sex;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "雇员{" +
                "id:" + id +  '\'' +
                ", 姓名='" + name + '\'' +
                ", 雇佣日期=" + hireDate +
                ", 性别='" + this.getSex() + '\'' +
                ", 月薪=" + salary +
                ", 工作部门='" + department + '\'' +
                '}';
    }
}
