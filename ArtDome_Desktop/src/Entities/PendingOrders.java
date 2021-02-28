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
