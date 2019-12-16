package pojo;

import java.util.Date;

/**
 * @author Bmo
 * @date 2019/12/12 10:18
 */
public class Email {
    private Integer id;
    private String fromname;
    private String toname;
    private String title;
    private String content;
    private String status;
    private Date time;

    public Email() {

    }

    public Email(Integer id, String fromname, String toname, String title, String content, String status, Date time) {
        this.id = id;
        this.fromname = fromname;
        this.toname = toname;
        this.title = title;
        this.content = content;
        this.status = status;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToname() {
        return toname;
    }

    public void setToname(String toname) {
        this.toname = toname;
    }

    public String getFromname() {
        return fromname;
    }

    public void setFromname(String fromname) {
        this.fromname = fromname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Email(Integer id, String fromname, String title, String content, String status, Date time) {
        this.id = id;
        this.fromname = fromname;
        this.title = title;
        this.content = content;
        this.status = status;
        this.time = time;
    }
}
