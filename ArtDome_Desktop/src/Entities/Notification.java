/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author asus
 */
public class Notification {
    private int id;
    private String type;
    private int id_user;
    private User u;

    public Notification(int id, User u) {
        this.id = id;
        this.u = u;
    }

    public Notification(int id, String type, User u) {
        this.id = id;
        this.type = type;
        this.u = u;
    }

    public Notification(String type) {
        this.type = type;
    }

    public Notification(String type, int id_user, User u) {
        this.type = type;
        this.id_user = id_user;
        this.u = u;
    }

    public Notification(String type, User u) {
        this.type = type;
        this.u = u;
    }

    public Notification(int id, int id_user, String type) {
        this.id = id;
        this.type = type;
        this.id_user = id_user;
    }

    public Notification(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
    
}
