/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entite.Oeuvre;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
//import javax.swing.text.Document;
import services.OeuvreCRUD;

/**
 *
 * @author user
 */
public class PDFOeuvre {
    


  public void OeuvrePDF() throws FileNotFoundException, DocumentException, IOException 
    {
        Document document = new Document();

        OeuvreCRUD oc = new  OeuvreCRUD ();
        List<Oeuvre> res=oc.readAll();
        PdfWriter.getInstance(document, new FileOutputStream (new File ("C:/Users/user/Documents/NetBeansProjects/PDF/Oeuvre.pdf")));
        document.open();
       PDFOeuvre pdf=new PDFOeuvre();
        for (Oeuvre o :res) {

            Paragraph Oeuvre= new Paragraph ("oeuvre n°"+ o.getID_Oeuvre());
            Oeuvre.setAlignment (Element.ALIGN_CENTER);
            document.add (Oeuvre);
            Paragraph ID_Oeuvre = new Paragraph ("ID_Oeuvre : " + o.getID_Oeuvre());
            ID_Oeuvre.setAlignment (Element.ALIGN_LEFT);
            Paragraph NomOeuvre = new Paragraph ("NomOeuvre : " + o.getNomOeuvre());
            NomOeuvre.setAlignment (Element.ALIGN_LEFT);
            Paragraph  PrixOeuvre = new Paragraph (" PrixOeuvre: " + o.getPrixOeuvre());
            PrixOeuvre.setAlignment (Element.ALIGN_LEFT);
            Paragraph ID_Artiste= new Paragraph ("ID_Artiste : " + o.getID_Artiste());
            ID_Artiste.setAlignment (Element.ALIGN_LEFT);
           
            document.add (ID_Oeuvre);
            document.add (NomOeuvre);
            document.add (PrixOeuvre);
            document.add (ID_Artiste);
            


        }
        document.close ();
        Desktop.getDesktop().open(new File("C:/Users/user/Documents/NetBeansProjects/PDF/Oeuvre.pdf"));
    }
}
