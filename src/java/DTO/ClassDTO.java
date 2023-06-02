/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class ClassDTO {
    private int classID;
    private int courseID;
    private String classname;
    private String typeofclass;
    private String address;
    private int classStatus;

    public ClassDTO() {
    }

    public ClassDTO(int classID, int courseID, String classname, String typeofclass, String address, int classStatus) {
        this.classID = classID;
        this.courseID = courseID;
        this.classname = classname;
        this.typeofclass = typeofclass;
        this.address = address;
        this.classStatus = classStatus;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getTypeofclass() {
        return typeofclass;
    }

    public void setTypeofclass(String typeofclass) {
        this.typeofclass = typeofclass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(int classStatus) {
        this.classStatus = classStatus;
    }
    
    
}
