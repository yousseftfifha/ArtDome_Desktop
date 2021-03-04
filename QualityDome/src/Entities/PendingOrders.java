package Entities;

/**
 * @author tfifha youssef
 */
public class PendingOrders {
    private int OrderId;
    private String UserName;
    private int InnoNumber;
    private int OeuvreID;
    private int Quantity;
    private String Status;
    private int AddressID;

    public PendingOrders() {
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getInnoNumber() {
        return InnoNumber;
    }

    public void setInnoNumber(int innoNumber) {
        InnoNumber = innoNumber;
    }

    public int getOeuvreID() {
        return OeuvreID;
    }

    public void setOeuvreID(int oeuvreID) {
        OeuvreID = oeuvreID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getAddressID() {
        return AddressID;
    }

    public void setAddressID(int addressID) {
        AddressID = addressID;
    }

    public PendingOrders(int orderId, String userName, int innoNumber, int oeuvreID, int quantity, String status, int addressID) {
        OrderId = orderId;
        UserName = userName;
        InnoNumber = innoNumber;
        OeuvreID = oeuvreID;
        Quantity = quantity;
        Status = status;
        AddressID = addressID;
    }

    @Override
    public String toString() {
        return "PendingOrders{" +
                "OrderId=" + OrderId +
                ", UserName='" + UserName + '\'' +
                ", InnoNumber=" + InnoNumber +
                ", OeuvreID=" + OeuvreID +
                ", Quantity=" + Quantity +
                ", Status='" + Status + '\'' +
                ", AddressID=" + AddressID +
                '}';
    }
}
