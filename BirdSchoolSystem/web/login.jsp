<%-- 
    Document   : index
    Created on : May 30, 2023, 7:07:33 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div><form action="LoginController" method="post">
                <h1>Login Form</h1>
                <input type="text" name="email" placeholder="Email"><br>
                <input type="password" name="password" placeholder="Password"><br>
                <input type="submit" value="Login">
                ${mess}
            </form>
        </div>
    </body>
</html>
