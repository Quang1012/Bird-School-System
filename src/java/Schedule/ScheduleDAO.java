/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Schedule;

import bird.BirdDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
    public ScheduleDTO getSchedulesByID(int accountID) throws SQLException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement("SELECT b.birdID , b.date, "
                        + "b.slot,b.coachID,b.coachName,"
                        + "b.classID FROM dbo.tblSchedule b WHERE accountID = ? ");
                stm.setInt(1, accountID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    ScheduleDTO sche = new ScheduleDTO();
                    sche.setBirdId(rs.getInt(1));
                    sche.setDate(rs.getDate(2));
                    sche.setSlot(rs.getInt(3));
                    sche.setCoachId(rs.getInt(4));
                    sche.setCoachName(rs.getString(5));
                    sche.setClassId(rs.getInt(6));
                    return sche;
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
        return null;
    }

    public List<ScheduleDTO> getSchedules() throws SQLException {
        List<ScheduleDTO> schedules = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
//                stm = con.prepareStatement("SELECT * FROM dbo.tblSchedule ");
                stm = con.prepareStatement("SELECT tblSchedule.birdID ,tblSchedule.date,tblSchedule.slot,tblSchedule.coachID,tblSchedule.coachName,tblSchedule.classId, Bird.birdName\n"
                        + "FROM tblSchedule\n"
                        + "JOIN Bird ON tblSchedule.birdID = Bird.birdID\n"
                        + "where tblSchedule.accountID = 1 ");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int birdID = rs.getInt("birdID");
                    String birdName = rs.getString("birdName");
                    BirdDTO a = new BirdDTO(birdName);
                    java.sql.Date date = rs.getDate("date");
                    int slot = rs.getInt("slot");
                    int coachId = rs.getInt("coachId");
                    String coachName = rs.getString("coachName");
                    int classId = rs.getInt("classId");
                    ScheduleDTO schedule = new ScheduleDTO(birdID, date, slot, coachId, coachName, classId, a);
                    schedules.add(schedule);
                }
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
        return schedules;
    }

    public static void main(String[] args) throws SQLException {
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        LocalDate startDate = LocalDate.now(); // Ngày bắt đầu từ hôm nay
        List<ScheduleDTO> schedules = scheduleDAO.getSchedules();

        System.out.println(schedules);

    }
}
