/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class BirdCategoryDTO {
    private int categoriesID;
    private String categoriesName;

    public BirdCategoryDTO() {
    }

    public BirdCategoryDTO(int categoriesID, String categoriesName) {
        this.categoriesID = categoriesID;
        this.categoriesName = categoriesName;
    }

    public int getCategoriesID() {
        return categoriesID;
    }

    public void setCategoriesID(int categoriesID) {
        this.categoriesID = categoriesID;
    }

    public String getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
    }
    
}
