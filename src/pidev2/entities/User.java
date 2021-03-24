/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev2.entities;

import java.util.Date;

/**
 *
 * @author HP
 */
public class User {
    int id;
    String nom;
    String prenom;
    Date datenaissance;
    String ville;
    String email;
    int numero;
    
    
    public User() {
    }

    public User(int id, String nom, String prenom, Date datenaissance, String ville, String email, int numero) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.ville = ville;
        this.email = email;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", datenaissance=" + datenaissance + ", ville=" + ville + ", email=" + email + ", numero=" + numero + '}';
    }

    public User(String nom, String prenom, Date datenaissance, String ville, String email, int numero) {
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.ville = ville;
        this.email = email;
        this.numero = numero;
    }
    


   
    
    
    
}
