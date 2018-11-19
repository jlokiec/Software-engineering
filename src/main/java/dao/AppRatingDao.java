package dao;

import model.AppRating;

import javax.persistence.Query;

public class AppRatingDao extends AbstractDaoImpl<AppRating> {
    public AppRatingDao() {
        super(AppRating.class);
    }

    public Double getAverageRating() {
        String sqlQuery = "select avg(cast(ar.rating as double)) from AppRating ar";
        Query query = entityManager.createQuery(sqlQuery);

        return (Double) query.getSingleResult();
    }
}
