package lk.ijse.Gdse.aad.Entity;

public class Customer implements SuperEntity{
    private String custId;
    private String custName;
    private String custAddress;
    private String custContact;

    public Customer(String custId, String custName, String custAddress, String custContact) {
        this.custId = custId;
        this.custName = custName;
        this.custAddress = custAddress;
        this.custContact = custContact;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustContact() {
        return custContact;
    }

    public void setCustContact(String custContact) {
        this.custContact = custContact;
    }
}
