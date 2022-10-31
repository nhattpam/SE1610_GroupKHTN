<%-- 
    Document   : product_details
    Created on : Sep 17, 2022, 9:01:30 PM
    Author     : Admin
--%>

<%@page import="dtos.GoogleDTO"%>
<%@page import="dtos.CartDTO"%>
<%@page import="dtos.CartDTO"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="dtos.UsersDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Chi Tiết Sản Phẩm</title>

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
        <style>
            *{
                font-family: Tahoma, Verdana, Segoe, sans-serif;
            }
            .featured__item__pic__hover li:hover a {
                color: #6a0e13;
                border-color: #6a0e13;
            }
            .product__item__pic__hover li:hover a {
                background: #6a0e13;
                border-color: #6a0e13;
            }


        </style>
    </head>

    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Humberger Begin -->
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
                                <c:forEach items="${CList}" var="l">
                                    <li><a href="danh-muc?cateId=${l.category_id}">${l.name}</a></li>
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
                                    <button type="submit" class="site-btn" style="background: #6a0e13;">TÌM KIẾM</button>
                                </form>
                            </div>
                            <div class="hero__search__phone">
                                <div class="hero__search__phone__icon">
                                    <i class="fa fa-phone" style="color: #6a0e13;"></i>
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
        <section class="breadcrumb-section set-bg" data-setbg="img/imang1.png">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="breadcrumb__text">
                            <h2>Sản Phẩm Chính Hãng</h2>
                            <div class="breadcrumb__option">
                                <a href="home">Trang Chủ</a>
                                <span>Chi Tiết Sản Phẩm</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->
        <!-- Product Details Section Begin -->
        <section class="product-details spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="product__details__pic">
                            <div class="product__details__pic__item">
                                <img class="product__details__pic__item--large"
                                     src="products/${detail.photo}" alt="">
                            </div>
                            <div>
                                Bạn đang xem giá tại: <span style="font-weight: bold;">${q.branch_id.name}</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="product__details__text">
                            <h3  style="font-family: Tahoma, Verdana, Segoe, sans-serif;">${detail.name}</h3>
                            <div class="product__details__rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star-half-o"></i>
                                <span>(18 reviews)</span>
                            </div>
                            <div class="product__details__price"><fmt:formatNumber type="number" groupingUsed="true" value="${detail.price}" /> VNĐ</div>
                            <p>${detail.short_description}</p>
                            <c:if test="${q.quantity > 0}">
                                <c:if test="${empty USER && empty USERG}">
                                <a href="loginController" class="primary-btn" style="background: #6a0e13;">THÊM VÀO GIỎ</a>
                            </c:if>
                            <c:if test="${ not empty USER }">
                                <a href="add-cart?command=insert&product_id=${detail.product_id}&cartID=${System.currentTimeMillis()}" class="primary-btn" style="background: #6a0e13;">THÊM VÀO GIỎ</a>
                            </c:if>
                            <c:if test="${ not empty USERG }">
                                <a href="add-cart?command=insert&product_id=${detail.product_id}&cartID=${System.currentTimeMillis()}" class="primary-btn" style="background: #6a0e13;">THÊM VÀO GIỎ</a>
                            </c:if>
                            </c:if>
                            
                            <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
                            <ul>
                                <c:if test="${q.quantity == 0}">
                                    <li><b>Số lượng còn lại</b> <span style="color: red; font-style: italic">Hết hàng</span></li>
                                </c:if>
                                    <c:if test="${q.quantity > 0}">
                                    <li><b>Số lượng còn lại</b> <span>${q.quantity}</span></li>
                                </c:if>
                                <li><b>Vận chuyển</b> <span><samp>Miễn Phí Vận Chuyển Toàn Quốc</samp></span></li>
                                <li><b>Trọng lượng</b> <span>${detail.weight} gam</span></li>
                                <!--                                <li><b>Share on</b>
                                                                    <div class="share">
                                                                        <a href="#"><i class="fa fa-facebook"></i></a>
                                                                        <a href="#"><i class="fa fa-twitter"></i></a>
                                                                        <a href="#"><i class="fa fa-instagram"></i></a>
                                                                        <a href="#"><i class="fa fa-pinterest"></i></a>
                                                                    </div>
                                                                </li>-->
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="product__details__tab">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                                       aria-selected="true">Mô tả</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab"
                                       aria-selected="false">Thông tin bổ sung</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                                       aria-selected="false">Đánh giá <span>(<c:out value="${fn:length(listFeedback)}"/>)</span></a>
                                </li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                    <div class="product__details__tab__desc">
                                        <h6  style="font-family: Tahoma, Verdana, Segoe, sans-serif;">Giới thiệu về ${detail.name}</h6>
                                        <p>${detail.full_description}</p>
                                    </div>
                                </div>
                                <div class="tab-pane" id="tabs-2" role="tabpanel">
                                    <div class="product__details__tab__desc">
                                        <h6>Trọng lượng</h6>
                                        <p>${detail.weight} gam</p>
                                    </div>
                                </div>
                                <div class="tab-pane" id="tabs-3" role="tabpane3">
                                    <div class="product__details__tab__desc">
                                        <section style="background-color: #eee;">
                                            <div class="container py-5">

                                                <div class="row">

                                                    <div class="col-md-6 col-lg-7 col-xl-8">     
                                                        <c:forEach items="${listFeedback}" var="f">
                                                            <li class="d-flex justify-content-between mb-3" width="30">
                                                                <c:if test="${f.user_id.user_id == USER.user_id}"><i class="" width="60"></i></c:if>
                                                                    <div class="card">
                                                                        <div class="card-header d-flex justify-content-between p-3">
                                                                            <p class="fw-bold mb-0">${f.user_id.full_name}</p>
                                                                        <p class="text-muted small mb-0"><i class="far fa-clock"></i> ${f.create_date}</p>
                                                                        <c:if test="${f.user_id.user_id == USER.user_id}">
                                                                            <div class="header__top__right__language fw-bold mb-0">
                                                                                <i class="fa fa-ellipsis-v" aria-hidden="true"></i>
                                                                                <ul>

                                                                                    <li><a href="deletefeedback?fid=${f.feedback_id}&pid=${f.product_id.product_id}" style="color: white;">Gỡ xuống</a></li>

                                                                                    <c:if test="${empty USER && empty USERG}">
                                                                                        <li><a href="loginController" style="color: white;">Gỡ xuống</a></li>
                                                                                        </c:if>    

                                                                                </ul>
                                                                            </div>
                                                                        </c:if>
                                                                    </div>
                                                                    <div class="card-body">
                                                                        <p class="mb-0">
                                                                            ${f.feedback}
                                                                        </p>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                        </c:forEach>
                                                    </div>

                                                </div>

                                            </div>
                                        </section>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Details Section End -->

        <!-- Related Product Section Begin -->
        <section class="related-product">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title related__product__title">
                            <h2 style="font-family: Tahoma, Verdana, Segoe, sans-serif;">Sản Phẩm Mới Nhất</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${listLastest}" var="l">
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" data-setbg="products/${l.photo}">
                                    <ul class="product__item__pic__hover">
                                        <li><a href="#"><i class="fa fa-heart"></i></a></li>
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
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title related__product__title">
                            <h2 style="font-family: Tahoma, Verdana, Segoe, sans-serif;">Sản Phẩm Phổ Biến</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${listPopular}" var="p">
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" data-setbg="products/${p.photo}">
                                    <ul class="product__item__pic__hover">
                                        <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                                <c:if test="${empty USER && empty USERG}">
                                            <li><a href="loginController"><i class="fa fa-shopping-cart"></i></a></li>
                                                </c:if>
                                                <c:if test="${ not empty USER }">
                                            <li><a href="add-cart?command=insert&product_id=${p.product_id}&cartID=${System.currentTimeMillis()}"><i class="fa fa-shopping-cart"></i></a></li>   
                                                </c:if>    
                                                <c:if test="${ not empty USERG }">
                                            <li><a href="add-cart?command=insert&product_id=${p.product_id}&cartID=${System.currentTimeMillis()}"><i class="fa fa-shopping-cart"></i></a></li>    
                                                </c:if>
                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="detail?product_id=${p.product_id}">${p.name}</a></h6>
                                    <h5><fmt:formatNumber type="number" groupingUsed="true" value="${p.price}" /> VNĐ</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>

        <!-- Related Product Section End -->

        <!-- Footer Section Begin -->
        <footer class="footer spad" style="background: #6a0e13">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="footer__about">
                            <div class="footer__about__logo">
                                <a href="./index.html"><img src="img/logo-song-an2.png" style="width: 50%;" alt=""></a>
                            </div>
                            <ul >
                                <li style="color: white;">Địa chỉ: 60-49 Rạch Giá Kiên Giang</li>
                                <li style="color: white;">Sđt:  +84 1235548 48</li>
                                <li style="color: white;">Email: khtnholdings.work.gmail</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                        <div class="footer__widget">
                            <h6 style="color: white;">Thông tin thêm</h6>
                            <ul>
                                <li><a href="ve-song-an" style="color: white;">Về song ân</a></li>
                                <li><a href="huong-dan-mua-hang" style="color: white;">Hướng dẫn mua hàng</a></li>
                                <li><a href="huong-dan-mua-hang" style="color: white;">Thanh toán</a></li>
                            </ul>
                            <ul>
                                <!--<li><a href="#" style="color: white;">Testimonials</a></li>-->
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d125724.66264495872!2d105.0312464060239!3d10.025464559052855!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31a0b383f135522f%3A0xb503ed2c7808c8a!2zVHAuIFLhuqFjaCBHacOhLCBLacOqbiBHaWFuZywgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1665498206471!5m2!1svi!2s" 
                                width="400" height="300" style="border:0;" allowfullscreen="" 
                                loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="footer__copyright">
                            <div class="footer__copyright__text"><p style="color: white;"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> Bản quyền thuộc về Song Ân
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                            <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Footer Section End -->

        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>


    </body>

</html>