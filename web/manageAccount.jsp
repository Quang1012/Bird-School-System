<%-- 
    Document   : manageAccount
    Created on : Jun 1, 2023, 12:18:33 PM
    Author     : PC
--%>

<%@page import="java.util.List"%>
<%@page import="DTO.AccountDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link <a href="CSS/manangeAccount.css" rel="stylesheet" ></a>>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <%@include file="headeradmin.jsp"%>
        </header>
        <div class="row container">
            <div class="col-2">
                <nav>
                    <ul>
                        <li><a href="MainController?action=COUNT_ACCOUNT">Count Account</a></li>
                        <li><a href="MainController?action=LISTALLACCOUNT">List All Account</a></li>
                    </ul>
                </nav>
            </div>
            <div>
                <p>Account Count : ${sessionScope.accCount}</p>
            </div>
            <div class="col-md-10">
                <div>
                    <form action="MainController" method="post">
                        <input type="text" name="txtSearch" placeholder="Search">
                        <select name="searchBy">
                            <option value="byName">By Name</option>
                            <option value="byEmail">By Email</option>
                            <option value="byPhone">By Phone</option>
                        </select>
                        <input type="submit" name="action" value="SEARCH">
                    </form>
                </div>
            </div>          
            <div>
                <c:set var="acc" value="${requestScope.searchList}"></c:set>
                <c:choose>
                    <c:when test="${acc != null}">
                        <table class="table-bordered">
                            <thead>
                                <tr>
                                    <th style="text-align: center">Id</th>
                                    <th style="text-align: center">Name</th>
                                    <th style="text-align: center">Email</th>
                                    <th style="text-align: center">Password</th>
                                    <th style="text-align: center">Phone</th>
                                    <th style="text-align: center">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="acc" items="${requestScope.searchList}">
                                <form action="MainController" method="post">
                                    <input type="hidden" name="lastSearchValue" value="${requestScope.lastSearchValue}">
                                    <input type="hidden" name="searchByValue" value="${requestScope.searchByValue}">
                                    <input type="hidden" name="accountStatus" value="${acc.accountStatus}">
                                    <tr>
                                        <td>
                                            <c:out value="${acc.getAccountID()}"/>
                                            <input type="hidden" name="userId" value="${acc.getAccountID()}">
                                        </td>
                                        <td style="text-align: center">
                                            <input type="text" name="newName" value="${acc.getName()}">
                                            <input type="hidden" name="oldname" value="${acc.getName()}">
                                        </td>
                                        <td style="text-align: center">
                                            <input type="text" name="newEmail" value="${acc.getEmail()}">
                                            <input type="hidden" name="oldEmail" value="${acc.getEmail()}">
                                        </td>
                                        <td style="text-align: center">
                                            <input type="text" name="newPassword" value="${acc.getPassword()}">
                                            <input type="hidden" name="oldPassword" value="${acc.getPassword()}">
                                        </td>
                                        <td style="text-align: center">
                                            <input type="text" name="newPhone" value="${acc.getPhone()}">
                                            <input type="hidden" name="oldPhone" value="${acc.getPhone()}">
                                        </td>

                                        <td style="text-align: center">
                                            <button type="submit" name="action" value="UPDATE_ACCOUNT" class="btn btn-login">Update</button>
                                            <button type="submit" name="action" value="DELETE_ACCOUNT" class="btn btn-login">Delete</button>
                                            <button type="submit" name="action" value="BAN_ACCOUNT" class="btn btn-login">Ban</button>
                                        </td>
                                    </tr>
                                </form>
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
                        <table border="1" width="60%">
                            <thead>
                                <tr>
                                    <th width="30px">Id</th>
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Password</th>
                                    <th>Phone</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="acc" items="${requestScope.allAcc}">
                                <form action="MainController" method="post">
                                    <tr>
                                    <input type="hidden" name="lastSearchValue" value="${requestScope.lastSearchValue}">
                                    <input type="hidden" name="searchByValue" value="${requestScope.searchByValue}">
                                    <input type="hidden" name="accountStatus" value="${acc.accountStatus}">

                                    <td style="text-align: center"><c:out value="${acc.getAccountID()}"/></td>
                                    <td style="text-align: center">
                                        <input type="text" name="newName" value="${acc.getName()}">
                                        <input type="hidden" name="oldname" value="${acc.getName()}">
                                    </td>
                                    <td style="text-align: center">
                                        <input type="text" name="newEmail" value="${acc.getEmail()}">
                                        <input type="hidden" name="oldEmail" value="${acc.getEmail()}">
                                    </td>
                                    <td style="text-align: center">
                                        <input type="text" name="newEmail" value="${acc.getPassword()}">
                                        <input type="hidden" name="oldEmail" value="${acc.getPassword()}">
                                    </td>
                                    <td style="text-align: center">
                                        <input type="text" name="newPassword" value="${acc.getPhone()}">
                                        <input type="hidden" name="oldPassword" value="${acc.getPhone()}">
                                    </td>

                                    <td style="text-align: center">
                                        <button type="submit" name="action" value="UPDATE" class="btn btn-login">Update</button>
                                        <button type="submit" name="action" value="DELETE" class="btn btn-login">Delete</button>
                                        <button type="submit" name="action" value="BAN_ACCOUNT" class="btn btn-login">Ban</button>
                                    </td>
                                    </tr>
                                </c:forEach>
                            </form>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <c:out value="${mess1}"></c:out>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
