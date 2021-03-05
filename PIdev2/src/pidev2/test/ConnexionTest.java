/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev2.test;

import pidev2.entities.Exposition;
import pidev2.services.ExpoMethods;
import pidev2.tools.MyConnection;

/**
 *
 * @author Oumaima
 */
public class ConnexionTest {
     public static void main(String[] args) {
         MyConnection mc= MyConnection.getInstance();
           ExpoMethods expo = new ExpoMethods();
         Exposition p2 = new Exposition(1, "bib");
         expo.AddExpo(p2);
} 
}
