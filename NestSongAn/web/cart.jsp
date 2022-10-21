<%@page import="java.io.PrintWriter"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Map"%>
<%@page import="dtos.ProductDTO"%>
<%@page import="java.util.TreeMap"%>
<%@page import="dtos.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Giỏ Hàng</title>

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
                background:#F0F0E9;
                color: #696763;
                display: inline-block;
                font-size: 16px;
                height: 28px;
                overflow: hidden;
                text-align: center;
                width: 35px;
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

        <jsp:include page="header.jsp" />


        <section id="cart_items">
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <li><a href="home">Trang Chủ</a></li>
                        <li class="active">Giỏ Hàng</li>
                    </ol>
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
                            <c:set var="noti" scope="session" value="${wrongQuantity}" />
                           
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
                                            <c:if test="${ not empty wrongQuantity }">
                                                <p class="text-danger">${wrongQuantity}</p>
                                                <c:remove var="wrongQuantity" scope="session"/>
                                            </c:if>
                                            <a class="cart_quantity_up" href="add-cart?command=plus&product_id=${map.key.product_id}&cartID=${System.currentTimeMillis()}&bid=${sessionScope.branch_id}"> + </a>
                                            <input class="cart_quantity_input" type="text" value="${map.value}" autocomplete="off" size="2" disabled="">
                                            <a class="cart_quantity_down" href="add-cart?command=sub&product_id=${map.key.product_id}&cartID=${System.currentTimeMillis()}&bid=${sessionScope.branch_id}"> - </a>

                                        </div>
                                    </td>
                                    <td class="cart_total">
                                        <c:set var="TotalPriceAll" scope="session" value="${TotalPriceAll+(map.value * map.key.price)}" />
                                        <p><fmt:formatNumber type="number" groupingUsed="true" value="${map.key.price * map.value}" /> VNĐ</p>
                                    </td>
                                    <td class="cart_delete">
                                        <a class="cart_quantity_delete" href="add-cart?command=remove&product_id=${map.key.product_id}&cartID=${System.currentTimeMillis()}&bid=${sessionScope.branch_id}"><i class="fa fa-times"></i></a>
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
                <div  class="container-fluid mb-5" style="color: white">
                    <c:if test="${ not empty USER }">
                        <c:if test="${ empty requestScope.list }" >
                            Giỏ hàng trống
                        </c:if>
                        <c:if test="${ not empty requestScope.list && empty sessionScope.noti}">
                            <a class="btn btn-custom btn-lg btn-block" href="checkout?bid=${sessionScope.branch_id}" id="button">TIẾN HÀNH ĐẶT HÀNG</a>
                        </c:if>
                            
                    </c:if>
                     
                    <c:if test="${ not empty USERG }">
                        <c:if test="${ empty requestScope.list }">
                            Giỏ hàng trống
                        </c:if>
                        <c:if test="${ not empty requestScope.list && empty sessionScope.noti }">
                            <a class="btn btn-custom btn-lg btn-block" href="checkoutgg?bid=${sessionScope.branch_id}" id="button">TIẾN HÀNH ĐẶT HÀNG</a>
                        </c:if>
                    </c:if>
                </div>
            </div>

        </section> <!--/#cart_items-->
    </div>
</div>


<jsp:include page="footer.jsp" />
<script>
    $('#myModal').on('shown.bs.modal', function () {
        $('#myInput').trigger('focus');
    });
</script>
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
