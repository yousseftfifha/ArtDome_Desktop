package Services;

import Entities.Cart;
import Entities.Oeuvre;
import Tools.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tfifha youssef
 */
public class CartCRUD {
    private Statement statement;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    public CartCRUD() {
        connection = MyConnection.getInstance ().getConnection ();
    }
    public void AddCart(Cart cart,Oeuvre oeuvre){
        String request="INSERT INTO CART(CartId,OeuvreId,Quantity)"+"VALUES(?,?,?) ";
        try {
            preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt (1,cart.getCartId ());
            preparedStatement.setInt (2,oeuvre.getID_Oeuvre ());
            preparedStatement.setInt (3,1);
            preparedStatement.executeUpdate ();


        } catch (SQLException throwables) {
//                if (throwables.getErrorCode ()==1062){
//                    String request1="UPDATE cart SET Quantity=Quantity+? where CartId=?";
//                    try {
//                        preparedStatement = connection.prepareStatement(request1);
//                        preparedStatement.setInt (2,1);
//                        preparedStatement.setInt (1,cart.getCartId ());
//
//                        preparedStatement.executeUpdate ();
//
//
//
//                    }catch (SQLException throwables1){
//                        System.out.println ("Probleme lors de l'update du panier");
//
//                    }
//
//                }
            System.out.println ("Probleme lors de l'ajout du panier");

        }
    }

    public List<Cart> readAll() {
        String req = "select * from Cart";

        List<Cart> list=new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet= statement.executeQuery(req);
            while(resultSet.next()){
                list.add(new Cart (resultSet.getInt(1), resultSet.getInt (2), resultSet.getInt (3)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CartCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<Oeuvre> readOeuvre() {
        String req = "select NomOeuvre,PrixOeuvre from oeuvre";

        List<Oeuvre> list=new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet= statement.executeQuery(req);
            while(resultSet.next()){
                list.add(new Oeuvre (resultSet.getString (1), resultSet.getInt (2)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CartCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public  void DeletCart (Cart cart)
    {
        String req="DELETE  from Cart where  CartId =?" ;
        try {
            preparedStatement=connection.prepareStatement (req);
            preparedStatement.setInt(1,cart.getCartId ());
            preparedStatement.executeUpdate ();

        } catch (SQLException ex) {
            System.out.println ("Probleme lors de la supprision du panier");

        }

    }
    public  void updateQuantity (int id ,Oeuvre oeuvre)
    {
        String req="UPDATE cart SET Quantity=Quantity+? WHERE CartId =? and OeuvreId=?" ;
        try {
            preparedStatement=connection.prepareStatement (req);
            preparedStatement.setInt (1,1) ;
            preparedStatement.setInt (2,id) ;
            preparedStatement.setInt (3,oeuvre.getID_Oeuvre ()) ;

            preparedStatement.executeUpdate() ;

        } catch (SQLException ex) {
            System.out.println ("Probleme lors de l'update de quantite");
        }

    }
    public  List<Cart> selectCartById (int id)
    {
        List<Cart> list =new ArrayList<>() ;
        String req = "select * from cart where CartId=?";
        try {
            preparedStatement=connection.prepareStatement (req);
            preparedStatement.setInt(1,id);
            ResultSet result =preparedStatement.executeQuery() ;
            while (result.next()){
                result.toString();
                list.add(new Cart (
                        result.getInt(1),
                        result.getInt (2),
                        result.getInt (3)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    public  List<Oeuvre> selectOeuvreById (int id)
    {
        List<Oeuvre> list =new ArrayList<>() ;
        String req = "select * from oeuvre where ID_Oeuvre=?";
        try {
            preparedStatement=connection.prepareStatement (req);
            preparedStatement.setInt(1,id);
            ResultSet result =preparedStatement.executeQuery() ;
            while (result.next()){
                list.add(new Oeuvre (
                        result.getInt(1),
                        result.getString (2),
                        result.getInt (3)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    public Map<Cart,Oeuvre> ReadAllOeuvrse() {
        String req = "select * from cart,oeuvre where oeuvre.ID_Oeuvre=cart.OeuvreId";

        Map<Cart,Oeuvre>  list=new HashMap<> ();
        try {
            statement = connection.createStatement();
            resultSet= statement.executeQuery(req);
            while(resultSet.next()){
                Cart cart=new Cart (resultSet.getInt (1),resultSet.getInt (2),resultSet.getInt (3));
                Oeuvre oeuvre=new Oeuvre (resultSet.getInt(4), resultSet.getString (5), resultSet.getInt (6));
                list.put (cart,oeuvre);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CartCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public int count ()
    {
        int count=0;
        List<Cart> list =new ArrayList<>() ;
        String req = "select * from cart ";
        try {
            preparedStatement=connection.prepareStatement (req);
            ResultSet result =preparedStatement.executeQuery() ;
            while (result.next()){
                result.toString();
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }

}
