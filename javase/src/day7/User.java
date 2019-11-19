package day7;

import java.io.Serializable;

/**
 * @author Bmo
 * @date 2019/11/19 14:30
 */
public class User implements Serializable {
    //提供一个隐式属性 UID
    private static final long serialVersion = 4335345463L;

    private Integer id;
    private String username;
    private String password;
    private String role;
    //通过static修饰的属性不会被序列化
    //通过transient修饰的属性不会被序列化

    private static String testStatic;
    private transient String testTransient;

    public User(Integer id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public User() {

    }
}
