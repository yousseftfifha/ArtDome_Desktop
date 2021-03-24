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
public class Reservation {
    private int code_reservation;
    private User c;
    private int nb_place;
    private int code_event;

    public Reservation() {
    }

//    public Reservation(String nom_client, String prenom_client, int telephone, String email, int nb_place, int code_event) {
//        this.nom_client = nom_client;
//        this.prenom_client = prenom_client;
//        this.telephone = telephone;
//        this.email = email;
//        this.nb_place = nb_place;
//        this.code_event = code_event;
//    }
//
//    public Reservation(String nom_client, String prenom_client, int telephone, String email, int nb_place) {
//        this.nom_client = nom_client;
//        this.prenom_client = prenom_client;
//        this.telephone = telephone;
//        this.email = email;
//        this.nb_place = nb_place;
//    }
//
//    public Reservation(int code_reservation, String nom_client, String prenom_client, int telephone, String email, int nb_place) {
//        this.code_reservation = code_reservation;
//        this.nom_client = nom_client;
//        this.prenom_client = prenom_client;
//        this.telephone = telephone;
//        this.email = email;
//        this.nb_place = nb_place;
//    }

    public Reservation( User c, int nb_place, int code_event) {
        this.c=c;
        this.nb_place = nb_place;
        this.code_event = code_event;
    }

//    public Reservation(int code_reservation,String nom_client, String prenom_client, int telephone, String email,int nb_place, int code_event) {
//        this.code_reservation = code_reservation;
//        Client c=new Client(nom_client, prenom_client, telephone, email); 
//        this.nb_place = nb_place;
//        this.code_event = code_event;
//       
//    }

    public Reservation(int code_reservation, User c, int nb_place, int code_event) {
        this.code_reservation = code_reservation;
        this.c = c;
        this.nb_place = nb_place;
        this.code_event = code_event;
    }

    public Reservation(User c, int nb_place) {
        this.c = c;
        this.nb_place = nb_place;
    }

  
    
    

    public int getCode_reservation() {
        return code_reservation;
    }

    public void setCode_reservation(int code_reservation) {
        this.code_reservation = code_reservation;
    }


    public User getC() {
        return c;
    }

    public void setC(Client c) {
        this.c = c;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public int getCode_event() {
        return code_event;
    }

    public void setCode_event(int code_event) {
        this.code_event = code_event;
    }

    public Reservation(int nb_place, int code_event) {
        this.nb_place = nb_place;
        this.code_event = code_event;
    }

    public Reservation(int nb_place) {
        this.nb_place = nb_place;
    }


  
    
}