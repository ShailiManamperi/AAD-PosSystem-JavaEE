package lk.ijse.Gdse.aad.Dto;

import java.util.ArrayList;

public class PlaceOrderDto {
    private String O_id;
    private String C_id;
    private String date;
    private ArrayList<CartDetailDto> orderdetail = new ArrayList<>();

    public PlaceOrderDto(String o_id, String c_id, String date, ArrayList<CartDetailDto> orderdetail) {
        O_id = o_id;
        C_id = c_id;
        this.date = date;
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

    public ArrayList<CartDetailDto> getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(ArrayList<CartDetailDto> orderdetail) {
        this.orderdetail = orderdetail;
    }
}
