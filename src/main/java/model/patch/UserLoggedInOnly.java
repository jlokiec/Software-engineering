package model.patch;

public class UserLoggedInOnly {
    private boolean loggedIn;

    public UserLoggedInOnly() {
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
