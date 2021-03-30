/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import static javafx.scene.input.KeyCode.T;
import java.util.List; 
/**
 *
 * @author user
 */
public interface Ioeuvre<T> 
{ 
    void insert(T t);
    List<T>readAll();
    T readById(int id);
    
}
