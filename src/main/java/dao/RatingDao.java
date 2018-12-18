package dao;

import model.Product;
import model.Rating;

import javax.persistence.Query;
import java.util.List;

public class RatingDao extends AbstractDaoImpl<Rating> {
    public RatingDao() { super(Rating.class); }

    public List<Float> getAverage() {
        String sqlQuery  = "select ROUND(AVG(CAST(rate AS FLOAT)), 2) from [pizzeria].[dbo].[rating]";
        Query query = entityManager.createNativeQuery(sqlQuery);
        return (List<Float>)query.getResultList();
    }

    public List<Rating> getAll() {
        String sqlQuery  = "select * from [pizzeria].[dbo].[rating]";
        Query query = entityManager.createNativeQuery(sqlQuery, Rating.class);
        return (List<Rating>) query.getResultList();
    }
}
