package lk.ijse.Gdse.aad.Service.Custom.Impl;

import lk.ijse.Gdse.aad.Dao.Custom.*;
import lk.ijse.Gdse.aad.Dao.DaoFactory;
import lk.ijse.Gdse.aad.Dao.DaoTypes;
import lk.ijse.Gdse.aad.Db.DBConnection;
import lk.ijse.Gdse.aad.Dto.PlaceOrderDto;
import lk.ijse.Gdse.aad.Service.Custom.PlaceOrderService;
import lk.ijse.Gdse.aad.Util.Converter;

import java.sql.Connection;
import java.sql.SQLException;

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
            Order order = converter.toOrder(new OrderDTO(placeOrder.getOid(), placeOrder.getDate(), placeOrder.getCid(), placeOrder.getStatus(), placeOrder.getPrice()));
            Order save = orderDAO.save(order);
            if (save != null) {
                boolean isUpdated = itemDAO.updateQty(placeOrder.getOrderDetails());
                if (isUpdated) {
                    boolean issaved = itemDAO.saveOrderDetails(placeOrder.getOrderDetails(), converter.toPlaceOrder(placeOrder));
                    if (issaved) {
                        boolean saveDelivery = deliveryDAO.saveHaveDelivery(converter.toDelivery(deliveryDTO));
                        if (saveDelivery) {
                            DBConnection.getDbConnection().getConnection().commit();
                            return true;
                        }
                    }
                }
            }
            DBConnection.getDbConnection().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getDbConnection().getConnection().setAutoCommit(true);
        }
    }
}
