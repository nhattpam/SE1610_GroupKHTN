<%-- 
    Document   : search
    Created on : Oct 4, 2022, 9:09:11 PM
    Author     : Admin
--%>

<%@page import="dtos.CartDTO"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="dtos.UsersDTO"%>
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
        <title>Kết Quả Tìm Kiếm</title>

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
        <link rel="stylesheet" href="css/style.css" type="text/css" />

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
            *{
                font-family: Tahoma, Verdana, Segoe, sans-serif;
            }
        </style>
    </head>
    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>
        <jsp:include page="header.jsp" />
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
                                <c:forEach items="${CList}" var="l">
                                    <li><a href="">${l.name}</a></li>
                                </c:forEach>

                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="hero__search">
                            <div class="hero__search__form">
                                <form action="search-result">
                                    <div class="hero__search__categories">
                                        Danh Mục
                                        <span class="arrow_carrot-down"></span>
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
        <section class="featured spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2 style="font-family: Tahoma, Verdana, Segoe, sans-serif;">Kết Quả Tìm Kiếm</h2>
                            <br>
                            <br>
                            <c:if test="${not empty wrongSearch}">
                                <h5>${wrongSearch}</h5>
                                <c:remove var="wrongSearch" scope="session" />
                            </c:if>

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
                            </style>
                        </div>
                    </div>
                </div>

                <div class="row featured__filter">
                    <c:forEach items="${listSearch}" var="l">
                        <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                            <div class="featured__item">

                                <div class="featured__item__pic set-bg" data-setbg="products/${l.photo}">
                                    <ul class="featured__item__pic__hover">
                                        <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                        <!--<li><a href="#"><i class="fa fa-retweet"></i></a></li>-->
                                        
                                        <c:if test="${empty USER && empty USERG}">
                                            <li><a href="loginController"><i class="fa fa-shopping-cart"></i></a></li>
                                        </c:if>
                                        <c:if test="${ not empty USER }">
                                                <li><a href="add-cart?command=insert&product_id=${l.product_id}&cartID=${System.currentTimeMillis()}"><i class="fa fa-shopping-cart"></i></a></li>   
                                        </c:if>    
                                        <c:if test="${ not empty USERG }">
                                             <li><a href="add-cart?command=insert&product_id=${l.product_id}&cartID=${System.currentTimeMillis()}"><i class="fa fa-shopping-cart"></i></a></li>    
                                        </c:if>
                                        
                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="detail?product_id=${l.product_id}">${l.name}</a></h6>
                                    <h5><fmt:formatNumber type="number" groupingUsed="true" value="${l.price}" /> VNĐ</h5>
                                </div>

                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp" />
    </body>
</html>
