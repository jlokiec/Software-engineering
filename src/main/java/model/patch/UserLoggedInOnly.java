package model.patch;

public class UserLoggedInOnly {
    private int id;
    private boolean loggedIn;

    public UserLoggedInOnly() {
    }

    public UserLoggedInOnly(int id, boolean loggedIn) {
        this.id = id;
        this.loggedIn = loggedIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
