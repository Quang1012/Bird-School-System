package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import registrationform.RegistrationFormDAO;
import registrationform.RegistrationFormDTO;

@WebServlet(name = "RegisterFormController", urlPatterns = {"/RegisterFormController"})
public class RegisterFormController extends HttpServlet {

    private static final String SUCCESS = "registrationForm.jsp";
    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = ERROR;
            HttpSession s = request.getSession();
            RegistrationFormDAO r = new RegistrationFormDAO();
            try {
                int courseID = Integer.valueOf(request.getParameter("CID"));
                int accountID = Integer.valueOf(request.getParameter("aID"));
                RegistrationFormDTO course_detail = r.getDetailCourse(courseID);
                List<RegistrationFormDTO> bird_detail = r.listBirdByAccountID(accountID, 1);
                if (course_detail != null && bird_detail != null) {
                    s.setAttribute("DETAIL_COUR", course_detail);
                    s.setAttribute("DETAIL_BIRD", bird_detail);
                    url = SUCCESS;
                } else {
                    url = ERROR;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher(url).forward(request, response);
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