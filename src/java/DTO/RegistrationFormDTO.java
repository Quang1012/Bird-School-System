package registrationform;

import java.io.Serializable;
import DTO.AccountDTO;
import DTO.BirdDTO;
import DTO.CourseDTO;

public class RegistrationFormDTO implements Serializable {

    private int registrationFormID;
    private int formStatus;
    private BirdDTO bird;
    private CourseDTO course;
    private AccountDTO acc;

    public RegistrationFormDTO() {
    }

    public RegistrationFormDTO(int formStatus, CourseDTO course, BirdDTO bird, AccountDTO acc) {
        this.formStatus = formStatus;
        this.course = course;
        this.bird = bird;
        this.acc = acc;
    }

    public RegistrationFormDTO(int registrationFormID, int formStatus, CourseDTO course, BirdDTO bird, AccountDTO acc) {
        this.registrationFormID = registrationFormID;
        this.formStatus = formStatus;
        this.course = course;
        this.bird = bird;
        this.acc = acc;
    }

    public RegistrationFormDTO(int registrationFormID, CourseDTO course, AccountDTO acc, BirdDTO bird, int formStatus) {
        this.registrationFormID = registrationFormID;
        this.course = course;
        this.acc = acc;
        this.bird = bird;
        this.formStatus = formStatus;
    }

    public RegistrationFormDTO(CourseDTO course) {
        this.course = course;
    }

    public RegistrationFormDTO(BirdDTO bird) {
        this.bird = bird;
    }

    public int getRegistrationFormID() {
        return registrationFormID;
    }

    public void setRegistrationFormID(int registrationFormID) {
        this.registrationFormID = registrationFormID;
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

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public AccountDTO getAcc() {
        return acc;
    }

    public void setAcc(AccountDTO acc) {
        this.acc = acc;
    }

}
