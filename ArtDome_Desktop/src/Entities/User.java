/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.io.File;
import java.sql.Date;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author asus
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
    String  mdp;

    public User() {
    }

    public User(int id, String nom, String prenom, Date datenaissance, String email, String mdp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.email = email;
        this.mdp = mdp;
    }

    public User(String nom, String prenom, String email, String role, int numero) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numero = numero;
        this.role = role;
    }

    public User(int id, String nom, String prenom, Date datenaissance, String ville, String email, int numero, String mdp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.ville = ville;
        this.email = email;
        this.numero = numero;
        this.mdp=mdp;
    }

    public User(String nom, String prenom, Date datenaissance, String ville, String email, int numero, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.ville = ville;
        this.email = email;
        this.numero = numero;
        this.mdp = mdp;
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

    public User(int id, String nom, String prenom, Date datenaissance, String ville, String email, int numero) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.ville = ville;
        this.email = email;
        this.numero = numero;
    }

    public User(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public User(int id) {
        this.id = id;
    }

    public User(String nom, String prenom, String email, int numero) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numero = numero;
    }

    public User(String image) {
        this.image = image;
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

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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
       this.image=image;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", datenaissance=" + datenaissance + ", ville=" + ville + ", email=" + email + ", numero=" + numero + ", image=" + image + ", role=" + role + '}';
    }
    
}
