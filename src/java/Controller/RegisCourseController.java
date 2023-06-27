/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BirdDAO;
import DAO.ClassDAO;
import DAO.CoachDAO;
import DAO.ScheduleDAO;
import DTO.BirdDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import registrationform.RegistrationFormDAO;

/**
 *
 * @author PC
 */
@WebServlet(name = "RegisCourseController", urlPatterns = {"/RegisCourseController"})
public class RegisCourseController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int accountID = Integer.parseInt(request.getParameter("accountID"));
            int slot = Integer.parseInt(request.getParameter("slotDropdown"));
            int birdCategoriesID = Integer.valueOf(request.getParameter("birdCategories"));
            int birdWeight = Integer.parseInt(request.getParameter("txtBirdWeight"));
            int birdHeight = Integer.parseInt(request.getParameter("txtBirdHeight"));
            String birdColor = request.getParameter("txtBirdColor");
            String birdPhoto = request.getParameter("birdPhoto");
            String birdName = request.getParameter("txtBirdName");
            String mess = "";
            String url = "";
            
            CoachDAO coachdao = new CoachDAO();
            BirdDAO birddao = new BirdDAO();
            ClassDAO classdao = new ClassDAO();
            ScheduleDAO schedao = new ScheduleDAO();
            RegistrationFormDAO reDao = new RegistrationFormDAO();

            List<Integer> listCoachId = coachdao.getListCoachId();
//            System.out.println(listCoachId.size());
            boolean check = birddao.addBird(accountID, birdName, birdHeight, birdWeight, birdColor, birdCategoriesID, null, birdPhoto, 1);
            if (check) {
                BirdDTO bird = birddao.getBirdInactiveByAccountID(accountID);
                int birdId = bird.getBirdID();
                Random random = new Random();
                int coachID;
                if (listCoachId.size() >= 2) {
                    int index = random.nextInt(listCoachId.size() - 1);
                    coachID = listCoachId.get(index);
                } else if (listCoachId.isEmpty()) {
                    coachID = 1;
                } else {
                    coachID = listCoachId.get(0);
                }
                int courseId = Integer.parseInt(request.getParameter("courseID"));
                String name = "class" + coachID;
                String typeOfclass = "Offline";
                reDao.createRegisForm(courseId, accountID, birdId, name, courseId);
                boolean kaka = classdao.createClass(courseId, name, typeOfclass, 0, coachID, birdId);
                if (kaka) {
                    birddao.setBirdActive(birdId);
                    int classID = classdao.getClassByBirdID(birdId);
                    LocalDate localdate = LocalDate.now();
                    java.sql.Date date = java.sql.Date.valueOf(localdate);
                    boolean huhu = schedao.createSchedule(birdId, date, slot, coachID, classID);
                    if (huhu) {
                        if (coachID != 1) {
                            coachdao.setCoachActive(coachID);
                        }else{
                            return;
                        }
                        mess = "Regis Successfull";
                    } else {
                        mess = "Regis Fail";
                    }
                }
                request.setAttribute("mess", mess);
                url = "MainController?id=" + courseId + "&action=ENROLL_COURSE";
                request.getRequestDispatcher(url).forward(request, response);
            }
            out.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
