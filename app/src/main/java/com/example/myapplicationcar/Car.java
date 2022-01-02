package com.example.myapplicationcar;

import java.io.Serializable;

public class Car implements Serializable {
   private int photoResource;
   private String brand;
   private String model;
   private String year;
   private String price;

    public Car(int photoResource, String brand, String model, String year, String price) {
        this.photoResource = photoResource;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public int getPhotoResource() {
        return photoResource;
    }

    public void setPhotoResource(int photoResource) {
        this.photoResource = photoResource;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
