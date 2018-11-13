package model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pizzeria.dbo.invoice")
public class Invoice extends AbstractModel{
    @ManyToOne
    @JoinColumn(name="delivery_id")
    private Delivery delivery;
    private String name;

    public Invoice(){}

    public Invoice(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
