package Tools;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import jxl.write.Label;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author tfifha youssef
 */
public class ExcelOrders {
    public void ExcelOrders() throws SQLException, WriteException, IOException {

        WritableWorkbook myFirstWbook = null;
        String requete = "SELECT * from orders";
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
        workbook = Workbook.createWorkbook(new File ("Orders.xls"));
        WritableSheet ws1 = workbook.createSheet("Liste : ", 0);
        WritableCellFormat cellFormat3 = new WritableCellFormat();
        cellFormat3.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, Colour.DARK_YELLOW);


        // * Header ***//
        WritableCellFormat cellFormat1 = new WritableCellFormat(fontWhite);
        cellFormat1.setBackground(Colour.ICE_BLUE);
        cellFormat1.setAlignment(jxl.format.Alignment.CENTRE);
        cellFormat1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
        cellFormat1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, Colour.DARK_PURPLE);

        // * Data ***//
        WritableCellFormat cellFormat2 = new WritableCellFormat(fontBlue);
        cellFormat2.setWrap(true);
        cellFormat2.setBackground(Colour.WHITE);
        cellFormat2.setAlignment(jxl.format.Alignment.CENTRE);
        cellFormat2.setVerticalAlignment(VerticalAlignment.CENTRE);
        cellFormat2.setWrap(true);
        cellFormat2.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, Colour.OCEAN_BLUE);

        // * Header ***//
        ws1.setColumnView(0, 15);
        ws1.addCell(new jxl.write.Label(0, 0, "OrderID", cellFormat1));

        ws1.setColumnView(1, 15);
        ws1.addCell(new jxl.write.Label(1, 0, "UserName", cellFormat1));

        ws1.setColumnView(2, 10);
        ws1.addCell(new jxl.write.Label(2, 0, "DueAmount", cellFormat1));

        ws1.setColumnView(3, 10);
        ws1.addCell(new jxl.write.Label(3, 0, "InnoNumber", cellFormat1));

        ws1.setColumnView(4, 20);
        ws1.addCell(new jxl.write.Label(4, 0,"TotalQty" , cellFormat1));

        ws1.setColumnView(5, 15);
        ws1.addCell(new jxl.write.Label(5, 0, "OrderDate", cellFormat1));

        ws1.setColumnView(6, 20);
        ws1.addCell(new jxl.write.Label(6, 0, "Status", cellFormat1));
        int iRows = 1;
        while ((rs != null) && (rs.next())) {
            ws1.addCell(new jxl.write.Label(0, iRows,""+ rs.getInt(1), cellFormat2));
            ws1.addCell(new jxl.write.Label(1, iRows, ""+ rs.getString (2), cellFormat2));
            ws1.addCell(new jxl.write.Label(2, iRows, rs.getString(3), cellFormat2));
            ws1.addCell(new jxl.write.Label(3, iRows,  rs.getString(4), cellFormat2));
            ws1.addCell(new jxl.write.Label(4, iRows,  rs.getString(5), cellFormat2));
            ws1.addCell(new jxl.write.Label(5, iRows, ""+rs.getString (6), cellFormat2));
            ws1.addCell(new jxl.write.Label(6, iRows, ""+rs.getString (7), cellFormat2));

            ++iRows;
        }
        workbook.write();
        workbook.close();

        Desktop.getDesktop().open(new File("Orders.xls"));
    }


}


