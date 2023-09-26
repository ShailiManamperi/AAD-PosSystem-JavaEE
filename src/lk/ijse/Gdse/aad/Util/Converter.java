package lk.ijse.Gdse.aad.Util;

import lk.ijse.Gdse.aad.Dto.CustomerDto;
import lk.ijse.Gdse.aad.Dto.ItemDto;
import lk.ijse.Gdse.aad.Dto.OrderDto;
import lk.ijse.Gdse.aad.Entity.Customer;
import lk.ijse.Gdse.aad.Entity.Item;
import lk.ijse.Gdse.aad.Entity.Order;

public class Converter {
    public CustomerDto fromCustomer(Customer customer){
        return new CustomerDto(customer.getCustId(), customer.getCustName(), customer.getCustAddress(), customer.getCustContact());
    }

    public Customer toCustomer(CustomerDto customerDTO){
        return new Customer(customerDTO.getCustid(), customerDTO.getCustname(), customerDTO.getCustaddress(), customerDTO.getCustcontact());
    }

    public ItemDto fromItem(Item item){
        return new ItemDto(item.getItemid(),item.getDescription(),item.getUnitprice(), item.getQty());
    }

    public Item toItem(ItemDto itemDto){
        return new Item(itemDto.getItemid(),itemDto.getDescription(), itemDto.getUnitprice(), itemDto.getQty());
    }

    public OrderDto fromOrder(Order order){
        return new OrderDto(order.getO_id(),order.getC_id(),order.getDate(),order.getTotal(),order.getDiscount(),order.getSubtotal());
    }

    public Order toOrder(OrderDto orderDTO){
        return new Order(orderDTO.getO_id(),orderDTO.getC_id(),orderDTO.getDate(),orderDTO.getTotal(),orderDTO.getDiscount(),orderDTO.getSubtotal());
    }
//
//    public PlaceOrderDTO fromPlaceOrder(PlaceOrder placeOrder){
//        return new PlaceOrderDTO(placeOrder.getOid(),placeOrder.getDate(),placeOrder.getCid(),placeOrder.getStatus(),placeOrder.getPrice(),placeOrder.getOrderDetails());
//    }
//
//    public PlaceOrder toPlaceOrder(PlaceOrderDTO placeOrderDTO){
//        return new PlaceOrder(placeOrderDTO.getOid(), placeOrderDTO.getDate(), placeOrderDTO.getCid(), placeOrderDTO.getStatus(), placeOrderDTO.getPrice(), placeOrderDTO.getOrderDetails());
//    }
}
