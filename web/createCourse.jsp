<%-- 
    Document   : create
    Created on : Jul 3, 2021, 12:08:33 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
        <link href="CSS/create.css" rel="stylesheet" type="text/css"/>
       
    </head>
    <body>
    <head> <jsp:include page="headeradmin.jsp"></jsp:include>  </head>
        <div class="all">
            <div class="passed" id="passed" >
                <form class="pass" action="CreateServlet" method="post" enctype="multipart/form-data">
                    <h1>Create A New CourseOnline</h1>
                <input class="swp" id="file-upload" type="file" name="photo"/>
                    <c:if test="${not empty ErrCreateMsg[0]}" >
                    <div class="alert alert-danger" role="alert">
                        ${ErrCreateMsg[0]}
                    </div>
                    </c:if>
                <input class="swp" type="text" placeholder="Course Name" name="name"/>
                <c:if test="${not empty message or not empty ErrCreateMsg[2]}" >
                <div class="alert alert-danger" role="alert">
                        ${message}                 
                        ${ErrCreateMsg[2]}                  
                </div>
                </c:if>
                <textarea class="swp" placeholder="Description" name="description"></textarea>
                <c:if test="${not empty message or not empty ErrCreateMsg[3]}" >
                <div class="alert alert-danger" role="alert">
                        ${message}                
                        ${ErrCreateMsg[3]}                  
                </div>
                </c:if>
                <c:if test="${not empty message or not empty ErrCreateMsg[4]}" >
                <div class="alert alert-danger" role="alert">
                        ${message}
                        ${ErrCreateMsg[4]}                   
                </div>
                </c:if>
                    <input class="swp" type="text" placeholder="Price" name="Price"/>
                    <c:if test="${not empty message or not empty ErrCreateMsg[1]}" >
                    <div class="alert alert-danger" role="alert">
                        ${message}          
                        ${ErrCreateMsg[1]}
                    </div>
                    </c:if>
                
                <select class="swp"  placeholder="category"  name="category">
                    <c:forEach items="${listCategory}" var="c">
                        <option value="${c.getId()}" ${(c.getId() eq b.getCategoryID().getId()) ? "selected" : ""}>
                            ${c.getName()}
                        </option>
                    </c:forEach>   
                </select>
                <button value="Create" type="submit">Create</button>
            </form>
        </div>
        </div>
    </body>
</html>
