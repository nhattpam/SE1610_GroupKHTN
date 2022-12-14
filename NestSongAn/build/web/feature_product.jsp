<%-- 
    Document   : feature_product
    Created on : Sep 17, 2022, 8:44:05 PM
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
        <style>
            *{
                font-family: Tahoma, Verdana, Segoe, sans-serif;
            }
        </style>
    </head>
    <body>
        <!-- Featured Section Begin -->
        <section class="featured spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2 style="color: #6a0e13; font-family: Tahoma, Verdana, Segoe, sans-serif;">S???n Ph???m M???i Nh???t</h2>
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
<!--                        <div class="featured__controls">
                            <ul>
                                <li class="active" data-filter="*">All</li>
                                                                                                    <li data-filter=".oranges">Oranges</li>
                                                                                                    <li data-filter=".fresh-meat">Fresh Meat</li>
                                                                                                    <li data-filter=".vegetables">Vegetables</li>
                                                                                                    <li data-filter=".fastfood">Fastfood</li>
                            </ul>
                        </div>-->
                    </div>
                </div>
                
                <div class="row featured__filter">
                    <c:forEach items="${listFeature}" var="l">
                        <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                            <div class="featured__item">
                                <style>
                                    #hello:hover{
                                        font-weight: bold;
                                        color: #6a0e13;
                                    }
                                </style>
                                <div class="featured__item__pic set-bg" data-setbg="products/${l.photo}">
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
                                    <h6><a href="detail?product_id=${l.product_id}&bid=${sessionScope.branch_id}" id="hello">${l.name}</a></h6>
                                    <h5><fmt:formatNumber type="number" groupingUsed="true" value="${l.price}" /> VN??</h5>
                                </div>

                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Featured Section End -->
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
