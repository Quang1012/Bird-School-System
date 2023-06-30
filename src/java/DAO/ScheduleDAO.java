/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.AccountDTO;
import DTO.BirdDTO;
import DTO.ClassDTO;
import DTO.ScheduleDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.DBContext;

public class ScheduleDAO implements Serializable {

    // Insert a schedule into the database
//    public static int insertSchedule(ScheduleDTO schedule) throws SQLException {
//        Connection con = null;
//        PreparedStatement statement = null;
//        int result = 0;
//        try {
//            con = DBContext.getConnection();
//            if (con != null) {
//                statement = con.prepareStatement("INSERT INTO dbo.tblSchedule (birdId, date, slot, coachId, classId) VALUES (?, ?, ?, ?, ?)");
//                statement.setInt(1, schedule.getBirdId());
//                statement.setDate(2, java.sql.Date.valueOf(schedule.getDate()));
//                statement.setInt(3, schedule.getSlot());
//                statement.setInt(4, schedule.getCoachId());
//                statement.setInt(5, schedule.getClassId());
//                statement.executeUpdate();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (statement != null) {
//                statement.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
//        return result;
//    }
    public List<ScheduleDTO> getSchedulesByID(int accountID) throws SQLException {
        List<ScheduleDTO> listSchedule = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement("SELECT b.birdID ,b.birdName, a.name, s.date, s.slot, cl.classname\n"
                        + "FROM dbo.tblSchedule s\n"
                        + "INNER JOIN dbo.tblCoach c ON c.coachID = s.coachID\n"
                        + "INNER JOIN dbo.tblClass cl ON cl.classID = s.classID\n"
                        + "INNER JOIN dbo.tblBird b ON b.birdID = s.birdID\n"
                        + "INNER JOIN dbo.tblAccount a ON a.accountID = b.accountID\n"
                        + "WHERE c.accountID = ?;");
                stm.setInt(1, accountID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    BirdDTO bird = new BirdDTO();
                    ClassDTO classs = new ClassDTO();
                    AccountDTO acc = new AccountDTO();
                    bird.setBirdID(rs.getInt("birdID"));
                    bird.setBirdName(rs.getString("birdName"));
                    acc.setName(rs.getString("name"));
                    java.sql.Date date = rs.getDate("date");
                    int slot = rs.getInt("slot");
                    classs.setClassname(rs.getString("classname"));
                    bird.setBirdName(rs.getString("birdName"));
                    ScheduleDTO sche = new ScheduleDTO(bird,acc,date,slot,classs);
                    listSchedule.add(sche);
                }
            }
        } catch (Exception e) {
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
        return listSchedule;
    }

//    public List<ScheduleDTO> getSchedules() throws SQLException {
//        List<ScheduleDTO> schedules = new ArrayList<>();
//        Connection con = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        try {
//            con = DBContext.getConnection();
//            if (con != null) {
////                stm = con.prepareStatement("SELECT * FROM dbo.tblSchedule ");
//                stm = con.prepareStatement("SELECT tblSchedule.birdID ,tblSchedule.date,tblSchedule.slot,tblSchedule.coachID,tblSchedule.coachName,tblSchedule.classId, Bird.birdName\n"
//                        + "FROM tblSchedule\n"
//                        + "JOIN Bird ON tblSchedule.birdID = Bird.birdID\n"
//                        + "where tblSchedule.accountID = 4 ");
//                rs = stm.executeQuery();
//                while (rs.next()) {
//                    int birdID = rs.getInt("birdID");
//                    String birdName = rs.getString("birdName");
//                    BirdDTO a = new BirdDTO(birdName);
//                    java.sql.Date date = rs.getDate("date");
//                    int slot = rs.getInt("slot");
//                    int coachId = rs.getInt("coachId");
//                    String coachName = rs.getString("coachName");
//                    int classId = rs.getInt("classId");
//                    ScheduleDTO schedule = new ScheduleDTO(birdID, date, slot, coachId, coachName, classId, a);
//                    schedules.add(schedule);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (stm != null) {
//                stm.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
//        return schedules;
//    }
    public boolean createSchedule(int birdId, Date date, int slot, int coachId, int Class) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement("insert into dbo.tblSchedule(birdID, date, slot, coachID ,classID) values (?,?,?,?,?)");
                stm.setInt(1, birdId);
                stm.setDate(2, (java.sql.Date) date);
                stm.setInt(3, slot);
                stm.setInt(4, coachId);
                stm.setInt(5, Class);
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

//    public static void main(String[] args) throws SQLException {
//        ScheduleDAO scheduleDAO = new ScheduleDAO();
//        LocalDate startDate = LocalDate.now(); // Ngày bắt đầu từ hôm nay
//        List<ScheduleDTO> schedules = scheduleDAO.getSchedules();
//
//        System.out.println(schedules);
//
//    }
}
