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

                    CourseDTO courseDTO = new CourseDTO(CourseID, categoriesID, CourseName, description, timeOfCourse, fee, image, CourseStatus);

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

    public List<CourseDTO> getCourseByCate(int cateID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CourseDTO> courseList = new ArrayList<>();
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement("select * from dbo.tblCourse where categoriesID = ?");
                stm.setInt(1, cateID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    courseList.add(new CourseDTO(rs.getInt("courseID"), rs.getInt("categoriesID"),
                            rs.getString("coursename"), rs.getString("description"),
                            rs.getString("timeofcourse"), rs.getString("fee"), rs.getString("image"), rs.getInt("courseStatus")));
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
        return courseList;
    }

    public List<CourseDTO> getCourseByName(String name) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CourseDTO> courseList = new ArrayList<>();
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement("select * from dbo.tblCourse where coursename like ?");
                stm.setString(1, "%" + name + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    courseList.add(new CourseDTO(rs.getInt("courseID"), rs.getInt("categoriesID"),
                            rs.getString("coursename"), rs.getString("description"),
                            rs.getString("timeofcourse"), rs.getString("fee"), rs.getString("image"), rs.getInt("courseStatus")));
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
        return courseList;
    }

    public List<CourseDTO> getCourseByPrice(int min, int max) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CourseDTO> courseList = new ArrayList<>();
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement("select * from dbo.tblCourse where fee >= ? and fee <= ?");
                stm.setInt(1, min);
                stm.setInt(2, max);
                rs = stm.executeQuery();
                while (rs.next()) {
                    courseList.add(new CourseDTO(rs.getInt("courseID"), rs.getInt("categoriesID"),
                            rs.getString("coursename"), rs.getString("description"),
                            rs.getString("timeofcourse"), rs.getString("fee"), rs.getString("image"), rs.getInt("courseStatus")));
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
        return courseList;
    }

    public CourseDTO getCourse(int id) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement("select coursename, categoriesID, description,fee,image,timeofcourse from dbo.tblCourse where courseID = ?");
                stm.setInt(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    CourseDTO cour = new CourseDTO(id,rs.getString("coursename"), rs.getInt("categoriesID"),
                            rs.getString("description"), rs.getString("fee"), rs.getString("image"), rs.getString("timeofcourse"));
                    return cour;
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
