package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pizzeria.dbo.component")
public class Component extends AbstractModel {
    private String name;
    private float price;
    private boolean available;
    private boolean vegan;

    public Component(){}

    public Component(String name, float price, boolean available, boolean vegan){
        this.name=name;
        this.price=price;
        this.available=available;
        this.vegan=vegan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }
}
