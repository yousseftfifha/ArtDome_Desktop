package Tools;

/**
 * @author tfifha youssef
 */
public class emailHolder {
    private String mail;
    private final static emailHolder INSTANCE = new emailHolder();

    private emailHolder() {}

    public static emailHolder getInstance()
    {   return INSTANCE;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return this.mail;
    }
}
