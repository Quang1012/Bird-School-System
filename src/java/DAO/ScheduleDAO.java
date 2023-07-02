/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ScheduleDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.DBContext;

public class ScheduleDAO implements Serializable {

    private final String USER = "select aa.birdID , bb.birdName , bb.coachID , bb.classID , bb.slot from\n"
            + "(select a.accountID , b.birdID from dbo.tblAccount a join dbo.tblBird b on a.accountID = b.accountID where b.accountID = ?) aa\n"
            + "join (select c.birdID , c.birdName ,s.classID , s.slot , s.date, s.coachID from dbo.tblBird c join dbo.tblSchedule s on c.birdID = s.birdID) bb\n"
            + "on aa.birdID = bb.birdID";
    private final String STAFF = "select b.birdID , b.birdName , s.coachID , s.classID , s.slot , s.date from dbo.tblBird b join dbo.tblSchedule s on b.birdID = s.birdID";
    private final String COACH = "select aa.name , aa.coachID  , bb.birdID  , bb.birdName , bb.slot , bb.date from  \n"
            + "(select a.name , c.coachID , a.accountID from dbo.tblAccount a join dbo.tblCoach c on a.accountID = c.accountID where a.accountID = ?) aa \n"
            + "join (select b.birdID , b.birdName ,s.classID , s.slot , s.date, s.coachID from dbo.tblBird b join dbo.tblSchedule s on b.birdID = s.birdID) bb\n"
            + "on aa.coachID = bb.coachID";

    public List<ScheduleDTO> getSchedules(String accountID) throws SQLException {
        List<ScheduleDTO> schedules = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                //get role of account int db
                stm = con.prepareCall("select role from dbo.tblAccount where accountID = ? ");
                stm.setString(1, accountID);
                rs = stm.executeQuery();
                int role = 0;
                while (rs.next()) {
                    role = rs.getInt(1);
                }
                //get schedule by role of account 
                if (role == 0) {
                    stm = con.prepareStatement(USER);
                    stm.setString(1, accountID);
                } else if (role == 4) {
                    stm = con.prepareStatement(COACH);
                    stm.setString(1, accountID);
                } else {
                    stm = con.prepareStatement(STAFF);
                }
                rs = stm.executeQuery();
                while (rs.next()) {
                    schedules.add(new ScheduleDTO(rs.getInt(1),
                            rs.getDate(6),
                            rs.getInt(5),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getString(2)));
                }
            } else {
                return null;
            }
        } catch (ClassNotFoundException | SQLException e) {
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
        } catch (ClassNotFoundException | SQLException e) {
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
}
