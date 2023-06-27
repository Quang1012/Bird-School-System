
package DTO;

public class FeedbackDTO {

    private int feedbackID;
    private String body;
    private CourseDTO Course;
    private AccountDTO acc;

    public FeedbackDTO() {
    }

    public FeedbackDTO(int feedbackID, CourseDTO tour, AccountDTO acc, String body) {
        this.feedbackID = feedbackID;
        this.body = body;
        this.Course = tour;
        this.acc = acc;
    }

    public CourseDTO getCourse() {
        return Course;
    }

    public void setCourse(CourseDTO Course) {
        this.Course = Course;
    }


    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AccountDTO getAcc() {
        return acc;
    }

    public void setAcc(AccountDTO acc) {
        this.acc = acc;
    }

}
