package Entities;

/**
 * @author tfifha youssef
 */
public class Cart {
    private int CartId;
    private int OeuvreID;
    private int Quantity;

    public Cart() {
    }
    public Cart(int cartId) {
        CartId = cartId;
    }


    public Cart(int cartId, int oeuvreID, int quantity) {
        CartId = cartId;
        OeuvreID = oeuvreID;
        Quantity = quantity;
    }

    public int getCartId() {
        return CartId;
    }

    public void setCartId(int cartId) {
        CartId= cartId;
    }

    public int getOeuvreID() {
        return OeuvreID;
    }

    public void setOeuvreID(int oeuvreID) {
        OeuvreID= oeuvreID;
    }

    public int getQuantiy() {
        return Quantity;
    }

    public void setQuantiy(int quantiy) {
        Quantity=quantiy;

    }

    @Override
    public String toString() {
        return "Cart{" +
                "CartId=" + CartId +
                ", ProductID=" + OeuvreID +
                ", Quantiy=" + Quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Cart cart = (Cart) o;
        return getCartId () == cart.getCartId ();
    }

}
