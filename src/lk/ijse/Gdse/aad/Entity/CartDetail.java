package lk.ijse.Gdse.aad.Entity;

public class CartDetail implements SuperEntity{
    private String Itemid;
    private int Qty;
    private double price;

    public CartDetail(String itemid, int qty, double price) {
        Itemid = itemid;
        Qty = qty;
        this.price = price;
    }

    public String getItemid() {
        return Itemid;
    }

    public void setItemid(String itemid) {
        Itemid = itemid;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
