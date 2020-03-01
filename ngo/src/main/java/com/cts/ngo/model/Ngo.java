package com.cts.ngo.model;/*
 *@author Myvin Barboza

 *
 * 12:19 PM 2/27/2020
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Ngo {
    @Id
    private String id;



    private String name;



    private String location;



    public Ngo() {

    }

    public Ngo(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;

    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
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
}
