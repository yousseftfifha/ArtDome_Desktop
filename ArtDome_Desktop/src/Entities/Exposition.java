/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Oumaima
 */
public class Exposition {
    
    private int code_expo;
    private String nom_expo;
    private String theme_expo;
    private int code_espace;
    private int code_artiste;
    private Date date_expo;
    private int nb_max_participant;

    public Exposition() {
    }

    public Exposition(int code_artiste) {
        this.code_artiste = code_artiste;
    }

    public Exposition(int code_expo, String nom_expo, String theme_expo, int code_espace, int code_artiste, Date date_expo, int nb_max_participant) {
        this.code_expo = code_expo;
        this.nom_expo = nom_expo;
        this.theme_expo = theme_expo;
        this.code_espace = code_espace;
        this.code_artiste = code_artiste;
        this.date_expo = date_expo;
        this.nb_max_participant = nb_max_participant;
    }

    public int getCode_expo() {
        return code_expo;
    }

    public void setCode_expo(int code_expo) {
        this.code_expo = code_expo;
    }

    public String getNom_expo() {
        return nom_expo;
    }

    public void setNom_expo(String nom_expo) {
        this.nom_expo = nom_expo;
    }

    public String getTheme_expo() {
        return theme_expo;
    }

    public void setTheme_expo(String theme_expo) {
        this.theme_expo = theme_expo;
    }

    public int getCode_espace() {
        return code_espace;
    }

    public void setCode_espace(int code_espace) {
        this.code_espace = code_espace;
    }

    public int getCode_artiste() {
        return code_artiste;
    }

    public void setCode_artiste(int code_artiste) {
        this.code_artiste = code_artiste;
    }

    public Date getDate_expo() {
        return date_expo;
    }

    public void setDate_expo(Date date_expo) {
        this.date_expo = date_expo;
    }


    public int getNb_max_participant() {
        return nb_max_participant;
    }

    public void setNb_max_participant(int nb_max_participant) {
        this.nb_max_participant = nb_max_participant;
    }



    @Override
    public String toString() {
        return "Exposition{" + "code_expo=" + code_expo + ", nom_expo=" + nom_expo + ", theme_expo=" + theme_expo + ", code_espace=" + code_espace + ", code_artiste=" + code_artiste + ", date_expo=" + date_expo + ", nb_max_participant=" + nb_max_participant + '}';
    }

    public Exposition(int code_expo, String nom_expo) {
        this.code_expo = code_expo;
        this.nom_expo = nom_expo;
    }

    public Exposition(String nom_expo, String theme_expo, int code_espace, int code_artiste, Date date_expo,  int nb_max_participant) {
        this.nom_expo = nom_expo;
        this.theme_expo = theme_expo;
        this.code_espace = code_espace;
        this.code_artiste = code_artiste;
        this.date_expo = date_expo;
        this.nb_max_participant = nb_max_participant;
    }
    
    
    
    
    
}
