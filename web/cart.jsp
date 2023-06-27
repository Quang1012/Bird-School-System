<%-- 
    Document   : cart
    Created on : Jun 25, 2021, 11:41:28 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
         <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
        <link href="CSS/style.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/cart.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="headeruser.jsp"></jsp:include>
             <form action="DispatchServlet" method="post">
        <div class="cart-wrap">
            <div class="container">
                <div class="row">
                    <c:if test="${message != null}"><div class="alert alert-danger" role="alert">${message}</div></c:if>
                    <div class="col-lg-8">
                        <div class="main-heading">Shopping Cart</div>
                        <div class="table-cart">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Product</th>
                                        <th>Total</th>
                                        <th><button value="Remove" name="btAction" type="submit" onclick="return confirm('Are you sure?')">Remove</button></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:set scope="session" var="totalOrder" value="0"/>
                                    <c:forEach items="${cart}" var="i">
                                        <c:set scope="session" var="totalOrder" value="${totalOrder + i.getCourse().getFee()}"/>
                                        <tr>
                                            <td>
                                                <div class="display-flex align-center">
                                                    <div class="img-product">
                                                        <img src="photo/${i.getCourse().getImg()}" alt="" class="mCS_img_loaded">
                                                    </div>
                                                    <div class="name-product">
                                                        ${i.getCourse().getCourseName()}
                                                        <br>by ${i.getCourse().getDescription()}
                                                    </div>
                                                    <div class="price">
                                                        $${i.getCourse().getFee()}
                                                    </div>
                                                </div>
                                            </td>
                                        
                                            <td>
                                                <div class="total">
                                                    $${i.getCourse().getfee()}
                                                </div>
                                            </td>
                                            <td><input type="checkbox" name="select" value="${i.getCourse().getCourseId()}"></td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-cart -->
                        </div>
                        <!-- /.col-lg-8 -->
                        <div class="col-lg-4">
                            <div class="cart-totals">
                                <h3>Cart Totals</h3>
                                    <c:set scope="session" var="totalPayment" value="${totalOrder }"/>
                                    <table>
                                        <tbody>
                                            <tr>
                                                <td>Subtotal</td>
                                                <td class="subtotal">$${totalOrder}</td>
                                            </tr>
                                         
                                            <tr class="total-row">
                                                <td>Total Payment</td>
                                                <td class="price-total">$${totalPayment}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <div class="btn-cart-totals">
                                        <a href="DispatchServlet?btAction=User" class="btn btn-success">Continue Shopping</a>
                                          <a href="DispatchServlet?btAction=User" class="btn btn-success">Payment</a>
                                    </div>
                                    <!-- /.btn-cart-totals -->
                            </div>
                            <!-- /.cart-totals -->
                        </div>
                        <!-- /.col-lg-4 -->
                    </div>
                </div>
            </div>            
        </form>
    </body>F
</html>
