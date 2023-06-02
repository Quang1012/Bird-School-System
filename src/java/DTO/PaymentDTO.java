/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class PaymentDTO {
    private int paymentID;
    private int courseID;
    private int accountID;
    private float total;

    public PaymentDTO() {
    }

    public PaymentDTO(int paymentID, int courseID, int accountID, float total) {
        this.paymentID = paymentID;
        this.courseID = courseID;
        this.accountID = accountID;
        this.total = total;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
}
