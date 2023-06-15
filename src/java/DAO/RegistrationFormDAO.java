package registrationform;

import DTO.AccountDTO;
import DTO.CourseDTO;
import DTO.BirdDTO;
//import bird.BirdDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import course.CourseDTO;
import utils.DBContext;

public class RegistrationFormDAO implements Serializable {

    private static final String INSERT_FORM = "INSERT INTO dbo.tblRegistrationForm([courseID],[accountID],[birdID],[formStatus])\n"
            + "VALUES(?,?,?,?)";

    private final static String GET_BIRD_BY_ID = "SELECT b.birdID, b.birdName, b.birdPhoto\n"
            + "FROM dbo.tblBird b\n"
            + "WHERE b.accountID = ? AND b.birdStatus = ?\n"
            + "ORDER BY b.birdID ASC";

    private final static String GET_COURSE_DETAIL = "SELECT DISTINCT t.courseID,t.image, t.courseName, t.courseStatus, FORMAT(CAST(t.dateTime AS datetime),'dd/MM/yyyy HH:mm:ss') AS dateTime, t.fee\n"
            + " FROM  dbo.tblCourse t\n"
            + "WHERE t.courseID =  ?";

    private final static String MY_COURSE = "SELECT r.formID, r.formStatus,t.courseName,r.courseID, t.fee, t.dateTime,t.courseStatus, b.birdPhoto, b.birdName, b.height, b.weight, b.color, a.accountID ,a.phone, a.email, a.name\n"
            + "FROM dbo.tblCourse t\n"
            + "JOIN dbo.tblRegistrationForm r ON t.courseID = r.courseID\n"
            + "JOIN dbo.tblBird b ON b.birdID = r.birdID\n"
            + "JOIN dbo.tblAccount a ON r.accountID = a.accountID\n"
            + " WHERE a.accountID = ?"
            + " ORDER BY t.dateTime DESC";

    private final static String COUNT_COURSE = "SELECT COUNT(*) AS count, formStatus \n"
            + "FROM dbo.tblRegistrationForm WHERE accountID = ?\n"
            + "GROUP BY formStatus";

    public static String NUMBER_CURRENT_REGISTERED = "SELECT COUNT(formID) as numberOfPlayer\n"
            + "FROM dbo.tblRegistrationForm\n"
            + "WHERE formStatus = ? AND courseID = ?";
    private final static String GET_FORM_BY_COURSEID = "SELECT r.formID, r.courseID, a.name, b.birdName, r.formStatus\n"
            + "FROM dbo.tblRegistrationForm r \n"
            + "JOIN dbo.tblAccount a ON r.accountID = a.accountID \n"
            + "JOIN dbo.tblBird b ON r.birdID = b.birdID\n"
            + "WHERE r.courseID = ?";
    private final static String MANAGE_FORM_BY_ID = "UPDATE dbo.tblRegistrationForm \n"
            + "SET formStatus = ?\n"
            + "WHERE formID = ?";
    private final static String FORM_DETAIL_BY_ID = "SELECT r.accountID, r.formID, r.formStatus,t.courseName,r.courseID, t.fee, t.dateTime,t.courseStatus, b.birdPhoto, b.birdName, b.height, b.weight, b.color, a.accountID ,a.phone, a.email, a.name\n"
            + "FROM dbo.tblCourse t\n"
            + "JOIN dbo.tblRegistrationForm r ON t.courseID = r.courseID\n"
            + "JOIN dbo.tblBird b ON b.birdID = r.birdID\n"
            + "JOIN dbo.tblAccount a ON r.accountID = a.accountID\n"
            + "WHERE r.formID = ?\n"
            + "AND t.courseID = ?";

    public boolean manageForm(int formStatus, int formID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(MANAGE_FORM_BY_ID);
                stm.setInt(1, formStatus);
                stm.setInt(2, formID);
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

    public boolean insertForm(int courseID, int accountID, int birdID, int formStatus) throws SQLException {
        RegistrationFormDTO r = null;
        boolean check = true;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(INSERT_FORM);
                stm.setInt(1, courseID);
                stm.setInt(2, accountID);
                stm.setInt(3, birdID);
                stm.setInt(4, formStatus);
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

    public List<RegistrationFormDTO> listBirdByAccountID(int accountID, int birdStatus) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RegistrationFormDTO> list = new ArrayList<>();
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(GET_BIRD_BY_ID);
                stm.setInt(1, accountID);
                stm.setInt(2, birdStatus);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String birdName = rs.getString("birdName");
                    String birdPhoto = rs.getString("birdPhoto");
                    BirdDTO b = new BirdDTO();
                    b.setBirdName(birdName);
                    b.setBirdPhoto(birdPhoto);
                    RegistrationFormDTO r = new RegistrationFormDTO(b);
                    list.add(r);
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

    public RegistrationFormDTO getDetailCourse(int ID) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(GET_COURSE_DETAIL);
                stm.setInt(1, ID);
                rs = stm.executeQuery();

                if (rs.next()) {
                    int courseID = rs.getInt("courseID");
                    String image = rs.getString("image");
                    String courseName = rs.getString("courseName");
                    int courseStatus = rs.getInt("courseStatus");
                    String dateTime = rs.getString("dateTime");
                    String fee = rs.getString("fee");
                    CourseDTO course = new CourseDTO(courseID, image, courseName, courseStatus, dateTime, fee);
                    RegistrationFormDTO r = new RegistrationFormDTO(course);
                    return r;
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
        return null;
    }

    public List<RegistrationFormDTO> MyCourse(int accountID) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RegistrationFormDTO> list = new ArrayList<>();
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(MY_COURSE);
                stm.setInt(1, accountID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int formID = rs.getInt("formID");
                    int formStatus = rs.getInt("formStatus");
                    String courseName = rs.getString("courseName");
                    int courseID = rs.getInt("courseID");
                    String fee = rs.getString("fee");
                    String dateTime = rs.getString("dateTime");
                    int courseStatus = rs.getInt("courseStatus");
                    String birdPhoto = rs.getString("birdPhoto");
                    String birdName = rs.getString("birdName");
                    String height = rs.getString("height");
                    String weight = rs.getString("weight");
                    String color = rs.getString("color");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String name = rs.getString("name");
                    CourseDTO c = new CourseDTO(courseID, courseName, fee, dateTime, courseStatus);                
                    BirdDTO b = new BirdDTO();
                    b.setBirdPhoto(birdPhoto);
                    b.setBirdName(birdName);
                    b.setHeight(height);
                    b.setWeight(weight);
                    b.setColor(color);
                    AccountDTO a = new AccountDTO(accountID, phone, email, name);
                    RegistrationFormDTO r = new RegistrationFormDTO(formID, formStatus, c, b, a);
                    list.add(r);
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

    public int countCourse(int accountID) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int count = 0;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(COUNT_COURSE);
                stm.setInt(1, accountID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("count");
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
        return count;
    }

    public int getNumberRegistered(int formStatus, int courseID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int num = 0;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(NUMBER_CURRENT_REGISTERED);
                stm.setInt(1, formStatus);
                stm.setInt(2, courseID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    num = rs.getInt(1);
                    return num;
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
        return num;
    }

    public List<RegistrationFormDTO> loadFormByCourseID(int courseID) throws SQLException {
        List<RegistrationFormDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(GET_FORM_BY_COURSEID);
                stm.setInt(1, courseID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int formID = rs.getInt("formID");
                    int ncourseID = rs.getInt("courseID");
                    String accName = rs.getString("name");
                    String birdName = rs.getString("birdName");
                    int formStatus = rs.getInt("formStatus");
                    AccountDTO acc = new AccountDTO(accName);
                    CourseDTO course = new CourseDTO();
                    BirdDTO bird = new BirdDTO();
                    bird.setBirdName(birdName);
                    course.setCourseID(courseID);
                    RegistrationFormDTO form = new RegistrationFormDTO(formID, course ,acc, bird, formStatus);
                    list.add(form);
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

    public RegistrationFormDTO getFromDetailByID(int formID, int courseID) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(FORM_DETAIL_BY_ID);
                stm.setInt(1, formID);
                stm.setInt(2, courseID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    formID = rs.getInt("formID");
                    int formStatus = rs.getInt("formStatus");
                    String courseName = rs.getString("courseName");
                    courseID = rs.getInt("courseID");

                    String fee = rs.getString("fee");
                    String dateTime = rs.getString("dateTime");

                    int courseStatus = rs.getInt("courseStatus");
                    String birdPhoto = rs.getString("birdPhoto");
                    String birdName = rs.getString("birdName");
                    String height = rs.getString("height");
                    String weight = rs.getString("weight");
                    String color = rs.getString("color");
                    int accountID = rs.getInt("accountID");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String name = rs.getString("name");
                    CourseDTO course = new CourseDTO(courseID, courseName, fee, dateTime, courseStatus);
                    BirdDTO bird = new BirdDTO(birdPhoto, birdName, height, weight, color);
                    AccountDTO acc = new AccountDTO(accountID, phone, email, name);
                    RegistrationFormDTO r = new RegistrationFormDTO(formID, formStatus, course, bird, acc);
                    return r;
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
        return null;
    }
}
