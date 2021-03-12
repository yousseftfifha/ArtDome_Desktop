/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

/**
 *
 * @author HP
 */
public class Client extends User{
    private int code_client;
    private User u;

    public Client() {
        
    }
    
    

    public Client(User u) {
        this.u = u;
    }

    public Client(int code_client,User u ) {
        this.code_client = code_client;
        this.u = u;
    }

    
    public Client(String nom_client, String prenom_client, String email, int telephone,int code_client) {
        super(nom_client, prenom_client, email, telephone);
        this.code_client = code_client;
    }
    
    public Client(String nom_client, String prenom_client, String email, int telephone) {
        super(nom_client, prenom_client, email, telephone);
       
    }

    public int getCode_client() {
        return code_client;
    }

    public void setCode_client(int code_client) {
        this.code_client = code_client;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
    
    
}
