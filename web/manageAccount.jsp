<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/owl.carousel.min.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/magnific-popup.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/themify-icons.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/nice-select.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/flaticon.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/gijgo.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/animate.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/slicknav.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/cssss/style.css" rel="stylesheet" type="text/css"/>
        <title>Manage Account</title>
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
                <option value="byEmail">By Email</option>
                <option value="byPhone">By Phone</option>
            </select>

            <input type="submit" name="action" value="SEARCH" class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
                   type="submit">

        </form>
        <div>
            <c:set var="acc" value="${requestScope.searchList}"></c:set>
            <c:choose>
                <c:when test="${acc != null}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Account Name</th>
                                <th scope="col">Role</th>
                                <th scope="col">Status</th>
                                <th scope="col">Block</th>
                                <th scope="col">Unblock</th>
                                <th scope="col">Detail</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="acc" items="${requestScope.searchList}">
                            <form action="MainController" method="post">
                                <input type="hidden" name="lastSearchValue" value="${requestScope.lastSearchValue}">
                                <input type="hidden" name="searchByValue" value="${requestScope.searchByValue}">
                                <input type="hidden" name="accountStatus" value="${acc.accountStatus}">
                                <tr>
                                    <th scope="row">${acc.accountID}</th>
                                    <td>${acc.name}</td>

                                    <td>
                                        <c:choose>
                                            <c:when test="${acc.role == 0}">User</c:when>
                                            <c:otherwise>Admin</c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${acc.accountStatus == 1}">Active</c:when>
                                            <c:otherwise>Inactive</c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${acc.accountStatus == 0 && acc.role == 0}">Block</c:when>
                                            <c:when test="${acc.accountStatus == 0 && acc.role == 1}"></c:when>
                                            <c:when test="${acc.accountStatus == 1 && acc.role == 1}"></c:when>
                                            <c:otherwise>
                                                <a class="custom-button_2" href="MainController?action=BAN_ACCOUNT&userId=${acc.accountID}&accountStatus=${acc.accountStatus}&lastSearchValue=${requestScope.lastSearchValue}&searchByValue=${requestScope.searchByValue}">Block</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${acc.accountStatus == 1 && acc.role == 0}">Unblock</c:when>
                                            <c:when test="${acc.accountStatus == 1 && acc.role == 1}"></c:when>
                                            <c:when test="${acc.accountStatus == 0 && acc.role == 1}"></c:when>
                                            <c:otherwise>
                                                <a class="custom-button_2" href=MainController?action=BAN_ACCOUNT&userId=${acc.accountID}&accountStatus=${acc.accountStatus}&lastSearchValue=${requestScope.lastSearchValue}&searchByValue=${requestScope.searchByValue}">Unblock</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <a class="custom-button_2" href="ManageAccountController?action=Detail&accountID=${acc.accountID}">Detail</a>
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
            <c:when test="${requestScope.allAcc != null}">
                <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Account Name</th>
                        <th scope="col">Role</th>
                        <th scope="col">Status</th>
                        <th scope="col">Block</th>
                        <th scope="col">Unblock</th>
                        <th scope="col">Detail</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.allAcc}" var="a">
                        <tr>
                            <th scope="row">${a.accountID}</th>
                            <td>${a.name}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${a.role == 0}">User</c:when>
                                    <c:otherwise>Admin</c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${a.accountStatus == 1}">Active</c:when>
                                    <c:otherwise>Inactive</c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${a.accountStatus == 0 && a.role == 0}">Block</c:when>
                                    <c:when test="${a.accountStatus == 0 && a.role == 1}"></c:when>
                                    <c:when test="${a.accountStatus == 1 && a.role == 1}"></c:when>
                                    <c:otherwise>
                                        <a class="custom-button_2" href="ManageAccountController?action=Block&accountID=${a.accountID}">Block</a>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${a.accountStatus == 1 && a.role == 0}">Unblock</c:when>
                                    <c:when test="${a.accountStatus == 1 && a.role == 1}"></c:when>
                                    <c:when test="${a.accountStatus == 0 && a.role == 1}"></c:when>
                                    <c:otherwise>
                                        <a class="custom-button_2" href="ManageAccountController?action=Unblock&accountID=${a.accountID}">Unblock</a>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <a class="custom-button_2" href="ManageAccountController?action=Detail&accountID=${a.accountID}">Detail</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            </c:when>
        </c:choose>
        </section>
<!--        <div class="edit-container d-none">
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
        </div>-->
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
