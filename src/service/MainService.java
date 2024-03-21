package service;

import model.PostType;
import model.users.BusinessUser;
import model.users.GuestUser;
import model.users.PrivateUser;

import java.util.ArrayList;
import java.util.Arrays;

public class MainService {

    // TODO: Change access modifier.
    private static ArrayList<GuestUser> allUsers = new ArrayList<>();

    public static void main(String[] args) {
        GuestUser u1 = new GuestUser();
        GuestUser u2 = new GuestUser();
        PrivateUser u3 = new PrivateUser();
        GuestUser u4 = new GuestUser();
        BusinessUser u5 = new BusinessUser();
        PrivateUser u6 = new PrivateUser("Rudolfs", "Sniedzins", "RudisSudis123");
        BusinessUser u7 = new BusinessUser("Rudolfs un ko", "RudisSniedzins1337", "LV12345678912");

        allUsers.addAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7));

        for (GuestUser user : allUsers) {
            System.out.println(user);
        }

        try {
            u6.publishPost(PostType.privatePost, "cau ka iet");
            u6.publishPost(PostType.publicPost, "cau ka iet broskii");
            u6.publishPost(PostType.publicPost, "caw maZulit");
            u6.followPrivateUser(u3);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(u6.getUsername() + " private posts ->");
        System.out.println(u6.getPrivatePosts());

        System.out.println(u6.getUsername() + " public posts ->");
        System.out.println(u6.getPublicPosts());

        System.out.println(u6.getFollowers());

        try {
            u7.createPage("Riepas ventpili", "pa leto jaunas rieps");
            u7.createPostInPage("Atlaid jaunam vasar riepam", "Riepas ventpili");
            u7.createPage("Riepas talsos", "pa leto jaunas rieps");
            u7.createPostInPage("Atlaid jaunam vissezon riepam", "Riepas talsos");
        } catch (Exception e) {
            System.out.println();
        }

        System.out.println(u7.getListOfPages());
    }

}
