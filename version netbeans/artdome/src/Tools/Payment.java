package Tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tfifha youssef
 */
public class Payment { Customer a=new Customer();


    public Payment() {
        Stripe.apiKey = "sk_test_51ISlU2GPzOJm2oIXjJlV3dETv60FnrMNqOqFrK3ESUdhjnRuOxB4nY6hFQ2OENvJylnEyxxvlOlyZzsOo13oY9vp00Xp03ebq0";

    }

  /*public void createCustomer() {

    Map<String, Object> customerParams = new HashMap<String, Object>();
	customerParams.put("email", "c@gmail.com");
      try {
          // Create customer
          Customer stripeCustomer = Customer.create(customerParams);
          System.out.println(stripeCustomer.getId());
      } catch (StripeException ex) {
          Logger.getLogger(PaymentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
      }


  }*/

    public void RetrieveCustomer(){
        try {
            Customer a=Customer.retrieve("cus_J4vLHqM4VkGLnH");

            //create card
            Map<String, Object> cardParams = new HashMap<String, Object> ();
            cardParams.put("number", "4000056655665556");
            cardParams.put("exp_month", "12");
            cardParams.put("exp_year", "2022");
            cardParams.put("cvc", "456");
            Map<String, Object> tokenParams = new HashMap<String, Object>();
            tokenParams.put("card", cardParams);
            Token token=Token.create(tokenParams);
//            Map<String, Object> source = new HashMap<String, Object>();
//            source.put("source", token.getId());
//            a.getSources().create(source);
            Gson gson=new GsonBuilder ().setPrettyPrinting().create();
            System.out.println(gson.toJson(a));
        }
        catch (StripeException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }}
    public void payement(int prix){

        try {Customer a=Customer.retrieve("cus_J4vLHqM4VkGLnH");

            //charge customer
            Map<String, Object> chargeParams = new HashMap<String, Object>();
            chargeParams.put("amount", (prix)+"00");
            chargeParams.put("currency", "usd");
            chargeParams.put("customer", a.getId());
            Charge.create(chargeParams);

        } catch (StripeException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }}



}





