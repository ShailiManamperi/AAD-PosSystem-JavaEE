package lk.ijse.Gdse.aad.Dao.Custom.Impl;

import lk.ijse.Gdse.aad.Dao.Custom.CustomerDAO;
import lk.ijse.Gdse.aad.Dao.exception.ConstraintViolationException;
import lk.ijse.Gdse.aad.Entity.Customer;
import lk.ijse.Gdse.aad.Util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDAO {
    @Override
    public Boolean save(Customer entity) throws ConstraintViolationException {
        try {
            if(CRUDUtil.execute("INSERT INTO customer VALUES (?, ?, ?, ?)",
                    entity.getCustId(),entity.getCustName(),entity.getCustAddress(),entity.getCustContact())){
                return true;
            }
        }catch (SQLException e){
            throw new ConstraintViolationException(e);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Boolean update(Customer entity) throws ConstraintViolationException {
        return false;
    }

    @Override
    public boolean deleteByPk(String pk) throws ConstraintViolationException {
        return false;
    }

    @Override
    public List<Customer> findAll() {
        try{
            ResultSet rst = CRUDUtil.execute("SELECT * FROM customer");
            return getCustomerList(rst);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to load the customers");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private List<Customer> getCustomerList(ResultSet rst) {
        try {
            List<Customer> customerList= new ArrayList<>();
            while (rst.next()){
                Customer e1 = new Customer(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4));
                customerList.add(e1);
            }
            return customerList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer findByPk(String pk) {
        try{
            ResultSet rst = CRUDUtil.execute("SELECT * FROM customer WHERE C_id = ?", pk);
            if(rst.next()){
                return new Customer(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4)
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the customer details");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existByPk(String pk) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Customer findCustomer(String id, String type) {
        return null;
    }

    @Override
    public String findNewCustomerId() {
        return null;
    }
}