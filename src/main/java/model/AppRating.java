package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "[pizzeria].[dbo].[app_rating]")
public class AppRating extends AbstractModel {
    private double rating;
    private long rateTimestamp;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public long getRateTimestamp() {
        return rateTimestamp;
    }

    public void setRateTimestamp(long rateTimestamp) {
        this.rateTimestamp = rateTimestamp;
    }
}
