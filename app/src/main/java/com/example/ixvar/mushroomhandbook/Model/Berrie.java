package com.example.ixvar.mushroomhandbook.Model;

/**
 * Created by ixvar on 10/29/2017.
 */

public class Berrie {

    private int id;
    private String name;
    private String otherName;
    private int[] images;
    private String description;
    private String size;
    private String type;
    private String color;
    private String place;
    private String season;
    private boolean favorite;


    public Berrie(int id, String name, String otherName, int[] images, String description, String size, String type, String color, String place, String season, boolean favorite) {
        this.id = id;
        this.name = name;
        this.otherName = otherName;
        this.images = images;
        this.description = description;
        this.size = size;
        this.type = type;
        this.color = color;
        this.place = place;
        this.season = season;
        this.favorite = favorite;
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

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public int[] getImages() {
        return images;
    }

    public void setImages(int[] images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
