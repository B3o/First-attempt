package entity;

/**
 * @author Bmo
 * @date 2019/12/8 21:53
 */
public class Mail {
    private int id;
    private String title;
    private String content;
    private String sender;
    private String receiver;
    private String time;
    private Boolean readed;

    public Mail(int id, String title, String content, String sender, String receiver, String time, Boolean readed) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.time = time;
        this.readed = readed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getReaded() {
        return readed;
    }

    public void setReaded(Boolean readed) {
        this.readed = readed;
    }
}
