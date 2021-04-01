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
public class topic {

    public topic(String topic_subject, Date topic_date, int topic_by) {
        this.topic_subject = topic_subject;
        this.topic_date = topic_date;
        this.topic_by = topic_by;
    }

//    public static void add(topic topic) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    public static void Addtopic(topic t2) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
   private int topic_id;
    private String topic_subject;
    private String topic_description;
    private Date topic_date;
    private int topic_by;

    public topic(int topic_id, String topic_subject, String topic_description, int topic_by) {
        this.topic_id = topic_id;
        this.topic_subject = topic_subject;
        this.topic_description = topic_description;
        this.topic_by = topic_by;
    }

    public topic(String topic_subject, String topic_description, int topic_by) {
        this.topic_subject = topic_subject;
        this.topic_description = topic_description;
        this.topic_by = topic_by;
    }

    
    public topic(int topic_id, String topic_subject, String topic_description, Date topic_date, int topic_by) {
        this.topic_id = topic_id;
        this.topic_subject = topic_subject;
        this.topic_description = topic_description;
        this.topic_date = topic_date;
        this.topic_by = topic_by;
        
        
    }

    public topic(int topic_by, String topic_subject) {
        this.topic_subject = topic_subject;
        this.topic_by = topic_by;
    }
    
     public topic(int topic_id,int topic_by, String topic_subject, String topic_description) {
        this.topic_subject = topic_subject;
        this.topic_description = topic_description;
        this.topic_id = topic_id;
        this.topic_by = topic_by;
    }

    public topic(int topic_by, String topic_subject, String topic_description, Date topic_date) {
        this.topic_subject = topic_subject;
        this.topic_description = topic_description;
        this.topic_date = topic_date;
        this.topic_by = topic_by;
    }

    public topic(String Ide, String titre, String description, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getTopic_id() {
        return topic_id;
    }

    public String getTopic_subject() {
        return topic_subject;
    }

    public String getTopic_description() {
        return topic_description;
    }

    public Date getTopic_date() {
        return topic_date;
    }

    public int getTopic_by() {
        return topic_by;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public void setTopic_subject(String topic_subject) {
        this.topic_subject = topic_subject;
    }

    public void setTopic_description(String topic_description) {
        this.topic_description = topic_description;
    }

    public void setTopic_date(Date topic_date) {
        this.topic_date = topic_date;
    }

    public void setTopic_by(int topic_by) {
        this.topic_by = topic_by;
    }

    @Override
    public String toString() {
        return "topic{" + "topic_id=" + topic_id + ", topic_subject=" + topic_subject + ", topic_description=" + topic_description + ", topic_date=" + topic_date + ", topic_by=" + topic_by + '}';
    }

    
    
    
}
