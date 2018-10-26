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
        entityManager.getTransaction().begin();
        entityManager.persist(modelObject.getAddress());
        entityManager.persist(modelObject);
        entityManager.getTransaction().commit();

        return modelObject;
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
