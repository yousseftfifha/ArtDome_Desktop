/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Oumaima
 */
public class reservation_expo {
    private int code_reservationE;
    private int code_client;
    private int nb_place;
    private int code_expo;
    
      public reservation_expo() {
    }
      
          public reservation_expo(int code_reservationE, int code_client, int nb_place, int code_expo) {
        this.code_reservationE = code_reservationE;
        this.code_client = code_client;
        this.nb_place = nb_place;
        this.code_expo = code_expo;
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
        return "reservation_expo{" + "code_reservationE=" + code_reservationE + ", code_client=" + code_client + ", nb_place=" + nb_place + ", code_expo=" + code_expo + '}';
    }

    public reservation_expo(int code_reservationE, int code_client, int nb_place) {
        this.code_reservationE = code_reservationE;
        this.code_client = code_client;
        this.nb_place = nb_place;
    }

    public reservation_expo(int nb_place) {
        this.nb_place = nb_place;
    }

    public reservation_expo(int code_client, int nb_place) {
        this.code_client = code_client;
        this.nb_place = nb_place;
    }
    
    

    
   
    

  

   

  

   
    
    
    
}
