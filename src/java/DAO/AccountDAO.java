package DAO;

import DTO.AccountDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBContext;

public class AccountDAO implements Serializable {

    private static final String GET_ALL = "SELECT accountID, email, password, name, profilePhoto, role, phone, accountStatus FROM dbo.tblAccount WHERE role != 2";
    private static final String REGISTER = "INSERT INTO dbo.tblAccount(email, password, name, profilePhoto, role, phone, accountStatus) VALUES(?,?,?,?,?,?,?)";
    private static final String LOGIN = "SELECT accountID, email, password, name, profilePhoto, role, phone, accountStatus FROM dbo.tblAccount WHERE email = ? COLLATE SQL_Latin1_General_CP1_CS_AS AND password = ? ";
    private static final String CHECK_DUPLICATE = "SELECT email FROM dbo.tblAccount WHERE email = ? COLLATE SQL_Latin1_General_CP1_CS_AS";
    private static final String UPDATE_ACCOUNT = "UPDATE dbo.tblAccount SET name= ? , email = ? ,password = ?, phone = ? WHERE accountID = ? ";
    private static final String DELETE_ACCOUNT = "ALTER TABLE dbo.tblBlog\n"
            + "DROP CONSTRAINT account;"
            + "DELETE FROM dbo.tblAccount WHERE accountID = ?";
    private static final String GET_ALL_BY_ID = "SELECT accountID, email, password, name, profilePhoto, role, phone, accountStatus FROM dbo.tblAccount WHERE accountID = ? ";
    private static final String UPDATE_ACCOUNT_NEW = "UPDATE Account SET email= ?, password = ?, name = ?, phone = ?  WHERE accountID = ? ";
    private static final String DASHBOARD = "SELECT COUNT(AccountID) as AccountID\n"
            + "FROM dbo.tblAccount";
    private static final String CHECK_ACCOUNT_BY_EMAIL = "SELECT accountID,email,password,phone FROM dbo.tblAccount WHERE email = ?";
    private static final String FIND_ACCOUNT_BY_OPTION = "SELECT * FROM dbo.tblAccount\n";
    private static final String RESET_ACCOUNT_PASSWORD = "UPDATE Account SET password = ? WHERE accountID = ?";
    private static final String BAN_ACCOUNT = "UPDATE dbo.tblAccount SET accountStatus = ? WHERE accountID = ?";
    private static final String GET_ACCOUNT_BY_BIRDID = "select accountID from dbo.tblBird where birdID = ?";

    public int countAccount() throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int count = 0;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(DASHBOARD);
                rs = stm.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("AccountID");
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
    
    public AccountDTO getAccountByBird(int birdID) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if(con != null){
                stm = con.prepareStatement(GET_ACCOUNT_BY_BIRDID);
                stm.setInt(1, birdID);
                rs = stm.executeQuery();
                if(rs.next()){
                    int accID = rs.getInt("accountID");
                    AccountDTO acc = new AccountDTO(accID);
                    return acc;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
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

    public static ArrayList<AccountDTO> findAccByOption(String txtSearch, String searchBy) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<AccountDTO> list = new ArrayList<>();
        try {
            con = DBContext.getConnection();
            if (con != null) {
                String sql = FIND_ACCOUNT_BY_OPTION;
                if (searchBy.equalsIgnoreCase("byName")) {
                    sql = sql + "where name like ?";
                } else if (searchBy.equalsIgnoreCase("byEmail")) {
                    sql = sql + "where email like ?";
                } else {
                    sql = sql + "where phone like ?";
                }
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + txtSearch + "%");
                rs = stm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int accountID = rs.getInt("accountID");
                        String name = rs.getString("name");
                        String email = rs.getString("email");
                        String password = rs.getString("password");
                        String phone = rs.getString("phone");
                        int accountStatus = rs.getInt("accountStatus");
                        AccountDTO acc = new AccountDTO(accountID, name, email, password, phone, accountStatus);
                        list.add(acc);
                    }
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

    

    public AccountDTO getByID(int accountID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(GET_ALL_BY_ID);
                stm.setInt(1, accountID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    AccountDTO acc = new AccountDTO();
                    acc.setAccountID(rs.getInt(1));
                    acc.setEmail(rs.getString(2));
                    acc.setPassword(rs.getString(3));
                    acc.setName(rs.getString(4));
                    acc.setProfilePhoto(rs.getString(5));
                    acc.setRole(rs.getInt(6));
                    acc.setPhone(rs.getString(7));
                    acc.setAccountStatus(rs.getInt(8));
                    return acc;
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

    public static List<AccountDTO> getAllAccount() throws SQLException {
        List<AccountDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(GET_ALL);
                rs = stm.executeQuery();
                while (rs.next()) {
                    AccountDTO acc = new AccountDTO();
                    acc.setAccountID(rs.getInt(1));
                    acc.setEmail(rs.getString(2));
                    acc.setPassword(rs.getString(3));
                    acc.setName(rs.getString(4));
                    acc.setProfilePhoto(rs.getString(5));
                    acc.setRole(rs.getInt(6));
                    acc.setPhone(rs.getString(7));
                    acc.setAccountStatus(rs.getInt(8));
                    list.add(acc);
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

    public AccountDTO checkAccountByEmail(String email) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        AccountDTO acc = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(CHECK_ACCOUNT_BY_EMAIL);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int accountID = rs.getInt("accountID");
                    String nemail = rs.getString("email");
                    String password = rs.getString("password");
                    String phone = rs.getString("phone");
                    acc = new AccountDTO(accountID, nemail, password, phone);
                    return acc;
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

    public AccountDTO checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        AccountDTO acc = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(LOGIN);
                stm.setString(1, email);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int accountID = rs.getInt("accountID");
                    String nemail = rs.getString("email");
                    String npassword = rs.getString("password");
                    String name = rs.getString("name");
                    String profilePhoto = rs.getString("profilePhoto");
                    int accountStatus = rs.getInt("accountStatus");
                    int role = rs.getInt("role");
                    String phone = rs.getString("phone");
                    acc = new AccountDTO(accountID, nemail, npassword, name, profilePhoto, role, phone, accountStatus);
                    return acc;
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

    public boolean insertAccount(AccountDTO acc) throws SQLException {
        boolean check = true;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(REGISTER);
                stm.setString(1, acc.getEmail());
                stm.setString(2, acc.getPassword());
                stm.setString(3, acc.getName());
                stm.setString(4, acc.getProfilePhoto());
                stm.setInt(5, acc.getRole());
                stm.setString(6, acc.getPhone());
                stm.setInt(7, acc.getAccountStatus());
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

    public boolean checkDuplicate(String email) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(CHECK_DUPLICATE);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }

    public boolean updateAccount(String name, String email, String password, String phone, int id) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(UPDATE_ACCOUNT);
                stm.setString(1, name);
                stm.setString(2, email);
                stm.setString(3, password);
                stm.setString(4, phone);
                stm.setInt(5, id);
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

    public boolean deleteAccount(int accountID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(DELETE_ACCOUNT);
                stm.setInt(1, accountID);
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

    public static int updateAccount(String email, String name, int phone, String password, int accountID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        int result = 0;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(UPDATE_ACCOUNT_NEW);
                stm.setString(1, email);
                stm.setString(2, password);
                stm.setString(3, name);
                stm.setInt(4, phone);
                stm.setInt(5, accountID);
                result = stm.executeUpdate();
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
        return result;
    }

//    public static boolean updateAccountPassword( String password,int id) throws SQLException {
//        Connection con = null;
//        PreparedStatement stm = null;
//        int result = 0;
//        try {
//            con = DBContext.getConnection();
//            if (con != null) {
//                stm = con.prepareStatement(UPDATE_ACCOUNT_NEW);
//                stm.setString(1, password);
//                stm.setInt(2, id);
//                result = stm.executeUpdate();
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
//        return result;
//    }
    public boolean updateAccountPassword(String password, int id) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(RESET_ACCOUNT_PASSWORD);
                stm.setString(1, password);
                stm.setInt(2, id);
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

    public boolean banAccount(int id, int status) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(BAN_ACCOUNT);
                stm.setInt(1, status);
                stm.setInt(2, id);
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
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
