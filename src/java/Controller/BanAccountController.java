/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "BanAccountController", urlPatterns = {"/BanAccountController"})
public class BanAccountController extends HttpServlet {
    private static final String FAIL = "error.jsp";
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
            int Id = Integer.parseInt(request.getParameter("userId"));
            int status = Integer.parseInt(request.getParameter("accountStatus"));
            String lastSearchValue = request.getParameter("lastSearchValue");
            String searchByValue = request.getParameter("searchByValue");
            AccountDAO accDao = new AccountDAO();
            String url = "";
            boolean check;
            if(status == 1){
                check = accDao.banAccount(Id, 0);
                if(check){
                    url = "MainController?action=SEARCH&txtSearch=" + lastSearchValue + "&searchBy=" + searchByValue;
                }else{
                    url= FAIL;
                }
            }else{
                check = accDao.banAccount(Id, 1);
                if(check){
                    if(!lastSearchValue.trim().isEmpty() && !lastSearchValue.trim().isBlank() && !searchByValue.trim().isEmpty() && !searchByValue.trim().isBlank()){
                        url = "MainController?action=SEARCH&txtSearch=" + lastSearchValue + "&searchBy=" + searchByValue;
                    }else{
                        url = "MainController?action=LISTALLACCOUNT";
                    }
                }else{
                    url= FAIL;
                }
            }
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
