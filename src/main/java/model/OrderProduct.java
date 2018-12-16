package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "[pizzeria].[dbo].[order_product]")
public class OrderProduct extends AbstractModel {
    @ManyToOne()
    private Order order;

    @ManyToOne
    private Product product;

    private int quantity;

    private int productIdInOrder;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
