/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class CourseDTO {
    private int courseID;
    private int categoriesID;
    private String description;
    private float fee;
    private String image;
    private int courseStatus;

    public CourseDTO() {
    }

    public CourseDTO(int courseID, int categoriesID, String description, float fee, String image, int courseStatus) {
        this.courseID = courseID;
        this.categoriesID = categoriesID;
        this.description = description;
        this.fee = fee;
        this.image = image;
        this.courseStatus = courseStatus;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getCategoriesID() {
        return categoriesID;
    }

    public void setCategoriesID(int categoriesID) {
        this.categoriesID = categoriesID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(int courseStatus) {
        this.courseStatus = courseStatus;
    }
    
    
}
