<%-- 
    Document   : shop_all_product
    Created on : Sep 29, 2022, 1:30:11 PM
    Author     : Admin
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
        <title>Tất Cả Sản Phẩm</title>

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
        </style>
    </head>
    <body>
        <!-- Page Preloder -->
        <!--        <div id="preloder">
                    <div class="loader"></div>
                </div>-->
        <jsp:include page="header.jsp" />
        <!-- Hero Section Begin -->
        <section class="hero hero-normal">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="hero__categories">
                            <div class="hero__categories__all" style="background: #6a0e13;">
                                <i class="fa fa-bars"></i>
                                <span>Danh Mục</span>
                            </div>
                            <ul>
                                <c:forEach items="${cList}" var="l">
                                    <li><a href="danh-muc?cateId=${l.category_id}&bid=${sessionScope.branch_id}">${l.name}</a></li>
                                    </c:forEach>

                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="hero__search">
                            <div class="hero__search__form">
                                <form action="search-result">
                                    <div class="hero__search__categories">
                                        Yến Song Ân
                                        <!--<span class="arrow_carrot-down"></span>-->
                                    </div>
                                    <input type="text" placeholder="Bạn tìm gì?" name="character">
                                    <button type="submit" class="site-btn">TÌM KIẾM</button>
                                </form>
                            </div>
                            <div class="hero__search__phone">
                                <div class="hero__search__phone__icon" style="color: #6a0e13;">
                                    <i class="fa fa-phone"></i>
                                </div>
                                <div class="hero__search__phone__text">
                                    <h5>+84 1235548 48</h5>
                                    <span>Hỗ trợ 24/7</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->

        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="breadcrumb__text">
                            <h2>Sản Phẩm Của Nest Song Ân</h2>
                            <div class="breadcrumb__option">
                                <a href="home">Trang chủ</a>
                                <span>Shop</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Featured Section Begin -->
        <section class="featured spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2>Tất Cả</h2>
                            <style type="text/css">
                                .section-title h2:after {
                                    position: absolute;
                                    left: 0;
                                    bottom: -15px;
                                    right: 0;
                                    height: 4px;
                                    width: 80px;
                                    background: #6a0e13;
                                    content: "";
                                    margin: 0 auto;
                                }
                                .featured__controls a{
                                    color: black;
                                }
                            </style>
                        </div>
                        <div class="featured__controls">
                            <ul>
                                <li class="active" data-filter="*"><a href="shop-products?bid=${sessionScope.branch_id}">All</a></li>
                                    <c:forEach items="${cList}" var="l">
                                    <li><a href="SortPriceController?cateId=${l.category_id}&bid=${sessionScope.branch_id}">${l.name}</a></li>
                                    </c:forEach>
                            </ul>
                            </br>
                            <ul>
                                <c:if test="${empty cateId}">
                                    <li><a href="SortPriceController?sort=1">Giá tăng dần</a></li>
                                    <li><a href="SortPriceController?sort=2">Giá giảm dần</a></li>
                                    </c:if>
                                    <c:if test="${not empty cateId}">
                                    <li><a href="SortPriceController?sort=1&cateId=${cateId}">Giá tăng dần</a></li>
                                    <li><a href="SortPriceController?sort=2&cateId=${cateId}">Giá giảm dần</a></li>
                                    </c:if>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row featured__filter">
                    <c:forEach items="${listPaging}" var="l">
                        <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                            <div class="featured__item">

                                <div class="featured__item__pic set-bg" data-setbg="products/${l.photo}">
                                    <ul class="featured__item__pic__hover">
                                        <c:if test="${empty USER && empty USERG}">
                                            <li><a href="loginController"><i class="fa fa-heart"></i></a></li>
                                                </c:if>
                                                <c:if test="${ not empty USER }">
                                            <li><a href="AddToWishlistController?product_id=${l.product_id}&user_id=${USER.user_id}"><i class="fa fa-heart"></i></a></li>
                                                </c:if>
                                                <c:if test="${ not empty USERG }">
                                            <li><a href="AddToWishlistController?product_id=${l.product_id}&user_id=${USERG.id}"><i class="fa fa-heart"></i></a></li>
                                                </c:if>
                                        <!--<li><a href="#"><i class="fa fa-retweet"></i></a></li>-->

                                        <c:if test="${empty USER && empty USERG}">
                                            <li><a href="loginController"><i class="fa fa-shopping-cart"></i></a></li>
                                                </c:if>
                                                <c:if test="${ not empty USER }">
                                            <li><a href="add-cart?command=insert&product_id=${l.product_id}&cartID=${System.currentTimeMillis()}&bid=${sessionScope.branch_id}"><i class="fa fa-shopping-cart"></i></a></li>   
                                                </c:if>    
                                                <c:if test="${ not empty USERG }">
                                            <li><a href="add-cart?command=insert&product_id=${l.product_id}&cartID=${System.currentTimeMillis()}&bid=${sessionScope.branch_id}"><i class="fa fa-shopping-cart"></i></a></li>    
                                                </c:if>

                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="detail?product_id=${l.product_id}&bid=${sessionScope.branch_id}">${l.name}</a></h6>
                                    <h5><fmt:formatNumber type="number" groupingUsed="true" value="${l.price}" /> VNĐ</h5>
                                </div>

                            </div>
                        </div>
                    </c:forEach>


                </div>
                <c:forEach begin="1" end="${endPage}" var="i">
                    <a href="shop-products?index=${i}" class="pagi">${i}</a>
                </c:forEach>
                <c:if test="${not empty endPageS}">
                    <c:forEach begin="1" end="${endPageS}" var="i">
                        <c:if test="${empty cateId && empty sort}">
                            <a href="SortPriceController?index=${i}" class="pagi">${i}</a>
                        </c:if>
                        <c:if test="${empty cateId && not empty sort}">
                            <a href="SortPriceController?index=${i}&sort=${sort}" class="pagi">${i}</a>
                        </c:if>
                        <c:if test="${not empty cateId && empty sort}">
                            <a href="SortPriceController?index=${i}&cateId=${cateId}" class="pagi">${i}</a>
                        </c:if>
                        <c:if test="${not empty cateId && not empty sort}">
                            <a href="SortPriceController?index=${i}&cateId=${cateId}&sort=${sort}" class="pagi">${i}</a>
                        </c:if>                        
                    </c:forEach>
                </c:if>
            </div>

        </section>
        <!-- Featured Section End -->
        <jsp:include page="footer.jsp" />
    </body>
</html>
