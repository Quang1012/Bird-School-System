package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

    //link to jsp
    private static final String HOME_PAGE = "homePage.jsp";
    private static final String MANAGE_ACCOUNT_PAGE = "manageAccount.jsp";
    private static final String MANAGE_COURSE_PAGE = "adminCourseManagement.jsp";
    private static final String ABOUT_US_PAGE = "about.jsp";

    //value of action of User
    private static final String LOGIN = "Login";
    private static final String REGISTER = "Register";
    private static final String LOGOUT = "Logout";
    private static final String REGISTER_FORM = "RegisterForm";
    private static final String LOAD_BIRD = "BIRD";
    private static final String HOME_USER = "HOME_USER";
    private static final String HOME_GUEST = "HOME_GUEST";
    private static final String LOAD_BIRD_BY_ID = "LoadBirdByAccountID";
    private static final String UPDATE = "UPDATE";
    private static final String LOAD_ACCOUNT = "ProfileLoad";
    private static final String ADD_BIRD = "addBird";
    private static final String GET_BIRD_UPDATE_USER = "getBirdUpdate";
    private static final String UPDATE_BIRD_PAGE = "UPDATE_BIRD_PAGE";
    private static final String LOAD_BLOG = "BLOG";
    private static final String LOAD_BLOG_DETAIL = "BlogDetail";
    private static final String SUBMIT_FEEDBACK = "Submit Feedback";
    private static final String PASSWORD_FORGOT_SEARCH = "forgotPaasswordSearch";
    private static final String PASSWORD_RESET = "resetPasswordUpdate";
    private static final String SEARCH_ACCOUNT = "SEARCH_ACCOUNT";
    private static final String LISTALLACCOUNT = "LISTALLACCOUNT";
    private static final String ABOUT_US = "ABOUT_US";
    private static final String USER_BLOG = "USER_BLOG";
    private static final String LIST_COURSE_FOR_USER = "LIST_COURSE_FOR_USER";
    private static final String ENROLL_COURSE = "ENROLL_COURSE";
    private static final String SUBMIT_REGIS_FORM = "SUBMIT_REGIS_FORM";
    private static final String SEND_REPORT = "SEND_REPORT";
    private static final String VIEW_REPORT_PAGE = "VIEW_REPORT_PAGE";
    
    //value of action of Admin
    private static final String MANAGE_ACCOUNT = "MANAGE_ACCOUNT";
    private static final String MANAGE_BIRD = "MANAGE_BIRD";
    private static final String LOAD_BIRD_CATEGORY = "LOAD_BIRD_CATEGORY";
    private static final String SEARCHBIRD = "SEARCHBIRD";

    private static final String LOAD_FORM_DETAIL = "LOAD_FORM_DETAIL";
    private static final String LOAD_BLOGS_MANGEMENT = "MANAGE_BLOG";
    private static final String DELETE_BLOGS = "DELETE_BLOGS";
    private static final String ADD_BLOGS = "AddNewBlog";
    private static final String UPDATE_BLOGS = "UPDATE_BLOGS";
    private static final String UPDATE_ACCOUNT = "Update_Account";
    private static final String DELETE_ACCOUNT = "DELETE_ACCOUNT";
    private static final String LOAD_FEEDBACK = "LOAD_FEEDBACK";
    private static final String DASHBOARD = "DASHBOARD";
    private static final String BAN_ACCOUNT = "BAN_ACCOUNT";
    private static final String MANAGE_COURSE = "MANAGE_COURSE";
    private static final String LIST_COURSE = "LIST_COURSE";
    private static final String UPDATE_COURSE = "UPDATE_COURSE";
    private static final String BIRD_DETAIL = "BIRD_DETAIL";
    private static final String ACCOUNT_DETAIL = "Detail";
    private static final String UPDATE_BIRD = "UPDATE_BIRD";
    private static final String REPORT_PAGE = "REPORT_PAGE";

    //link to servlet of User
    private static final String LOAD_HOME_PAGE = "LoadHomePageController";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String REGISTER_CONTROLLER = "RegisterController";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String REGISTER_FORM_CONTROLLER = "RegisterFormController";
    private static final String LOAD_ACCOUNT_DETAIL_CONTROLLER = "LoadProfileController";
    private static final String DELETE_ACCOUNT_CONTROLLER = "DeleteAccountController";
    private static final String ADD_BIRD_CONTROLLER = "AddBirdController";
    private static final String GET_BIRD_UPDATE_CONTROLLER = "LoadBirdUpdateController";
    private static final String UPDATE_BIRD_CONTROLLER = "UpdateBirdController";
    private static final String LOAD_BLOG_CONTROLLER = "LoadBlogController";
    private static final String LOAD_BLOG_DETAIL_CONTROLLER = "LoadBlogDetailController";
    private static final String SUBMIT_FEEDBACK_CONTROLLER = "SubmitFeedbackController";
    private static final String LOAD_PASSWORD_FORGOT_CONTROLLER = "checkForgotController";
    private static final String RESET_FORGOT_PASSWORD = "ResetPasswordController";
    private static final String LOAD_MY_BLOG = "LoadMyBlogController";
    private static final String LIST_COURSE_CONTROLLER = "ListCourseController";
    private static final String LIST_COURSE_USER = "ListCourseUserController";
    private static final String SEARCH_COURSE = "SEARCH_COURSE";
    private static final String ADD_TO_CART = "AddCourseToCartController";
    private static final String DETAIL_AND_REGISCOURSE = "DetailAndRegisterCourseController";
    private static final String REGIS_COURSE_CONTROLLER = "RegisCourseController";
    private static final String REPORT_PAGE_CONTROLLER = "ReportPageController";
    private static final String VIEW_REPORT_CONTROLLER = "ViewReportController";
    
    // link to servlet of Admin
    private static final String COUNT_ACCOUNT = "COUNT_ACCOUNT";
    private static final String LIST_ALL_ACCOUNT = "ListAllAccountController";
    private static final String SEARCH = "SEARCH";
    private static final String SEARCH_ACCOUNT_BY_OPTION = "SearchAccountController";
    private static final String COUNT_ACCOUNT_CONTROLLER = "CountAccountController";
    private static final String LOAD_BIRD_CONTROLLER = "LoadBirdController";
    private static final String LOAD_UPDATE_BIRD_CONTROLLER = "LoadBirdUpdateController";
    private static final String UPDATE_ACCOUNT_ALL_ROLE = "UpdateAccountController";
    private static final String BAN_ACCOUNT_CONTROLLER = "BanAccountController";
    private static final String UPDATE_COURSE_CONTROLLER = "AdminUpdateCourseController";
    private static final String BIRD_DETAIL_CONTROLLER = "BirdDetailController";
    private static final String ACCOUNT_DETAIL_CONTROLLER = "AccountDetailController";
    private static final String SEARCH_BIRD_CONTROLLER = "SearchBirdController";
    private static final String SEARCH_COURSE_BY_OPTION = "SearchCourseByOptionController";
    private static final String SEND_REPORT_CONTROLLER = "SendReportController";

    private static final String LOAD_BIRD_CATEGORY_CONTROLLER = "LoadBirdCategoryController";
    private static final String LOAD_FORM_DETAIL_CONTROLLER = "LoadFormDetailController";
    private static final String LOAD_BLOGS_MANGEMENT_CONTROLLER = "LoadBlogControllerManageController";
    private static final String DELETE_BLOGS_CONTROLLER = "DeleteBlogsController";
    private static final String ADD_BLOGS_CONTROLLER = "AddBlogsController";
    private static final String LOAD_UPDATE_BLOGS_CONTROLLER = "LoadUpdateBlogsController";
    private static final String UPDATE_BLOGS_CONTROLLER = "UpdateBlogsController";
    private static final String LOAD_FEEDBACK_CONTROLLER = "LoadFeedbackController";
    private static final String LOAD_DASHBOARD_CONTROLLER = "LoadDashboardController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOAD_HOME_PAGE;
        try {
            String action = request.getParameter("action");
            if (action == null) {
                url = LOAD_HOME_PAGE;
            } else {
                switch (action) {
                    case LOGIN:
                        url = LOGIN_CONTROLLER;
                        break;
                    case REGISTER:
                        url = REGISTER_CONTROLLER;
                        break;
                    case LOGOUT:
                        url = LOGOUT_CONTROLLER;
                        break;
                    case HOME_USER:
                        url = HOME_PAGE;
                        break;
                    case HOME_GUEST:
                        url = HOME_PAGE;
                        break;
                    case MANAGE_ACCOUNT:
                        url = LIST_ALL_ACCOUNT;
                        break;
                    case SEARCH_ACCOUNT:
                        url = MANAGE_ACCOUNT_PAGE;
                        break;
                    case MANAGE_COURSE:
                        url = MANAGE_COURSE_PAGE;
                        break;
                    case ABOUT_US:
                        url = ABOUT_US_PAGE;
                        break;
                    case REGISTER_FORM:
                        url = REGISTER_FORM_CONTROLLER;
                        break;
                    case LOAD_BIRD:
                        url = LOAD_BIRD_BY_ID;
                        break;
                    case SEARCHBIRD:
                        url = SEARCH_BIRD_CONTROLLER;
                        break;
                    case SUBMIT_REGIS_FORM:
                        url= REGIS_COURSE_CONTROLLER;
                        break;
                    //function of ManageAccount
                    case COUNT_ACCOUNT:
                        url = COUNT_ACCOUNT_CONTROLLER;
                        break;
                    case SEARCH:
                        url = SEARCH_ACCOUNT_BY_OPTION;
                        break;
                    case LISTALLACCOUNT:
                        url = LIST_ALL_ACCOUNT;
                        break;
                    case UPDATE_ACCOUNT:
                        url = UPDATE_ACCOUNT_ALL_ROLE;
                        break;
                    case DELETE_ACCOUNT:
                        url = DELETE_ACCOUNT_CONTROLLER;
                        break;
                    case BAN_ACCOUNT:
                        url = BAN_ACCOUNT_CONTROLLER;
                        break;
                    case LOAD_ACCOUNT:
                        url = LOAD_ACCOUNT_DETAIL_CONTROLLER;
                        break;
                    case ACCOUNT_DETAIL:
                        url = ACCOUNT_DETAIL_CONTROLLER;
                        break;

                    case SEARCH_COURSE:
                        url = SEARCH_COURSE_BY_OPTION;
                        break;
                    case LIST_COURSE:
                        url = LIST_COURSE_CONTROLLER;
                        break;
                    case UPDATE_COURSE:
                        url = UPDATE_COURSE_CONTROLLER;
                        break;
                    case LIST_COURSE_FOR_USER:
                        url = LIST_COURSE_USER;
                        break;
                    case ENROLL_COURSE:
                        url = DETAIL_AND_REGISCOURSE;
                        break;

                    case MANAGE_BIRD:
                        url = LOAD_BIRD_CONTROLLER;
                        break;
                    case LOAD_BIRD_CATEGORY:
                        url = LOAD_BIRD_CATEGORY_CONTROLLER;
                        break;
                    case ADD_BIRD:
                        url = ADD_BIRD_CONTROLLER;
                        break;
                    case GET_BIRD_UPDATE_USER:
                        url = GET_BIRD_UPDATE_CONTROLLER;
                        break;
                    case UPDATE_BIRD_PAGE:
                        url = LOAD_UPDATE_BIRD_CONTROLLER;
                        break;
                    case BIRD_DETAIL:
                        url = BIRD_DETAIL_CONTROLLER;
                        break;
                    case UPDATE_BIRD:
                        url = UPDATE_BIRD_CONTROLLER;
                        break;

                    case LOAD_BLOG:
                        url = LOAD_BLOG_CONTROLLER;
                        break;
                    case LOAD_BLOG_DETAIL:
                        url = LOAD_BLOG_DETAIL_CONTROLLER;
                        break;
                    case LOAD_BLOGS_MANGEMENT:
                        url = LOAD_BLOGS_MANGEMENT_CONTROLLER;
                        break;
                    case DELETE_BLOGS:
                        url = DELETE_BLOGS_CONTROLLER;
                        break;
                    case ADD_BLOGS:
                        url = ADD_BLOGS_CONTROLLER;
                        break;
                    case UPDATE_BLOGS:
                        url = LOAD_UPDATE_BLOGS_CONTROLLER;
                        break;
                    case UPDATE:
                        url = UPDATE_BLOGS_CONTROLLER;
                        break;
                    case USER_BLOG:
                        url = LOAD_MY_BLOG;
                        break;

                    case SUBMIT_FEEDBACK:
                        url = SUBMIT_FEEDBACK_CONTROLLER;
                        break;
                    case LOAD_FEEDBACK:
                        url = LOAD_FEEDBACK_CONTROLLER;
                        break;
                    case LOAD_FORM_DETAIL:
                        url = LOAD_FORM_DETAIL_CONTROLLER;
                        break;

                    case DASHBOARD:
                        url = LOAD_DASHBOARD_CONTROLLER;
                        break;

                    case PASSWORD_FORGOT_SEARCH:
                        url = LOAD_PASSWORD_FORGOT_CONTROLLER;
                        break;
                    case PASSWORD_RESET:
                        url = RESET_FORGOT_PASSWORD;
                        break;
                    case REPORT_PAGE:
                        url= REPORT_PAGE_CONTROLLER;
                        break;
                    case SEND_REPORT:
                        url = SEND_REPORT_CONTROLLER;
                        break;
                    case VIEW_REPORT_PAGE:
                        url = VIEW_REPORT_CONTROLLER;
                        break;
                }
            }
        } catch (Exception e) {
            log("Error at MainController" + e.toString());
            request.setAttribute("mess", e.toString());
        } finally {
            request.getSession().setAttribute("urlHistory", "MainController");
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

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
