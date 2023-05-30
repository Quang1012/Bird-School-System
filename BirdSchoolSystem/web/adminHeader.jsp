<%-- 
    Document   : adminHeader
    Created on : 29-05-2023, 21:18:21
    Author     : Quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
       <body>
        <nav>
            <div>
                <ul>
                    <li>
                        <a href="MainController?action=HOME_GUEST">HOME</a>
                    </li>
                    <li>
                        <div>
                            <a href="MainController?action=MANAGE_ACCOUNT">ACCOUNT</a>
                            <a href="MainController?action=MANAGE_BIRD">BIRD</a>
                            <a href="MainController?action=MANAGE_COURSE">COURSE</a>
                            <a href="MainController?action=MANAGE_BLOG">BLOG</a>
                            <a  href="MainController?action=LOAD_FEEDBACK">FEEDBACK</a>
                        </div>
                    </li>
                </ul>
                <div>
                    <div>
                        <a>Welcome ${sessionScope.acc.getName()}</a>
                        <div>
                            <a  href="MainController?action=ProfileLoad">     Account Setting</a> 
                            <a href="MainController?action=Logout"> Logout</a>
                        </div>
                    </div>
                    <img src="${sessionScope.acc.profilePhoto}" alt="Avatar" class="avatar">
                </div>
            </div>
        </nav>
    </body>
</html>
