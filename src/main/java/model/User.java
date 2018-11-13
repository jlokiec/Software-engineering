package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "[pizzeria].[dbo].[user]")
public class User extends AbstractModel {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String answer;

    @Column(nullable = false, unique = true)
    private String nick;

    @OneToOne
    private Address address;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    private Question question;

    @Column(nullable = false)
    private long createTimestamp = System.currentTimeMillis();

    @Column(nullable = false)
    private long updateTimestamp = System.currentTimeMillis();

    @Column(nullable = false)
    private boolean active = true;

    @Column(nullable = false)
    private boolean loggedIn = false;

    @Column(nullable = false)
    private boolean admin = false;

    @Column(nullable = false)
    private boolean ableToChangePassword = false;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updateTimestamp = System.currentTimeMillis();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        updateTimestamp = System.currentTimeMillis();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        updateTimestamp = System.currentTimeMillis();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        updateTimestamp = System.currentTimeMillis();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
        updateTimestamp = System.currentTimeMillis();
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @JsonIgnore
    public String getAnswer() {
        return answer;
    }

    @JsonProperty
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(long create_timestamp) {
        this.createTimestamp = create_timestamp;
    }

    public long getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(long update_timestamp) {
        this.updateTimestamp = update_timestamp;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isAbleToChangePassword() {
        return ableToChangePassword;
    }

    public void setAbleToChangePassword(boolean ableToChangePassword) {
        this.ableToChangePassword = ableToChangePassword;
    }
}
