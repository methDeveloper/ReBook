/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;

/**
 *
 * @author raj
 */
public class User implements Serializable{
    
     private String userId;
     private String email;
     private String name;
     private String dob;
     private String hashed_passwd;
     private String department;
     private String programme;
     private String contact;
     private double rating;
     private int number_rating;
     
     public User()
     {
         
     }

    public User(String userId, String email, String name, String dob, 
            String hashed_passwd, String department, String programme, String contact, double rating, int number_rating) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.dob = dob;
        this.hashed_passwd = hashed_passwd;
        this.department = department;
        this.programme = programme;
        this.contact = contact;
        this.rating = rating;
        this.number_rating = number_rating;
    }

    public void setAll(String userId, String email, String name, String dob, 
            String hashed_passwd, String department, String programme, String contact, double rating, int number_rating){
        
        
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.dob = dob;
        this.hashed_passwd = hashed_passwd;
        this.department = department;
        this.programme = programme;
        this.contact = contact;
        this.rating = rating;
        this.number_rating = number_rating;
    }
    
    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getHashed_passwd() {
        return hashed_passwd;
    }

    public String getDepartment() {
        return department;
    }

    public String getProgramme() {
        return programme;
    }

    public String getContact() {
        return contact;
    }

    public double getRating() {
        return rating;
    }

    public int getNumber_rating() {
        return number_rating;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setHashed_passwd(String hashed_passwd) {
        this.hashed_passwd = hashed_passwd;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setNumber_rating(int number_rating) {
        this.number_rating = number_rating;
    }
    
     
}
