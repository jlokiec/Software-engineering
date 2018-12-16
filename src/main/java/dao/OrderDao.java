package dao;

import model.Order;

import javax.persistence.Query;
import java.util.List;

public class OrderDao extends AbstractDaoImpl<Order> {
    public OrderDao() {
        super(Order.class);
    }

    public List<Order> getAll() {
        String sqlQuery = "select * from [pizzeria].[dbo].[order]";
        Query query = entityManager.createNativeQuery(sqlQuery, Order.class);
        return query.getResultList();
    }
}
