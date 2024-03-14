package model.users;

import model.Page;
import model.PostType;

import java.util.ArrayList;

public class BusinessUser extends User {
    private ArrayList<Page> listOfPages = new ArrayList<>();

    public BusinessUser(String title, String password) {
        super(password);
        setNameAndSurnameOrTitle(title);
        setUsername();
    }

    public BusinessUser() {
        super();
        setNameAndSurnameOrTitle("defaultTitle");
        setUsername();
    }

    public ArrayList<Page> getListOfPages() {
        return listOfPages;
    }

    @Override
    public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
        super.nameAndSurnameOrTitle = (nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-ZĒŪĪĻĶĢŠĀČŅ]{1}[a-zēūīļķģšāžčņ]+"))
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
}
