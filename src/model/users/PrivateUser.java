package model.users;

import model.Post;
import model.PostType;

import java.util.ArrayList;

public class PrivateUser extends User {
    private ArrayList<Post> privatePosts = new ArrayList<>();
    private ArrayList<Post> publicPosts = new ArrayList<>();
    private ArrayList<User> followers = new ArrayList<>();

    public PrivateUser(String name, String surname, String password) {
        super(password);
        setNameAndSurnameOrTitle(name + " " + surname);
        setUsername();
    }

    public PrivateUser() {
        super();
        setNameAndSurnameOrTitle("defaultNameSurname");
        setUsername();
    }

    public ArrayList<Post> getPrivatePosts() {
        return privatePosts;
    }

    public ArrayList<Post> getPublicPosts() {
        return publicPosts;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    @Override
    public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
        super.nameAndSurnameOrTitle = (nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-ZĒŪĪĻĶĢŠĀČŅ]{1}[a-zēūīļķģšāžčņ]+ [A-ZĒŪĪĻĶĢŠĀČŅ]{1}[a-zēūīļķģšāžčņ]+"))
                ? nameAndSurnameOrTitle : "defaultNameSurname";
    }

    @Override
    public void publishPost(PostType type, String msg) throws Exception {
        if (type == null || msg == null) throw new Exception("BOO");

        if (type.equals(PostType.privatePost)) privatePosts.add(new Post(msg));
        if (type.equals(PostType.publicPost)) publicPosts.add(new Post(msg));
    }

    public void followPrivateUser(User user) throws Exception {
        if (user == null) throw new Exception("BOO");

        for (User follower : followers) {
            if (follower.getUsername().equals(user.getUsername())) throw new Exception("BOO");
        }

        followers.add(user);
    }

    @Override
    public String toString() {
        return super.toString() + " " + (privatePosts.size() + publicPosts.size()) + " posts";
    }
}
