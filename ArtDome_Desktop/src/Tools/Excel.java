/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import com.itextpdf.text.DocumentException;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import Tools.MyConnection;

/**
 *
 * @author HP
 */
public class Excel {
    
    public void Excel() throws SQLException, WriteException, IOException{
        
        WritableWorkbook myFirstWbook = null;
        String requete = "Select r.code_reservation, r.nb_place, r.code_event, u.nom, u.prenom, u.email, u.numero FROM reservationevent r INNER JOIN user u ON r.code_client = u.id ORDER BY code_reservation DESC";
        Connection cx = MyConnection.getInstance().getConnection();
        Statement st = cx.createStatement();
        ResultSet rs = st.executeQuery(requete);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableWorkbook workbook = Workbook.createWorkbook(baos);

        // * Create Font ***//
        WritableFont fontBlue = new WritableFont(WritableFont.TIMES, 10);
        fontBlue.setColour(Colour.BLUE);
        
        WritableFont fontRed = new WritableFont(WritableFont.TIMES, 10);
        fontRed.setColour(Colour.RED);

        WritableFont fontWhite = new WritableFont(WritableFont.TIMES, 10);
        fontRed.setColour(Colour.WHITE);

        // * Sheet 1 ***//
        workbook = Workbook.createWorkbook(new File("Réservation.xls"));
        WritableSheet ws1 = workbook.createSheet("Liste : ", 0);
        WritableCellFormat cellFormat3 = new WritableCellFormat();
        cellFormat3.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, Colour.DARK_YELLOW);


        // * Header ***//
        WritableCellFormat cellFormat1 = new WritableCellFormat(fontWhite);
        cellFormat1.setBackground(Colour.ICE_BLUE);
        cellFormat1.setAlignment(Alignment.CENTRE);
        cellFormat1.setVerticalAlignment(VerticalAlignment.CENTRE);
        cellFormat1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, Colour.DARK_PURPLE);

        // * Data ***//
         WritableCellFormat cellFormat2 = new WritableCellFormat(fontBlue);
        cellFormat2.setWrap(true);
        cellFormat2.setBackground(Colour.WHITE);
        cellFormat2.setAlignment(Alignment.CENTRE);
        cellFormat2.setVerticalAlignment(VerticalAlignment.CENTRE);
        cellFormat2.setWrap(true);
        cellFormat2.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, Colour.OCEAN_BLUE);

        // * Header ***//
        ws1.setColumnView(0, 15);
        ws1.addCell(new jxl.write.Label(0, 0, "Code réservation", cellFormat1));

        ws1.setColumnView(1, 15);
        ws1.addCell(new jxl.write.Label(1, 0, "Code Event", cellFormat1));

        ws1.setColumnView(2, 10);
        ws1.addCell(new jxl.write.Label(2, 0, "Nom", cellFormat1));

        ws1.setColumnView(3, 10);
        ws1.addCell(new jxl.write.Label(3, 0, "Prenom", cellFormat1));
        
        ws1.setColumnView(4, 20);
        ws1.addCell(new jxl.write.Label(4, 0,"Email" , cellFormat1));
        
        ws1.setColumnView(5, 15);
        ws1.addCell(new jxl.write.Label(5, 0, "Telephone", cellFormat1));
        
        ws1.setColumnView(6, 20);
        ws1.addCell(new jxl.write.Label(6, 0, "Nombre de place réservées", cellFormat1));
        int iRows = 1;
        while ((rs != null) && (rs.next())) {
            ws1.addCell(new jxl.write.Label(0, iRows,""+ rs.getInt("code_reservation"), cellFormat2));
            ws1.addCell(new jxl.write.Label(1, iRows, ""+ rs.getInt("code_event"), cellFormat2));
            ws1.addCell(new jxl.write.Label(2, iRows, rs.getString("nom"), cellFormat2));
            ws1.addCell(new jxl.write.Label(3, iRows,  rs.getString("prenom"), cellFormat2));
             ws1.addCell(new jxl.write.Label(4, iRows,  rs.getString("email"), cellFormat2));
            ws1.addCell(new jxl.write.Label(5, iRows, ""+rs.getInt("numero"), cellFormat2));
            ws1.addCell(new jxl.write.Label(6, iRows, ""+rs.getInt("nb_place"), cellFormat2));

            ++iRows;
        }
        workbook.write();
        workbook.close();

//        System.out.println("Excel file created.");
//        JOptionPane.showMessageDialog(null, "Excel file created.");
Desktop.getDesktop().open(new File("Réservation.xls"));
    }
//    WritableWorkbook myFirstWbook = null;
//        String requete = "SELECT * FROM e_books";
//        Connection cx = myconnexion.getInstance().getCnx();
//        Statement st = cx.createStatement();
//        ResultSet rs = st.executeQuery(requete);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        WritableWorkbook workbook = Workbook.createWorkbook(baos);
//
//        // * Create Font ***//
//        WritableFont fontBlue = new WritableFont(WritableFont.TIMES, 10);
//        fontBlue.setColour(Colour.BLUE);
//        
//        WritableFont fontRed = new WritableFont(WritableFont.TIMES, 10);
//        fontRed.setColour(Colour.RED);
//
//        WritableFont fontWhite = new WritableFont(WritableFont.TIMES, 10);
//        fontRed.setColour(Colour.WHITE);
//
//        // * Sheet 1 ***//
//        workbook = Workbook.createWorkbook(new File("Liste des e_books.xls"));
//        WritableSheet ws1 = workbook.createSheet("Liste : ", 0);
//        WritableCellFormat cellFormat3 = new WritableCellFormat();
//        cellFormat3.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.WHITE);
//      
//        // * Header ***//
//        WritableCellFormat cellFormat1 = new WritableCellFormat(fontWhite);
//        cellFormat1.setBackground(Colour.TAN);
//        cellFormat1.setAlignment(Alignment.CENTRE);
//        cellFormat1.setVerticalAlignment(VerticalAlignment.CENTRE);
//        cellFormat1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLUE2);
//
//        // * Data ***//
//        WritableCellFormat cellFormat2 = new WritableCellFormat(fontBlue);
//
//        // cellFormat2.setWrap(true);
//        cellFormat2.setBackground(Colour.WHITE);
//        cellFormat2.setAlignment(jxl.format.Alignment.CENTRE);
//        cellFormat2.setVerticalAlignment(VerticalAlignment.CENTRE);
//        cellFormat2.setWrap(true);
//        cellFormat2.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLUE2);
//
//        // * Header ***//
//        ws1.setColumnView(0, 10);
//        ws1.addCell(new jxl.write.Label(0, 0, "Id", cellFormat1));
//
//        ws1.setColumnView(1, 15);
//        ws1.addCell(new jxl.write.Label(1, 0, "Titre", cellFormat1));
//
//        ws1.setColumnView(2, 10);
//        ws1.addCell(new jxl.write.Label(2, 0, "Genre", cellFormat1));
//
//        ws1.setColumnView(3, 10);
//        ws1.addCell(new jxl.write.Label(3, 0, "Auteur", cellFormat1));
//
//        int iRows = 1;
//        while ((rs != null) && (rs.next())) {
//            ws1.addCell(new jxl.write.Label(0, iRows, rs.getString("id"), cellFormat2));
//            ws1.addCell(new jxl.write.Label(1, iRows, rs.getString("titre"), cellFormat2));
//            ws1.addCell(new jxl.write.Label(2, iRows, rs.getString("genre"), cellFormat2));
//            ws1.addCell(new jxl.write.Label(3, iRows, rs.getString("auteur"), cellFormat2));
//
//            ++iRows;
//        }
//        workbook.write();
//        workbook.close();
//
//        System.out.println("Excel file created.");
//
//    }
    
}
