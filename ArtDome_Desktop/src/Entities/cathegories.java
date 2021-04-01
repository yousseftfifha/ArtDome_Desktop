/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author max
 */
public class cathegories {
    private int cat_id;
    private String cat_name;
    private String cat_description;
    private Date lastPostDate;
    
    public cathegories (){
    }

    public cathegories(int cat_id, String cat_name, String cat_description, Date lastPostDate) {
        this.cat_id = cat_id;
        this.cat_name = cat_name;
        this.cat_description = cat_description;
        this.lastPostDate = lastPostDate;
    }
 
     public cathegories(int cat_id, String cat_name, String cat_description) {
        this.cat_id = cat_id;
        this.cat_name = cat_name;
        this.cat_description = cat_description;
        
    }

    public cathegories(String cat_name, String cat_description, Date lastPostDate) {
        this.cat_name = cat_name;
        this.cat_description = cat_description;
        this.lastPostDate = lastPostDate;
    }

    public cathegories(String cat_name, String cat_description) {
        this.cat_name = cat_name;
        this.cat_description = cat_description;
    }

    public int getCat_id() {
        return cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public String getCat_description() {
        return cat_description;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public void setCat_description(String cat_description) {
        this.cat_description = cat_description;
    }

    @Override
    public String toString() {
        return "cathegories{" + "cat_id=" + cat_id + ", cat_name=" + cat_name + ", cat_description=" + cat_description + ",lastPostDate=" +lastPostDate+ '}';
    }
    
    
    
}
