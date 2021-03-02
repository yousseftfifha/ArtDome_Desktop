package Services;

import Entities.Cart;
import Entities.Oeuvre;
import Entities.Orders;
import Entities.PendingOrders;
import Tools.MyConnection;
import javafx.scene.control.ComboBox;

import java.sql.*;
import java.text.DateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tfifha youssef
 */
public class OrdersCRUD {
    private Statement statement;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    public OrdersCRUD() {
        connection = MyConnection.getInstance ().getConnection ();
    }
    public void AddFromCart(int UserID){
        int nombreAleatoire = 1000000 + (int)(Math.random() * ((9999999 - 1000000) + 1));
        int orID = 1000 + (int)(Math.random() * ((9999 - 1000) + 1));
        float total_prix=0;
        int quantitytot=0;
        CartCRUD cartCRUD = new CartCRUD ();
//        List<Cart> carts = cartCRUD.selectCartById (cart.getCartId ());
////        List<Oeuvre> oeuvres = cartCRUD.ReadAllOeuvrse();
//
////        for (Oeuvre oeuvre : oeuvres) {
////            System.out.println(oeuvre.getID_Oeuvre ());
////            System.out.println(oeuvre.getNomOeuvre ());
////            System.out.println(oeuvre.getPrixOeuvre ());
////
////
//        }
        ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);

        Map<Cart,Oeuvre> cartOeuvreMap=cartCRUD.ReadAllOeuvrse ();

        for(Cart i : cartOeuvreMap.keySet()){
            total_prix+=i.getQuantiy ()*cartOeuvreMap.get (i).getPrixOeuvre ();
            String request="INSERT INTO pending_orders(OrderID,UserName,InnoNumber,OeuvreID,Quantity,Status,AddressID)"+"VALUES(?,?,?,?,?,?,?) ";
            quantitytot+=i.getQuantiy ();
            try {
                preparedStatement = connection.prepareStatement(request);
                preparedStatement.setInt (1,orID);
                preparedStatement.setString (2,"youssef");
                preparedStatement.setInt (3,nombreAleatoire);
                preparedStatement.setInt (4,cartOeuvreMap.get (i).getID_Oeuvre ());
                preparedStatement.setInt (5,i.getQuantiy ());
                preparedStatement.setString (6,"pending");
                preparedStatement.setInt (7,1);
                preparedStatement.executeUpdate ();
                cartCRUD.DeletCart (i.getCartId ());

            } catch (SQLException throwables) {
                System.out.println ("Probleme lors de l'ajout de la pending order");
            }

        }
        String request1="INSERT INTO orders(OrderID,UserName,DueAmount,InnoNumber,TotalQty,OrderDate,Status,AddressId)"+"VALUES(?,?,?,?,?,?,?,?) ";

        try {
            preparedStatement = connection.prepareStatement(request1);
            preparedStatement.setInt (1,orID);
            preparedStatement.setString (2,"youssef");
            preparedStatement.setFloat (3,total_prix);
            preparedStatement.setInt (4,nombreAleatoire);
            preparedStatement.setInt (5,quantitytot);
            preparedStatement.setString (6,ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME) );
            preparedStatement.setString (7,"pending");
            preparedStatement.setInt (8,1);
            preparedStatement.executeUpdate ();


        } catch (SQLException throwables) {
            System.out.println ("Probleme lors de l'ajout du l'order");
            throwables.printStackTrace ();
        }


    }
    public List<PendingOrders> readAllpendingOrders() {
        String req = "select * from pending_orders";

        List<PendingOrders> list=new ArrayList<> ();
        try {
            statement = connection.createStatement();
            resultSet= statement.executeQuery(req);
            while(resultSet.next()){
                list.add(new PendingOrders (resultSet.getInt(1), resultSet.getString (2), resultSet.getInt (3),resultSet.getInt (4),resultSet.getInt (5),resultSet.getString (6),resultSet.getInt (7)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CartCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<Orders> readAllOrders() {
        String req = "select * from orders";

        List<Orders> list=new ArrayList<> ();
        try {
            statement = connection.createStatement();
            resultSet= statement.executeQuery(req);
            while(resultSet.next()){
                list.add(new Orders (resultSet.getInt(1), resultSet.getString (2), resultSet.getFloat (3),resultSet.getInt (4),resultSet.getInt (5),resultSet.getString (6),resultSet.getString (7),resultSet.getInt (8)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CartCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public  List<Orders> combofill ()
    {
        List<Orders> list =new ArrayList<>() ;
        String req = "select OrderID from orders ";
        try {
            preparedStatement=connection.prepareStatement (req);

            ResultSet result =preparedStatement.executeQuery() ;
            while (result.next()){
                list.add(new Orders (
                        result.getInt(1)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    public  List<Orders> selectOrderById (int id)
    {
        List<Orders> list =new ArrayList<>() ;
        String req = "select * from orders where OrderID=?";
        try {
            preparedStatement=connection.prepareStatement (req);
            preparedStatement.setInt(1,id);
            ResultSet result =preparedStatement.executeQuery() ;
            while (result.next()){
                list.add(new Orders (
                        result.getInt(1),
                        result.getString (2),
                        result.getFloat (3),
                        result.getInt (4),
                        result.getInt (5),
                        result.getString (6),
                        result.getString (7),
                        result.getInt (8)

                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    public  List<PendingOrders> selectPendById (int id)
    {
        List<PendingOrders> list =new ArrayList<>() ;
        String req = "select * from pending_orders where OrderID=?";
        try {
            preparedStatement=connection.prepareStatement (req);
            preparedStatement.setInt(1,id);
            ResultSet result =preparedStatement.executeQuery() ;
            while (result.next()){
                list.add(new PendingOrders (
                        result.getInt(1),
                        result.getString (2),
                        result.getInt (3),
                        result.getInt (4),
                        result.getInt (5),
                        result.getString (6),
                        result.getInt (7)

                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    public  void updateOrderStatus (int id ,String str)
    {
        String req="UPDATE orders SET Status=? WHERE OrderID =?" ;
        try {
            preparedStatement=connection.prepareStatement (req);
            preparedStatement.setString (1,str); ;
            preparedStatement.setInt (2,id) ;

            preparedStatement.executeUpdate() ;

        } catch (SQLException ex) {
            System.out.println ("Probleme lors de l'update du statut de l'ordre");
        }
        String req1="UPDATE pending_orders SET Status=? WHERE OrderID =?" ;
        try {
            preparedStatement=connection.prepareStatement (req1);
            preparedStatement.setString (1,str); ;
            preparedStatement.setInt (2,id) ;

            preparedStatement.executeUpdate() ;

        } catch (SQLException ex) {
            System.out.println ("Probleme lors de l'update de du statut du pending order");
        }
    }
    public  void DeletOrders (int id)
    {
        String req="DELETE  from orders where  OrderID =?" ;
        try {
            preparedStatement=connection.prepareStatement (req);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate ();

        } catch (SQLException ex) {
            System.out.println ("Probleme lors de la supprision du panier");

        }
        String req1="DELETE  from pending_orders where  OrderID =?" ;
        try {
            preparedStatement=connection.prepareStatement (req1);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate ();

        } catch (SQLException ex) {
            System.out.println ("Probleme lors de la supprision du panier");

        }

    }
}
