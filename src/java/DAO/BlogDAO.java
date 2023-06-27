package DAO;

import DTO.BlogDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBContext;

public class BlogDAO implements Serializable {

//    private final static String VIEW_BLOG = "SELECT TOP 3 *\n"
//            + "FROM (\n"
//            + "SELECT b.blogID, b.account, b.body, b.title, b.media, FORMAT(CAST(b.createTime AS datetime),'dd/MM/yyyy HH:mm:ss') AS createTime\n"
//            + "FROM dbo.tblBlog b\n"
//            + "WHERE createTime >= CURRENT_TIMESTAMP \n"
//            + "     ) AS subquery\n"
//            + "ORDER BY subquery.createTime ASC";
    private final static String VIEW_BLOG = "SELECT TOP 3 * " +
    "FROM ( " +
    "SELECT b.blogID, b.account, b.body, b.title, b.media, " +
    "CONVERT(varchar, b.createTime, 103) + ' ' + CONVERT(varchar, b.createTime, 108) AS createTime " +
    "FROM dbo.tblBlog b " +
    "WHERE b.createTime >= GETDATE() " +
    ") AS subquery " +
    "ORDER BY subquery.createTime ASC";
    private final static String LIST_BLOG = "SELECT b.blogID, b.accountID, b.body, b.title, b.media, FORMAT(CAST(b.createTime AS datetime),'dd/MM/yyyy HH:mm:ss') AS createTime\n"
            + "FROM dbo.tblBlog b";
    private final static String BLOG_DETAIL = "SELECT b.blogID, b.accountID, b.body, b.title, b.media, FORMAT(CAST(b.createTime AS datetime),'dd/MM/yyyy HH:mm:ss') AS createTime\n"
            + "FROM dbo.tblBlog b\n"
            + "WHERE b.blogID = ?";
    private final static String ANOTHER_DETAIL = "SELECT b.blogID, b.accountID, b.body, b.title, b.media, FORMAT(CAST(b.createTime AS datetime),'dd/MM/yyyy HH:mm:ss') AS createTime\n"
            + "FROM dbo.tblBlog b\n"
            + "WHERE blogID NOT IN (SELECT blogID FROM dbo.tblBlog WHERE blogID = ?);";
    private final static String DELETE_BLOG = "DELETE FROM dbo.tblBlog  \n"
            + "WHERE blogID = ? ";
    private final static String ADD_BLOG = "INSERT INTO dbo.tblBlog([account],[body],[title],[media],[createTime])\n"
            + "VALUES(?,?,?,?,GETDATE());";
    private final static String UPDATE_BLOG = "UPDATE dbo.tblBlog\n"
            + "SET body = ?, title =?, media =?, createTime = GETDATE()\n"
            + "WHERE blogID = ?";
    private final static String DASHBOARD_BLOG = "SELECT COUNT(blogID) as blogID FROM dbo.tblBlog";
    private final static String GET_LIST_USER_BLOG = "select * from dbo.tblBlog where account = ?";

    public static int updateBlog(String Body, String Title, String Media, int blogID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        int result = 0;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(UPDATE_BLOG);
                stm.setString(1, Body);
                stm.setString(2, Title);
                stm.setString(3, Media);
                stm.setInt(4, blogID);
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

    public int addBlog(int accountID, String Body, String Title, String Media) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        int result = 0;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(ADD_BLOG);
                stm.setInt(1, accountID);
                stm.setString(2, Body);
                stm.setString(3, Title);
                stm.setString(4, Media);
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

    public boolean deleteBlog(int blogID) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(DELETE_BLOG);
                stm.setInt(1, blogID);
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
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

    public List<BlogDTO> listAnotherBlog(int blogID) throws Exception {
        List<BlogDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(ANOTHER_DETAIL);
                stm.setInt(1, blogID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int nblogID = rs.getInt("blogID");
                    int accountID = rs.getInt("accountID");
                    String Body = rs.getString("Body");
                    String Title = rs.getString("Title");
                    String Media = rs.getString("Media");
                    String createTime = rs.getString("createTime");
                    BlogDTO blog = new BlogDTO(nblogID, accountID, Body, Title, Media, createTime);
                    list.add(blog);
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

    public BlogDTO getBlogbyID(int blogID) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(BLOG_DETAIL);
                stm.setInt(1, blogID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    BlogDTO blog = new BlogDTO();
                    blog.setBlogID(rs.getInt(1));
                    blog.setAccountID(rs.getInt(2));
                    blog.setBody(rs.getString(3));
                    blog.setTitle(rs.getString(4));
                    blog.setMedia(rs.getString(5));
                    blog.setCreateTime(rs.getString(6));
                    return blog;
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

    public List<BlogDTO> listBlog() throws Exception {
        List<BlogDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(LIST_BLOG);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int blogID = rs.getInt("blogID");
                    int accountID = rs.getInt("accountID");
                    String Body = rs.getString("body");
                    String Title = rs.getString("title");
                    String Media = rs.getString("media");
                    String createTime = rs.getString("createTime");
                    BlogDTO blog = new BlogDTO(blogID, accountID, Body, Title, Media, createTime);
                    list.add(blog);
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

    public List<BlogDTO> viewBlog() throws Exception {
        List<BlogDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(VIEW_BLOG);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int blogID = rs.getInt("blogID");
                    int accountID = rs.getInt("account");
                    String Body = rs.getString("body");
                    String Title = rs.getString("title");
                    String Media = rs.getString("media");
                    String createTime = rs.getString("createTime");
                    BlogDTO blog = new BlogDTO(blogID, accountID, Body, Title, Media, createTime);
                    list.add(blog);
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

    public int countBlog() throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int count = 0;
        try {
            con = DBContext.getConnection();
            if (con != null) {
                stm = con.prepareStatement(DASHBOARD_BLOG);
                rs = stm.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("blogID");
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
    
    public List<BlogDTO> getListUserBlog(int userID){
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<BlogDTO> blogList = new ArrayList<>();
        try {
            con = DBContext.getConnection();
            if(con != null){
                stm = con.prepareStatement(GET_LIST_USER_BLOG);
                stm.setInt(1, userID);
                rs = stm.executeQuery();
                if(rs != null){
                    while(rs.next()){
                        int blogID = rs.getInt("blogID");
                        int accountID = rs.getInt("account");
                        String body = rs.getString("body");
                        String title = rs.getString("title");
                        String media = rs.getString("media");
                        String createTime = rs.getString("createTime");
                        BlogDTO blog = new BlogDTO(blogID, accountID, body, title, media, createTime);
                        blogList.add(blog);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blogList;
    }
}
