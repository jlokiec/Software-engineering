package model.patch;

public class UserActiveOnly {
    private int id;
    private boolean active;

    public UserActiveOnly() {
    }

    public UserActiveOnly(int id, boolean active) {
        this.id = id;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
