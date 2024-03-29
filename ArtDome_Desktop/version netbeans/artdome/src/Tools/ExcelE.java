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
 * @author Oumaima
 */
public class ExcelE {
    
      public void ExcelE() throws SQLException, WriteException, IOException{
        
        WritableWorkbook myFirstWbook = null;
        String requete = "Select r.code_reservationE, r.nb_place, r.code_expo, u.nom, u.prenom, u.email, u.numero FROM reservation_expo r INNER JOIN user u ON r.code_client = u.ID ORDER BY code_reservationE DESC";
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
        cellFormat3.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, Colour.WHITE);

//        ws1.addImage(new WritableImage(0, 0, 4, 6, bao.toByteArray()));
//        ws1.setColumnView(0, 10);
//        ws1.addCell(new jxl.write.Label(0, 0, "", cellFormat3));
//        ws1.setColumnView(0, 10);
//        ws1.addCell(new jxl.write.Label(0, 1, "", cellFormat3));
//        ws1.setColumnView(2, 10);
//        ws1.addCell(new jxl.write.Label(0, 2, "", cellFormat3));
//        ws1.setColumnView(3, 10);
//        ws1.addCell(new jxl.write.Label(0, 3, "", cellFormat3));
//        ws1.setColumnView(3, 10);
//        ws1.addCell(new jxl.write.Label(0, 4, "", cellFormat3));
//        ws1.setColumnView(3, 10);
//        ws1.addCell(new jxl.write.Label(0, 5, "", cellFormat3));
//        ws1.setColumnView(0, 10);
//        ws1.addCell(new jxl.write.Label(1, 0, "", cellFormat3));
//        ws1.setColumnView(0, 10);
//        ws1.addCell(new jxl.write.Label(1, 1, "", cellFormat3));
//        ws1.setColumnView(2, 10);
//        ws1.addCell(new jxl.write.Label(1, 2, "", cellFormat3));
//        ws1.setColumnView(3, 10);
//        ws1.addCell(new jxl.write.Label(1, 3, "", cellFormat3));
//        ws1.setColumnView(3, 10);
//        ws1.addCell(new jxl.write.Label(1, 4, "", cellFormat3));
//        ws1.setColumnView(3, 10);
//        ws1.addCell(new jxl.write.Label(1, 5, "", cellFormat3));
//
//        ws1.setColumnView(0, 10);
//        ws1.addCell(new jxl.write.Label(2, 0, "", cellFormat3));
//        ws1.setColumnView(0, 10);
//        ws1.addCell(new jxl.write.Label(2, 1, "", cellFormat3));
//        ws1.setColumnView(2, 10);
//        ws1.addCell(new jxl.write.Label(2, 2, "", cellFormat3));
//        ws1.setColumnView(3, 10);
//        ws1.addCell(new jxl.write.Label(2, 3, "", cellFormat3));
//        ws1.setColumnView(3, 10);
//        ws1.addCell(new jxl.write.Label(2, 4, "", cellFormat3));
//        ws1.setColumnView(3, 10);
//        ws1.addCell(new jxl.write.Label(2, 5, "", cellFormat3));
//
//        ws1.setColumnView(0, 10);
//        ws1.addCell(new jxl.write.Label(3, 0, "", cellFormat3));
//        ws1.setColumnView(0, 10);
//        ws1.addCell(new jxl.write.Label(3, 1, "", cellFormat3));
//        ws1.setColumnView(2, 10);
//        ws1.addCell(new jxl.write.Label(3, 2, "", cellFormat3));
//        ws1.setColumnView(3, 10);
//        ws1.addCell(new jxl.write.Label(3, 3, "", cellFormat3));
//        ws1.setColumnView(3, 10);
//        ws1.addCell(new jxl.write.Label(3, 4, "", cellFormat3));
//        ws1.setColumnView(3, 10);
//        ws1.addCell(new jxl.write.Label(3, 5, "", cellFormat3));

        ///
        // * Header ***//
        WritableCellFormat cellFormat1 = new WritableCellFormat(fontWhite);
        cellFormat1.setBackground(Colour.AQUA);
        cellFormat1.setAlignment(Alignment.CENTRE);
        cellFormat1.setVerticalAlignment(VerticalAlignment.CENTRE);
        cellFormat1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, Colour.BLUE2);

        // * Data ***//
        WritableCellFormat cellFormat2 = new WritableCellFormat(fontBlue);

        // cellFormat2.setWrap(true);
        cellFormat2.setBackground(Colour.WHITE);
        cellFormat2.setAlignment(Alignment.CENTRE);
        cellFormat2.setVerticalAlignment(VerticalAlignment.CENTRE);
        cellFormat2.setWrap(true);
        cellFormat2.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, Colour.BLUE2);

        // * Header ***//
        ws1.setColumnView(0, 25);
        ws1.addCell(new jxl.write.Label(0, 6, "Code réservation exposition", cellFormat1));

        ws1.setColumnView(1, 15);
        ws1.addCell(new jxl.write.Label(1, 6, "Code Expo", cellFormat1));

        ws1.setColumnView(2, 10);
        ws1.addCell(new jxl.write.Label(2, 6, "Nom", cellFormat1));

        ws1.setColumnView(3, 10);
        ws1.addCell(new jxl.write.Label(3, 6, "Prenom", cellFormat1));
        
        ws1.setColumnView(4, 10);
        ws1.addCell(new jxl.write.Label(4, 6,"Email" , cellFormat1));
        
        ws1.setColumnView(5, 15);
        ws1.addCell(new jxl.write.Label(5, 6, "Telephone", cellFormat1));
        
        ws1.setColumnView(6, 20);
        ws1.addCell(new jxl.write.Label(6, 6, "Nombre de place réservées", cellFormat1));
        int iRows = 0;
        while ((rs != null) && (rs.next())) {
            ws1.addCell(new jxl.write.Label(0, iRows,""+ rs.getInt("code_reservationE"), cellFormat2));
            ws1.addCell(new jxl.write.Label(1, iRows, ""+ rs.getInt("code_expo"), cellFormat2));
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
    
}
