package dao;

import model.Product;

import javax.persistence.Query;
import java.util.List;

public class ProductDao extends AbstractDaoImpl<Product> {
    public ProductDao() {
        super(Product.class);
    }

    public List<Product> getAll() {
        String sqlQuery  = "select * from [pizzeria].[dbo].[product]";
        Query query = entityManager.createNativeQuery(sqlQuery, Product.class);
        return (List<Product>) query.getResultList();
    }
}
