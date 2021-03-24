/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Event {
    private int code_event;
    private String nom_event;
    private String theme_event;
    private String etat;
    private Date date;
    private int nb_participant;
    private int nb_max_part;
    private String image;
    private String video;
    private int code_espace;
    private User u;

    public Event() {
    }

    public Event(int code_event, String nom_event, String theme_event, String etat, Date date, int nb_participant, int nb_max_part, String image, String video, int code_espace, User u) {
        this.code_event = code_event;
        this.nom_event = nom_event;
        this.theme_event = theme_event;
        this.etat = etat;
        this.date = date;
        this.nb_participant = nb_participant;
        this.nb_max_part = nb_max_part;
        this.image = image;
        this.video = video;
        this.code_espace = code_espace;
        this.u = u;
    }
    
    

    public Event(int code_event, String nom_event, String theme_event, String etat, Date date, int nb_max_part, String image, String video, int code_espace) {
        this.code_event = code_event;
        this.nom_event = nom_event;
        this.theme_event = theme_event;
        this.etat = etat;
        this.date = date;
        this.nb_max_part = nb_max_part;
        this.image = image;
        this.video = video;
        this.code_espace = code_espace;
        
    }

    
    public Event(int code_event, String nom_event, String theme_event) {
        this.code_event = code_event;
        this.nom_event = nom_event;
        this.theme_event = theme_event;
    }

    public Event(String nom_event, String theme_event, String etat, Date date, int nb_max_part, String image, String video, int code_espace) {
        this.nom_event = nom_event;
        this.theme_event = theme_event;
        this.etat = etat;
        this.date = date;
        this.nb_max_part = nb_max_part;
        this.image = image;
        this.video = video;
        this.code_espace = code_espace;
    }

    public Event(int code_event, String nom_event, String theme_event, String etat, Date date, int nb_participant, int nb_max_part, String image, String video, int code_espace) {
        this.code_event = code_event;
        this.nom_event = nom_event;
        this.theme_event = theme_event;
        this.etat = etat;
        this.date = date;
        this.nb_participant = nb_participant;
        this.nb_max_part = nb_max_part;
        this.image = image;
        this.video = video;
        this.code_espace = code_espace;
    }



    public Event(int code_event, int nb_participant) {
        this.code_event = code_event;
        this.nb_participant = nb_participant;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
    
    
    public Event(int code_event) {
        this.code_event = code_event;
    }

    public int getCode_event() {
        return code_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public String getTheme_event() {
        return theme_event;
    }

    public String getEtat() {
        return etat;
    }

    public Date getDate() {
        return date;
    }

    public int getNb_participant() {
        return nb_participant;
    }

    public int getNb_max_part() {
        return nb_max_part;
    }

    public String getImage() {
        return image;
    }

    public String getVideo() {
        return video;
    }

    public int getCode_espace() {
        return code_espace;
    }



    public void setCode_event(int code_event) {
        this.code_event = code_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public void setTheme_event(String theme_event) {
        this.theme_event = theme_event;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNb_participant(int nb_participant) {
        this.nb_participant = nb_participant;
    }

    public void setNb_max_part(int nb_max_part) {
        this.nb_max_part = nb_max_part;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setCode_espace(int code_espace) {
        this.code_espace = code_espace;
    }

    @Override
    public String toString() {
        return "Event{" + "code_event=" + code_event + ", nom_event=" + nom_event + ", theme_event=" + theme_event + ", etat=" + etat + ", date=" + date + ", nb_participant=" + nb_participant + ", nb_max_part=" + nb_max_part + ", image=" + image + ", video=" + video + ", code_espace=" + code_espace + ", u=" + u + '}';
    }





   
}
