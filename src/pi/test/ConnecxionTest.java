/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.test;

import pi.services.EventMethods;
import pi.tools.MyConnection;
import pidev.entities.Event;

/**
 *
 * @author HP
 */
public class ConnecxionTest {
     public static void main(String[] args) {
        MyConnection mc= MyConnection.getInstance();
        EventMethods per = new EventMethods();
        Event p2 = new Event(88,"Foulen","Ben foulen");
        per.AddEvent(p2);
     }
}
