package Tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * @author tfifha youssef
 */
public class SMS {
    public SMS() {
    }

    public String SendSMS(String username, String password, String message, String number, String URL) {
        String line = "";

        try {
            String data = "";
            data = data + "username=" + URLEncoder.encode(username, "ISO-8859-1");
            data = data + "&password=" + URLEncoder.encode(password, "ISO-8859-1");
            data = data + "&message=" + URLEncoder.encode(message, "ISO-8859-1");
            data = data + "&want_report=1";
            data = data + "&msisdn=" + number;
            java.net.URL url = new URL(URL);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();
            BufferedReader rd = new BufferedReader(new InputStreamReader (conn.getInputStream()));

            while((line = rd.readLine()) != null) {
                System.out.println(line);
            }

            wr.close();
            rd.close();
        } catch (Exception var12) {
            var12.printStackTrace();
        }

        return line;
    }
}

