package entity;

import java.util.Date;

/**
 * 描述:user实体类 用于描述数据库中表的类
 * 属性一般是和表中的字段是类似的
 * @author Bmo
 * @date 2019/11/28 14:14
 */
public class User {
    //实体类的属性名  不一定跟数据库的字段名称是一样的
    private Integer id;
    private String username;
    private String password;
    private Date birthday;
    private String sex;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public User(Integer id, String username, String password, Date birthday, String sex, Integer age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.sex = sex;
        this.age = age;
    }
    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
