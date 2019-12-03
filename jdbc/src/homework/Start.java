package homework;

import homework.entity.User;
import homework.util.DBUtil;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/29 15:07
 */
public class Start {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choice = 0;
        do {
            printMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    try {
                        showUser();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        modifyUser();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    addUser();
                    break;
                case 4:
                    addSalary();
                    break;
                case 5:
                    try {
                        deleteUser();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } while (choice != 0);


    }
    public static void printMenu() {
        System.out.println("*****员工系统*****");
        System.out.println("1.展示员工信息");
        System.out.println("2.修改员工信息");
        System.out.println("3.添加员工信息");
        System.out.println("4.员工加薪");
        System.out.println("5.开除员工");
        System.out.println("0.退出系统");
        System.out.print("请输入你选择的功能:");
    }
    public static void showUser() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        ResultSet rs = DBUtil.query("select * from employee");
        while (rs.next()) {
            User user = new User(rs.getInt(1), rs.getString(2),
                    rs.getDate(3), rs.getString(4), rs.getInt(5),
                    rs.getString(6));
            users.add(user);
        }
        System.out.println("当前雇员列表:");
        for (User temp : users) {
            System.out.println(temp.toString());
        }
    }
    public static void deleteUser() throws SQLException {
        showUser();
        String sql = "delete from employee where eid = ?";
        System.out.print("大老板,今天想开除谁?(直接输入员工id):");
        int deleteId = sc.nextInt();
        int result = DBUtil.update(sql, deleteId);
        if (result > 0) {
            System.out.println("开除成功,员工已滚蛋");
        } else {
            System.out.println("出了一些问题,需要HR出动解决");
        }
    }
    public static void modifyUser() throws SQLException {
        showUser();
        System.out.print("请输入要修改的员工id:");
        int userId = sc.nextInt();
        System.out.print("请输入修改后的员工姓名:");
        String name = sc.next();
        System.out.print("请输入修改后的员工性别(0. 女   1.男):");
        String sex = sc.next();
        System.out.print("请输入修改后的员工工资:");
        int salary = sc.nextInt();
        System.out.print("请输入修改后的员工部门:");
        String department = sc.next();
        String sql = "update employee set ename = ?, esex = ?, esalary = ?, department = ?" +
                "where eid = ?";
        DBUtil.update(sql, name, sex, salary, department, userId);
        System.out.println("员工资料更新完成!");
    }
    public static void addUser() {
        System.out.println("欢迎进入添加员工界面====");
        System.out.print("请输入员工姓名:");
        String name = sc.next();
        System.out.print("请输入员工入职时间(年-月-日):");
        String hireDate = sc.next();
        System.out.print("请输入员工性别(0. 女    1.男):");
        String sex = sc.next();
        System.out.print("请输入员工工资:");
        int salary = sc.nextInt();
        System.out.print("请输入员工部门:");
        String department = sc.next();
        String sql = "insert into employee values(EMPLOYEE_SEQ.NEXTVAL, ?, to_date(?,'yyyy-mm-dd'), ?, ?, ?)";
        DBUtil.update(sql, name, hireDate, sex, salary, department);
        System.out.println("新员工入职成功!");
    }
    public static void addSalary() {
        try {
            showUser();
            String sql = "update employee set esalary = ((select esalary from employee where eid = ?) + ?) where eid = ?";
            System.out.print("今天给哪个员工加工资? 输入员工id号:");
            int userId = sc.nextInt();
            System.out.print("要给他加多少钱的工资呢:");
            int add = sc.nextInt();
            DBUtil.update(sql, userId, add, userId);
            System.out.println("给员工加薪成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
