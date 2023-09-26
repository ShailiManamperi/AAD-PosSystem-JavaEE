package lk.ijse.Gdse.aad.Service.Custom;

import lk.ijse.Gdse.aad.Dto.ItemDto;
import lk.ijse.Gdse.aad.Dto.OrderDto;
import lk.ijse.Gdse.aad.Service.SuperService;
import lk.ijse.Gdse.aad.Service.exception.NotFoundException;

import java.util.ArrayList;

public interface OrderService extends SuperService {
    public ArrayList<OrderDto> getAllOrders() throws NotFoundException;
}
