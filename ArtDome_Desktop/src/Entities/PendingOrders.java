package Entities;

/**
 * @author tfifha youssef
 */
public class PendingOrders {
    private int ID_PendingOrder;
    private User IDUser;
    private int InnoNumber;
    private Oeuvre OeuvreID;
    private int Quantity;
    private String Status;

    public PendingOrders() {
    }

    public int getID_PendingOrder() {
        return ID_PendingOrder;
    }

    public void setID_PendingOrder(int orderId) {
        ID_PendingOrder = ID_PendingOrder;
    }

    public User getIDUser() {
        return IDUser;
    }

    public void setIDUser(User IDUser) {
        IDUser = IDUser;
    }

    public int getInnoNumber() {
        return InnoNumber;
    }

    public void setInnoNumber(int innoNumber) {
        InnoNumber = innoNumber;
    }

    public Oeuvre getOeuvreID() {
        return OeuvreID;
    }

    public void setOeuvreID(Oeuvre oeuvreID) {
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


    public PendingOrders(User IDUser, int innoNumber, Oeuvre oeuvreID, int quantity, String status) {
        IDUser = IDUser;
        InnoNumber = innoNumber;
        OeuvreID = oeuvreID;
        Quantity = quantity;
        Status = status;
    }

    @Override
    public String toString() {
        return "PendingOrders{" +
                "ID_PendingOrder=" + ID_PendingOrder +
                ", UserName='" + IDUser + '\'' +
                ", InnoNumber=" + InnoNumber +
                ", OeuvreID=" + OeuvreID +
                ", Quantity=" + Quantity +
                ", Status='" + Status + '\'' +
                '}';
    }
}
