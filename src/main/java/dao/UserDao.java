package dao;

import model.User;
import model.patch.*;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class UserDao extends AbstractDaoImpl<User> {
    public UserDao() {
        super(User.class);
    }

    @Override
    public User create(User modelObject) throws NickTakenException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(modelObject.getAddress());
            entityManager.persist(modelObject);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            throw new NickTakenException();
        }

        return modelObject;
    }

    public boolean updateActive(final UserActiveOnly userActiveOnly, int id) {
        User user = read(id);

        if (user == null) {
            return false;
        }

        boolean newActive = userActiveOnly.isActive();
        user.setActive(newActive);
        update(user);

        return true;
    }

    public boolean updatePassword(final UserPasswordOnly userPasswordOnly, int id) {
        User user = read(id);

        if (user == null) {
            return false;
        }

        if (user.isActive() && user.isAbleToChangePassword()) {
            String newPassword = userPasswordOnly.getPassword();
            user.setPassword(newPassword);
            user.setAbleToChangePassword(false);
            update(user);
            return true;
        }

        return false;
    }

    public boolean updateDetails(final UserDetails userDetails, int id) {
        User user = read(id);

        if (user == null) {
            return false;
        }

        if (user.isActive() && user.isLoggedIn()) {
            String newName = userDetails.getName();
            String newSurname = userDetails.getSurname();
            String newPhone = userDetails.getPhone();
            String newEmail = userDetails.getEmail();

            if (newName != null && !newName.equals("")) {
                user.setName(newName);
            }
            if (newSurname != null && !newSurname.equals("")) {
                user.setSurname(newSurname);
            }
            if (newPhone != null && !newPhone.equals("")) {
                user.setPhone(newPhone);
            }
            if (newEmail != null && !newEmail.equals("")) {
                user.setEmail(newEmail);
            }

            return true;
        }

        return false;
    }

    public boolean login(final UserNickAndPassword userNickAndPassword) {
        String nick = userNickAndPassword.getNick();
        String password = userNickAndPassword.getPassword();

        String sqlQuery = "select * from [pizzeria].[dbo].[user] where [nick] = :nick and [password] = :password";
        Query query = entityManager.createNativeQuery(sqlQuery, User.class);
        query.setParameter("nick", nick);
        query.setParameter("password", password);

        User user = (User) query.getSingleResult();

        if (user == null) {
            return false;
        }

        if (user.isActive()) {
            user.setLoggedIn(true);
            update(user);
            return true;
        }

        return false;
    }

    public boolean logout(int id) {
        User user = read(id);

        if (user == null) {
            return false;
        }

        if (user.isActive() && user.isLoggedIn()) {
            user.setLoggedIn(false);
            update(user);
            return true;
        }

        return false;
    }

    public boolean checkQuestionAnswer(final UserNickAndAnswer userNickAndAnswer) {
        String nick = userNickAndAnswer.getNick();
        String answer = userNickAndAnswer.getAnswer();

        String sqlQuery = "select * from [pizzeria].[dbo].[user] where [nick] = :nick and [question_id] is not null and [answer] = :answer";
        Query query = entityManager.createNativeQuery(sqlQuery, User.class);
        query.setParameter("nick", nick);
        query.setParameter("answer", answer);

        User user = null;

        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException e) {
            return false;
        }

        if (user == null) {
            return false;
        }

        if (user.isActive()) {
            user.setAbleToChangePassword(true);
            update(user);
            return true;
        }

        return false;
    }
}
