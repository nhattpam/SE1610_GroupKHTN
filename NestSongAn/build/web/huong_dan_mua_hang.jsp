<%-- 
    Document   : bi-quyet-giu-duoc-duong-chat-cua-yen-sao-khi-che-bien
    Created on : Oct 7, 2022, 9:56:43 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Về Song Ân</title>

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
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="container text-center">
            <h3 style="color: #6a0e13; font-weight: bold; font-family: Tahoma, Verdana, Segoe, sans-serif;">Hướng dẫn mua hàng & Thanh toán</h3>
            <br>
            <h4 style="text-align: left;">Hướng dẫn mua hàng</h4><br>
            
            <h4 style="text-align: left;">Hình thức thanh toán</h4>
            <ul style="text-align: left;">
                <li>Thanh toán khi nhận hàng (COD)</li>
                <li>Thanh toán bằng paypal & thẻ ngân hàng</li>
            </ul>
            <div>
                <br>
            </div>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
