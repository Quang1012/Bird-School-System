<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
           </head>
    <body>
        <header>
            <c:choose>
                <c:when test="${sessionScope.acc.role == 0}">
                    <%@include file="headeruser.jsp" %>
                </c:when>
                <c:otherwise>
                    <%@include file="headerguest.jsp"%>
                </c:otherwise>
            </c:choose>
        </header>>
        <!-- Pircture heading -->
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100" style="height: 800px;" src="./image/intro2.jpg" alt="First slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" style="height: 800px;" src="./image/intro3.jpg" alt="Second slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100"  style="height: 800px;" src="./image/intro4.jpg" alt="Third slide">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!-- search tnm by name site -->
        <div class="search-tnm-site">
            <div class="search-tnm-main-site">
                <form action="MainController" class="search-tnm-form" method="post">
                    <input type="text" placeholder="Search Course" class="form-control" name="CourseName">
                    <button class="btn btn-search" type="search" name="action" value="SEARCH_Course"><i class='fas fa-search' style='font-size:40px'></i></button>
                </form>
            </div>     
        </div>
        <!-- tnm categories heading  -->
        <div class="container tnm-categories-heading">
            <a href="MainController?action=Course"><p>All Courses     <i class='fas fa-award' style='font-size:24px;color: #dbbd0e;;'></i></p></a>
            <a href="MainController?action=ON_GOING_Course"><p>On Going Courses</p></a>
            <a href="MainController?action=OLD_Course"><p>Old Courses</p></a>
            <a href="MainController?action=DELAY_Course"><p>Delay Course     <i class='fas fa-hourglass-end' style='font-size:24px;color: green;'></i></p></a>
        </div>
        <!-- tnm-list -->
        <div class="tnm-site-all container">
            <div class="tnm-list container">
                <!-- card 1 -->
                <c:forEach var="list" items="${sessionScope.GET_LIST}">
                    <div class="tnm-card-site-ptr">     
                        <div class="card" style="width: 45rem;">
                            <img class="card-img-top" src="${list.image}" alt="Card image cap">
                            <div class="card-body" style="height:20rem;">
                                <!-- status -->
                                <div class="status-heading d-flex justify-content-center" style="font-weight: bold;">
                                    <h3>${list.CourseName}</h3>
                                </div>
                                <div class="status-heading d-flex justify-content-center" style="font-weight: bold;">
                                    <p>
                                        <c:choose>
                                            <c:when test="${list.CourseStatus == 0}">Up Coming</c:when>
                                            <c:when test="${list.CourseStatus == 1}">Open Form</c:when>
                                            <c:when test="${list.CourseStatus == 2}">Close Form</c:when>
                                            <c:when test="${list.CourseStatus == 3}">On Going</c:when>
                                            <c:when test="${list.CourseStatus == 4}">Finished</c:when>
                                            <c:otherwise>Delay</c:otherwise>
                                        </c:choose>
                                    </p>
                                </div>
                                <!-- Other information -->
                                <div class="other-inf-tnm">
                                    <div class="each-other-inf-tnm">
                                        <h5>Date and Time</h5>
                                        <p>${list.dateTime}</p>
                                    </div>
                                    <div class="each-other-inf-tnm">
                                        <h5>Location</h5>
                                        <p>${list.location}</p>
                                    </div>
                                    <div class="each-other-inf-tnm">
                                        <h5>Fee</h5>
                                        <p>${list.fee} VND</p>
                                    </div>
                                </div>
                            </div>
                            <div class="btn-card-tnm">
                                <a href="MainController?action=Course_DETAIL&ID=${list.CourseID}">More Detail</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!-- footer site -->
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
