package lk.ijse.Gdse.aad.Dto;

public class CustomerDto {
    private String custid;
    private String custname;
    private String custaddress;
    private String custcontact;

    public CustomerDto() {
    }

    public CustomerDto(String custid, String custname, String custaddress, String custcontact) {
        this.custid = custid;
        this.custname = custname;
        this.custaddress = custaddress;
        this.custcontact = custcontact;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustaddress() {
        return custaddress;
    }

    public void setCustaddress(String custaddress) {
        this.custaddress = custaddress;
    }

    public String getCustcontact() {
        return custcontact;
    }

    public void setCustcontact(String custcontact) {
        this.custcontact = custcontact;
    }
}
