package model.users;

import model.Page;
import model.Post;
import model.PostType;

import java.util.ArrayList;

public class BusinessUser extends User {
    private String PVNNo;
    private ArrayList<Page> listOfPages = new ArrayList<>();

    public BusinessUser(String title, String password, String PVNNo) {
        super(password);
        setNameAndSurnameOrTitle(title);
        setPVNNo(PVNNo);
        setUsername();
    }

    public BusinessUser() {
        super();
        setNameAndSurnameOrTitle("defaultTitle");
        setPVNNo("defaultPVNNo");
        setUsername();
    }

    public String getPVNNo() {
        return PVNNo;
    }

    public ArrayList<Page> getListOfPages() {
        return listOfPages;
    }

    public void setPVNNo(String PVNNo) {
        this.PVNNo = (PVNNo != null && PVNNo.matches("[A-Z]{2}[0-9]{11}")) ? PVNNo : "defaultPVNNo";
    }

    public void createPage(String title, String description) throws Exception {
        if (title == null || description == null) throw new Exception("BOO");

        for (Page page : listOfPages) {
            if (page.getTitle().equals(title)) throw new Exception("Page with that title already exists.");
        }

        listOfPages.add(new Page(title, description));
    }

    public void createPostInPage(String msg, String pageTitle) throws Exception {
        if (msg == null || pageTitle == null) throw new Exception("WOOOOO");

        for (Page page : listOfPages) {
            if (page.getTitle().equals(pageTitle)) {
                Post newPost = publishPost(PostType.publicPost, msg);
                page.getPostsInPage().add(newPost);
                return;
            }
        }

        throw new Exception("There is no page with title " + pageTitle + ".");
    }

    @Override
    public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
        super.nameAndSurnameOrTitle = (nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-Za-z0-9%^+@=.,! ]{3,50}"))
                ? nameAndSurnameOrTitle : "defaultTitle";
    }

    @Override
    public Post publishPost(PostType type, String msg) throws Exception {
        if (type == null || msg == null) throw new Exception("Either type (" + type + ") or msg (" + msg + ") is null.");

        return new Post(msg);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + PVNNo;
    }
}
