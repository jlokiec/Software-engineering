package dao;

import model.OrderProduct;

import javax.persistence.Query;
import java.util.List;

public class OrderProductDao extends AbstractDaoImpl<OrderProduct> {
    public OrderProductDao() {
        super(OrderProduct.class);
    }

    public List<OrderProduct> getAll() {
        String sqlQuery = "select * from [pizzeria].[dbo].[order_product]";
        Query query = entityManager.createNativeQuery(sqlQuery, OrderProduct.class);
        return query.getResultList();
    }
}
