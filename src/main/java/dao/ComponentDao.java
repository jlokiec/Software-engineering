package dao;

import model.Component;
import model.Product;

import javax.persistence.Query;
import java.util.List;

public class ComponentDao extends AbstractDaoImpl<Component> {
    public ComponentDao() {
        super(Component.class);
    }

    public List<Component> getAll() {
        String sqlQuery = "select * from [pizzeria].[dbo].[component]";
        Query query = entityManager.createNativeQuery(sqlQuery, Component.class);
        return (List<Component>) query.getResultList();
    }
}
