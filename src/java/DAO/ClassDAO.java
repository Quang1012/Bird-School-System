/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBContext;

/**
 *
 * @author PC
 */
public class ClassDAO {

    public boolean createClass(int courseId, String classname, String typeOfClass, int classStatus, int coachId, int birdId) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement("INSERT INTO dbo.tblClass (courseID, classname, typeofclass, classStatus, coachID, birdID)\n" + "VALUES (?, ?, ?, ?, ?, ?);");
                stm.setInt(1, courseId);
                stm.setString(2, classname);
                stm.setString(3, typeOfClass);
                stm.setInt(4, classStatus);
                stm.setInt(5, coachId);
                stm.setInt(6, birdId);
                check = stm.execute() ? check : !check;
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

    public int getClassByBirdID(int birdID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int classID = 0; // Initialize classID

        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement("SELECT classID FROM dbo.tblClass WHERE birdID = ?");
                stm.setInt(1, birdID);
                rs = stm.executeQuery(); 

                if (rs.next()) { 
                    classID = rs.getInt("classID"); 
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

        return classID;
    }
}
