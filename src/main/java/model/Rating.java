package model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pizzeria.dbo.rating")
public class Rating extends AbstractModel {
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    private int rate;
    private String comment;
    private long ratingTimestamp;

    public int getRate() { return rate; }

    public void setRate(int rate) { this.rate = rate; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }

    public long getRatingTimestamp() { return ratingTimestamp; }

    public void setRatingTimestamp(long ratingTimestamp) { this.ratingTimestamp = ratingTimestamp; }
}
