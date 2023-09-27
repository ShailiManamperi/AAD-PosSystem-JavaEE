package lk.ijse.Gdse.aad.Dao.Custom;

import lk.ijse.Gdse.aad.Dao.CrudDAO;
import lk.ijse.Gdse.aad.Entity.CartDetail;
import lk.ijse.Gdse.aad.Entity.Customer;
import lk.ijse.Gdse.aad.Entity.Item;
import lk.ijse.Gdse.aad.Entity.PlaceOrder;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<Item,String> {
    public  boolean updateQty(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException;

    public  boolean saveOrderDetails(ArrayList<CartDetail> cartDetails, PlaceOrder placeOrder) throws SQLException, ClassNotFoundException;
}
