<%-- 
    Document   : DetailCourse
    Created on : Jun 22, 2023, 2:33:40 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- css -->
        <link href="CSS/submit.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header> 
            <c:choose>
                <c:when test="${sessionScope.acc.role == 0}">
                    <jsp:include page="headeruser.jsp"></jsp:include>
                </c:when>
                <c:otherwise>
                    <jsp:include page="headerguest.jsp"></jsp:include>
                </c:otherwise>
            </c:choose>
        </header>
        <section class="content">
            <!-- Content-information -->
            <div class="content-information">
                <!-- IMG -->
                <div class="content-information-img">
                    <img src="${course.getImage()}" alt="">
                    <span class="img-title" >${course.getCourseName()}</span>
                </div>
                <!-- content -->
                <div class="content-information-content">
                    <div class="information-content">
                        ${course.getDescription()}
                    </div>
                    <!-- author -->
                    <div class="information-author">
                        <!-- director -->
                        <div class="info director">
                            <span class="info-title">Bird type:</span>
                            <span class="info-name"> </span>
                        </div>
                        <!-- Performer -->
                        <div class="info Performer">
                            <span class="info-title">Fee:</span>
                            <span class="info-name">${course.getFee()}</span>
                        </div>
                        <!-- Category -->
                        <div class="info Category">
                            <span class="info-title">Time training:</span>
                            <span class="info-name">${course.getTimeOfCourse()}
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <!-- SUBMIT -->
            <form action="MainController" method="post">
                <div class="content-location">
                    <!-- Form xác nhận -->
                    <div class="form-submit">
                        <div class="form-submit-left">
                            <div class="form">
                                <div class="form-title"><span>Bird Name*:</span></div>
                                <input class="form-title-1" type="text" name="txtBirdName" placeholder="Your bird name">
                            </div>
                            <div class="form">
                                <select name="slotDropdown">
                                    <option value="1">Slot 1 : 9:00</option>
                                    <option value="2">Slot 2 : 10:00</option>
                                    <option value="3">Slot 3 : 11:00</option>
                                    <option value="4">Slot 4 : 12:00</option>
                                    <option value="5">Slot 5 : 13:00</option>
                                    <option value="6">Slot 6 : 14:00</option>
                                </select>
                            </div>
                            <div class="form">
                                <div class="form">
                                    <select name="birdCategories">
                                        <c:forEach var="c" items="${listBirdCate}">
                                            <option value="${c.getCategoriesID()}">${c.getCategoriesName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-submit-right">
                            <!-- NTNS -->
                            
                            <div class="form">
                                <div class="form-title"><span>Bird weight*:</span></div>
                                <input class="form-title-1" type="text" name="txtBirdWeight" placeholder="">
                            </div><br>
                            <div class="form">
                                <div class="form-title"><span>Bird height*:</span></div>
                                <input class="form-title-1" type="text" name="txtBirdHeight" placeholder="">
                            </div>
                            <div class="form">
                                <div class="form-title"><span>Bird Color*:</span></div>
                                <input class="form-title-1" type="text" name="txtBirdColor" placeholder="">
                            </div>
                            <div class="form">
                                <div class="form-title"><span>Bird Photo*:</span></div>
                                <input type="file" name="birdPhoto"/>
                            </div>
                            <input type="hidden" name="courseID" value="${course.getCourseID()}">
                            <input type="hidden" name="accountID" value="${sessionScope.acc.getAccountID()}">
                            <input type="hidden" name="accountName" value="${sessionScope.acc.getName()}">
                        </div>
                    </div>
                    <p class="Luuy">(*):Xin vùi lòng điền đầy đủ thông tin.<br>Chúc bạn và gia đình có một ngày thật tuyệt vời.</p>
                    <!-- Button  -->
                    <div class="Button">
                        <button class="btn btn-submit" type="submit" name="action" value="SUBMIT_REGIS_FORM">Xác nhận
<!--                            <div class="icon"><span class="material-symbols-outlined"></span></div>
                            <div class="text"><a href="">Xác nhận</a> </div>-->
                        </button>
                    </div>
                    ${mess}
                </div>
            </form>
        </section>
    </body>
</html>
