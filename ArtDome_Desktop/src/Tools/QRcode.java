/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
//package com.chillyfacts.com;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 *
 * @author HP
 */
public class QRcode {
    
    public void QRcode(){
    try {
        Connection cx = MyConnection.getInstance().getConnection();
        String query = "Select r.code_reservation, r.nb_place, r.code_event, u.nom, u.prenom, u.email, u.numero FROM reservationevent r INNER JOIN user u ON r.code_client = u.id ORDER BY code_reservation DESC";
        Statement st = cx.createStatement();
        ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
            	QRcode.generate_qr("Reservation n°"+rs.getInt("code_reservation"), "Reservation n "+rs.getInt("code_reservation")+" ,De "+rs.getInt("nb_place")+" place(s) " +"au nom de "+rs.getString("nom")+" "+ rs.getString("prenom"));
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void generate_qr(String image_name,String qrCodeData) {
        try {
            String filePath = image_name+".png";
            String charset = "UTF-8"; // or "ISO-8859-1"
            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                .lastIndexOf('.') + 1), new File(filePath));
            System.out.println("QR Code image created successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
