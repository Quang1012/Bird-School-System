/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CourseDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBContext;

/**
 *
 * @author Dell
 */
public class CourseDAO {

    private List<CourseDTO> listCourses;

    public List<CourseDTO> getListCourses() {
        return listCourses;
    }

    public void listCourse() throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                String sql = "select * from dbo.tblCourse";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int CourseID = rs.getInt("CourseID");
                    int categoriesID = rs.getInt("categoriesID");
                    String CourseName = rs.getString("CourseName");
                    String description = rs.getString("description");
                    String timeOfCourse = rs.getString("timeofcourse");
                    String fee = rs.getString("fee");
                    String image = rs.getString("image");
                    int CourseStatus = rs.getInt("CourseStatus");

                    CourseDTO courseDTO = new CourseDTO(CourseID, categoriesID, CourseName, description ,timeOfCourse, fee, image, CourseStatus);

                    if (listCourses == null) {
                        listCourses = new ArrayList<CourseDTO>();
                    }
                    listCourses.add(courseDTO);
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
    }

    public boolean updateCourse(int CourseID, int categoriesID, String CourseName,
         String description, String timeOfCourse, String fee, int CourseStatus) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                String sql = "update dbo.tblCourse "
                        + "set categoriesID = ? , CourseName = ? , description = ? "
                        + ", timeofcourse = ? "
                        + ", fee = ? , CourseStatus = ? "
                        + "where CourseID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, categoriesID);
                stm.setString(2, CourseName);
                stm.setString(3, description);
                stm.setString(4, timeOfCourse);
                stm.setString(5, fee);
                stm.setInt(6, CourseStatus);
                stm.setInt(7, CourseID);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
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
        return false;
    }
}
