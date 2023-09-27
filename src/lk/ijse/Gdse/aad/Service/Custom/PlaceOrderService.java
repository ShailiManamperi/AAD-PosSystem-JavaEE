package lk.ijse.Gdse.aad.Service.Custom;

import lk.ijse.Gdse.aad.Dto.PlaceOrderDto;
import lk.ijse.Gdse.aad.Service.SuperService;

import java.sql.SQLException;

public interface PlaceOrderService extends SuperService {
    public boolean PlaceOrder(PlaceOrderDto placeOrder) throws SQLException,ClassNotFoundException;
}
