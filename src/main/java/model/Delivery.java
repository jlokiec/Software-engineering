package model;

import javax.persistence.*;

@Entity
@Table(name = "pizzeria.dbo.delivery")
public class Delivery extends AbstractModel{
    @AttributeOverride(name="id", column =@Column(name="delivery_id"))
    @ManyToOne
    @JoinColumn(name="delivery_option_id")
    private DeliveryOption deliveryOption;
    @ManyToOne
    @JoinColumn(name="address_id")
    private Address address;

    public Delivery(){}

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public DeliveryOption getDeliveryOption() {
        return deliveryOption;
    }

    public void setDeliveryOption(DeliveryOption deliveryOption) {
        this.deliveryOption = deliveryOption;
    }
}
