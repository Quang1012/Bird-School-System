package Controller;

import DAO.AccountDAO;
import DTO.AccountDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String ERROR = "homePage.jsp";
    private static final String SUCCESS = "homePage.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = null;
        HttpSession session = request.getSession();
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            AccountDAO adb = new AccountDAO();
            AccountDTO a = adb.checkLogin(email, password);
        
            if (a == null) {
                request.setAttribute("mess", "Wrong email or pass");
                url = ERROR;
            } else {
                if (a.getRole() == 0) {
                    if (a.getAccountStatus() == 1) {
                        session.setAttribute("acc", a);
                        url = SUCCESS;
                    } else {
                        request.setAttribute("mess", "Your account blocked. Please contact Admin !!!!");
                        url = ERROR;
                    }
                } else {
                    session.setAttribute("acc", a);
                    url = SUCCESS;
                }
            }
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
