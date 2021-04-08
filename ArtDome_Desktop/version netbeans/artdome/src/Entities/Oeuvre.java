/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;



import java.util.Date;


/**
 *
 * @author user
 */
public class Oeuvre {
    private int ID_Oeuvre;
    private String NomOeuvre;
    private double PrixOeuvre;
    private int ID_Artiste;
    private Date DateOeuvre;
    private String ImageOeuvre;
    private String NomCat;
    private String EmailArtiste ; 
    public Oeuvre() {
    }

    public Oeuvre(int ID_Oeuvre, String nomOeuvre) {
        this.ID_Oeuvre = ID_Oeuvre;
        NomOeuvre = nomOeuvre;
    }

    public Oeuvre(int ID_Oeuvre, String nomOeuvre, double prixOeuvre) {
        this.ID_Oeuvre = ID_Oeuvre;
        NomOeuvre = nomOeuvre;
        PrixOeuvre = prixOeuvre;
    }

    public Oeuvre(int ID_Oeuvre, String nomOeuvre, double prixOeuvre, int ID_Artiste, String imageOeuvre) {
        this.ID_Oeuvre = ID_Oeuvre;
        NomOeuvre = nomOeuvre;
        PrixOeuvre = prixOeuvre;
        this.ID_Artiste = ID_Artiste;
        ImageOeuvre = imageOeuvre;
    }

    public Oeuvre(int ID_Oeuvre, String NomOeuvre, double PrixOeuvre, int ID_Artiste, Date DateOeuvre, String ImageOeuvre, String NomCat, String EmailArtiste) {
        this.ID_Oeuvre = ID_Oeuvre;
        this.NomOeuvre = NomOeuvre;
        this.PrixOeuvre = PrixOeuvre;
        this.ID_Artiste = ID_Artiste;
        this.DateOeuvre = DateOeuvre;
        this.ImageOeuvre = ImageOeuvre;
        this.NomCat = NomCat;
        this.EmailArtiste = EmailArtiste;
    }

    public Oeuvre(String NomOeuvre, double PrixOeuvre, int ID_Artiste, Date DateOeuvre, String ImageOeuvre, String NomCat, String EmailArtiste) {
        this.NomOeuvre = NomOeuvre;
        this.PrixOeuvre = PrixOeuvre;
        this.ID_Artiste = ID_Artiste;
        this.DateOeuvre = DateOeuvre;
        this.ImageOeuvre = ImageOeuvre;
        this.NomCat = NomCat;
        this.EmailArtiste = EmailArtiste;
    }


     
    public int getID_Oeuvre() {
        return ID_Oeuvre;
    }

    public String getNomOeuvre() {
        return NomOeuvre;
    }

    public double getPrixOeuvre() {
        return PrixOeuvre;
    }

    public int getID_Artiste() {
        return ID_Artiste;
    }

    public Date getDateOeuvre() {
        return DateOeuvre;
    }

    public String getImageOeuvre() {
        return ImageOeuvre;
    }

    public String getNomCat() {
        return NomCat;
    }

    public String getEmailArtiste() {
        return EmailArtiste;
    }
    

    public void setID_Oeuvre(int ID_Oeuvre) {
        this.ID_Oeuvre = ID_Oeuvre;
    }

    public void setNomOeuvre(String NomOeuvre) {
        this.NomOeuvre = NomOeuvre;
    }

    public void setPrixOeuvre(double PrixOeuvre) {
        this.PrixOeuvre = PrixOeuvre;
    }

    public void setID_Artiste(int ID_Artiste) {
        this.ID_Artiste = ID_Artiste;
    }

    public void setDateOeuvre(Date DateOeuvre) {
        this.DateOeuvre = DateOeuvre;
    }

    public void setImageOeuvre(String ImageOeuvre) {
        this.ImageOeuvre = ImageOeuvre;
    }

    public void setNomCat(String NomCat) {
        this.NomCat = NomCat;
    }

    public void setEmailArtiste(String EmailArtiste) {
        this.EmailArtiste = EmailArtiste;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.ID_Oeuvre;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Oeuvre other = (Oeuvre) obj;
        if (this.ID_Oeuvre != other.ID_Oeuvre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Oeuvre{" + "ID_Oeuvre=" + ID_Oeuvre + ", NomOeuvre=" + NomOeuvre + ", PrixOeuvre=" + PrixOeuvre + ", ID_Artiste=" + ID_Artiste +  ", DateOeuvre=" + DateOeuvre+ ", ImageOeuvre=" + ImageOeuvre+ ", NomCat=" + NomCat+ ", EmailArtiste=" + EmailArtiste+  '}';
    }
    
}
