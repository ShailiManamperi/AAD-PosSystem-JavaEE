package lk.ijse.Gdse.aad.Service.Custom.Impl;

import lk.ijse.Gdse.aad.Dao.Custom.*;
import lk.ijse.Gdse.aad.Dao.DaoFactory;
import lk.ijse.Gdse.aad.Dao.DaoTypes;
import lk.ijse.Gdse.aad.Db.DBConnection;
import lk.ijse.Gdse.aad.Dto.OrderDto;
import lk.ijse.Gdse.aad.Dto.PlaceOrderDto;
import lk.ijse.Gdse.aad.Entity.CartDetail;
import lk.ijse.Gdse.aad.Entity.Order;
import lk.ijse.Gdse.aad.Service.Custom.PlaceOrderService;
import lk.ijse.Gdse.aad.Util.Converter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderServiceImpl implements PlaceOrderService {
    private final Connection connection;
    private final Converter converter;
    private final OrderDAO orderDAO;
    private final ItemDAO itemDAO;

    public PlaceOrderServiceImpl(){
        connection = DBConnection.getConnection();
        orderDAO = DaoFactory.getInstance().getDAO(DaoTypes.ORDER);
        itemDAO = DaoFactory.getInstance().getDAO(DaoTypes.ITEM);
        converter = new Converter();
    }
    @Override
    public boolean PlaceOrder(PlaceOrderDto placeOrder) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getConnection().setAutoCommit(false);
            Order order = converter.toOrder(new OrderDto(placeOrder.getO_id(), placeOrder.getC_id(), placeOrder.getDate(),
                    placeOrder.getTotal(), placeOrder.getDiscount(), placeOrder.getSubtotal()));
            Boolean save = orderDAO.save(order);
            if (save) {
                System.out.println("order saved in order table");
                boolean isUpdated = itemDAO.updateQty(placeOrder.getOrderdetail());
                if (isUpdated) {
                    System.out.println("update item qty");
                    boolean issaved = itemDAO.saveOrderDetails(placeOrder.getOrderdetail(), converter.toPlaceOrder(placeOrder));
                    if (issaved) {
                        System.out.println("order saved in orderdetail table");
                        DBConnection.getConnection().commit();
                        return true;
                    }
                }
            }

            DBConnection.getConnection().rollback();
            return false;
        } finally {
            DBConnection.getConnection().setAutoCommit(true);
        }
    }
}
