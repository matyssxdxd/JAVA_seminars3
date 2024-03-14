package model;

import model.users.User;

import java.util.ArrayList;

public class Page {
    private String title;
    private String description;
    private ArrayList<User> followers = new ArrayList<User>();
    private ArrayList<Post> postsInPage = new ArrayList<Post>();

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
        this.title = (title != null) ? title : "default_title";
    }

    public void setDescription(String description) {
        this.description = (description != null) ? description : "default_description";
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    public void setPostsInPage(ArrayList<Post> postsInPage) {
        this.postsInPage = postsInPage;
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
