package dao;

import model.AbstractModel;

public interface InterfaceDao<T extends AbstractModel> {
    T create(T modelObject);

    T read(int id);

    T update(T modelObject);

    boolean delete(int id);
}
