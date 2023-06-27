/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBContext;

/**
 *
 * @author PC
 */
public class CoachDAO {
    
    public List<Integer> getListCoachId() throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Integer> list = new ArrayList<>();
        try {
            con = DBContext.getConnection();
            if(con != null){
                stm = con.prepareStatement("select coachID from dbo.tblCoach where Active = 0 and coachID != 1");
                rs = stm.executeQuery();
                while(rs.next()){
                    int coachId = rs.getInt("coachID");
                    list.add(coachId);
                }
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(con != null){
                con.close();
            }
            if(stm != null){
                stm.close();
            }
            if(rs != null){
                rs.close();
            }
        }
        return list;
    }
    
    public int getCoachByClassID(int classId) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if(con != null){
                stm = con.prepareStatement("select coachID from dbo.tblClass where classID = ?");
                stm.setInt(1, classId);
                stm.execute();
                if(rs != null){
                    int coachID = rs.getInt("coachID");    
                    return coachID;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
            if(rs != null){
                rs.close();
            }
        }
        return 0;
    }
    
    public boolean setCoachActive(int coachID) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            con = DBContext.getConnection();
            if(con != null){
                stm = con.prepareStatement("update dbo.tblCoach set Active = 1 where coachID = ?");
                stm.setInt(1, coachID);
                check = stm.execute() ? check : !check;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
}
