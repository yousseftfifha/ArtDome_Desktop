/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev2.entities;

/**
 *
 * @author Oumaima
 */
public class reservation_expo {
    private int code_reservationE;
    private int code_client;
    private String nom_client;
    private String prenom_client;
    private int telephone;
    private String email;
    private int nb_place;
    private int code_expo;

    public reservation_expo() {
    }

    public reservation_expo(int code_reservationE, int code_client, String nom_client, String prenom_client, int telephone, String email, int nb_place, int code_expo) {
        this.code_reservationE = code_reservationE;
        this.code_client = code_client;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.telephone = telephone;
        this.email = email;
        this.nb_place = nb_place;
        this.code_expo = code_expo;
    }

    public reservation_expo(int code_client, String nom_client, String prenom_client, int telephone, String email, int nb_place, int code_expo) {
        this.code_client = code_client;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.telephone = telephone;
        this.email = email;
        this.nb_place = nb_place;
        this.code_expo = code_expo;
    }

    public reservation_expo(int code_client, String nom_client, String prenom_client, int telephone, String email, int nb_place) {
        this.code_client = code_client;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.telephone = telephone;
        this.email = email;
        this.nb_place = nb_place;
    }

    public reservation_expo(String nom_client, String prenom_client, int telephone, String email, int nb_place, int code_expo) {
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.telephone = telephone;
        this.email = email;
        this.nb_place = nb_place;
        this.code_expo = code_expo;
    }

    public reservation_expo(String nom_client, String prenom_client, int telephone, String email, int nb_place) {
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.telephone = telephone;
        this.email = email;
        this.nb_place = nb_place;
    }
    
   

    public int getCode_reservationE() {
        return code_reservationE;
    }

    public void setCode_reservationE(int code_reservationE) {
        this.code_reservationE = code_reservationE;
    }

    public int getCode_client() {
        return code_client;
    }

    public void setCode_client(int code_client) {
        this.code_client = code_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client = prenom_client;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public int getCode_expo() {
        return code_expo;
    }

    public void setCode_expo(int code_expo) {
        this.code_expo = code_expo;
    }

    @Override
    public String toString() {
        return "reservation_expo{" + "code_reservationE=" + code_reservationE + ", code_client=" + code_client + ", nom_client=" + nom_client + ", prenom_client=" + prenom_client + ", telephone=" + telephone + ", email=" + email + ", nb_place=" + nb_place + ", code_expo=" + code_expo + '}';
    }

  

   
    
    
    
}
