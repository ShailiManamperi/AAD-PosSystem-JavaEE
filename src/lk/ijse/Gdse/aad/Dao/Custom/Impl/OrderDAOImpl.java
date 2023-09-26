package lk.ijse.Gdse.aad.Dao.Custom.Impl;

import lk.ijse.Gdse.aad.Dao.Custom.OrderDAO;
import lk.ijse.Gdse.aad.Dao.exception.ConstraintViolationException;
import lk.ijse.Gdse.aad.Entity.Item;
import lk.ijse.Gdse.aad.Entity.Order;
import lk.ijse.Gdse.aad.Util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public Boolean save(Order entity) throws ConstraintViolationException {
        return null;
    }

    @Override
    public Boolean update(Order entity) throws ConstraintViolationException {
        return null;
    }

    @Override
    public boolean deleteByPk(String pk) throws ConstraintViolationException {
        return false;
    }

    @Override
    public List<Order> findAll() {
        try{
            ResultSet rst = CRUDUtil.execute("SELECT * FROM order");
            return getOrderList(rst);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to load the items");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Order> getOrderList(ResultSet rst) {
        try {
            List<Order> orderList= new ArrayList<>();
            while (rst.next()){
                Order e1 = new Order(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getDouble(4),
                        rst.getDouble(5),
                        rst.getDouble(6));
                orderList.add(e1);
            }
            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order findByPk(String pk) {
        return null;
    }

    @Override
    public boolean existByPk(String pk) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }
}
