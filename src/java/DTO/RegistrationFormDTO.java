package registrationform;

import DTO.AccountDTO;
import DTO.BirdDTO;
import DTO.CourseDTO;
//import bird.BirdDTO;
import java.io.Serializable;
//import course.CourseDTO;

public class RegistrationFormDTO implements Serializable {

    private int registrationFormID;
    private int courseID;
    private int accountID;
    private int birdID;
    private int formStatus;
    private BirdDTO bird;
    private CourseDTO cour;
    private AccountDTO acc;

    public RegistrationFormDTO() {
    }

    public RegistrationFormDTO(int formStatus, CourseDTO cour, BirdDTO bird, AccountDTO acc) {
        this.formStatus = formStatus;
        this.cour = cour;
        this.bird = bird;
        this.acc = acc;
    }

    public RegistrationFormDTO(int registrationFormID, int formStatus, CourseDTO cour, BirdDTO bird, AccountDTO acc) {
        this.registrationFormID = registrationFormID;
        this.formStatus = formStatus;
        this.cour = cour;
        this.bird = bird;
        this.acc = acc;
    }

    public RegistrationFormDTO(int registrationFormID, CourseDTO cour, AccountDTO acc, BirdDTO bird, int formStatus) {
        this.registrationFormID = registrationFormID;
        this.cour = cour;
        this.acc = acc;
        this.bird = bird;
        this.formStatus = formStatus;
    }

    public RegistrationFormDTO(int courseID, CourseDTO cour) {
        this.courseID = courseID;
        this.cour = cour;
    }

    public RegistrationFormDTO(BirdDTO bird) {
        this.bird = bird;
    }

    public RegistrationFormDTO(int registrationFormID, int courseID, AccountDTO acc, BirdDTO bird, int formStatus) {
        this.registrationFormID = registrationFormID;
        this.courseID = courseID;
        this.acc = acc;
        this.bird = bird;
        this.formStatus = formStatus;
    }

    public int getRegistrationFormID() {
        return registrationFormID;
    }

    public void setRegistrationFormID(int registrationFormID) {
        this.registrationFormID = registrationFormID;
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

    public int getBirdID() {
        return birdID;
    }

    public void setBirdID(int birdID) {
        this.birdID = birdID;
    }

    public int getFormStatus() {
        return formStatus;
    }

    public void setFormStatus(int formStatus) {
        this.formStatus = formStatus;
    }

    public BirdDTO getBird() {
        return bird;
    }

    public void setBird(BirdDTO bird) {
        this.bird = bird;
    }

    public CourseDTO getTour() {
        return cour;
    }

    public void setTour(CourseDTO cour) {
        this.cour = cour;
    }

    public AccountDTO getAcc() {
        return acc;
    }

    public void setAcc(AccountDTO acc) {
        this.acc = acc;
    }

    @Override
    public String toString() {
        return "RegistrationFormDTO{" + "registrationFormID=" + registrationFormID + ", courseID=" + courseID + ", accountID=" + accountID + ", birdID=" + birdID + ", formStatus=" + formStatus + ", bird=" + bird + ", cour=" + cour + ", acc=" + acc + '}';
    }

}
