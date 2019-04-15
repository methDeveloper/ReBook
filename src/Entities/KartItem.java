/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;

/**
 *
 * @author mp
 */
public class KartItem implements Serializable{
     
     public String book_name;
     public String seller_name;
     public double price;

    public KartItem(String book_name, String seller_name, double price) {
        this.book_name = book_name;
        this.seller_name = seller_name;
        this.price = price;
     }

    public String getBook_name() {
        return book_name;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public double getPrice() {
        return price;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
