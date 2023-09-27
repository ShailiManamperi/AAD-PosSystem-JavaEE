package lk.ijse.Gdse.aad.Dao.Custom.Impl;

import lk.ijse.Gdse.aad.Dao.Custom.ItemDAO;
import lk.ijse.Gdse.aad.Dao.exception.ConstraintViolationException;
import lk.ijse.Gdse.aad.Entity.CartDetail;
import lk.ijse.Gdse.aad.Entity.Customer;
import lk.ijse.Gdse.aad.Entity.Item;
import lk.ijse.Gdse.aad.Entity.PlaceOrder;
import lk.ijse.Gdse.aad.Util.CRUDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class itemDAOImpl implements ItemDAO {
    @Override
    public Boolean save(Item entity) throws ConstraintViolationException {
        try {
            if(CRUDUtil.execute("INSERT INTO item VALUES (?, ?, ?, ?)",
                    entity.getItemid(),entity.getDescription(),entity.getUnitprice(),entity.getQty())){
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
    public Boolean update(Item entity) throws ConstraintViolationException {
        try {
            String sql ="UPDATE item SET description = ?, unitprice = ?, qty = ? WHERE I_id = ?";
            if(CRUDUtil.execute(sql,entity.getDescription(),entity.getUnitprice(),entity.getQty(),entity.getItemid())){
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new ConstraintViolationException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteByPk(String pk) throws ConstraintViolationException {
        try {
            if(CRUDUtil.execute("DELETE FROM item WHERE I_id=?",pk)){
                return true;
            }

        } catch (SQLException e) {
            throw new ConstraintViolationException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public List<Item> findAll() {
        try{
            ResultSet rst = CRUDUtil.execute("SELECT * FROM item");
            return getItemList(rst);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to load the items");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Item> getItemList(ResultSet rst) {
        try {
            List<Item> itemList= new ArrayList<>();
            while (rst.next()){
                Item e1 = new Item(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getDouble(3),
                        rst.getInt(4));
                itemList.add(e1);
            }
            return itemList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Item findByPk(String pk) {
        try{
            ResultSet rst = CRUDUtil.execute("SELECT * FROM item WHERE I_id = ?", pk);
            if(rst.next()){
                return new Item(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getDouble(3),
                        rst.getInt(4)
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the item details");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existByPk(String pk) {
        try {
            ResultSet rst = CRUDUtil.execute("SELECT * FROM item WHERE I_id = ?", pk);
            return rst.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean updateQty(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException {
        for (CartDetail cartDetail : cartDetails) {
            if (!updateQty(new Item(cartDetail.getQty(),cartDetail.getItemid()))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean saveOrderDetails(ArrayList<CartDetail> cartDetails, PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
        for (CartDetail cartDetail : cartDetails) {
            if (!save(cartDetail,placeOrder)) {
                return false;
            }
        }
        return true;
    }

    private boolean save(CartDetail cartDetail, PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO orderdetail VALUES(?, ?, ?,?)";
        return CRUDUtil.execute(sql,placeOrder.getO_id(),cartDetail.getItemid(),cartDetail.getQty(),cartDetail.getPrice() );
    }

    private boolean updateQty(Item item) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE item SET qty = qty - ? WHERE I_id = ?";
        return CRUDUtil.execute(sql,item.getQty(),item.getItemid());
    }
}
