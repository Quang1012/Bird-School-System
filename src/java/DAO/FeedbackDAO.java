package DAO;
import DTO.AccountDTO;
import DTO.CourseDTO;
import DTO.FeedbackDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBContext;

public class FeedbackDAO implements Serializable {

    private static final String CREATE_FEEDBACK = "INSERT Feedback([accountID], [tournamentID], [body])\n"
            + "VALUES(?,?,?);";
    private static final String LIST_ALL_FEEDBACK = "SELECT f.feedbackID, t.CourseName, a.name, f.body\n"
            + "FROM Feedback f\n"
            + "JOIN Account a ON f.accountID = a.accountID\n"
            + "JOIN Tournament t ON f.tournamentID = t.tournamentID\n"
            + "ORDER BY t.tournamentName";

    public boolean createFeedback(FeedbackDTO feedback) throws SQLException {
        boolean check = true;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(CREATE_FEEDBACK);
                stm.setInt(1, feedback.getAcc().getAccountID());
                stm.setInt(2, feedback.getCourse().getCourseID());
                stm.setString(3, feedback.getBody());
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public List<FeedbackDTO> loadAllFeedback() throws SQLException {
        List<FeedbackDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(LIST_ALL_FEEDBACK);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int feedbackID = rs.getInt("feedbackID");
                    String CourseName = rs.getString("CourseName");
                    String accName = rs.getString("name");
                    String body = rs.getString("body");
                    AccountDTO acc = new AccountDTO(accName);
                    CourseDTO course = new CourseDTO();
                    course.setCourseName(CourseName);
                    FeedbackDTO feedback = new FeedbackDTO(feedbackID, course, acc, body);
                    list.add(feedback);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }
}
