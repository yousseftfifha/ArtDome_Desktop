package Tests;

import Entities.Cart;
import Entities.Oeuvre;
import Entities.Orders;
import Services.CartCRUD;
import Services.OrdersCRUD;
import Tools.MyConnection;
import Tools.SendEmail;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author tfifha youssef
 */
public class CrudTest {
    public static void main(String[] args) throws SQLException, MessagingException {
        MyConnection myConnection=MyConnection.getInstance ();//connection

        CartCRUD cartCRUD=new CartCRUD ();
        OrdersCRUD ordersCRUD=new OrdersCRUD ();

        List<Oeuvre> oeuvre1=cartCRUD.selectOeuvreById (1);
//        List<Oeuvre> oeuvre2=cartCRUD.selectOeuvreById (2);

        Cart cart=new Cart("youssef");
//        Cart cart1=new Cart(1);

        cartCRUD.AddCart (cart,oeuvre1.get (0));
//        cartCRUD.AddCart (cart,oeuvre2.get (0));
//        cartCRUD.AddCart (cart1,oeuvre2.get (0));

        cartCRUD.updateQuantity ("youssef",oeuvre1.get (0));

//        cartCRUD.DeletCart (cart1);

        ordersCRUD.AddFromCart (0);

        List<Orders> orders=ordersCRUD.readAllOrders ();

//        ordersCRUD.updateOrderStatus ( orders.get (0),"confirmed");

//        ordersCRUD.DeletOrders (orders.get (0).getOrderID ());

//        cartCRUD.DeletCart (cart);
        int i= cartCRUD.count ();
        System.out.println (i);

        SendEmail.sendMail ("youssef.tfifha@esprit.tn","OrderConfirmation","vous avez ajouter une nouvelle commande ");

    }
}
