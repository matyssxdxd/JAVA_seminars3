package model;

import java.time.LocalDateTime;

public class Post {
    private String msg;
    private LocalDateTime date;
    private int countOfLikes = 0;

    public Post() {
        setMsg("default_message");
        setDate();
    }

    public Post(String msg) {
        setMsg(msg);
        setDate();
    }

    public String getMsg() {
        return msg;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getCountOfLikes() {
        return countOfLikes;
    }

    public void setMsg(String msg) {
        this.msg = (msg != null && msg.length() > 5 && msg.length() < 300) ? msg : "default_message";
    }

    public void setDate() {
        this.date = LocalDateTime.now();
    }

    public void incrementCountOfLikes() {
        countOfLikes++;
    }

    @Override
    public String toString() {
        return msg + " ( " + date + " , " + "likes: " + countOfLikes + " )";
    }
}
