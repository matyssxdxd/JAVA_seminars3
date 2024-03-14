package model.users;

import model.Post;

import java.util.ArrayList;

public class PrivateUser extends User {
    private ArrayList<Post> privatePosts;
    private ArrayList<Post> publicPosts;
    private ArrayList<User> followers;
}
