package lk.ijse.Gdse.aad.Dto;

import lk.ijse.Gdse.aad.Entity.CartDetail;

import java.util.ArrayList;

public class PlaceOrderDto {
    private String O_id;
    private String C_id;
    private String date;
    private double total;
    private double discount;
    private double subtotal;
    private ArrayList<CartDetail> orderdetail = new ArrayList<>();

    public PlaceOrderDto(String o_id, String c_id, String date, double total, double discount, double subtotal, ArrayList<CartDetail> orderdetail) {
        O_id = o_id;
        C_id = c_id;
        this.date = date;
        this.total = total;
        this.discount = discount;
        this.subtotal = subtotal;
        this.orderdetail = orderdetail;
    }

    public String getO_id() {
        return O_id;
    }

    public void setO_id(String o_id) {
        O_id = o_id;
    }

    public String getC_id() {
        return C_id;
    }

    public void setC_id(String c_id) {
        C_id = c_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public ArrayList<CartDetail> getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(ArrayList<CartDetail> orderdetail) {
        this.orderdetail = orderdetail;
    }
}
