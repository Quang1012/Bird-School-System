/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;


/**
 *
 * @author Dell
 */
public class CourseDTO {

    private int CourseID;
    private int categoriesID;
    private String CourseName;
    private String description;
    private String timeOfCourse;
    private String fee;
    private String image;
    private int CourseStatus;

    public CourseDTO() {
    }

    public CourseDTO(int CourseID, String image, String CourseName, int CourseStatus, String timeOfCourse, String fee) {
        this.CourseID = CourseID;
        this.image = image;
        this.CourseName = CourseName;
        this.CourseStatus = CourseStatus;
        this.timeOfCourse = timeOfCourse;
        this.fee = fee;
    }

    public CourseDTO(int CourseID, int categoriesID, String CourseName, String description, String timeOfCourse, String fee, String image, int CourseStatus) {
        this.CourseID = CourseID;
        this.categoriesID = categoriesID;
        this.CourseName = CourseName;
        this.description = description;
        this.timeOfCourse = timeOfCourse;
        this.fee = fee;
        this.image = image;
        this.CourseStatus = CourseStatus;
    }


    public CourseDTO(int courseID, String courseName, String fee, String timeOfCourse, int courseStatus) {
        this.CourseID = courseID;
        this.CourseName = courseName;
        this.fee = fee;
        this.timeOfCourse = timeOfCourse;
        this.CourseStatus = courseStatus;
    }

    public CourseDTO(int courseID,String coursename, int categoriesID, String description, String fee, String image, String timeofcourse) {
        this.CourseID = courseID;
        this.CourseName = coursename;
        this.categoriesID = categoriesID;
        this.description = description;
        this.fee = fee;
        this.image = image;
        this.timeOfCourse = timeofcourse;
    }

    public CourseDTO(int courseID, String description, String fee, int courseStatus, String image, String courseName, String dateTime) {
        this.CourseID = courseID;
        this.description = description;
        this.fee = fee;
        this.CourseStatus = courseStatus;
        this.image = image;
        this.CourseName = courseName;
        this.timeOfCourse = dateTime;
    }

    public String getTimeOfCourse() {
        return timeOfCourse;
    }

    public void setTimeOfCourse(String timeOfCourse) {
        this.timeOfCourse = timeOfCourse;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public int getCategoriesID() {
        return categoriesID;
    }

    public void setCategoriesID(int categoriesID) {
        this.categoriesID = categoriesID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCourseStatus() {
        return CourseStatus;
    }

    public void setCourseStatus(int CourseStatus) {
        this.CourseStatus = CourseStatus;
    }

}
