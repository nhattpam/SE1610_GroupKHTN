<%-- 
    Document   : wishlist
    Created on : Oct 23, 2022, 8:25:16 PM
    Author     : HUNG
--%>

<%@page import="dtos.GoogleDTO"%>
<%@page import="dtos.UsersDTO"%>
<%@page import="dtos.ProductDTO"%>
<%@page import="dtos.CartDTO"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="utils.DBUtils"%>
<%@page import="daos.ProductDAOImpl"%>
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
        <title>Sản Phẩm Ưa Thích </title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
        <style>
            .pagi{
                color: #6a0e13;
                font-weight: bold;
                border: 1px solid #6a0e13;
                padding: 15px 15px;
                margin: 10px;
            }
            .pagi:hover{
                color: white;
                background: #6a0e13;
            }
            .featured span .row            
            {
                padding-bottom: 30px;
            }            
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <!-- Hero Section Begin -->

        <!-- Hero Section End -->

        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="breadcrumb__text">
                            <h2>Sản Phẩm Yêu Thích</h2>                            
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Featured Section Begin -->
        <section class="featured spad">
            <c:if test="${empty list}">
                <h4>Hiện Chưa Có Sản Phẩm Ưa Thích </h4>
            </c:if>
            <c:forEach items="${list}" var="dto">
                <div class="row">
                    <div class="col-lg-4 col-md-4">
                        <div class="product__details__pic">
                            <div class="product__details__pic__item">
                                <img class="product__details__pic__item--large"
                                     src="products/${dto.product_id.photo}" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-8">
                        <div class="product__details__text">
                            <h3>${dto.product_id.name}</h3>                        
                            <div class="product__details__price"><fmt:formatNumber type="number" groupingUsed="true" value="${dto.product_id.price}" /> VNĐ</div>
                            <p>${dto.product_id.short_description}</p>
                            <p>Ngày thêm: ${dto.create_date}</p>
                            <c:if test="${ not empty USER }">
                                <a href="add-cart?command=insert&product_id=${dto.product_id.product_id}&cartID=${System.currentTimeMillis()}&bid=${sessionScope.branch_id}" class="primary-btn" style="background: #6a0e13;">THÊM VÀO GIỎ</a>
                            </c:if>
                            <c:if test="${ not empty USERG }">
                                <a href="add-cart?command=insert&product_id=${dto.product_id.product_id}&cartID=${System.currentTimeMillis()}&bid=${sessionScope.branch_id}" class="primary-btn" style="background: #6a0e13;">THÊM VÀO GIỎ</a>
                            </c:if>
                            <c:if test="${ not empty USER }">
                                <a href="DeleteWishlistController?product_id=${dto.product_id.product_id}" class="primary-btn" style="background: #6a0e13;">XÓA KHỎI YÊU THÍCH</a> 
                            </c:if>
                            <c:if test="${ not empty USERG }">
                                <a href="DeleteWishlistController?product_id=${dto.product_id.product_id}" class="primary-btn" style="background: #6a0e13;">XÓA KHỎI YÊU THÍCH</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <c:forEach begin="1" end="${endPage}" var="i">
                <a href="ViewWishlist?index=${i}" class="pagi">${i}</a>
            </c:forEach>
        </div>
    </section>
    <!-- Featured Section End -->
    <jsp:include page="footer.jsp" />
</body>
</html>