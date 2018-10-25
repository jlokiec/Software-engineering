package dao;

import model.AbstractModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDaoImpl<T extends AbstractModel> implements InterfaceDao<T> {
    protected EntityManager entityManager;
    private Class<T> genericClass;

    public AbstractDaoImpl(Class<T> genericClass) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Pizzeria-Server");
        entityManager = entityManagerFactory.createEntityManager();
        this.genericClass = genericClass;
    }

    @Override
    public T create(T modelObject) {
        entityManager.getTransaction().begin();
        entityManager.persist(modelObject);
        entityManager.getTransaction().commit();

        return modelObject;
    }

    @Override
    public T read(int id) {
        return entityManager.find(genericClass, id);
    }

    @Override
    public T update(T modelObject) {
        entityManager.getTransaction().begin();
        T updatedObject = entityManager.merge(modelObject);
        entityManager.getTransaction().commit();

        return updatedObject;
    }

    @Override
    public boolean delete(int id) {
        if (entityManager.find(genericClass, id) == null) {
            return false;
        }

        entityManager.getTransaction().begin();
        T foundObject = entityManager.find(genericClass, id);
        entityManager.remove(foundObject);
        entityManager.getTransaction().commit();

        return true;
    }
}
