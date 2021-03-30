package Services;

import Entities.*;
import Tools.MyConnection;
import Tools.PDF;
import Tools.SendEmail;
import com.itextpdf.text.DocumentException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
    public void AddFromCart(int UserID) throws MessagingException, DocumentException, IOException, URISyntaxException {
        int nombreAleatoire = 1000000 + (int)(Math.random() * ((9999999 - 1000000) + 1));
        int orID = 1000 + (int)(Math.random() * ((9999 - 1000) + 1));
        float total_prix=0;
        int quantitytot=0;
        int oeuvreid=0;
        int qua=0;
        CartServices cartServices = new CartServices ();
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

        Map<Cart,Oeuvre> cartOeuvreMap= cartServices.ReadAllOeuvrse ();
        UserHolder holder = UserHolder.getInstance();
        for(Cart i : cartOeuvreMap.keySet()){
            total_prix+=i.getQuantiy ()*cartOeuvreMap.get (i).getPrixOeuvre ();
            String request="INSERT INTO pending_orders(OrderID,UserName,InnoNumber,OeuvreID,Quantity,Status,AddressID)"+"VALUES(?,?,?,?,?,?,?) ";
            quantitytot+=i.getQuantiy ();
            oeuvreid=cartOeuvreMap.get (i).getID_Oeuvre ();
            qua=i.getQuantiy ();
            try {
                preparedStatement = connection.prepareStatement(request);
                preparedStatement.setInt (1,orID);
                preparedStatement.setString (2,holder.getUser().getNom ()+" "+holder.getUser().getPrenom ());
                preparedStatement.setInt (3,nombreAleatoire);
                preparedStatement.setInt (4,cartOeuvreMap.get (i).getID_Oeuvre ());
                preparedStatement.setInt (5,i.getQuantiy ());
                preparedStatement.setString (6,"pending");
                preparedStatement.setInt (7,1);

                preparedStatement.executeUpdate ();
                cartServices.DeletCart (i.getCartId ());


            } catch (SQLException throwables) {
                System.out.println ("Probleme lors de l'ajout de la pending order");
            }


        }

        List<PendingOrders> pendingOrdersList=new ArrayList<> ();
        PendingOrders pendingOrders=new PendingOrders (orID,holder.getUser().getNom ()+" "+holder.getUser().getPrenom (),nombreAleatoire,oeuvreid,qua,"pending",1);
        pendingOrdersList.add (pendingOrders);
        String request1="INSERT INTO orders(OrderID,UserName,DueAmount,InnoNumber,TotalQty,OrderDate,Status,AddressId)"+"VALUES(?,?,?,?,?,?,?,?) ";

        try {
            preparedStatement = connection.prepareStatement(request1);
            preparedStatement.setInt (1,orID);
            preparedStatement.setString (2,holder.getUser().getEmail ());
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

        Orders orders= new Orders (orID,holder.getUser().getEmail (),total_prix,nombreAleatoire,quantitytot,ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME), "pending", 1);
        List<Orders> ordersList=new ArrayList<> ();
        ordersList.add (orders);
        PDF pdf=new PDF ();
        pdf.FactureGeneration(ordersList,pendingOrdersList);
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("Facture.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }

        String message="Bonjour Mr/Mme " +System.lineSeparator()+
                "Vous avez ajouter une nouvelle commande a " +ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME)+
                System.lineSeparator()+
                " Order ID: "+orID+
                " User: "+holder.getUser().getNom ()+" "+holder.getUser().getPrenom ()+
                " prix a payer: "+total_prix+
                " quantite total: "+quantitytot+
                " status: Pending "
                +System.lineSeparator()
                +" Cordialement "+System.lineSeparator()+" Bonne journee";
        ExecutorService emailExecutor = Executors.newSingleThreadExecutor();
        emailExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    SendEmail.sendMail ("youssef.tfifha@esprit.tn","New Order Confirmation",message);
                } catch (AddressException e) {
                    e.printStackTrace ();
                } catch (MessagingException e) {
                    e.printStackTrace ();
                }
//                SMS sendtext=new SMS ();
//                sendtext.SendSMS("yousseftfifha","181JMT2499y","un nouveau evenement a ete cree !","216"+"20245989","https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
//                HttpConfig httpConfig = HttpConfig.defaultConfig();
//                VonageClient client = new VonageClient .Builder()
//                        .apiKey("8f52a2c6")
//                        .apiSecret("967AQN7qPzUl5BB6")
//                        .httpConfig(httpConfig)
//                        .build();
//
//                SmsSubmissionResponse responses = client.getSmsClient().submitMessage(new TextMessage (
//                        "ArtDome",
//                        "21620245989",
//                        message));

            }
        });
        emailExecutor.shutdown();


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
            Logger.getLogger(CartServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<Orders> readAllOrders() {
        String req = "select * from orders order by OrderDate  ";

        List<Orders> list=new ArrayList<> ();
        try {
            statement = connection.createStatement();
            resultSet= statement.executeQuery(req);
            while(resultSet.next()){
                list.add(new Orders (resultSet.getInt(1), resultSet.getString (2), resultSet.getFloat (3),resultSet.getInt (4),resultSet.getInt (5),resultSet.getString (6),resultSet.getString (7),resultSet.getInt (8)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CartServices.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CartServices.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CartServices.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CartServices.class.getName()).log(Level.SEVERE, null, ex);
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

    public ObservableList<PieChart.Data> getData(){
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        String req = "SELECT Status  from orders ";
        try {
            statement = connection.createStatement();
            resultSet= statement.executeQuery(req);
            while(resultSet.next()){
                data.add(new PieChart.Data (resultSet.getString("Status"),1));
            }

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }

        return data;
    }
    public List<Orders> readprice() {
        String req = "select DueAmount from orders  order by OrderDate desc limit 1";

        List<Orders> list=new ArrayList<> ();
        try {
            statement = connection.createStatement();
            resultSet= statement.executeQuery(req);
            while(resultSet.next()){
                list.add(new Orders (resultSet.getFloat (1)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CartServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public int getCount(String cond) throws SQLException
    {
        Statement s = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s
                .executeQuery("SELECT * FROM orders Where Status = " + "'"+cond+"'");
        r.last();
        int count = r.getRow();
        r.beforeFirst();
        System.err.println(count);
        return  count;
    }
    public List<Orders> Rechercher(int id)
    {

        List<Orders> list =new ArrayList<>() ;
        String req = "select * from orders where OrderID = ? or InnoNumber=? ";
        try {
            preparedStatement=connection.prepareStatement (req);
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2,id);
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
            Logger.getLogger(CartServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    public List<Orders> Rechercherstatus(String status)
    {

        List<Orders> list =new ArrayList<>() ;
        String req = "select * from orders where Status = ?  ";
        try {
            preparedStatement=connection.prepareStatement (req);
            preparedStatement.setString (1,status);
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
            Logger.getLogger(CartServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    public  List<Orders> selectOrderByUser (String id)
    {
        List<Orders> list =new ArrayList<>() ;
        String req = "select * from orders where UserName=?";
        try {
            preparedStatement=connection.prepareStatement (req);
            preparedStatement.setString (1,id);
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
            Logger.getLogger(CartServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    public  List<Orders> sortbyorderdate ()
    {
        List<Orders> list =new ArrayList<>() ;
        String req = "select * from orders order by OrderDate desc";
        try {
            preparedStatement=connection.prepareStatement (req);
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
            Logger.getLogger(CartServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    public  List<Orders> sortbyDueAmount ()
    {
        List<Orders> list =new ArrayList<>() ;
        String req = "select * from orders order by DueAmount desc";
        try {
            preparedStatement=connection.prepareStatement (req);
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
            Logger.getLogger(CartServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    public  List<Orders> sortbyquantity ()
    {
        List<Orders> list =new ArrayList<>() ;
        String req = "select * from orders order by TotalQty desc ";
        try {
            preparedStatement=connection.prepareStatement (req);
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
            Logger.getLogger(CartServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

}
