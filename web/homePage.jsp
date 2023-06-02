 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <link href='https://fonts.googleapis.com/css?family=Baloo' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet'>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <link rel="stylesheet" href="CSS/guest-userPage.css">
          <link href="./CSS/blogs.css" rel="stylesheet">                
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>Welcome</title>
    </head>
    <body>
        <header>
            <c:choose>
                <c:when test="${sessionScope.acc.role == 0}">
                    <%@include file="headeruser.jsp" %>
                </c:when>
                <c:when test="${sessionScope.acc.role == 1}">
                    <%@include file="headeradmin.jsp" %>
                </c:when>
                <c:otherwise>
                    <%@include file="headerguest.jsp"%>
                </c:otherwise>
            </c:choose>
        </header>
 
       <div class="blogs-container-section">
            <div class="blogs-main-site">
             <c:forEach var = "a" items="${sessionScope.LIST_BLOG}">
                    <div class="small-categories-blogs-site container">
                        <!-- each card blog site -->
                            <div class="small-categories-blogs-main-body-site">
                            <div class=" card-categories">
                                <div class="card-categories-img-left-site">
                                    <img class="card-img-top" src="${a.getMedia()}" alt="Card image cap">
                                </div>
                                <div class="card-body time-heading-site">
                                    <h5>${a.getTitle()}</h5>
                                    <p>${a.getCreateTime()}</p>
                                    <div class="link-read-button">
                                        <a href="MainController?action=BlogDetail&blogID=${a.getBlogID()}">Read more</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
     
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
