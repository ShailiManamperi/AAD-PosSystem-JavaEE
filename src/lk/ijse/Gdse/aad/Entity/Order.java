package lk.ijse.Gdse.aad.Entity;

public class Order implements SuperEntity{
    private String O_id;
    private String C_id;
    private String date;
    private double total;
    private double discount;
    private double subtotal;

    public Order(String o_id, String c_id, String date, double total, double discount, double subtotal) {
        this.O_id = o_id;
        this.C_id = c_id;
        this.date = date;
        this.total = total;
        this.discount = discount;
        this.subtotal = subtotal;
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
}
