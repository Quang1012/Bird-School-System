<%-- 
    Document   : newjsp
    Created on : 28-05-2023, 22:46:22
    Author     : Quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
           <link rel="stylesheet" href="CSS/cssss/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/cssss/owl.carousel.min.css">
        <link rel="stylesheet" href="CSS/cssss/magnific-popup.css">
        <link rel="stylesheet" href="CSS/cssss/font-awesome.min.css">
        <link rel="stylesheet" href="CSS/cssss/themify-icons.css">
        <link rel="stylesheet" href="CSS/cssss/nice-select.css">
        <link rel="stylesheet" href="CSS/cssss/flaticon.css">
        <link rel="stylesheet" href="CSS/cssss/gijgo.css">
        <link rel="stylesheet" href="CSS/cssss/animate.css">
        <link rel="stylesheet" href="CSS/cssss/slicknav.css">
        <link rel="stylesheet" href="CSS/cssss/style.css">
        <link rel="stylesheet" href="CSS/adminHeader.css.css">
        <link rel="stylesheet" href="CSS/adminHeader.css.css">
    </head>
    <body>

        <div class="col-xl-6 col-lg-6z  ">
            <div class="main-menu  d-none d-lg-block">
                <nav>
                    <ul id="navigation">

                        <li><a href="#">Menu </a>
                            <ul class="submenu">
                                <li>    
                                    <a class="nav-link" href="MainController?action=HOME_USER">HOME</a>
                                    <a class="nav-link" href="MainController?action=USER_BLOG&userID=${sessionScope.acc.accountID}">My BLOG</a>
                                    <a class="nav-link" href="MainController?action=BLOG">BLOGS</a>


                                </li> 

                            </ul>
                            </div>
                            </div>

        <div>
            <h1>BIRD SCHOOL SYSTEM</h1>
            <h3>INTRODUCTION</h3> 
            <br>
            <p>Typically, some birders will want to train their birds so that they can recognize and do some of the owner requests. But they don't have much time, knowledge and experience when it comes to coaching it. As a result, they will lose time without getting any results. So we developed a bird training model system to help bird owners take less time and get better quality.</p>
            <br>
            <p>This app is for bird lovers who wish their bird could do some of their requests. They don't have enough time or knowledge to train their birds. With our ornamental school system, they can now easily schedule ornamental bird training and follow the training. It is also possible to update your knowledge about ornamental birds through blog posts about ornamental birds. </p>
        </div>

        <div>
            <h2> Our Mission Statement:</h2>
            <p>
                "To help all parrot owners/keepers communicate with, bond with and care for their birds to the highest possible standard through&nbsp;education,&nbsp;training and enrichment, resulting in the best possible life for captive parrots."
            </p>
        </div>

        <!-- About us and Contact -->
        <div>
            <h1>About us and Contact</h1>
            <p>We are admin of Bird Tranning and those who create and manage school system  about bird as well as create and manage this website to help players have more good experience.When ypu have anyproblmes or question.
                Please contact us throught:
            </p>
            <div class="social-admin-site">
                <li><i class="fa-brands fa-facebook-f"></i>Facebook</li>
                <li><i class="fa-solid fa-phone"></i>(043)234-23-112</li>
                <li><i class="fa-solid fa-envelope"></i>BirdTranning@gmail.edu.vn</li>
            </div>
        </div>
    </body>
</html>
