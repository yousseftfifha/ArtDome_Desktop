/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import Services.ReservationMethods;
import Entities.Reservation;
/**
 *
 * @author HP
 */
public class PDFreservation {
  
//    public void ReservationPDF() throws FileNotFoundException, DocumentException, MalformedURLException, IOException
//    {
//        Document document = new Document();
//
//        ReservationMethods rm = new ReservationMethods ();
//        List<Reservation> res=rm.getReservationList();
//        PdfWriter.getInstance(document, new FileOutputStream (new File ("Réservation.pdf")));
//        document.open();
//        PDFreservation pdf=new PDFreservation ();
//        for (Reservation r:res) {
//
//            Paragraph reservation = new Paragraph ("Réservation n°"+ r.getCode_reservation());
//            reservation.setAlignment (Element.ALIGN_CENTER);
//            document.add (reservation);
//            Paragraph code = new Paragraph ("Code : " + r.getCode_event());
//            code.setAlignment (Element.ALIGN_LEFT);
//            Paragraph nom = new Paragraph ("Nom : " + r.getC().getNom());
//            nom.setAlignment (Element.ALIGN_LEFT);
//            Paragraph prenom = new Paragraph ("Prenom : " + r.getC().getPrenom());
//            prenom.setAlignment (Element.ALIGN_LEFT);
//            Paragraph telephone = new Paragraph ("Télèphone : " + r.getC().getNumero());
//            telephone.setAlignment (Element.ALIGN_LEFT);
//            Paragraph  email = new Paragraph ("Email : " + r.getC().getEmail());
//            email.setAlignment (Element.ALIGN_LEFT);
//            Paragraph nbp = new Paragraph ("Nombre de place réservées : " + r.getNb_place());
//            nbp.setAlignment (Element.ALIGN_LEFT);
//            document.add (code);
//            document.add (nom);
//            document.add (prenom);
//            document.add (telephone);
//            document.add (email);
//            document.add (nbp);
//
//
//        }
//        document.close ();
//    }
    
     public void ReservationPDFback() throws FileNotFoundException, DocumentException, MalformedURLException, IOException
    {
        Document document = new Document();

        ReservationMethods rm = new ReservationMethods ();
        List<Reservation> res=rm.listeResC();
        PdfWriter.getInstance(document, new FileOutputStream (new File ("Réservation.pdf")));
        document.open();
        PDFreservation pdf=new PDFreservation ();
        for (Reservation r:res) {

            Paragraph reservation = new Paragraph ("Réservation n°"+ r.getCode_reservation());
            reservation.setAlignment (Element.ALIGN_CENTER);
            document.add (reservation);
            Paragraph code = new Paragraph ("Code : " + r.getCode_event());
            code.setAlignment (Element.ALIGN_LEFT);
            Paragraph nom = new Paragraph ("Nom : " + r.getC().getNom());
            nom.setAlignment (Element.ALIGN_LEFT);
            Paragraph prenom = new Paragraph ("Prenom : " + r.getC().getPrenom());
            prenom.setAlignment (Element.ALIGN_LEFT);
            Paragraph telephone = new Paragraph ("Télèphone : " + r.getC().getNumero());
            telephone.setAlignment (Element.ALIGN_LEFT);
            Paragraph  email = new Paragraph ("Email : " + r.getC().getEmail());
            email.setAlignment (Element.ALIGN_LEFT);
            Paragraph nbp = new Paragraph ("Nombre de place réservées : " + r.getNb_place());
            nbp.setAlignment (Element.ALIGN_LEFT);
            document.add (code);
            document.add (nom);
            document.add (prenom);
            document.add (telephone);
            document.add (email);
            document.add (nbp);


        }
        document.close ();
    }
}
