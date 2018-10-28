package model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pizzeria.dbo.address")
public class Address extends AbstractModel {
    @AttributeOverride(name="id", column =@Column(name="address_id"))
    private String name;
    private String nip;
    private String city;
    private String postalCode;
    private String street;

    public Address() {
    }

    public Address(String name, String nip, String city, String postalCode, String street) {
        this.name = name;
        this.nip = nip;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}
