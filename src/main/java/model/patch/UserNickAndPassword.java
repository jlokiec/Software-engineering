package model.patch;

public class UserNickAndPassword {
    private String nick;
    private String password;

    public UserNickAndPassword() {
    }

    public UserNickAndPassword(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
