<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/manageAccount-Bird.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>Manage Bird</title>
    </head>
    <body>
        <header>
            <%@include file="headeradmin.jsp" %>
        </header>

        <form action="MainController" method="post">

            <input  name="txtSearch" type="text" class="form-control" placeholder='Search Keyword'
                    onfocus="this.placeholder = ''" onblur="this.placeholder = 'Search Keyword'">
            <select class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"name="searchBy">
                <option value="byName">By Name</option>

            </select>

            <input type="submit" name="action" value="SEARCHBIRD" class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
                   type="submit">

        </form>
        <div>
            <c:set var="b" value="${requestScope.searchList}"></c:set>
            <c:choose>
                <c:when test="${b != null}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Bird Name</th>
                                <th scope="col">Owner ID</th>
                                <th scope="col">Status</th>
                                <th scope="col">Block</th>
                                <th scope="col">Unblock</th>
                                <th scope="col">Detail</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="b" items="${requestScope.searchList}">
                            <form action="MainController" method="post">
                                <input type="hidden" name="lastSearchValue" value="${requestScope.lastSearchValue}">
                                <input type="hidden" name="searchByValue" value="${requestScope.searchByValue}">
                                <input type="hidden" name="accountStatus" value="${acc.accountStatus}">
                                <tr>
                                    <th scope="row">${b.birdID}</th>
                                    <td>${b.birdName}</td>
                                    <td>${b.account.getAccountID()}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${b.birdStatus == 1}">Active</c:when>
                                            <c:otherwise>Inactive</c:otherwise>
                                        </c:choose>
                                    <td>
                                        <c:choose>
                                            <c:when test="${b.birdStatus == 0}">Block</c:when>
                                            <c:otherwise>
                                                <a class="custom-button_2" href="ManageBirdController?action=Block&birdID=${b.birdID}">Block</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${b.birdStatus == 1}">Unblock</c:when>
                                            <c:otherwise>
                                                <a class="custom-button_2" href="ManageBirdController?action=Unblock&birdID=${b.birdID}">Unblock</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <a class="custom-button_2" href="ManageBirdController?action=Detail&birdID=${b.birdID}">Detail</a>
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
        <section>
            <c:choose>
                <c:when test="${birds != null}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Bird Name</th>
                                <th scope="col">Owner ID</th>
                                <th scope="col">Status</th>
                                <th scope="col">Block</th>
                                <th scope="col">Unblock</th>
                                <th scope="col">Detail</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${birds}" var="b">
                                <tr>
                                    <th scope="row">${b.birdID}</th>
                                    <td>${b.birdName}</td>
                                    <td>${b.account.getAccountID()}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${b.birdStatus == 1}">Active</c:when>
                                            <c:otherwise>Inactive</c:otherwise>
                                        </c:choose>
                                    <td>
                                        <c:choose>
                                            <c:when test="${b.birdStatus == 0}">Block</c:when>
                                            <c:otherwise>
                                                <a class="custom-button_2" href="ManageBirdController?action=Block&birdID=${b.birdID}">Block</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${b.birdStatus == 1}">Unblock</c:when>
                                            <c:otherwise>
                                                <a class="custom-button_2" href="ManageBirdController?action=Unblock&birdID=${b.birdID}">Unblock</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <a class="custom-button_2" href="MainController?action=BIRD_DETAIL&birdID=${b.birdID}">Detail</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
            </c:choose>          
        </section>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>