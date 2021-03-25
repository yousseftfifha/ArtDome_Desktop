package Tools;

import Entities.Orders;
import Entities.PendingOrders;
import Services.CartCRUD;
import Services.OrdersCRUD;
import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.scenario.effect.ImageData;
import javafx.application.HostServices;

import javax.swing.text.TableView;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

/**
 * @author tfifha youssef
 */
public class PDF {
    public void pdfGeneration() throws FileNotFoundException, DocumentException, MalformedURLException, IOException, URISyntaxException {
        Document document = new Document();
        OrdersCRUD ordersCRUD = new OrdersCRUD ();
        List<Orders> order=ordersCRUD.readAllOrders ();
        List<PendingOrders> pendingOrders=ordersCRUD.readAllpendingOrders ();
        PdfWriter.getInstance(document, new FileOutputStream (new File ("orders.pdf")));
        document.open();
        document.addTitle("Orders");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Art Dome");
        document.addCreator("Tfifha Youssef");
        Paragraph preface = new Paragraph();

        Paragraph titre =new Paragraph (" ArtDome's Bills");
        titre.setAlignment (Element.ALIGN_CENTER);

        // Will create: Report generated by: _name, _date
        preface.add(new Paragraph(
                "Report generated by: " + System.getProperty("user.name") + ", " + new Date ()));
        preface.add(new Paragraph(
                "This document describes all the bills "));
        preface.setAlignment (Element.ALIGN_CENTER);
        document.add (titre);
        document.add(preface);
        String path = "D:/esprit/3A/PiDev/Quality-Overflow/ArtDome_Desktop/src/GFX/logo.png";
        Image img = Image.getInstance(path);
        PdfPCell cell = new PdfPCell(img, true);
        // Start a new page
//        document.newPage();

        PDF pdf=new PDF ();
        PdfPTable table = new PdfPTable(7);

        PdfPCell c1 = new PdfPCell(new Phrase("OrderID"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("UserName"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("DueAmount"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("InnoNumber"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("TotalQty"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("OrderDate"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Status"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        table.setHeaderRows(1);
        for (Orders o:order) {
            table.addCell(String.valueOf (o.getInnoNumber ()));
            table.addCell(o.getUserName ());
            table.addCell(String.valueOf (o.getDueAmount ()));
            table.addCell(String.valueOf (o.getInnoNumber ()));
            table.addCell(String.valueOf (o.getTotalQty ()));
            table.addCell(o.getOrderDate ());
            table.addCell(o.getStatus ());
        }

        document.add (table);
        document.close ();



    }
    public void FactureGeneration(List<Orders> ordersList,List<PendingOrders> pendingOrdersList) throws FileNotFoundException, DocumentException, MalformedURLException, IOException, URISyntaxException {
        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream (new File ("Facture.pdf")));
        document.open();
        document.addTitle("Facture");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Art Dome");
        document.addCreator("Tfifha Youssef");
        Paragraph preface = new Paragraph();

        Paragraph titre =new Paragraph (" Facture");
        titre.setAlignment (Element.ALIGN_CENTER);

        // Will create: Report generated by: _name, _date
        preface.add(new Paragraph(
                "Report generated by: " + System.getProperty("user.name") + ", " + new Date ()));
        preface.add(new Paragraph(
                "This document describes all the bills "));
        preface.setAlignment (Element.ALIGN_CENTER);
        document.add (titre);
        document.add(preface);
        String path = "D:/esprit/3A/PiDev/Quality-Overflow/ArtDome_Desktop/src/GFX/logo.png";
        Image img = Image.getInstance(path);
        PdfPCell cell = new PdfPCell(img, true);
        // Start a new page
//        document.newPage();

        PDF pdf=new PDF ();
        PdfPTable table = new PdfPTable(7);

        PdfPCell c1 = new PdfPCell(new Phrase("OrderID"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("UserName"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("DueAmount"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("InnoNumber"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("TotalQty"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("OrderDate"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Status"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        table.setHeaderRows(1);
        for (Orders o:ordersList) {
            table.addCell(String.valueOf (o.getInnoNumber ()));
            table.addCell(o.getUserName ());
            table.addCell(String.valueOf (o.getDueAmount ()));
            table.addCell(String.valueOf (o.getInnoNumber ()));
            table.addCell(String.valueOf (o.getTotalQty ()));
            table.addCell(o.getOrderDate ());
            table.addCell(o.getStatus ());
        }
        PdfPTable table1 = new PdfPTable(7);

        PdfPCell c2 = new PdfPCell(new Phrase("OrderID"));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);

        c2 = new PdfPCell(new Phrase("UserName"));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);

        c2 = new PdfPCell(new Phrase("InnoNumber"));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);

        c2 = new PdfPCell(new Phrase("Quantity"));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);

        c2 = new PdfPCell(new Phrase("OeuvreID"));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);

        c2 = new PdfPCell(new Phrase("Status"));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);

        table1.setHeaderRows(1);
        for (PendingOrders o:pendingOrdersList) {
            table1.addCell(String.valueOf (o.getOrderId ()));
            table1.addCell(o.getUserName ());
            table1.addCell(String.valueOf (o.getInnoNumber ()));
            table1.addCell(String.valueOf (o.getQuantity ()));
            table1.addCell(String.valueOf (o.getOeuvreID ()));
            table1.addCell(o.getStatus ());
        }
        document.add (table);
        document.add (table1);
        document.close ();



    }

}