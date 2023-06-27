<%-- 
    Document   : detail.jsp
    Created on : Jul 6, 2021, 1:13:15 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Online Details</title>
        <link href="css/detail.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <jsp:include page="headerguest.jsp"></jsp:include>
        <div class="container">
            <div class="row">
                <aside class="col-sm-6 border-right">
                    <article class="gallery-wrap"> 
                        <div class="img-big-wrap">
                            <div> <a href="photo/${b.getImg()}"><img src="photo/${b.getImg()}"></a></div>
                        </div> <!-- slider-product.// -->
                        <div class="img-small-wrap">
                            <div class="item-gallery"> <img src="photo/${b.getImg()}"> </div>
                            <div class="item-gallery"> <img src="photo/${b.getImg()}"> </div>
                            <div class="item-gallery"> <img src="photo/${b.getImg()}"> </div>
                            <div class="item-gallery"> <img src="photo/${b.getImg()}"> </div>
                        </div> <!-- slider-nav.// -->
                    </article> <!-- gallery-wrap .end// -->
                </aside>
                <div class="details col-sm-6">
                    <h3 class="product-title">${b.getCourseName()}</h3>
                    <p class="product-description">${b.getDescription()}</p>
                    <h4 class="price">current price: <span>$${b.getPrice()}</span></h4>
                    <p class="vote"><strong>91%</strong> of buyers enjoyed this Course!</p>
                    <h5>CourseNames:
                        <span>${b.getCourseName()}</span>
                    </h5>
                    <h5>description:
                        <span>${b.getdescription()}</span>
                    </h5>
                    <button ${user.getRole() eq 1 ? "hidden" : ""}>
                        <a href="DispatchServlet?btAction=Add&id=${b.getCourseId()}">Buy</a>
                    </button>
                </div>
            </div>
        </div>           
    </body>
</html>
