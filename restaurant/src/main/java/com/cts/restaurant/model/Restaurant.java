package com.cts.restaurant.model;/*
 *@author Myvin Barboza
 *
 * 10:28 AM 2/27/2020
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String location;
    private int food_availability;
    private int quantity;

    public int getId() {
        return id;
    }

    public int getFood_availability() {
        return food_availability;
    }

    public void setFood_availability(int food_availability) {
        this.food_availability = food_availability;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public Restaurant() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Restaurant(int id, String name, String location, int foodAvailability, int quantity) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.food_availability = food_availability;
        this.quantity = quantity;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
