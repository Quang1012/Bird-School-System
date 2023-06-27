package DTO;

import java.io.Serializable;

public class BirdDTO implements Serializable {

    private int birdID;
    private AccountDTO account;
    private BirdCategoryDTO birdCategory;
    private String birdName;
    private String birdPhoto;
    private String height;
    private String weight;
    private String color;
    private String dentification;
    private int birdStatus;

    public BirdDTO() {
    }

    public BirdDTO(int birdID) {
        this.birdID = birdID;
    }

    public BirdDTO(int birdID, AccountDTO account, BirdCategoryDTO birdCategory, String birdName, String birdPhoto, String height, String weight, String color, String dentification, int birdStatus) {
        this.birdID = birdID;
        this.account = account;
        this.birdCategory = birdCategory;
        this.birdName = birdName;
        this.birdPhoto = birdPhoto;
        this.height = height;
        this.weight = weight;
        this.color = color;
        this.dentification = dentification;
        this.birdStatus = birdStatus;
    }


    public BirdDTO(String birdName, String height, String weight, String color, int birdStatus, String birdPhoto) {
        this.birdName = birdName;
        this.height = height;
        this.weight = weight;
        this.color = color;
        this.birdStatus = birdStatus;
        this.birdPhoto = birdPhoto;
    }

    public BirdDTO(String birdPhoto, String birdName, String height, String weight, String color) {
        this.birdPhoto = birdPhoto;
        this.birdName = birdName;
        this.height = height;
        this.weight = weight;
        this.color = color;
    }

    public BirdDTO(int birdID, AccountDTO acc, BirdCategoryDTO birdCate, String birdName, String height, String weight, String color, String dentification, int birdStatus, String birdPhoto) {
        this.birdID = birdID;
        this.account = acc;
        this.birdCategory = birdCate;
        this.birdName = birdName;
        this.height = height;
        this.weight = weight;
        this.color = color;
        this.dentification = dentification;
        this.birdStatus = birdStatus;
        this.birdPhoto = birdPhoto;
    }

    public BirdDTO(String birdName) {
        this.birdName = birdName;
    }

    public int getBirdID() {
        return birdID;
    }

    public void setBirdID(int birdID) {
        this.birdID = birdID;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public BirdCategoryDTO getBirdCategory() {
        return birdCategory;
    }

    public void setBirdCategory(BirdCategoryDTO birdCategory) {
        this.birdCategory = birdCategory;
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
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
