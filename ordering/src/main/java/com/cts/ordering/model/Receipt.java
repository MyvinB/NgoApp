package com.cts.ordering.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/*
 @author Myvin Barboza
 01/03/20 1:40 AM
 */
@Entity
public class Receipt {
    @Id
    public String id;
    public String Restaurant;
    public String Ngo;
    @CreationTimestamp
    private Date created;


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestaurant() {
        return Restaurant;
    }

    public void setRestaurant(String restaurant) {
        Restaurant = restaurant;
    }

    public String getNgo() {
        return Ngo;
    }


    public Receipt(String id, String restaurant, String ngo, Date created) {
        this.id = id;
        Restaurant = restaurant;
        Ngo = ngo;
        this.created = created;
    }

    public void setNgo(String ngo) {
        Ngo = ngo;
    }

    public Receipt() {

    }





}