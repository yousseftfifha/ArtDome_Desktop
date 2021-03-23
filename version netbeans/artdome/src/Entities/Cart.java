package Entities;

import java.util.List;

/**
 * @author tfifha youssef
 */
public class Cart {
    private String CartId;
    private User LoggedInUser;
    private int OeuvreID;
    private Oeuvre Oeuvre;
    private List<Oeuvre> oeuvre;
    private int Quantity;
    private String NomOeuvre;

    public Cart(User LoggedInUser) {
        this.LoggedInUser = LoggedInUser;
    }

    public Cart(String cartId, User LoggedInUser, int oeuvreID, int quantity, String nomOeuvre) {
        CartId = cartId;
        this.LoggedInUser = LoggedInUser;
        OeuvreID = oeuvreID;
        Quantity = quantity;
        NomOeuvre = nomOeuvre;
    }

    public Cart(String cartId, int oeuvreID, String nomOeuvre, int quantity) {
        CartId = cartId;
        OeuvreID = oeuvreID;
        Quantity = quantity;
        NomOeuvre = nomOeuvre;
    }

    public void setOeuvre(Entities.Oeuvre oeuvre) {
        Oeuvre = oeuvre;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getNomOeuvre() {
        return NomOeuvre;
    }

    public void setNomOeuvre(String nomOeuvre) {
        NomOeuvre = nomOeuvre;
    }

    public Cart() {
    }

    public Cart(String cartId) {
        CartId = cartId;
    }

    public Cart(int oeuvreID) {
        OeuvreID = oeuvreID;
    }

    public Cart(String  cartId, int oeuvreID, int quantity) {
        CartId = cartId;
        OeuvreID = oeuvreID;
        Quantity = quantity;
    }

    public Oeuvre getOeuvre() {
        return Oeuvre;
    }
    public List<Oeuvre> getListOeuvre() {
        return oeuvre;
    }


    public void setOeuvre1(List<Oeuvre> oeuvre) {
        this.oeuvre = oeuvre;
    }

    public String getCartId() {
        return CartId;
    }

    public void setCartId(String cartId) {
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

    public User getLoggedInUser() {
        return LoggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.LoggedInUser = loggedInUser;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "CartId='" + CartId + '\'' +
                ", OeuvreID=" + OeuvreID +
                ", Quantity=" + Quantity +
                ", NomOeuvre='" + NomOeuvre + '\'' +
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
