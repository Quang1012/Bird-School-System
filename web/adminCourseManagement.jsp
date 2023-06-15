<%-- 
    Document   : adminCourseManagement
    Created on : Jun 12, 2023, 5:48:22 PM
    Author     : Dell
--%>

<%@page import="java.util.List"%>
<%@page import="DTO.CourseDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Management</title>
    </head>
    <body>
        <header>
            <%@include file="headeradmin.jsp" %>
        </header>
        <div>
            <font color="red">
            <h1>Course Management</h1>
            <%
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    String username = "";
                    for (Cookie cookie : cookies) {
                        String tmp = cookie.getName();
                        if (!tmp.equals("JSESSIONID")) {
                            username = tmp;
                        }
                    }
            %>
            Welcome, <%= username%>
            <%
                }
            %>
            </font>
        </div>
        <form action="MainController">
            List Courses: <br>
            <input type="submit" value="LIST_COURSE" name="action">
        </form>
        <%
            String searchValue = request.getParameter("txtSearchValue");
            List<CourseDTO> result
                    = (List<CourseDTO>) request.getAttribute("SEARCHRESULT");
            if (result != null) {
        %>
        </br>

        <table border="1">
            <thead>
                <tr>
                    <th>Course ID</th>
                    <th>Categories ID</th>
                    <th>Course Name</th>
                    <th>Description</th>
                    <th>Time of course</th>
                    <th>Fee</th>
                    <th>Image</th>
                    <th>Course Status</th>
                    <th>Update</th>
                </tr>
            </thead>
            <%
                for (CourseDTO dto : result) {
            %>
            <tbody>

            <form action="MainController">
                <tr>
                    <td>
                        <%= dto.getCourseID()%>
                        <input type="hidden" name="txtCourseID" value="<%= dto.getCourseID()%>" />
                    </td>

                    <td>
                        <%= dto.getCategoriesID()%>
                        <br/>
                        <input type="text" name="txtCategoriesID" value="<%= dto.getCategoriesID()%>" />
                    </td>

                    <td>
                        <%= dto.getCourseName()%>
                        <br/>
                        <input type="text" name="txtCourseName" value="<%= dto.getCourseName()%>" />

                    </td>
                    <td>
                        <%= dto.getDescription()%>
                        <br/>
                        <input style="width: 99%" type="text" name="txtDescription" value="<%= dto.getDescription()%>" />
                    </td>
                    <td>
                        <%= dto.getTimeOfCourse()%>
                        <br/>
                        <input type="text" name="txtTimeOfCourse" value="<%= dto.getTimeOfCourse()%>" />
                    </td>

                    <td>
                        <%= dto.getFee()%>
                        <br/>
                        <input type="text" name="txtFee" value="<%= dto.getFee()%>" />
                    </td>
                    <td>
                        <img src="Images/<%= dto.getImage()%>" width="42" height="42" style="border:5px solid black"/>

                    </td>
                    <td>
                        <%= dto.getCourseStatus()%>
                        <br/>
                        <input type="text" name="txtCourseStatus" value="<%= dto.getCourseStatus()%>" />

                    </td>
                    <td>
                        <button type='submit' value='UPDATE_COURSE' name='action'>Update</button>
                        <input type='hidden' name='lastSearchValue' value= "<%= request.getParameter("txtSearchValue")%>" />
                    </td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <%
        }
    %>
</body>
</html>
