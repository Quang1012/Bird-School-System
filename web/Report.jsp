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
        <link href="CSS/style_1.css" rel="stylesheet" type="text/css"/>
        <title>Manage Account</title>
    </head>
    <body>
        <header>
            <%@include file="headeruser.jsp"%>
        </header>
        <div>
            <c:choose>
                <c:when test="${requestScope.schedule != null}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Bird Name</th>
                                <th scope="col">Bird Owner</th>
                                <th scope="col">Slot</th>
                                <th scope="col">Class Name</th>
                                <th scope="col">Input image</th>
                                <th scope="col">Input video</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="s" items="${requestScope.schedule}">
                            <form action="MainController" method="POST">
                                <tr>
                                    <td>
                                        ${s.bird.getBirdName()}
                                    </td>
                                    <td>
                                        ${s.acc.getName()}
                                    </td>
                                    <td>
                                        ${s.slot}
                                    </td>
                                    <td>
                                        ${s.classs.getClassname()}
                                    </td>
                                <input type="hidden" name="birdID" value="${s.bird.getBirdID()}">
                                <input type="hidden" name="coachAccID" value="${requestScope.coachAccID}">
                                <td>
                                    <input type="file" name="image">
                                </td>
                                <td>
                                    <input type="file" name="video">
                                </td>
                                 <td>
                                     <button type="submit" name="action" value="SEND_REPORT">Send</button>
                                </td>
                                </tr>
                            </form>
                        </c:forEach>
                        ${mess}
                        </tbody>
                    </table>
                </c:when>
            </c:choose>
        </div>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>       
    </body>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            var link = document.getElementById("myForm");
            if (!sessionStorage.getItem('linkClicked')) {
                // Simulate a click event using AJAX
                var xhr = new XMLHttpRequest();
                xhr.open("GET", link.getAttribute("href"), true);
                xhr.onreadystatechange = function () {
                    if (xhr.readyState === 4 && xhr.status === 200) {
                        // Request completed successfully
                        sessionStorage.setItem('linkClicked', true);
                    }
                };
                xhr.send();
            }
        });
    </script>
</html>
