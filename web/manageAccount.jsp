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
    </head>
    <body>
        <header>
            <%@include file="headeradmin.jsp"%>
        </header>
        <div>
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
        <div>
            <c:set var="acc" value="${requestScope.searchList}"></c:set>
            <c:choose>
                <c:when test="${acc != null}">
                    <form action="MainController" method="post">
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
                                <c:forEach var="acc" items="${requestScope.searchList}">
                                    <tr>
                                <input type="hidden" name="lastSearchValue" value="${requestScope.lastSearchValue}">
                                <input type="hidden" name="searchByValue" value="${requestScope.searchByValue}">
                                        <td style="text-align: center">
                                            <c:out value="${acc.getAccountID()}"/>
                                            <input type="hidden" name="Id" value="${acc.getAccountID()}">
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
                                </c:forEach>
                            </tbody>
                        </table>
                    </form>
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
                    <form action="MainController" method="post">
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
                                    <tr>
                                        <input type="hidden" name="lastSearchValue" value="${requestScope.lastSearchValue}">
                                        <input type="hidden" name="searchByValue" value="${requestScope.searchByValue}">
                                        
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
                            </tbody>
                        </table>
                    </form>
                </c:when>
                <c:otherwise>
                    <c:out value="${mess1}"></c:out>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
