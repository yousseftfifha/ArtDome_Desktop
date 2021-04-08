/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author HP
 */
public class FTP {
    public static void main(String[] args){
        
             String server="MyFTPserver.com";
            int port=21;
            String username="ghada";
            String password="ghada";
        try {  
            FTPClient ftpclient= new FTPClient();
            ftpclient.connect(server, port);
            ftpclient.login(username,password);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    }
