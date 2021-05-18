package Entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @author tfifha youssef
 */
public class Orders {
    private int OrderID;
    private int IDUser;
    private float DueAmount;
    private int InnoNumber;
    private String OrderDate;
    private String Status;

    public Orders(int orderID) {
        OrderID = orderID;
    }

    public Orders(float dueAmount) {
        DueAmount = dueAmount;
    }

    public Orders() {
    }

    public Orders(int orderID, int IDUser, float dueAmount, int innoNumber, String orderDate, String status) {
        OrderID = orderID;
        this.IDUser = IDUser;
        DueAmount = dueAmount;
        InnoNumber = innoNumber;
        OrderDate = orderDate;
        Status = status;
    }

    public Orders(float dueAmount, int innoNumber, String orderDate, String status) {
        DueAmount = dueAmount;
        InnoNumber = innoNumber;
        OrderDate = orderDate;
        Status = status;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        IDUser = IDUser;
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
                ", DueAmount=" + DueAmount +
                ", InnoNumber=" + InnoNumber +
                ", OrderDate=" + OrderDate +
                ", Status=" + Status +
                '}';
    }
}
