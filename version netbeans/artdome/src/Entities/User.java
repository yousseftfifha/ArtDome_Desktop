package Entities;

import java.util.Date;

/**
 * @author tfifha youssef
 */
public class User {
    int id;
    String nom;
    String prenom;
    Date datenaissance;
    String ville;
    String email;
    int numero;
    String image;
    String role;
    String mdp;

    public User() {
    }

    public User(int id, String nom, String prenom, Date datenaissance, String ville, String email, int numero, String image, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.ville = ville;
        this.email = email;
        this.numero = numero;
        this.image = image;
        this.role = role;
    }

    public User(String nom, String prenom, String email, int numero) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numero = numero;
    }

    public User(int id) {
        this.id = id;
    }

    public User(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }



}

