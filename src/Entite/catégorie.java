/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Date;

/**
 *
 * @author user
 */
public class catégorie {  
    private int ID_Cat;
    private String Type ;
    private String Description ;
    private String NomCat ;   
    private int NbreOeuvre;
    private Date DateCat;

    public catégorie() {
    }
    

    public catégorie(int ID_Cat, String Type, String Description, String NomCat, int NbreOeuvre, Date DateCat) {
        this.ID_Cat = ID_Cat;
        this.Type = Type;
        this.Description = Description;
        this.NomCat = NomCat;
        this.NbreOeuvre = NbreOeuvre;
        this.DateCat = DateCat;
    }
    public catégorie(String Type, String Description, String NomCat, int NbreOeuvre, Date DateCat) {
        this.Type = Type;
        this.Description = Description;
        this.NomCat = NomCat;
        this.NbreOeuvre = NbreOeuvre;
        this.DateCat = DateCat;
    }

    public catégorie(String Type, String Description, String NomCat, Date DateCat) {
        this.Type = Type;
        this.Description = Description;
        this.NomCat = NomCat;
        this.DateCat = DateCat;
    }

    public catégorie(int ID_Cat, String Type, String Description, String NomCat, Date DateCat) {
        this.ID_Cat = ID_Cat;
        this.Type = Type;
        this.Description = Description;
        this.NomCat = NomCat;
        this.DateCat = DateCat;
    }

    public catégorie(String Type, String Description) {
        this.Type = Type;
        this.Description = Description;
    }
    
    

//    public catégorie(String type, String description, String nomcategorie, Date dateajout) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public catégorie(int idcategorie, String type, String description, String nomcategorie, Date dateajout) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public catégorie(int aInt, String string, String string0, String string1, int aInt0, java.sql.Date date, int aInt1) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public void setID_Cat(int ID_Cat) {
        this.ID_Cat = ID_Cat;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setNomCat(String NomCat) {
        this.NomCat = NomCat;
    }

    public void setNbreOeuvre(int NbreOeuvre) {
        this.NbreOeuvre = NbreOeuvre;
    }

    public void setDateCat(Date DateCat) {
        this.DateCat = DateCat;
    }
    

    public int getID_Cat() {
        return ID_Cat;
    }

    public String getType() {
        return Type;
    }

    public String getDescription() {
        return Description;
    }

    public String getNomCat() {
        return NomCat;
    }

    public int getNbreOeuvre() {
        return NbreOeuvre;
    }

    public Date getDateCat() {
        return DateCat;
    }
    

   
     
}
