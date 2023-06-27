/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class ScheduleDTO implements Serializable {

    private int birdId;
    private java.sql.Date date;
    private int slot;
    private int coachId;
    private int classId;
    private String coachName;
    // Constructors, getters, and setters
    private BirdDTO birdName ;
    public ScheduleDTO(int birdId, java.sql.Date date, int slot, int coachId, String coachName, int classId,BirdDTO birdName ) {
        this.birdId = birdId;
        this.date = date;
        this.slot = slot;
        this.coachId = coachId;
        this.classId = classId;
        this.coachName = coachName;
        this.birdName =birdName;
    }

    public ScheduleDTO(int birdId, Date date, int slot, int coachId, int classId, String coachName, BirdDTO birdName) {
        this.birdId = birdId;
        this.date = date;
        this.slot = slot;
        this.coachId = coachId;
        this.classId = classId;
        this.coachName = coachName;
        this.birdName = birdName;
    }

    public BirdDTO getBirdName() {
        return birdName;
    }

    public void setBirdName(BirdDTO birdName) {
        this.birdName = birdName;
    }

  

    public ScheduleDTO() {
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public int getBirdId() {
        return birdId;
    }

    public void setBirdId(int birdId) {
        this.birdId = birdId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ScheduleDTO [birdId=" + birdId + ", date=" + date + ", slot=" + slot + ", coachId=" + coachId + ", classId=" + classId + "]";
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

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

}
