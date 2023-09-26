package lk.ijse.Gdse.aad.Service.Custom.Impl;

import lk.ijse.Gdse.aad.Dao.Custom.ItemDAO;
import lk.ijse.Gdse.aad.Dao.Custom.OrderDAO;
import lk.ijse.Gdse.aad.Dao.DaoFactory;
import lk.ijse.Gdse.aad.Dao.DaoTypes;
import lk.ijse.Gdse.aad.Dto.ItemDto;
import lk.ijse.Gdse.aad.Dto.OrderDto;
import lk.ijse.Gdse.aad.Entity.Item;
import lk.ijse.Gdse.aad.Entity.Order;
import lk.ijse.Gdse.aad.Service.Custom.OrderService;
import lk.ijse.Gdse.aad.Service.exception.NotFoundException;
import lk.ijse.Gdse.aad.Util.Converter;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final Converter converter;

    private final OrderDAO orderDAO;

    public OrderServiceImpl(){
        this.converter = new Converter();
        this.orderDAO = DaoFactory.getInstance().getDAO(DaoTypes.ORDER);
    }
    @Override
    public ArrayList<OrderDto> getAllOrders() throws NotFoundException {
        List<Order> all = orderDAO.findAll();
        ArrayList<OrderDto> OrderDtoList = new ArrayList<>();
        for (int i = 0; i<all.size(); i++){
            Order order = all.get(i);
            OrderDtoList.add(i,converter.fromOrder(order));
        }
        return OrderDtoList;
    }
}
