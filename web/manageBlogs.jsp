<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <link href="CSS/style_1.css" rel="stylesheet" type="text/css"/>
        <title>Manage Blogs</title>
    </head>
    <body>
        <!--header-->
        <header>
            <%@include file="headeradmin.jsp" %>
        </header>
        <div> <a href="manageAddBlogs.jsp" class="boxed-btn3" >Add New Blog</a></div>
        <div class="testmonial_area">
            <div class="container">
                <div class="row justify-content-center">

                    <c:forEach var="a" items="${sessionScope.LIST_BLOG}">
                        <div class="col-lg-10">
                            <div class="testmonial_wrap">
                                <div class="single_testmonial d-flex align-items-center">
                                    <div class="test_thumb">
                                        <img src="${a.getMedia()}" alt="Card image cap">
                                    </div>

                                    <div class="test_content">
                                        <h4>${a.getTitle()}</h4>
                                        <span>${a.getCreateTime()}</span>
                                        <p>#${a.getBlogID()}</p>
                                        <p>${a.getBody()}</p>
                                        <a class="boxed-btn3"  href="MainController?action=UPDATE_BLOGS&blogID=${a.getBlogID()}">Update</a>
                                        <a  class="boxed-btn3" href="MainController?action=DELETE_BLOGS&blogID=${a.getBlogID()}" >Delete</a>

                                    </div>
                                </div>
                            </div>

                        </div>
                    </c:forEach>
                </div>
            </div>
            <!-- footer_start  -->
            <footer>
                <%@include file="footer.jsp" %>
            </footer>
    </body>
</html>
