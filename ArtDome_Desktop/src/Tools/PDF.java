package Tools;

import Entities.Orders;
import Entities.PendingOrders;
import Services.OrdersCRUD;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author tfifha youssef
 */
public class PDF {
    public void pdfGeneration() throws FileNotFoundException, DocumentException, MalformedURLException, IOException
    {
        Document document = new Document();

        OrdersCRUD ordersCRUD = new OrdersCRUD ();
        List<Orders> order=ordersCRUD.readAllOrders ();
        List<PendingOrders> pendingOrders=ordersCRUD.readAllpendingOrders ();
        PdfWriter.getInstance(document, new FileOutputStream (new File ("orders.pdf")));
        document.open();
        PDF pdf=new PDF ();
        for (Orders o:order) {

            Paragraph titre = new Paragraph (o.getInnoNumber ());
            titre.setAlignment (Element.ALIGN_CENTER);
            document.add (titre);
            Paragraph inno = new Paragraph ("InnoNumber : " + o.getInnoNumber ());
            inno.setAlignment (Element.ALIGN_LEFT);
            Paragraph username = new Paragraph ("UserName : " + o.getUserName ());
            username.setAlignment (Element.ALIGN_LEFT);
            Paragraph price = new Paragraph ("Price : " + o.getDueAmount ());
            price.setAlignment (Element.ALIGN_LEFT);
            Paragraph quantity = new Paragraph ("Quantity : " + o.getTotalQty ());
            quantity.setAlignment (Element.ALIGN_LEFT);
            Paragraph date = new Paragraph ("Orde Date : " + o.getOrderDate ());
            date.setAlignment (Element.ALIGN_LEFT);
            Paragraph status = new Paragraph ("Status : " + o.getStatus ());
            status.setAlignment (Element.ALIGN_LEFT);
            document.add (inno);
            document.add (username);
            document.add (quantity);
            document.add (date);
            document.add (status);
            document.add (price);


        }
        document.close ();
    }

}
