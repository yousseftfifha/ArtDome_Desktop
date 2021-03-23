package Tests;

/**
 * @author tfifha youssef
 */
// Install the Java helper library from twilio.com/docs/java/install

import com.twilio.Twilio;
import com.twilio.rest.messaging.v1.Service;

class Example {
    // Find your Account Sid and Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Service service = Service.creator("My First Messaging Service")
                .create();

        System.out.println(service.getSid());
    }

}
