package model;

import javax.persistence.*;

@Entity
@Table(name = "pizzeria.dbo.deliveryOption")
public class DeliveryOption extends AbstractModel {
    @ManyToOne
    @JoinColumn(name="vehicle_id")
    private Vehicle vehicle;
    private String name;
    private String description;
    private boolean status;

    public DeliveryOption(){}

    public DeliveryOption(String name, String description, boolean status){
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
