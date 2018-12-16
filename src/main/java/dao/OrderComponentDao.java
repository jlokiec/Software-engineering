package dao;

import model.OrderComponent;

import javax.persistence.Query;
import java.util.List;

public class OrderComponentDao extends AbstractDaoImpl<OrderComponent> {
    public OrderComponentDao() {
        super(OrderComponent.class);
    }

    public List<OrderComponent> getAll() {
        String sqlQuery = "select * from [pizzeria].[dbo].[order_component]";
        Query query = entityManager.createNativeQuery(sqlQuery, OrderComponent.class);
        return query.getResultList();
    }
}
