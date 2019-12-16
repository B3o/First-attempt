package entity;

/**
 * @author Bmo
 * @date 2019/12/16 11:23
 */
public class EUser {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String head;
    public EUser(){}
    public EUser(Integer id, String username, String password, String email, String head) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.head = head;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
