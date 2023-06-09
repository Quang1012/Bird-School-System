<%-- 
    Document   : manageAccount
    Created on : Jun 1, 2023, 12:18:33 PM
    Author     : PC
--%>

<%@page import="java.util.List"%>
<%@page import="DTO.AccountDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link href="CSS/manangeAccount.css" rel="stylesheet">
        <link href="CSS/cssss/bootstrap.min.css" rel="stylesheet">
        <link href="CSS/cssss/style.css" rel="stylesheet">
        <link rel="stylesheet" href="CSS/login.css">
    </head>
    <body>
        <header>
            <%@include file="headeradmin.jsp"%>
        </header>
        <section>
            <div>
                <ul>
                    <li><a style="font-size: 20px;" href="MainController?action=LISTALLACCOUNT"><span class="text">List All Account</span></a></li>
                </ul>
            </div>
        </section>
        <div>
            <p>Account Count : ${sessionScope.accCount}</p>
        </div>
        <div>
            <div class="blog_right_sidebar">
                <aside class="single_sidebar_widget search_widget">
                    <form action="MainController" method="post">
                        <input type="text" name="txtSearch" placeholder="Search">
                        <select name="searchBy">
                            <option value="byName">By Name</option>
                            <option value="byEmail">By Email</option>
                            <option value="byPhone">By Phone</option>
                        </select>
                        <input type="submit" name="action" value="SEARCH">
                    </form>
                </aside>
            </div>
        </div>          
        <div>
            <c:set var="acc" value="${requestScope.searchList}"></c:set>
            <c:choose>
                <c:when test="${acc != null}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th style="text-align: center; font-size: 15px;">Id</th>
                                <th style="text-align: center; font-size: 15px;">Name</th>
                                <th style="text-align: center; font-size: 15px;">Email</th>
                                <th style="text-align: center; font-size: 15px;">Password</th>
                                <th style="text-align: center; font-size: 15px;">Phone</th>
                                <th style="text-align: center; font-size: 15px;">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="acc" items="${requestScope.searchList}">
                                <tr>
                                    <td style="text-align: center; font-size: 15px;">
                                        <c:out  value="${acc.getAccountID()}"/>
                                        <input type="hidden" name="userId" value="${acc.getAccountID()}">
                                    </td>
                                    <td style="text-align: center; font-size: 15px;">
                                        <c:out value="${acc.getName()}"/>
                                        <input type="hidden" name="oldname" value="${acc.getName()}">
                                    </td>
                                    <td style="text-align: center; font-size: 15px;">
                                        <c:out value="${acc.getEmail()}"/>
                                        <input type="hidden" name="oldEmail" value="${acc.getEmail()}">
                                    </td>
                                    <td style="text-align: center; font-size: 15px;">
                                        <c:out value="${acc.getPassword()}"/>
                                        <input type="hidden" name="oldPassword" value="${acc.getPassword()}">
                                    </td>
                                    <td style="text-align: center; font-size: 15px;">
                                        <c:out value="${acc.getPhone()}"/>
                                        <input type="hidden" name="oldPhone" value="${acc.getPhone()}">
                                    </td>

                                    <td style="text-align: center; font-size: 15px;">
                                        <a href="#" id="edit">Edit</a>
<!--                                        <a href="MainController?action=DELETE&userId=${acc.getAccountID()}">Delete</a>-->
                                        <c:choose>
                                            <c:when test="${acc.getAccountStatus() == 1}">
                                                <a href="MainController?action=BAN_ACCOUNT&userId=${acc.getAccountID()}&accountStatus=${acc.getAccountStatus()}&lastSearchValue=${requestScope.lastSearchValue}&searchByValue=${requestScope.searchByValue}">Block</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="MainController?action=BAN_ACCOUNT&userId=${acc.getAccountID()}&accountStatus=${acc.getAccountStatus()}&lastSearchValue=${requestScope.lastSearchValue}&searchByValue=${requestScope.searchByValue}">UnBlock</a>
                                            </c:otherwise>
                                        </c:choose>
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <c:out value="${mess}"></c:out>
                </c:otherwise>
            </c:choose>
        </div>
        <div>
            <c:set var="acc" value="${requestScope.allAcc}"></c:set>
            <c:choose>
                <c:when test="${acc != null}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th style="text-align: center; font-size: 15px;">Id</th>
                                <th style="text-align: center; font-size: 15px;">Name</th>
                                <th style="text-align: center; font-size: 15px;">Email</th>
                                <th style="text-align: center; font-size: 15px;">Password</th>
                                <th style="text-align: center; font-size: 15px;">Phone</th>
                                <th style="text-align: center; font-size: 15px;">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="acc" items="${requestScope.allAcc}">
                                <tr>
                                    <td style="text-align: center; font-size: 15px;">
                                        <c:out value="${acc.getAccountID()}"/>
                                    </td>
                                    <td style="text-align: center; font-size: 15px;">
                                        <c:out value="${acc.getName()}"/>
                                    </td>
                                    <td style="text-align: center; font-size: 15px;">
                                        <c:out value="${acc.getEmail()}"/>
                                    </td>
                                    <td style="text-align: center; font-size: 15px;">
                                        <c:out value="${acc.getPassword()}"/>
                                    </td>
                                    <td style="text-align: center; font-size: 15px;">
                                        <c:out value="${acc.getPhone()}"/>
                                    </td>

                                    <td style="text-align: center; font-size: 15px;">
                                        <a href="#" id="edit">Edit</a>
                                        <a href="MainController?action=DELETE&userId=${acc.getAccountID()}">Delete</a>
                                        <c:choose>
                                            <c:when test="${acc.getAccountStatus() == 1}">
                                                <a href="MainController?action=BAN_ACCOUNT&userId=${acc.getAccountID()}&accountStatus=${acc.getAccountStatus()}&lastSearchValue=${requestScope.lastSearchValue}&searchByValue=${requestScope.searchByValue}">Block</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="MainController?action=BAN_ACCOUNT&userId=${acc.getAccountID()}&accountStatus=${acc.getAccountStatus()}&lastSearchValue=${requestScope.lastSearchValue}&searchByValue=${requestScope.searchByValue}">UnBlock</a>
                                            </c:otherwise>
                                        </c:choose>
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <c:out value="${mess1}"></c:out>
                </c:otherwise>
            </c:choose>
            <div class="edit-container">
                <div class="edit-body-container-body-container">
                    <span id="close" onclick="closeLoginPopup()"><img class="close-img" src="image/closeButton.png" alt="icon"/></span>
                    <div class="edit-form-form d-flex justify-content-between">
                        <div class="edit-right-site-body">
                            <div class="signup-right-heading">
                                <b>Update Account</b>
                            </div>
                            <div class="login-register">
                                <form action="MainController" method="post" id="form">
                                    <input type="hidden" name="userId" value="${acc.getAccountID()}">
                                    <div class="form-group">
                                        <input type="text"  placeholder="Enter Name" name="newName" value="${acc.getName()}" class="form-control"required="" >
                                        <input type="hidden" name="oldName" value="${acc.getName()}">
                                    </div> 
                                    <div class="form-group">
                                        <input type="email"  placeholder="Enter email" name="newEmail" value="" class="form-control"required="">
                                        <input type="hidden" name="oldEmail" value="${acc.getEmail()}">
                                    </div>  
                                    <div class="form-group" >
                                        <input type="text"  placeholder="Enter password" name="newPassword" value=""class="form-control"required="" >
                                        <input type="hidden" name="oldPassword" value="${acc.getPassword()}">
                                    </div>      
                                    <div class="form-group">
                                        <input type="password"  placeholder="Enter Phone" name="newPhone" value=""  class="form-control"required="" >
                                        <input type="hidden" name="oldPhone" value="${acc.getPhone()}">
                                    </div> 
                                    <div class="form-group">
                                        <input type="password"  placeholder="Enter password again" name="repass" value="" id="txtRepass" class="form-control"required="">
                                    </div>  
                                    <button type="submit" name="action" value="UPDATE" class="btn btn-login">Update</button>
                                </form>
                            </div> 
                        </div>
                    </div>
                </div>
            </div>
            <footer>
                <%@include file="footer.jsp" %>
            </footer>       
            <script>

                document.getElementById("edit").addEventListener("click", function () {
                    document.querySelector(".edit-container").style.display = "flex";
                });

                document.getElementById("close").addEventListener("click", function () {
                    document.querySelector(".edit-container").style.display = "none";
                });
            </script>
    </body>
</html>
