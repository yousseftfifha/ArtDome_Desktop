/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.User;
import Entities.Blog;
import Tools.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSF_Nabeul
 */
public class blogService {
    private Statement statement;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    public blogService() {
        connection = MyConnection.getInstance ().getConnection ();
    }
    public void ajouterBlog(Blog blog){
    try{
        String requete="insert into blog (Title,Categorie,DateOfPub,Image,Description,Publisher) values(?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(requete);
    preparedStatement.setString(1,blog.getTitle ());
    preparedStatement.setString(2,blog.getCategorie ());
    preparedStatement.setDate(3, Date.valueOf(LocalDate.now()));
    preparedStatement.setString(4,blog.getImage ());
    preparedStatement.setString(5, blog.getDescription ());
    preparedStatement.setString (6, blog.getPublisher ());
    preparedStatement.executeUpdate();
    System.out.println("blog ajouté");
    }catch (SQLException ex) {
            Logger.getLogger(blogService.class.getName()).log(Level.SEVERE, null, ex);}
    }
 
 
public void mettreàjourBlog(Blog blog){
    
        try {
            String requete1="update blog set Categorie=?,Description=? where Title=?";
            preparedStatement.setString(2, blog.getCategorie ());
             preparedStatement.setString(4,blog.getDescription());
             preparedStatement.setString (5,blog.getTitle ());
            preparedStatement.executeUpdate();
            System.out.println("blog est mis à jour");
        } catch (SQLException ex) {
            Logger.getLogger(blogService.class.getName()).log(Level.SEVERE, null, ex);
        }

}

public ObservableList<Blog> selectionnerBlog(){
        ObservableList listBlog = FXCollections.observableArrayList();
        
        try {
            
            String requete2="select * from blog";
            statement = connection.createStatement();
            resultSet= statement.executeQuery(requete2);
            while(resultSet.next()){
               Blog blog=new Blog ();
               blog.setTitle (resultSet.getString(1));
               blog.setCategorie (resultSet.getString(2));
               blog.setDateOfPub (resultSet.getDate(3));
               blog.setImage(resultSet.getString(4));
               blog.setDescription(resultSet.getString(5));
               blog.setPublisher (resultSet.getString (6));
               listBlog.add(blog);
            }
        } catch (SQLException ex) {
            Logger.getLogger(blogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBlog;
    }

public ObservableList<Blog> selectionnerBlogById(String Title){
        ObservableList listBlog = FXCollections.observableArrayList();
        
        try {
            
            String requete2="select * from blog where Title =" +"'"+Title+"'";
            statement = connection.createStatement();
            resultSet= statement.executeQuery(requete2);
            while(resultSet.next()){
                Blog blog=new Blog ();
                blog.setTitle (resultSet.getString(1));
                blog.setCategorie (resultSet.getString(2));
                blog.setDateOfPub (resultSet.getDate(3));
                blog.setImage(resultSet.getString(4));
                blog.setDescription(resultSet.getString(5));
                blog.setPublisher (resultSet.getString (6));
                listBlog.add(blog);
            }
        } catch (SQLException ex) {
            Logger.getLogger(blogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBlog;
    }



public void supprimerBlog(Blog b){
    String requete3="delete from blog where Title=?";
     try{
    preparedStatement.setString(1,b.getTitle ());
    preparedStatement.executeUpdate();
    System.out.println("blog supprimé");
    }   catch (SQLException ex) {
            Logger.getLogger(blogService.class.getName()).log(Level.SEVERE, null, ex);}
}
}
