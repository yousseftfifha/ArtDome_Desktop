package Services;

import Entities.*;
import Tools.MyConnection;
import Tools.PDF;
import Tools.SendEmail;
import Tools.UserHolder;
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
public class OrdersService {
    private Connection connection;
    private PreparedStatement ste;
    private ResultSet rs;
    private Statement st;


    public OrdersService() {
        connection = MyConnection.getInstance ().getConnection ();
    }
    public void AddFromCart(int UserID) throws MessagingException, DocumentException, IOException, URISyntaxException {
        int nombreAleatoire = 1000000 + (int)(Math.random() * ((9999999 - 1000000) + 1));
        int orID = 1000 + (int)(Math.random() * ((9999 - 1000) + 1));
        float total_prix=0;
        int quantitytot=0;
        Oeuvre oeuvreid=null;
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
            String request="INSERT INTO pending_orders(IDUser,InnoNumber,OeuvreID,Quantity,Status)"+"VALUES(?,?,?,?,?) ";
            quantitytot+=i.getQuantiy ();
            oeuvreid=cartOeuvreMap.get (i);
            qua=i.getQuantiy ();
            try {
                ste = connection.prepareStatement(request);
                ste.setInt (1,holder.getUser().getId ());
                ste.setInt (2,nombreAleatoire);
                ste.setInt (3,cartOeuvreMap.get (i).getID_Oeuvre ());
                ste.setInt (4,i.getQuantiy ());
                ste.setString (5,"pending");

                ste.executeUpdate ();
                cartServices.DeletCart (i.getCartId ());


            } catch (SQLException throwables) {
                System.out.println ("Probleme lors de l'ajout de la pending order");
            }


        }

        List<PendingOrders> pendingOrdersList=new ArrayList<> ();
        PendingOrders pendingOrders=new PendingOrders (holder.getUser(),nombreAleatoire,oeuvreid,qua,"pending");
        pendingOrdersList.add (pendingOrders);
        String request1="INSERT INTO orders(IDUser,DueAmount,InnoNumber,OrderDate,Status)"+"VALUES(?,?,?,?,?) ";

        try {
            ste = connection.prepareStatement(request1);
            ste.setInt (1,holder.getUser().getId ());
            ste.setFloat (2,total_prix);
            ste.setInt (3,nombreAleatoire);
            ste.setString (4,ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME) );
            ste.setString (5,"pending");

            ste.executeUpdate ();


        } catch (SQLException throwables) {
            System.out.println ("Probleme lors de l'ajout du l'order");
            throwables.printStackTrace ();
        }

        Orders orders= new Orders (total_prix,nombreAleatoire,ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME), "pending");
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
            st = connection.createStatement();
            rs= st.executeQuery(req);
            while(rs.next()){
                User u=new User(rs.getInt("IDUser"));
                Oeuvre o=new Oeuvre (rs.getInt ("OeuvreID"));
                list.add(new PendingOrders (u, rs.getInt (3),o, rs.getInt (5), rs.getString (6)));
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
            st = connection.createStatement();
            rs= st.executeQuery(req);

            while (rs.next()){
                list.add(new Orders (this.rs.getInt (1), this.rs.getInt (2), this.rs.getFloat (3), this.rs.getInt (4), this.rs.getString (5), this.rs.getString (6)));
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
            ste=connection.prepareStatement (req);

            ResultSet result =ste.executeQuery() ;
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
            ste=connection.prepareStatement (req);
            ste.setInt(1,id);
            rs= st.executeQuery(req);

            while (rs.next()){
                list.add(new Orders (this.rs.getInt (1), this.rs.getInt (2), this.rs.getFloat (3), this.rs.getInt (4), this.rs.getString (5), this.rs.getString (6)));
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
            ste=connection.prepareStatement (req);
            ste.setInt(1,id);
            rs =ste.executeQuery() ;
            while (rs.next()){
                User u=new User(this.rs.getInt("IDUser"));
                Oeuvre o=new Oeuvre (this.rs.getInt ("OeuvreID"));
                list.add(new PendingOrders (u, this.rs.getInt (3),o, this.rs.getInt (5), this.rs.getString (6)));
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
            ste=connection.prepareStatement (req);
            ste.setString (1,str); ;
            ste.setInt (2,id) ;

            ste.executeUpdate() ;

        } catch (SQLException ex) {
            System.out.println ("Probleme lors de l'update du statut de l'ordre");
        }
        String req1="UPDATE pending_orders SET Status=? WHERE OrderID =?" ;
        try {
            ste=connection.prepareStatement (req1);
            ste.setString (1,str); ;
            ste.setInt (2,id) ;

            ste.executeUpdate() ;

        } catch (SQLException ex) {
            System.out.println ("Probleme lors de l'update de du statut du pending order");
        }
    }
    public  void DeletOrders (int id)
    {
        String req="DELETE  from orders where  OrderID =?" ;
        try {
            ste=connection.prepareStatement (req);
            ste.setInt(1,id);
            ste.executeUpdate ();

        } catch (SQLException ex) {
            System.out.println ("Probleme lors de la supprision du panier");

        }
        String req1="DELETE  from pending_orders where  OrderID =?" ;
        try {
            ste=connection.prepareStatement (req1);
            ste.setInt(1,id);
            ste.executeUpdate ();

        } catch (SQLException ex) {
            System.out.println ("Probleme lors de la supprision du panier");

        }

    }

    public ObservableList<PieChart.Data> getData(){
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        String req = "SELECT Status  from orders ";
        try {
            st = connection.createStatement();
            rs = st.executeQuery(req);

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
            st = connection.createStatement();
            rs = st.executeQuery(req);

            while (rs.next()){
                list.add(new Orders (this.rs.getInt (1), this.rs.getInt (2), this.rs.getFloat (3), this.rs.getInt (4), this.rs.getString (5), this.rs.getString (6)));
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
            ste=connection.prepareStatement (req);
            ste.setInt(1,id);
            ste.setInt(2,id);
            ResultSet result =ste.executeQuery() ;

            while (rs.next()){
                list.add(new Orders (this.rs.getInt (1), this.rs.getInt (2), this.rs.getFloat (3), this.rs.getInt (4), this.rs.getString (5), this.rs.getString (6)));
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
            ste=connection.prepareStatement (req);
            ste.setString (1,status);
            rs =ste.executeQuery() ;

            while (rs.next()){
                list.add(new Orders (this.rs.getInt (1), this.rs.getInt (2), this.rs.getFloat (3), this.rs.getInt (4), this.rs.getString (5), this.rs.getString (6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    public  List<Orders> selectOrderByUser (int id)
    {
        List<Orders> list =new ArrayList<>() ;
        String req = "select * from orders where IDUser='"+id+"'";
        try {
            ste=connection.prepareStatement (req);
            rs= ste.executeQuery(req);

            while (rs.next()){
                list.add(new Orders (this.rs.getInt (1), this.rs.getInt (2), this.rs.getFloat (3), this.rs.getInt (4), this.rs.getString (5), this.rs.getString (6)));
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
            ste=connection.prepareStatement (req);
            rs= st.executeQuery(req);

            while (rs.next()){
                list.add(new Orders (this.rs.getInt (1), this.rs.getInt (2), this.rs.getFloat (3), this.rs.getInt (4), this.rs.getString (5), this.rs.getString (6)));
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
            ste=connection.prepareStatement (req);
            rs= st.executeQuery(req);

            while (rs.next()){
                list.add(new Orders (this.rs.getInt (1), this.rs.getInt (2), this.rs.getFloat (3), this.rs.getInt (4), this.rs.getString (5), this.rs.getString (6)));
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
            ste=connection.prepareStatement (req);
            rs= st.executeQuery(req);

            while (rs.next()){
                list.add(new Orders (this.rs.getInt (1), this.rs.getInt (2), this.rs.getFloat (3), this.rs.getInt (4), this.rs.getString (5), this.rs.getString (6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

}
