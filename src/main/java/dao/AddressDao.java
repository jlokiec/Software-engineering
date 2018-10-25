package dao;

import model.Address;

public class AddressDao extends AbstractDaoImpl<Address> {
    public AddressDao() {
        super(Address.class);
    }
}
