package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "[pizzeria].[dbo].[order]")
public class Order extends AbstractModel {
    @ManyToOne
    private User user;

    private long orderTimestamp;

    private double price;

    private String comment;

    private boolean discountUsed;

    @OneToOne
    private Discount discount;

    private boolean deleted;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getOrderTimestamp() {
        return orderTimestamp;
    }

    public void setOrderTimestamp(long orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isDiscountUsed() {
        return discountUsed;
    }

    public void setDiscountUsed(boolean discountUsed) {
        this.discountUsed = discountUsed;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
