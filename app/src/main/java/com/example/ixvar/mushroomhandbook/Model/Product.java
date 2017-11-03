package com.example.ixvar.mushroomhandbook.Model;

/**
 * Created by Suleiman on 02/03/17.
 */

public class Product {

    private int id;
    private String name;
    private String otherNames;
    private String picture;


    public Product(int id, String name, String otherNames, String picture) {
        this.id = id;
        this.name = name;
        this.otherNames = otherNames;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}