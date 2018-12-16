package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "[pizzeria].[dbo].[order_component]")
public class OrderComponent extends AbstractModel {
    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Component component;

    private int quantity;

    private int productIdInOrder;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductIdInOrder() {
        return productIdInOrder;
    }

    public void setProductIdInOrder(int productIdInOrder) {
        this.productIdInOrder = productIdInOrder;
    }
}
