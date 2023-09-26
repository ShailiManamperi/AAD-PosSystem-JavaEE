package lk.ijse.Gdse.aad.Dao.Custom;

import lk.ijse.Gdse.aad.Dao.CrudDAO;
import lk.ijse.Gdse.aad.Entity.Customer;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    public Customer findCustomer(String id, String type);

    public String findNewCustomerId();

}
