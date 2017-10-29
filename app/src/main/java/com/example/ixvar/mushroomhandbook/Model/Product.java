package com.example.ixvar.mushroomhandbook.Model;

/**
 * Created by Suleiman on 02/03/17.
 */

public class Product {

    private int id;
    private String name;
    private String otherNames;
    private int picture;


    public Product(int id, String name, String otherNames, int picture) {
        this.id = id;
        this.name = name;
        this.otherNames = otherNames;
        this.picture = picture;
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

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

}