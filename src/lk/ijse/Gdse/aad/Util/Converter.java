package lk.ijse.Gdse.aad.Util;

import lk.ijse.Gdse.aad.Dto.CustomerDto;
import lk.ijse.Gdse.aad.Dto.ItemDto;
import lk.ijse.Gdse.aad.Entity.Customer;
import lk.ijse.Gdse.aad.Entity.Item;

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

//    public OrderDTO fromOrder(Order order){
//        return new OrderDTO(order.getOid(),order.getDate(),order.getCid(), order.getStatus(), order.getPrice());
//    }
//
//    public Order toOrder(OrderDTO orderDTO){
//        return new Order(orderDTO.getOid(),orderDTO.getDate(),orderDTO.getCid(), orderDTO.getStatus(),orderDTO.getPrice());
//    }
//
//    public PlaceOrderDTO fromPlaceOrder(PlaceOrder placeOrder){
//        return new PlaceOrderDTO(placeOrder.getOid(),placeOrder.getDate(),placeOrder.getCid(),placeOrder.getStatus(),placeOrder.getPrice(),placeOrder.getOrderDetails());
//    }
//
//    public PlaceOrder toPlaceOrder(PlaceOrderDTO placeOrderDTO){
//        return new PlaceOrder(placeOrderDTO.getOid(), placeOrderDTO.getDate(), placeOrderDTO.getCid(), placeOrderDTO.getStatus(), placeOrderDTO.getPrice(), placeOrderDTO.getOrderDetails());
//    }
}
