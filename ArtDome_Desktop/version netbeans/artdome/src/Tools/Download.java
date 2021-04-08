/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
        
/**
 *
 * @author asus
 */
public class Download implements Runnable{
    String link;
    File out;

    public Download(String link, File out) {
        this.link = link;
        this.out = out;
    }

    @Override
    public void run() {
        try{  
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            double filesize = (double) http.getContentLengthLong();
            BufferedInputStream in = new BufferedInputStream(http.getInputStream());
            FileOutputStream fos = new FileOutputStream(this.out);
            BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
            byte[] buffer = new byte[1024];
            double downloaded = 0.00;
            int read = 0;
            double percentDownloaded = 0.00;
            while ((read = in.read(buffer,0,1014)) >=0){
                bout.write(buffer,0,read);
                downloaded += read;
                percentDownloaded = (downloaded*100)/filesize;
                String percent = String.format("%.2f", percentDownloaded)   ;
                System.out.println("downloaded"+percent+"%of a file.");
            }
            bout.close();
            in.close();
            System.out.println("Download complete");
            
        }catch (IOException ex){
            System.out.println(ex);
            
        }
    }
    
    
    
}
