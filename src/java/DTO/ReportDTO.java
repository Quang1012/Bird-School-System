/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class ReportDTO {
    private java.sql.Date date;
    private String image;
    private String url;
    private AccountDTO account;
    private BirdDTO bird;

    public ReportDTO() {
    }

    public ReportDTO(Date date, String image, String url, AccountDTO account, BirdDTO bird) {
        this.date = date;
        this.image = image;
        this.url = url;
        this.account = account;
        this.bird = bird;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public BirdDTO getBird() {
        return bird;
    }

    public void setBird(BirdDTO bird) {
        this.bird = bird;
    }
    
    
}
