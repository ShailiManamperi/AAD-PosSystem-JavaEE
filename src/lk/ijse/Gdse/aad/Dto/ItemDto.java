package lk.ijse.Gdse.aad.Dto;

public class ItemDto {
    private String Itemid;
    private String description;
    private Double unitprice;
    private int qty;

    public ItemDto(String itemid, String description, Double unitprice, int qty) {
        Itemid = itemid;
        this.description = description;
        this.unitprice = unitprice;
        this.qty = qty;
    }

    public String getItemid() {
        return Itemid;
    }

    public void setItemid(String itemid) {
        Itemid = itemid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
