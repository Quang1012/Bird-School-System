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
                <c:when test="${requestScope.listRp != null}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Date</th>
                                <th scope="col">Image</th>
                                <th scope="col">Video</th>
                                <th scope="col">Bird</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="r" items="${requestScope.listRp}">
                                <tr>
                                    <td>
                                        ${r.getDate()}
                                    </td>
                                    <td>
                                        ${r.getImage()}
                                    </td>
                                    <td>
                                        ${r.getUrl()}
                                    </td>
                                    <td>
                                        ${r.bird.getBirdID()}
                                    </td>
                                </tr>
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
</html>
