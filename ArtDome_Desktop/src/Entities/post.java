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
public class post {
    
    private int post_id;
    private  String post_content;
    private Date post_date;
    private int post_topic;
    private int post_by;

    public post(int post_id, String post_content, Date post_date, int post_topic, int post_by) {
        this.post_id = post_id;
        this.post_content = post_content;
        this.post_date = post_date;
        this.post_topic = post_topic;
        this.post_by = post_by;
    }

    public int getPost_id() {
        return post_id;
    }

    public String getPost_content() {
        return post_content;
    }

    public Date getPost_date() {
        return post_date;
    }

    public int getPost_topic() {
        return post_topic;
    }

    public int getPost_by() {
        return post_by;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }

    public void setPost_topic(int post_topic) {
        this.post_topic = post_topic;
    }

    public void setPost_by(int post_by) {
        this.post_by = post_by;
    }

    @Override
    public String toString() {
        return "post{" + "post_id=" + post_id + ", post_content=" + post_content + ", post_date=" + post_date + ", post_topic=" + post_topic + ", post_by=" + post_by + '}';
    }
    
    
}
