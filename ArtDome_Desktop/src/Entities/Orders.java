package Entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @author tfifha youssef
 */
public class Orders {
    private int OrderID;
    private String UserName;
    private float DueAmount;
    private int InnoNumber;
    private int TotalQty;
    private String OrderDate;
    private String Status;
    private int AddressID;

    public Orders(int orderID) {
        OrderID = orderID;
    }

    public Orders() {
    }

    public Orders(int orderID, String userName, float dueAmount, int innoNumber, int totalQty, String orderDate, String status, int addressID) {
        OrderID = orderID;
        UserName = userName;
        DueAmount = dueAmount;
        InnoNumber = innoNumber;
        TotalQty = totalQty;
        OrderDate = orderDate;
        Status = status;
        AddressID = addressID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public float getDueAmount() {
        return DueAmount;
    }

    public void setDueAmount(float dueAmount) {
        DueAmount = dueAmount;
    }

    public int getInnoNumber() {
        return InnoNumber;
    }

    public void setInnoNumber(int innoNumber) {
        InnoNumber = innoNumber;
    }

    public int getTotalQty() {
        return TotalQty;
    }

    public void setTotalQty(int totalQty) {
        TotalQty = totalQty;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Orders orders = (Orders) o;
        return getOrderID () == orders.getOrderID ();
    }

    @Override
    public String toString() {
        return "Orders{" +
                "OrderID=" + OrderID +
                ", UserName='" + UserName + '\'' +
                ", DueAmount=" + DueAmount +
                ", InnoNumber=" + InnoNumber +
                ", TotalQty=" + TotalQty +
                ", OrderDate=" + OrderDate +
                ", Status=" + Status +
                ", AddressID=" + AddressID +
                '}';
    }
}
