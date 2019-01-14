package dao;

import model.Question;
import model.User;

import javax.persistence.NoResultException;
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

    public Question getQuestionForLogin(String login) {
        String sqlQuery = "select * from [pizzeria].[dbo].[user] where [nick] = :login";
        Query query = entityManager.createNativeQuery(sqlQuery, User.class);
        query.setParameter("login", login);

        try {
            User user = (User) query.getSingleResult();
            return user.getQuestion();
        } catch (NoResultException e) {
            return null;
        }
    }
}
