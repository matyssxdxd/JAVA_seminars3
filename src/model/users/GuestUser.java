package model.users;

public class GuestUser {
    private long generatedId;
    private static long idCounter = 0;

    public GuestUser() {
        setGeneratedId();
    }

    public long getGeneratedId() {
        return generatedId;
    }

    public void setGeneratedId() {
        generatedId = idCounter++;
    }

    @Override
    public String toString() {
        return "" + generatedId;
    }
}
