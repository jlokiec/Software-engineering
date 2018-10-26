package dao;

import model.Question;

import javax.persistence.Query;
import java.util.List;

public class QuestionDao extends AbstractDaoImpl<Question> {
    public QuestionDao() {
        super(Question.class);
    }

    public List<Question> getAll() {
        String sqlQuery = "select * from [pizzeria].[dbo].[question]";
        Query query = entityManager.createNativeQuery(sqlQuery, Question.class);
        return (List<Question>) query.getResultList();
    }
}
