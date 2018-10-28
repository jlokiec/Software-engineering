package dao;

import model.User;
import model.patch.*;

import javax.persistence.Query;
import java.util.List;

public class UserDao extends AbstractDaoImpl<User> {
    public UserDao() {
        super(User.class);
    }

    @Override
    public User create(User modelObject) {
        if (checkIfNickIsTaken(modelObject.getNick())) {
            return null;
        }

        long createTimestamp = System.currentTimeMillis();

        modelObject.setCreateTimestamp(createTimestamp);
        modelObject.setUpdateTimestamp(createTimestamp);
        modelObject.setActive(true);
        modelObject.setLoggedIn(false);

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

    public boolean updatePassword(final UserPasswordOnly userPasswordOnly, int id) {
        User user = read(id);

        if (user == null) {
            return false;
        }

        String newPassword = userPasswordOnly.getPassword();
        user.setPassword(newPassword);
        user.setUpdateTimestamp(System.currentTimeMillis());

        System.out.println(user.getPassword());

        if (update(user) == null) {
            return false;
        }

        return true;
    }

    public User updateDetails(final UserDetails userDetails, int id) {
        User user = read(id);

        if (user == null) {
            return null;
        }

        String newName = userDetails.getName();
        String newSurname = userDetails.getSurname();
        String newPhone = userDetails.getPhone();
        String newEmail = userDetails.getEmail();

        if (newName != null && !newName.equals("")) {
            user.setName(newName);
            user.setUpdateTimestamp(System.currentTimeMillis());
        }
        if (newSurname != null && !newSurname.equals("")) {
            user.setSurname(newSurname);
            user.setUpdateTimestamp(System.currentTimeMillis());
        }
        if (newPhone != null && !newPhone.equals("")) {
            user.setPhone(newPhone);
            user.setUpdateTimestamp(System.currentTimeMillis());
        }
        if (newEmail != null && !newEmail.equals("")) {
            user.setEmail(newEmail);
            user.setUpdateTimestamp(System.currentTimeMillis());
        }

        return update(user);
    }

    public boolean login(final UserNickAndPassword userNickAndPassword) {
        String nick = userNickAndPassword.getNick();
        String password = userNickAndPassword.getPassword();

        String sqlQuery = "select * from [pizzeria].[dbo].[user] where [nick] = :nick and [password] = :password";
        Query query = entityManager.createNativeQuery(sqlQuery, User.class);
        query.setParameter("nick", nick);
        query.setParameter("password", password);

        List<User> users = query.getResultList();

        if (users.size() == 1) {
            User user = users.get(0);

            if (user.isActive()) {
                user.setLoggedIn(true);
                update(user);
                return true;
            }
        }

        return false;
    }

    public boolean logout(int id) {
        User user = read(id);

        if (user == null) {
            return false;
        }

        if (user.isLoggedIn()) {
            user.setLoggedIn(false);
            update(user);
            return true;
        }

        return false;
    }
}
