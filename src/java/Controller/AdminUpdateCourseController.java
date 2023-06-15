/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.CourseDAO;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Dell
 */
@WebServlet(name = "AdminUpdateCourseController", urlPatterns = {"/AdminUpdateCourseController"})
public class AdminUpdateCourseController extends HttpServlet {

    private final String updateError = "UpdateError.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {
        String url = updateError;
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/dd/MM");
            int CourseID = Integer.parseInt(request.getParameter("txtCourseID"));
            int categoriesID = Integer.parseInt(request.getParameter("txtCategoriesID"));
            String CourseName = request.getParameter("txtCourseName");
            String description = request.getParameter("txtDescription");          
            String timeOfCourse = request.getParameter("txtTimeOfCourse");
            String fee = request.getParameter("txtFee");
            int CourseStatus = Integer.parseInt(request.getParameter("txtCourseStatus"));
            
            String searchValue = request.getParameter("lastSearchValue");
            CourseDAO dao = new CourseDAO();
            boolean result = dao.updateCourse(CourseID, categoriesID, CourseName, description, timeOfCourse, fee, CourseStatus);
            
            if (result) {
                url = "MainController?action=LIST_COURSE&txtSearchValue="
                        + searchValue;
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } else if (result == false) {
                response.sendRedirect(url);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
             response.sendRedirect(url);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AdminUpdateCourseController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminUpdateCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AdminUpdateCourseController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminUpdateCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
