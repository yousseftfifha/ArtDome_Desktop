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
public class oeuvre {
    private int ID_Oeuvre;
    private String NomOeuvre;

    public oeuvre() {
    }

    public oeuvre(int ID_Oeuvre, String NomOeuvre) {
        this.ID_Oeuvre = ID_Oeuvre;
        this.NomOeuvre = NomOeuvre;
    }

    public int getID_Oeuvre() {
        return ID_Oeuvre;
    }

    public void setID_Oeuvre(int ID_Oeuvre) {
        this.ID_Oeuvre = ID_Oeuvre;
    }

    public String getNomOeuvre() {
        return NomOeuvre;
    }

    public void setNomOeuvre(String NomOeuvre) {
        this.NomOeuvre = NomOeuvre;
    }

    @Override
    public String toString() {
        return "oeuvre{" + "ID_Oeuvre=" + ID_Oeuvre + ", NomOeuvre=" + NomOeuvre + '}';
    }
    
}
