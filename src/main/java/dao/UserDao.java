package dao;

import model.User;
import model.patch.UserActiveOnly;
import model.patch.UserLoggedInOnly;
import model.patch.UserPasswordOnly;

public class UserDao extends AbstractDaoImpl<User> {
    public UserDao() {
        super(User.class);
    }

    @Override
    public User create(User modelObject) {
        if (checkIfNickIsTaken(modelObject.getNick())) {
            return null;
        }

        entityManager.getTransaction().begin();
        entityManager.persist(modelObject.getAddress());
        entityManager.persist(modelObject);
        entityManager.getTransaction().commit();

        return modelObject;
    }

    private boolean checkIfNickIsTaken(String nick) {
        String sqlQuery = "select count(1) from [pizzeria].[dbo].[user] where [nick] = :nick";
        Query query = entityManager.createNativeQuery(sqlQuery);
        query.setParameter("nick", nick);

        int count = (Integer) query.getSingleResult();

        if (count == 0) {
            return false;
        }

        return true;
    }

    public boolean updateActive(final UserActiveOnly userActiveOnly, int id) {
        User user = read(id);

        if (user == null) {
            return false;
        }

        boolean newActive = userActiveOnly.isActive();
        user.setActive(newActive);

        if (update(user) == null) {
            return false;
        }

        return true;
    }

    public boolean updateLoggedIn(final UserLoggedInOnly userLoggedInOnly, int id) {
        User user = read(id);

        if (user == null) {
            return false;
        }

        boolean newLoggedIn = userLoggedInOnly.isLoggedIn();
        user.setLoggedIn(newLoggedIn);

        if (update(user) == null) {
            return false;
        }

        return true;
    }

    public boolean updatePassword(final UserPasswordOnly userPasswordOnly, int id) {
        User user = read(id);

        if (user == null) {
            return false;
        }

        String newPassword = userPasswordOnly.getPassword();
        user.setPassword(newPassword);

        System.out.println(user.getPassword());

        if (update(user) == null) {
            return false;
        }

        return true;
    }
}
