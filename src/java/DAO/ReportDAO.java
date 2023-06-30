/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.AccountDTO;
import DTO.BirdDTO;
import DTO.ReportDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.DBContext;

/**
 *
 * @author PC
 */
public class ReportDAO {
    public boolean insertReport(int accountID, int birdID, Date date, String image, String url, int reportStatus) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            con = DBContext.getConnection();
            if(con != null){
                stm = con.prepareStatement("insert into dbo.tblReport(createTime, image, url, accountID, birdID, reportStatus) values(?,?,?,?,?,?)");
                stm.setDate(1, (java.sql.Date) date);
                stm.setString(2, image);
                stm.setString(3, url);
                stm.setInt(4, accountID);
                stm.setInt(5, birdID);
                stm.setInt(6, reportStatus);
                check = stm.execute() ? check : !check;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return check;
    }
    
    public List<ReportDTO> getListReportByAccountID(int accID) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<ReportDTO> list = new ArrayList<>();
        try {
            con = DBContext.getConnection();
            if(con != null){
                stm = con.prepareStatement("select * from dbo.tblReport where accountID = ?");
                stm.setInt(1, accID);
                rs = stm.executeQuery();
                while(rs.next()){
                   Date date = rs.getDate(1);
                   String image = rs.getString(2);
                   String url = rs.getString(3);
                   AccountDTO acc =new AccountDTO();
                   acc.setAccountID(accID);
                   BirdDTO bird = new BirdDTO();
                   int birdID = rs.getInt(5);
                   bird.setBirdID(birdID);
                   ReportDTO rp = new ReportDTO((java.sql.Date) date, image, url, acc, bird);
                   list.add(rp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return list;
    }
}
