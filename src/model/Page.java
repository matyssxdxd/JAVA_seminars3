package model;

import model.users.User;

import java.util.ArrayList;

public class Page {
    private String title;
    private String description;
    private ArrayList<User> followers = new ArrayList<>();
    private ArrayList<Post> postsInPage = new ArrayList<>();

    public Page() {
        setTitle("default_title");
        setDescription("default_description");
    }

    public Page(String title, String description) {
        setTitle(title);
        setDescription(description);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public ArrayList<Post> getPostsInPage() {
        return postsInPage;
    }

    public void setTitle(String title) {
        this.title = (title != null && title.length() > 5 && title.length() < 50) ? title : "default_title";
    }

    public void setDescription(String description) {
        this.description = (description != null && description.length() > 5 && description.length() < 300) ? description : "default_description";
    }

    @Override
    public String toString() {
        return "Page{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", followers=" + followers +
                ", postsInPage=" + postsInPage +
                '}';
    }
}
