/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class ScheduleDTO implements Serializable {

    private BirdDTO bird;
    private java.sql.Date date;
    private int slot;
    private int coachId;
    private AccountDTO acc;
    private ClassDTO classs;

    public ScheduleDTO() {
    }

    public ScheduleDTO(BirdDTO bird, Date date, int slot, int coachId, ClassDTO classs) {
        this.bird = bird;
        this.date = date;
        this.slot = slot;
        this.coachId = coachId;
        this.classs = classs;
    }

    public ScheduleDTO(BirdDTO bird, AccountDTO acc, Date date, int slot, ClassDTO classs) {
         this.bird = bird;
         this.acc = acc;
         this.date = date;
         this.slot = slot;
         this.classs = classs;
    }

    public BirdDTO getBird() {
        return bird;
    }

    public void setBird(BirdDTO bird) {
        this.bird = bird;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public ClassDTO getClasss() {
        return classs;
    }

    public void setClasss(ClassDTO classs) {
        this.classs = classs;
    }

    public AccountDTO getAcc() {
        return acc;
    }

    public void setAcc(AccountDTO acc) {
        this.acc = acc;
    }
    
    
    

}
