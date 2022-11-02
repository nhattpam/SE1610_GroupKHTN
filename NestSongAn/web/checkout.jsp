<%-- 
    Document   : checkout
    Created on : Sep 19, 2022, 9:43:28 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Map"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.TreeMap"%>
<%@page import="dtos.ProductDTO"%>
<%@page import="dtos.CartDTO"%>
<%@page import="dtos.UsersDTO"%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta charset="utf-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Thông Tin Thanh Toán</title>

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
            .breadcrumbs {

            }

            .breadcrumbs .breadcrumb {
                background:transparent;
                margin-bottom: 75px;
                padding-left: 0;
            }

            .breadcrumbs .breadcrumb li a {
                background: #6a0e13;
                color: #FFFFFF;
                padding: 3px 7px;
            }

            .breadcrumbs .breadcrumb li a:after {
                content:"";
                height:auto;
                width: auto;
                border-width: 8px;
                border-style: solid;
                border-color:transparent transparent transparent #6a0e13;
                position: absolute;
                top: 11px;
                left:48px;

            }

            .breadcrumbs .breadcrumb > li + li:before {
                content: " ";
            }

            #cart_items .cart_info {
                border: 1px solid #E6E4DF;
                margin-bottom: 50px
            }


            #cart_items .cart_info .cart_menu {
                background: #6a0e13;
                color: #fff;
                font-size: 16px;
                font-family: 'Roboto', sans-serif;
                font-weight: normal;
            }

            #cart_items .cart_info .table.table-condensed thead tr {
                height: 51px;
            }


            #cart_items .cart_info .table.table-condensed tr {
                border-bottom: 1px solid#F7F7F0
            }

            #cart_items .cart_info .table.table-condensed tr:last-child {
                border-bottom: 0
            }

            .cart_info table tr td {
                border-top: 0 none;
                vertical-align: inherit;
            }


            #cart_items .cart_info .image {
                padding-left: 30px;
            }


            #cart_items .cart_info .cart_description h4 {
                margin-bottom: 0
            }

            #cart_items .cart_info .cart_description h4 a {
                color: #363432;
                font-family: 'Roboto',sans-serif;
                font-size: 20px;
                font-weight: normal;

            }

            #cart_items .cart_info .cart_description p {
                color:#696763
            }


            #cart_items .cart_info .cart_price p {
                color:#696763;
                font-size: 18px
            }


            #cart_items .cart_info .cart_total_price {
                color: #6a0e13;
                font-size: 24px;
            }

            .cart_product {
                display: block;
                margin: 15px -70px 10px 25px;
            }

            .cart_quantity_button a {
                background: #F0F0E9;
                color: #696763;
                display: inline-block;
                font-size: 16px;
                height: 28px;
                overflow: hidden;
                text-align: center;
                width: 20px;
                float: left;
            }


            .cart_quantity_input {
                color: #696763;
                float: left;
                font-size: 16px;
                text-align: center;
                font-family: 'Roboto',sans-serif;

            }


            .cart_delete  {
                display: block;
                margin-right: -12px;
                overflow: hidden;
            }


            .cart_delete a {
                background:#6a0e13;
                color: #FFFFFF;
                padding: 5px 7px;
                font-size: 16px
            }

            .cart_delete a:hover {
                background:#FE980F
            }

            #button{
                background: #6a0e13;
                color: white;
            }

        </style>
    </head>

    <body>
        <!-- Page Preloder -->
        <!--        <div id="preloder">
                    <div class="loader"></div>
                </div>-->
        <jsp:include page="header.jsp" />


        <section id="cart_items">
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <!--<li><a href="home">Trang Chủ</a></li>-->
                        <li><a href="my-cart" style="padding: 2px 4px 2px 2px;" >Giỏ Hàng</a></li>
                        <li class="active">Thanh Toán</li>
                    </ol>
                </div><!--/breadcrums-->

                <div class="content-wrapper " style="margin-bottom: 50px;">
                    <div class="container ">
                        <div class="row crd-ho">
                            <div class="col-md-6 offset-md-3">
                                <c:if test="${not empty user }">
                                    <div class="card">
                                        <div class="card-body">
                                            <c:if test="${ not empty notiCheckout }">
                                                <h5 class="text-center text-danger">${notiCheckout}</h5>
                                                <c:remove var="notiCheckout" scope="session"/>
                                            </c:if>
                                            <h4 class="text-center" style="color: #6a0e13; font-weight: bolder;">Thông Tin Đặt Hàng</h4><br>


                                            <form action="checkout?bid=${sessionScope.branch_id}" method="post">
                                                <input type="hidden" value="${user.user_id}" name="id">
                                                <div class="form-group" style="font-weight: bold;">
                                                    Họ và tên<input type="text" class="form-control" id="exampleInputPassword1" value="${user.full_name}" disabled="">
                                                </div> 
                                                <div class="form-group" style="font-weight: bold;">
                                                    Số điện thoại<input type="text" class="form-control" id="exampleInputPassword1" value="${user.phone}" disabled="">
                                                </div> 
                                                <c:if test="${ not empty wrongAddress }">
                                                    <p class="text-danger">${wrongAddress}</p>
                                                    <c:remove var="wrongAddress" scope="session"/>
                                                </c:if>
                                                <div style="font-weight: bold;" class="form-group">
                                                    Địa chỉ giao hàng
                                                </div>
                                                <div class="form-row" >
                                                    <c:set var = "tp" scope = "session" value = "${branch_id}"/>
                                                    <div class="col-12">
                                                        <select name="province" class="form-select selectpicker" required="">
                                                            <option value="chooseCity" selected="">--Tỉnh/Thành Phố--</option>
                                                            <c:if test="${tp == 1}">
                                                                <option value="Hoà Bình">Hoà Bình</option>
                                                                <option value="Sơn La">Sơn La</option>
                                                                <option value="Điện Biên">Điện Biên</option>
                                                                <option value="Lai Châu">Lai Châu</option>
                                                                <option value="Lào Cai">Lào Cai</option>
                                                                <option value="Yên Bái">Yên Bái</option>
                                                                <option value="Phú Thọ">Phú Thọ</option>
                                                                <option value="Hà Giang">Hà Giang</option>
                                                                <option value="Tuyên Quang">Tuyên Quang</option>
                                                                <option value="Cao Bằng">Cao Bằng</option>
                                                                <option value="Bắc Kạn">Bắc Kạn</option>
                                                                <option value="Thái Nguyên">Thái Nguyên</option>
                                                                <option value="Lạng Sơn">Lạng Sơn</option>
                                                                <option value="Bắc Giang">Bắc Giang</option>
                                                                <option value="Quảng Ninh">Quảng Ninh</option>
                                                                <option value="Hà Nội">Hà Nội</option>
                                                                <option value="Bắc Ninh">Bắc Ninh</option>
                                                                <option value="Hà Nam">Hà Nam</option>
                                                                <option value="Hải Dương">Hải Dương</option>
                                                                <option value="Hải Phòng">Hải Phòng</option>
                                                                <option value="Hưng Yên">Hưng Yên</option>
                                                                <option value="Nam Định">Nam Định</option>
                                                                <option value="Thái Bình">Thái Bình</option>
                                                                <option value="Vĩnh Phúc">Vĩnh Phúc</option>
                                                                <option value="Ninh Bình">Ninh Bình</option>
                                                            </c:if>
                                                            <c:if test="${tp == 2}">
                                                                <option value="Thanh Hoá">Thanh Hoá</option>
                                                                <option value="Nghệ An">Nghệ An</option>
                                                                <option value="Hà Tĩnh">Hà Tĩnh</option>
                                                                <option value="Quảng Bình">Quảng Bình</option>
                                                                <option value="Quảng Trị">Quảng Trị</option>
                                                                <option value="Thừa Thiên Huế">Thừa Thiên Huế</option>
                                                                <option value="Đà Nẵng">Đà Nẵng</option>
                                                                <option value="Quảng Nam">Quảng Nam</option>
                                                                <option value="Quảng Ngãi">Quảng Ngãi</option>
                                                                <option value="Bình Định">Bình Định</option>
                                                                <option value="Phú Yên">Phú Yên</option>
                                                                <option value="Khánh Hoà">Khánh Hoà</option>
                                                                <option value="Ninh Thuận">Ninh Thuận</option>
                                                                <option value="Bình Thuận">Bình Thuận</option>
                                                                <option value="Kon Tum">Kon Tum</option>
                                                                <option value="Gia Lai">Gia Lai</option>
                                                                <option value="Đắk Lắk">Đắk Lắk</option>
                                                                <option value="Đắk Nông">Đắk Nông</option>
                                                                <option value="Lâm Đồng">Lâm Đồng</option>
                                                            </c:if>
                                                            <c:if test="${tp == 3}">
                                                                <option value="TP Hồ Chí Minh">TP Hồ Chí Minh</option>
                                                                <option value="Bà Rịa Vũng Tàu">Bà Rịa Vũng Tàu</option>
                                                                <option value="Bình Dương">Bình Dương</option>
                                                                <option value="Bình Phước">Bình Phước</option>
                                                                <option value="Đồng Nai">Đồng Nai</option>
                                                                <option value="Tây Ninh">Tây Ninh</option>
                                                                <option value="An Giang">An Giang</option>
                                                                <option value="Bạc Liêu">Bạc Liêu</option>
                                                                <option value="Bến Tre">Bến Tre</option>
                                                                <option value="Cà Mau">Cà Mau</option>
                                                                <option value="Cần Thơ">Cần Thơ</option>
                                                                <option value="Đồng Tháp">Đồng Tháp</option>
                                                                <option value="Hậu Giang">Hậu Giang</option>
                                                                <option value="Kiên Giang">Kiên Giang</option>
                                                                <option value="Long An">Long An</option>
                                                                <option value="Sóc Trăng">Sóc Trăng</option>
                                                                <option value="Tiền Giang">Tiền Giang</option>
                                                                <option value="Trà Vinh">Trà Vinh</option>
                                                                <option value="Vĩnh Long">Vĩnh Long</option>
                                                            </c:if>

                                                        </select>
                                                    </div>
                                                </div>  
                                                <br>

                                                <div class="form-group">
                                                    <input name="delivery_address" type="text" class="form-control" id="exampleInputPassword1" required="required" placeholder="Địa chỉ chi tiết" value="${address}">
                                                </div> 
                                                <div class="form-group">
                                                    <select name="payment_method" required=""> 
                                                        <option value="choosePay" selected="">--Phương Thức Thanh Toán--</option>
                                                        <option value="cod">Thanh toán khi nhận hàng</option>
                                                    </select><br>
                                                </div> <br>
                                                <div  class="form-group">
                                                    <input type="submit" value="Xác nhận thanh toán" class="btn btn-custom btn-lg btn-block" id="button">
                                                </div>

                                            </form>
                                        </div> 
                                    </div>
                                </c:if>

                                <c:if test="${not empty usergg }">
                                    <div class="card">
                                        <div class="card-body">
                                            <c:if test="${ not empty notiCheckout }">
                                                <h5 class="text-center text-danger">${notiCheckout}</h5>
                                                <c:remove var="notiCheckout" scope="session"/>
                                            </c:if>
                                            <h4 class="text-center" style="color: #6a0e13; font-weight: bolder;">Thông Tin Đặt Hàng</h4><br>


                                            <form action="checkoutgg?bid=${sessionScope.branch_id}" method="post">
                                                <input type="hidden" value="${usergg.user_id}" name="id">
                                                <div class="form-group" style="font-weight: bold;">
                                                    Họ và tên<input type="text" class="form-control" id="exampleInputPassword1" value="${usergg.full_name}" disabled="">
                                                </div> 
                                                <c:if test="${ not empty wrongPhone }">
                                                    <p class="text-danger">${wrongPhone}</p>
                                                    <c:remove var="wrongPhone" scope="session"/>
                                                </c:if>
                                                <div class="form-group" style="font-weight: bold;">
                                                    Số điện thoại<input type="number" class="form-control" id="exampleInputPassword1" name="phone" value="${usergg.phone}">
                                                </div> 
                                                <c:if test="${ not empty wrongAddress }">
                                                    <p class="text-danger">${wrongAddress}</p>
                                                    <c:remove var="wrongAddress" scope="session"/>
                                                </c:if>
                                                <div style="font-weight: bold;" class="form-group">
                                                    Địa chỉ giao hàng
                                                </div>
                                                <div class="form-row" >
                                                    <c:set var = "tp" scope = "session" value = "${branch_id}"/>
                                                    <div class="col-12">
                                                        <select name="province" class="form-select selectpicker" required="">
                                                            <option value="chooseCity" selected="">--Tỉnh/Thành Phố--</option>
                                                            <c:if test="${tp == 1}">
                                                                <option value="Hoà Bình">Hoà Bình</option>
                                                                <option value="Sơn La">Sơn La</option>
                                                                <option value="Điện Biên">Điện Biên</option>
                                                                <option value="Lai Châu">Lai Châu</option>
                                                                <option value="Lào Cai">Lào Cai</option>
                                                                <option value="Yên Bái">Yên Bái</option>
                                                                <option value="Phú Thọ">Phú Thọ</option>
                                                                <option value="Hà Giang">Hà Giang</option>
                                                                <option value="Tuyên Quang">Tuyên Quang</option>
                                                                <option value="Cao Bằng">Cao Bằng</option>
                                                                <option value="Bắc Kạn">Bắc Kạn</option>
                                                                <option value="Thái Nguyên">Thái Nguyên</option>
                                                                <option value="Lạng Sơn">Lạng Sơn</option>
                                                                <option value="Bắc Giang">Bắc Giang</option>
                                                                <option value="Quảng Ninh">Quảng Ninh</option>
                                                                <option value="Hà Nội">Hà Nội</option>
                                                                <option value="Bắc Ninh">Bắc Ninh</option>
                                                                <option value="Hà Nam">Hà Nam</option>
                                                                <option value="Hải Dương">Hải Dương</option>
                                                                <option value="Hải Phòng">Hải Phòng</option>
                                                                <option value="Hưng Yên">Hưng Yên</option>
                                                                <option value="Nam Định">Nam Định</option>
                                                                <option value="Thái Bình">Thái Bình</option>
                                                                <option value="Vĩnh Phúc">Vĩnh Phúc</option>
                                                                <option value="Ninh Bình">Ninh Bình</option>
                                                            </c:if>
                                                            <c:if test="${tp == 2}">
                                                                <option value="Thanh Hoá">Thanh Hoá</option>
                                                                <option value="Nghệ An">Nghệ An</option>
                                                                <option value="Hà Tĩnh">Hà Tĩnh</option>
                                                                <option value="Quảng Bình">Quảng Bình</option>
                                                                <option value="Quảng Trị">Quảng Trị</option>
                                                                <option value="Thừa Thiên Huế">Thừa Thiên Huế</option>
                                                                <option value="Đà Nẵng">Đà Nẵng</option>
                                                                <option value="Quảng Nam">Quảng Nam</option>
                                                                <option value="Quảng Ngãi">Quảng Ngãi</option>
                                                                <option value="Bình Định">Bình Định</option>
                                                                <option value="Phú Yên">Phú Yên</option>
                                                                <option value="Khánh Hoà">Khánh Hoà</option>
                                                                <option value="Ninh Thuận">Ninh Thuận</option>
                                                                <option value="Bình Thuận">Bình Thuận</option>
                                                                <option value="Kon Tum">Kon Tum</option>
                                                                <option value="Gia Lai">Gia Lai</option>
                                                                <option value="Đắk Lắk">Đắk Lắk</option>
                                                                <option value="Đắk Nông">Đắk Nông</option>
                                                                <option value="Lâm Đồng">Lâm Đồng</option>
                                                            </c:if>
                                                            <c:if test="${tp == 3}">
                                                                <option value="TP Hồ Chí Minh">TP Hồ Chí Minh</option>
                                                                <option value="Bà Rịa Vũng Tàu">Bà Rịa Vũng Tàu</option>
                                                                <option value="Bình Dương">Bình Dương</option>
                                                                <option value="Bình Phước">Bình Phước</option>
                                                                <option value="Đồng Nai">Đồng Nai</option>
                                                                <option value="Tây Ninh">Tây Ninh</option>
                                                                <option value="An Giang">An Giang</option>
                                                                <option value="Bạc Liêu">Bạc Liêu</option>
                                                                <option value="Bến Tre">Bến Tre</option>
                                                                <option value="Cà Mau">Cà Mau</option>
                                                                <option value="Cần Thơ">Cần Thơ</option>
                                                                <option value="Đồng Tháp">Đồng Tháp</option>
                                                                <option value="Hậu Giang">Hậu Giang</option>
                                                                <option value="Kiên Giang">Kiên Giang</option>
                                                                <option value="Long An">Long An</option>
                                                                <option value="Sóc Trăng">Sóc Trăng</option>
                                                                <option value="Tiền Giang">Tiền Giang</option>
                                                                <option value="Trà Vinh">Trà Vinh</option>
                                                                <option value="Vĩnh Long">Vĩnh Long</option>
                                                            </c:if>

                                                        </select>
                                                    </div>
                                                </div> 
                                                <br>

                                                <div class="form-group">
                                                    <input name="delivery_address" type="text" class="form-control" id="exampleInputPassword1" required="required" placeholder="Địa chỉ chi tiết">
                                                </div> 
                                                <div class="form-group">
                                                    <select name="payment_method" required=""> 
                                                        <option value="choosePay" selected="">--Phương Thức Thanh Toán--</option>
                                                        <option value="cod">Thanh toán khi nhận hàng</option>
                                                    </select><br>
                                                </div> <br>
                                                <div  class="form-group">
                                                    <input type="submit" value="Xác nhận thanh toán" class="btn btn-custom btn-lg btn-block" id="button">
                                                </div>

                                            </form>
                                        </div> 
                                    </div>
                                </c:if>

                            </div>
                        </div>
                        <div class="table-responsive cart_info">
                            <table class="table table-condensed">
                                <thead>
                                    <tr class="cart_menu">
                                        <td class="image">Sản Phẩm</td>
                                        <td class="description"></td>
                                        <td class="price">Giá</td>
                                        <td class="quantity">Số Lượng</td>
                                        <td class="total">Tổng</td>
                                        <td></td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:set var="TotalPriceAll" scope="session" value="0" />
                                    <c:forEach items="${requestScope.list}" var="map">
                                        <tr>
                                            <td class="cart_product">
                                                <a href=""><img src="products/${map.key.photo}" alt="" style="width: 50px; height: 60px;"></a>
                                            </td>
                                            <td class="cart_description">
                                                <h4><a href="">${map.key.name}</a></h4>
                                                <p>Code: ${map.key.code}</p>
                                            </td>
                                            <td class="cart_price">
                                                <p><fmt:formatNumber type="number" groupingUsed="true" value="${map.key.price}" /> VNĐ</p>
                                            </td>
                                            <td class="cart_quantity">
                                                <div class="cart_quantity_button">
                                                    <a class="cart_quantity_up" href="add-cart?command=plus&product_id=${map.key.product_id}&cartID=${System.currentTimeMillis()}"> + </a>
                                                    <input class="cart_quantity_input" type="text" value="${map.value}" autocomplete="off" size="2" disabled="">
                                                    <a class="cart_quantity_down" href="add-cart?command=sub&product_id=${map.key.product_id}&cartID=${System.currentTimeMillis()}"> - </a>
                                                </div>
                                            </td>
                                            <td class="cart_total">
                                                <c:set var="TotalPriceAll" scope="session" value="${TotalPriceAll+(map.value * map.key.price)}" />
                                                <p><fmt:formatNumber type="number" groupingUsed="true" value="${map.key.price * map.value}" /> VNĐ</p>
                                            </td>
                                            <td class="cart_delete">
                                                <a class="cart_quantity_delete" href="add-cart?command=remove&product_id=${map.key.product_id}&cartID=${System.currentTimeMillis()}"><i class="fa fa-times"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>


                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td style="font-weight: bold;">Tiền tạm tính: </td>
                                        <td style="color: green; font-size: large; font-weight: bold;"><fmt:formatNumber type="number" groupingUsed="true" value="${TotalPriceAll}" /> VNĐ</td>
                                    </tr>
                                </tbody>

                            </table>

                        </div>

                    </div>
                </div>

            </div>
        </section> <!--/#cart_items-->


        <jsp:include page="footer.jsp" />


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
