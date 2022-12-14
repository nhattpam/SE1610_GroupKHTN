<%-- 
    Document   : header
    Created on : Sep 17, 2022, 8:30:42 PM
    Author     : Admin
--%>

<%@page import="dtos.GoogleDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="dtos.UsersDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Ogani | Template</title>

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
            *{
                font-family: Tahoma, Verdana, Segoe, sans-serif;
            }
            .header__menu ul li:hover>a {
                color: black;
            }
            .header__menu ul li .header__menu__dropdown li:hover>a {
                color: black;
            }
            .header__menu ul li.active a {
                color: black;
            }
            .header__menu ul li {
                list-style: none;
                display: inline-block;
                margin-right: 20px;
                position: relative;
            }
            #number{
                background: #6a0e13;
            }
        </style>
        <!--fixed navbar-->
        <script type="text/javascript">
            document.addEventListener("DOMContentLoaded", function () {
                window.addEventListener('scroll', function () {
                    if (window.scrollY > 50) {
                        document.getElementById('nav-fixed').classList.add('fixed-top');
                        // add padding top to show content behind navbar
                        navbar_height = document.querySelector('.navbar').offsetHeight;
                        document.body.style.paddingTop = navbar_height + 'px';
                    } else {
                        document.getElementById('nav-fixed').classList.remove('fixed-top');
                        // remove padding top from body
                        document.body.style.paddingTop = '0';
                    }
                });
            });
        </script>
        <!--fixed navbar-->
    </head>
    <body>
        <!-- Humberger Begin -->
        <div class="humberger__menu__overlay"></div>
        <div class="humberger__menu__wrapper">
            <div class="humberger__menu__logo">
                <a href="#"><img src="img/logo-song-an.jpg" alt=""></a>
            </div>
            <div class="humberger__menu__cart">
                <ul>
                    <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                    <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                </ul>
                <div class="header__cart__price">item: <span>555</span></div>
            </div>
            <div class="humberger__menu__widget">
                <div class="header__top__right__language">
                    <img src="img/language.png" alt="">
                    <div>English</div>
                    <span class="arrow_carrot-down"></span>
                    <ul>
                        <li><a href="#">Spanis</a></li>
                        <li><a href="#">English</a></li>
                    </ul>
                </div>
                <div class="header__top__right__auth">
                    <a href="#"><i class="fa fa-user"></i> Login</a>
                </div>
            </div>
            <nav class="humberger__menu__nav mobile-menu">
                <ul>
                    <li class="active"><a href="./index.html">Home</a></li>
                    <li><a href="./shop-grid.html">Shop</a></li>
                    <li><a href="#">Pages</a>
                        <ul class="header__menu__dropdown">
                            <li><a href="./shop-details.html">Shop Details</a></li>
                            <li><a href="./shoping-cart.html">Shoping Cart</a></li>
                            <li><a href="./checkout.html">Check Out</a></li>
                            <li><a href="./blog-details.html">Blog Details</a></li>
                        </ul>
                    </li>
                    <li><a href="./blog.html">Blog</a></li>
                    <li><a href="./contact.html">Contact</a></li>
                </ul>
            </nav>
            <div class="humberger__menu__contact">
                <ul>
                    <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                    <li>Free Shipping for all Order of $99</li>
                </ul>
            </div>
        </div>
        <!-- Humberger End -->

        <!-- Header Section Begin -->
        <header class="header">
            <div class="header__top" style="background: #6a0e13;" id="nav-fixed">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">

                        </div>
                        <div class="col-lg-6 col-md-6">
                            <div class="header__top__right">
                                <div class="header__top__right__social" >
                                </div>
                                <div class="header__top__right__language">                                   
                                </div>
                                <!--login-->

                                <c:if test="${not empty USER}">
                                    <div class="header__top__right__language">
                                        <a href="" style="color: white;"><i class="fa fa-user"></i> ${USER.full_name}</a>
                                        <span class="arrow_carrot-down"></span>
                                        <ul>
                                            <li><a href="MyProfile?uid=${USER.user_id}" style="color: white;">T??i kho???n</a></li>
                                            <li><a href="my-order?uid=${USER.user_id}" style="color: white;">L???ch s??? mua</a></li>
                                                <c:url var="logout" value="logoutController"/>
                                            <li><a href="${logout}" style="color: white;">????ng xu???t</a></li>
                                        </ul>
                                    </div>
                                </c:if>
                                <c:if test="${not empty USERG}">
                                    <div class="header__top__right__language">
                                        <a href="" style="color: white;"><i class="fa fa-user"></i> ${USERG.name}</a>
                                        <span class="arrow_carrot-down"></span>
                                        <ul>
                                            <li><a href="my-order-gg" style="color: white;">L???ch s??? mua</a></li>
                                                <c:url var="logout" value="logoutController"/>
                                            <li><a href="${logout}" style="color: white;">????ng xu???t</a></li>
                                        </ul>
                                    </div>
                                </c:if>
                                <c:if test="${empty USER && empty USERG}">
                                    <div class="header__top__right__auth">
                                        <a href="loginController" style="color: white;"><i class="fa fa-user"></i> ????ng nh???p</a>
                                    </div>
                                </c:if>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="header__logo">
                            <a href="home"><img src="img/logo-song-an2.png" alt="" style="width: 30%;"></a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <nav class="header__menu">
                            <ul>
                                <li class="active"><a href="trang-chu?bid=${sessionScope.branch_id}" style="color: #6a0e13;">Trang Ch???</a></li>
                                <li><a href="shop-products?bid=${sessionScope.branch_id}" style="color: #6a0e13;">S???n Ph???m</a></li>
                                <li><a href="ve-song-an" style="color: #6a0e13;">V??? Song ??n</a>
                                    <ul class="header__menu__dropdown">
                                        <li><a href="ve-song-an">Gi???i thi???u</a></li>
                                        <li><a href="huong-dan-mua-hang">H?????ng d???n mua h??ng</a></li>
                                        <!--                                        <li><a href="./checkout.html">Check Out</a></li>
                                                                                <li><a href="./blog-details.html">Blog Details</a></li>-->
                                    </ul>
                                </li>

                                <!--<li><a href="./contact.html">Contact</a></li>-->
                            </ul>
                        </nav>
                    </div>


                    <div class="col-lg-3">
                        <div class="header__cart">
                            <ul>
                                <c:if test="${empty USER && empty USERG}">
                                    <li><a href="loginController"><i class="fa fa-heart"></i> </a></li>
                                </c:if>
                                <c:if test="${ not empty USER }">
                                    <li><a href="ViewWishlist?bid=${sessionScope.branch_id}"><i class="fa fa-heart"></i> </a></li>
                                </c:if>
                                <c:if test="${ not empty USERG }">
                                    <li><a href="ViewWishlist?bid=${sessionScope.branch_id}"><i class="fa fa-heart"></i> </a></li>
                                </c:if>
                                <c:if test="${empty USER && empty USERG}">
                                    <li><a href="loginController"><i class="fa fa-shopping-bag"></i> </a></li>
                                </c:if>
                                <c:if test="${ not empty USER }">
                                    <li><a href="my-cart?uid=${USER.user_id}&bid=${sessionScope.branch_id}"><i class="fa fa-shopping-bag"></i><span  id="number"><c:out value="${fn:length(sessionScope.numlist)}"/></span></a></li>
                                </c:if>
                                <c:if test="${ not empty USERG }">
                                        <li><a href="my-cart?uid=${USERG.id}&bid=${sessionScope.branch_id}"><i class="fa fa-shopping-bag"></i><span id="number"><c:out value="${fn:length(sessionScope.numlist)}"/></span></a></li>
                                </c:if>

                            </ul>

                        </div>
                    </div>
                </div>
                <div class="humberger__open">
                    <i class="fa fa-bars"></i>
                </div>
            </div>
        </header>
        <!-- Header Section End -->

    </body>
</html>