package dao;

import model.Question;

import java.util.List;

public class QuestionDao extends AbstractDaoImpl<Question> {
    public QuestionDao() {
        super(Question.class);
    }

    public List<Question> getAll() {
        String sqlQuery = "select * from pizzeria.dbo.question";
        return (List<Question>) entityManager.createNativeQuery(sqlQuery, Question.class).getResultList();
    }
}
