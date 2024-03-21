package model.users;

import model.Page;
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

    @Override
    public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
        super.nameAndSurnameOrTitle = (nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-Za-z0-9%^+@=.,! ]{3,50}"))
                ? nameAndSurnameOrTitle : "defaultTitle";
    }

    @Override
    public void publishPost(PostType type, String msg) throws Exception {

    }

    public void createPage(String title, String description) throws Exception {
        if (title == null || description == null) throw new Exception("BOO");

        listOfPages.add(new Page(title, description));
    }

    public void createPostInPage(PostType type, String msg, String pageTitle) {

    }

    @Override
    public String toString() {
        return super.toString() + ", " + PVNNo;
    }
}
