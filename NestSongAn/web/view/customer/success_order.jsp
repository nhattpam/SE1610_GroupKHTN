<%-- 
    Document   : success_order
    Created on : Oct 7, 2022, 9:04:06 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Đặt Hàng Thành Công!</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
        <!-- Js Plugins -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.nice-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.slicknav.js"></script>
        <script src="${pageContext.request.contextPath}/js/mixitup.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
        <style>
            *{
                font-family: Tahoma, Verdana, Segoe, sans-serif;
            }
            .fa-check-circle{
                color : green;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../../header.jsp" />
        <div class="container">
            <div class="row">
                <div class="col-md-12 text-center">
                    
                    <i class="fa fa-check-circle fa-4x fa-success" aria-hidden="true"></i>
                    <h3>Cảm ơn bạn đã đặt hàng tại chúng tôi!</h3>
                    <h4>Đơn hàng của bạn : #${requestScope.order_id}</h4>
                     <table class="table table-striped">
                         <thead>
                             <tr>
                                 <th style="text-align: left;">Tên sản phẩm</th>
                                 <th>Số lượng</th>
                                 <th>Đơn giá</th>
                             </tr>
                         </thead>
                         <tbody>
                             <c:forEach items="${od}" var="l">
                                 <tr>
                                     <td style="text-align: left;">${l.product_id.name}</td>
                                     <td>${l.quantity}</td>
                                     <td><fmt:formatNumber type="number" groupingUsed="true" value="${l.total_price}" /> VNĐ</td>
                                 </tr>

                             </c:forEach>
                         


                         </tbody>
                     </table>
                     <h5>Phí giao hàng : <span style="color:green;">0đ</span></h5>
                    <h5>Tổng giá trị đơn hàng: <span style="color:green;"><fmt:formatNumber type="number" groupingUsed="true" value="${total_price}" /> VNĐ</span></h5>
                </div>
            </div>
        </div>
        <jsp:include page="../../footer.jsp" />
    </body>
</html>
