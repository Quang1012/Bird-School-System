<%-- 
    Document   : headeradmin
    Created on : 25 thg 5, 2023, 00:26:22
    Author     : Admin
--%>

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
        <link href="CSS/login_1.css" rel="stylesheet" type="text/css"/>
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
                                    <a href="index.html">
                                        <p style="text-transform : uppercase ;color: red;font-weight: bold ;font-size: 24px;  margin-right: 20px; padding-right: 20px"> Training Flying</p>
                                    </a>
                                </div>
                            </div>
                            <div class="col-xl-9 col-lg-9">
                                <div class="main-menu  d-none d-lg-block">
                                    <nav>
                                        <ul id="navigation">
                                            <li><a  href="MainController?action=HOME_USER">HOME</a></li>
                                            <li><a href="MainController?action=BLOG">BLOG</a></li>
                                            <li><a  href="#">Course</a> <i class="ti-angle-down"></i></a>
                                                <ul class="submenu">
                                                    <li><a href="MainController?action=LIST_COURSE_FOR_USER">Course</a></li>
                                                    <li><a href="MainController?action=LIST_COURSE_FOR_USER">Course online</a></li>
                                                </ul>
                                            </li>

                                            <li><a href="MainController?action=LOAD_FEEDBACK">FEEDBACK</a></li>
                                            <li><a href="#" id="button">Login</a></li>
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
        <div class="login-container">
            <div class="login-body-container">
                <span id="close" class="close_button"><img class="close-img" src="image/closeButton.png" alt="icon"/></span>
                <div class="login-form d-flex justify-content-between">
                    <div class="login-left-site">
                        <div class="left-content">
                            <div class="left-content-heading">
                                <b>Welcome To</b><br>
                                <b>The Bird FLY TRAINING </b>
                                <span style="font-size: 25px;">Now here?</span>
                            </div>                              
                        </div>
                        <div class="btn-left">
                            <form action="MainController"  method="POST">
                                <button type="submit" name="action" value="Register" class="btn left-btn">Register</button>
                            </form>
                        </div>
                    </div>
                    <div class="login-right-site">
                        <div class="login-right-site-body">
                            <div class="login-right-heading">
                                <b>SIGN IN</b>
                            </div>
                            <div class="login-register">
                                Login Form 
                                <form action="MainController" method="post">
                                    <p class="text-danger" id = "error-message"></p>
                                    <input type="email" name="email" value="" class="form-control" placeholder="Enter email"required="" >
                                    <input type="password" name="password" value="" class="form-control" placeholder="Password"required="" >
                                    <a href="forgotPassword.jsp">Forgot Password</a>
                                    <button type="submit" name="action" value="Login"  class="btn btn-login">Sign in</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>

            document.getElementById("button").addEventListener("click", function () {
                document.querySelector(".login-container").style.display = "flex";
            });

            document.getElementById("close").addEventListener("click", function (event) {
                event.preventDefault(); // Prevent default link behavior
                document.querySelector(".login-container").style.display = "none";
            });
        </script>
        <script>
            window.onload = function () {
                var errorMessage = '<%= request.getAttribute("mess")%>';
                if (errorMessage && errorMessage.trim().toLowerCase() !== "null") {
                    document.getElementById("error-message").textContent = errorMessage;
                    document.querySelector(".login-container").style.display = "flex";
                }
            };
        </script>
    </body>
</html>
