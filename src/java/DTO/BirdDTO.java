/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class BirdDTO {
    private int AccountID;
    private int categoriesID;
    private String birdName;
    private String birdPhoto;
    private double height;
    private double weight;
    private String color;
    private String dentification;
    private int birdStatus;

    public BirdDTO() {
    }

    public BirdDTO(int AccountID, int categoriesID, String birdName, String birdPhoto, double height, double weight, String color, String dentification, int birdStatus) {
        this.AccountID = AccountID;
        this.categoriesID = categoriesID;
        this.birdName = birdName;
        this.birdPhoto = birdPhoto;
        this.height = height;
        this.weight = weight;
        this.color = color;
        this.dentification = dentification;
        this.birdStatus = birdStatus;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public int getCategoriesID() {
        return categoriesID;
    }

    public void setCategoriesID(int categoriesID) {
        this.categoriesID = categoriesID;
    }

    public String getBirdName() {
        return birdName;
    }

    public void setBirdName(String birdName) {
        this.birdName = birdName;
    }

    public String getBirdPhoto() {
        return birdPhoto;
    }

    public void setBirdPhoto(String birdPhoto) {
        this.birdPhoto = birdPhoto;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDentification() {
        return dentification;
    }

    public void setDentification(String dentification) {
        this.dentification = dentification;
    }

    public int getBirdStatus() {
        return birdStatus;
    }

    public void setBirdStatus(int birdStatus) {
        this.birdStatus = birdStatus;
    }
    
    
}
