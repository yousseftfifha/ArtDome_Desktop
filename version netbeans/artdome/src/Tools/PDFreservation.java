/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import Entities.User;
import Entities.reservation_expo;
import Services.ReservationEMethods;

/**
 *
 * @author HP
 */
public class PDFreservation {
  
    public void ReservationPDF() throws FileNotFoundException, DocumentException, MalformedURLException, IOException
    {
        Document document = new Document();

        ReservationEMethods rm = new ReservationEMethods ();
        List<reservation_expo> res=rm.getReservationEList();
        List<User> re=rm.getUserListe();
        PdfWriter.getInstance(document, new FileOutputStream (new File ("C:\\Users\\Oumaima\\Documents\\NetBeansProjects\\RéservationExpo/Réservation.pdf")));
        document.open();
        PDFreservation pdf=new PDFreservation ();
        for (reservation_expo r:res) {
              for (User s:re){
            Paragraph reservation = new Paragraph ("Réservation n°"+ r.getCode_reservationE());
            reservation.setAlignment (Element.ALIGN_CENTER);
            document.add (reservation);
            Paragraph code = new Paragraph ("Code : " + r.getCode_expo());
            code.setAlignment (Element.ALIGN_LEFT);
            Paragraph nom = new Paragraph ("Nom : " +s.getNom());
            nom.setAlignment (Element.ALIGN_LEFT);
            Paragraph prenom = new Paragraph ("Prenom : " +s.getPrenom());
            prenom.setAlignment (Element.ALIGN_LEFT);
            Paragraph telephone = new Paragraph ("Télèphone : " +s.getNumero());
            telephone.setAlignment (Element.ALIGN_LEFT);
            Paragraph  email = new Paragraph ("Email : " +s.getEmail());
            email.setAlignment (Element.ALIGN_LEFT);
            Paragraph nbp = new Paragraph ("Nombre de place réservées : " + r.getNb_place());
            nbp.setAlignment (Element.ALIGN_LEFT);
            document.add (code);
            document.add (nom);
            document.add (prenom);
            document.add (telephone);
            document.add (email);
            document.add (nbp);


        }}
        document.close ();
    }
    
     public void ReservationPDFback() throws FileNotFoundException, DocumentException, MalformedURLException, IOException
    {
        Document document = new Document();

        ReservationEMethods rm = new ReservationEMethods ();
        List<reservation_expo> res=rm.getReservationEList();
        List<User> re=rm.getUserListe();
        PdfWriter.getInstance(document, new FileOutputStream (new File ("Réservation.pdf")));
        document.open();
        PDFreservation pdf=new PDFreservation ();
        for (reservation_expo r:res) {
                        for (User s:re){
            Paragraph reservation = new Paragraph ("Réservation n°"+ r.getCode_reservationE());
            reservation.setAlignment (Element.ALIGN_CENTER);
            document.add (reservation);
            Paragraph code = new Paragraph ("Code : " + r.getCode_expo());
            code.setAlignment (Element.ALIGN_LEFT);
            Paragraph nom = new Paragraph ("Nom : " +s.getNom());
            nom.setAlignment (Element.ALIGN_LEFT);
            Paragraph prenom = new Paragraph ("Prenom : " +s.getPrenom());
            prenom.setAlignment (Element.ALIGN_LEFT);
            Paragraph telephone = new Paragraph ("Télèphone : " +s.getNumero());
            telephone.setAlignment (Element.ALIGN_LEFT);
            Paragraph  email = new Paragraph ("Email : " +s.getEmail());
            email.setAlignment (Element.ALIGN_LEFT);
            Paragraph nbp = new Paragraph ("Nombre de place réservées : " + r.getNb_place());
            nbp.setAlignment (Element.ALIGN_LEFT);
            document.add (code);
            document.add (nom);
            document.add (prenom);
            document.add (telephone);
            document.add (email);
            document.add (nbp);


        } }
        document.close ();
        Desktop.getDesktop().open(new File("Réservation.pdf"));
    }
}
