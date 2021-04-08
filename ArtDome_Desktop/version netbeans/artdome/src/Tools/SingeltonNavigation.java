package Tools;

import Entities.User;
import javafx.scene.Parent;

/**
 * @author tfifha youssef
 */
public class SingeltonNavigation {
    User loggedInUser;
    Parent root;
    static SingeltonNavigation instance;

    private SingeltonNavigation()
    {

    }
    public User getLoggedInUser() {return loggedInUser;}

    public void setLoggedInUser(User loggedInUser) {this.loggedInUser = loggedInUser;}

    public Parent getRoot() {return root;}


    public static SingeltonNavigation getInstance()
    {
        if(instance == null)
        {
            instance = new SingeltonNavigation ();
            return instance;
        }
        else
            return instance;
    }
}
