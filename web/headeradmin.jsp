<%-- 
    Document   : headeradmin
    Created on : 25 thg 5, 2023, 00:26:22
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Animal</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- <link rel="manifest" href="site.webmanifest"> -->
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
        <!-- Place favicon.ico in the root directory -->

        <!-- CSS here -->
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
    </head>

    <body>

        <header>
            <div class="header-area ">
                <div class="header-top_area">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6 col-md-8">
                                <div class="short_contact_list">
                                    <ul>
                                        <li><a href="#">+880 4664 216</a></li>
                                        <li><a href="#">Mon - Sat 10:00 - 7:00</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-4 ">
                                <div class="social_media_links">
                                    <a href="#">
                                        <i class="fa fa-facebook"></i>
                                    </a>
                                    <a href="#">
                                        <i class="fa fa-pinterest-p"></i>
                                    </a>
                                    <a href="#">
                                        <i class="fa fa-google-plus"></i>
                                    </a>
                                    <a href="#">
                                        <i class="fa fa-linkedin"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="sticky-header" class="main-header-area">
                    <div class="container">
                        <div class="row align-items-center">
                            <div class="col-xl-3 col-lg-3">
                                <div class="logo">
                                    <a href="MainController?action=HOME_GUEST">
                                        <p style="text-transform : uppercase ;color: red;font-weight: bold ;font-size: 24px;  margin-right: 20px; padding-right: 20px"> Training Flying</p>
                                    </a>
                                </div>
                            </div>
                            <div class="col-xl-9 col-lg-9">
                                <div class="main-menu  d-none d-lg-block">
                                    <nav>
                                        <ul id="navigation">
                                            <li><a href="MainController?action=MANAGE_ACCOUNT">ACCOUNT</a></li>
                                            <li><a href="MainController?action=MANAGE_BIRD">BIRD</a></li>
                                            <li><a href="MainController?action=MANAGE_COURSE">Course</a></li>
                                            <li><a href="MainController?action=DASHBOARD">Dash Board</a></li>
                                            <li><a href="MainController?action=MANAGE_BLOG">BLOG</a></li>
                                            <li><a href="MainController?action=LOAD_FEEDBACK">Feedback</a></li>                                           
                                            <li><a href="#">Welcome ${sessionScope.acc.getName()}</a>
                                                <ul class="submenu">
                                                    <li><a href="MainController?action=ProfileLoad&acc=${sessionScope.acc.getAccountID()}">Setting Account</a></li>
                                                    <li><a href="MainController?action=Logout">Logout</a></li>
                                                </ul>
                                            </li>                                        
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="mobile_menu d-block d-lg-none"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
    </body>
</html>
