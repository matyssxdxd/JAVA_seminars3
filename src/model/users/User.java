package model.users;

import service.IPostService;

import java.security.MessageDigest;

public abstract class User extends GuestUser implements IPostService {
    private String username;
    private String password;
    protected String nameAndSurnameOrTitle;

    public User(String password) {
        super();
        setPassword(password);
    }

    public User() {
        super();
        setPassword("defaultPassword123");
    }

    public String getUsername() {
        return username;
    }

    private String getPassword() {
        return password;
    }

    public String getNameAndSurnameOrTitle() {
        return nameAndSurnameOrTitle;
    }

    public void setUsername() {
        username = nameAndSurnameOrTitle + "_" + getGeneratedId();
    }

    public void setPassword(String password) {
        if (password != null && password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,40}$")) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                this.password = new String(md.digest());
            } catch (Exception e) {
                this.password = "default_password";
            }
        } else {
            this.password = "default_password";
        }
    }

    public abstract void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle);

    @Override
    public String toString() {
        return super.toString() + ":";
    }
}
