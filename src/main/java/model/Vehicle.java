package model;

import javax.persistence.*;

@Entity
@Table(name = "pizzeria.dbo.vehicle")
public class Vehicle extends AbstractModel {
    private String name;
    private String image;

    public Vehicle(){}

    public Vehicle(String name, String image){
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
