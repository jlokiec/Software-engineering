package dao;

import model.Product;
import model.Rating;

import javax.persistence.Query;
import java.util.List;

public class RatingDao extends AbstractDaoImpl<Rating> {
    public RatingDao() { super(Rating.class); }

    public int getAverage() {
        return 1;
    }

    public List<Rating> getAll() {
        String sqlQuery  = "select * from [pizzeria].[dbo].[rating]";
        Query query = entityManager.createNativeQuery(sqlQuery, Rating.class);
        return (List<Rating>) query.getResultList();
    }
}
