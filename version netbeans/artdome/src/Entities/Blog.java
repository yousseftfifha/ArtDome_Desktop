package Entities;

import java.util.Date;
import java.util.Objects;

/**
 * @author tfifha youssef
 */
public class Blog {
   private String Title;
   private String Categorie;
   private Date DateOfPub;
   private String Image;
   private String Description;
   private String Publisher;


    public Blog() {
    }

    public Blog(String title, String categorie, String image, String description, String Publisher) {
        Title = title;
        Categorie = categorie;
        Image = image;
        Description = description;
        this.Publisher = Publisher;
    }

    public Blog(String title, String categorie, Date dateOfPub, String image, String description, String Publisher) {
        Title = title;
        Categorie = categorie;
        DateOfPub = dateOfPub;
        Image = image;
        Description = description;
        this.Publisher = Publisher;
    }



    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String categorie) {
        Categorie = categorie;
    }

    public Date getDateOfPub() {
        return DateOfPub;
    }

    public void setDateOfPub(Date dateOfPub) {
        DateOfPub = dateOfPub;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        this.Publisher = publisher;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "blog{" +
                "Title='" + Title + '\'' +
                ", Categorie='" + Categorie + '\'' +
                ", DateOfPub=" + DateOfPub +
                ", Image='" + Image + '\'' +
                ", ID_Artiste=" + Publisher +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Blog blog = (Blog) o;
        return Objects.equals (getTitle (), blog.getTitle ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getTitle ());
    }

}
