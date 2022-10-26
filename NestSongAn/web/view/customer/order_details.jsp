<%-- 
    Document   : my_order
    Created on : Oct 13, 2022, 7:29:30 AM
    Author     : Admin
--%>

<%@page import="dtos.GoogleDTO"%>
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
        <title>Chi Tiết Đơn Hàng</title>

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

    </head>
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}

        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            padding-top: 100px; /* Location of the box */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }

        /* Modal Content */
        .modal-content {
            background-color: #fefefe;
            margin: auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
        }

        /* The Close Button */
        .close {
            color: #aaaaaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
</head>

<body>

    <jsp:include page="../../header.jsp" />
    <% UsersDTO u = (UsersDTO) session.getAttribute("USER");%>
    <% GoogleDTO us = (GoogleDTO) session.getAttribute("USERG");%>
    <c:if test="${not empty user }">

        <div class="container">
            <h4 style="color: #6a0e13">Chi tiết đơn hàng #${order_id}</h4>            
            <p><span style="font-weight: bold">Cửa hàng: </span>Song Ân</p>
            <p><span style="font-weight: bold">Tên khách hàng:  </span>${user.full_name}</p>
            <p><span style="font-weight: bold">Số điện thoại: </span>${user.phone}</p>
            <p><span style="font-weight: bold">Địa chỉ: </span>${address}</p>

            <table class="table table-striped">
                <thead>

                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Sản phẩm</th>
                        <th scope="col">ĐVT</th>
                        <th scope="col">Số lượng</th>
                        <th scope="col">Đơn giá</th>
                        <th scope="col">Đánh giá</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${listOrderDetail}" var="l">

                        <tr>
                            <td>${l.order_details_id}</td>
                            <td>${l.product_id.name}</td>
                            <td>1</td>
                            <td>${l.quantity}</td>
                            <td><fmt:formatNumber type="number" groupingUsed="true" value="${l.total_price}" /> VNĐ</td>
                            <td>
                                <c:if test = "${l.order_id.status == '3'}">
                                    <a href="feedback?pid=${l.product_id.product_id}&uid=${user.user_id}" style="color: #6a0e13">Đánh giá</a>
                                </c:if>
                                <c:if test = "${l.order_id.status == '1' || '2' ||'4' ||'5'}">
                                </c:if>
                            </td
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </c:if>
    <c:if test="${not empty usergg }">
        <div class="container">
            <h4 style="color: #6a0e13">Chi tiết đơn hàng #${order_id}</h4>
            <p><span style="font-weight: bold">Cửa hàng: </span>Song Ân</p>
            <p><span style="font-weight: bold">Tên khách hàng:  </span><%= us.getName()%></p>
            <p><span style="font-weight: bold">Email: </span><%= us.getEmail()%></p>
            <p><span style="font-weight: bold">Địa chỉ: </span>${address}</p>
            <table class="table table-striped">
                <thead>

                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Sản phẩm</th>
                        <th scope="col">ĐVT</th>
                        <th scope="col">Số lượng</th>
                        <th scope="col">Đơn giá</th>
                        <th scope="col">Đánh giá</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listOrderDetail}" var="l">

                        <tr>
                            <td>${l.order_details_id}</td>
                            <td>${l.product_id.name}</td>
                            <td>1</td>
                            <td>${l.quantity}</td>
                            <td><fmt:formatNumber type="number" groupingUsed="true" value="${l.total_price}" /> VNĐ</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </c:if>

    <jsp:include page="../../footer.jsp" />
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
    <script>

        // Get the modal
        var modal = document.getElementById("myModal");

        // Get the button that opens the modal
        var btn = document.getElementById("myBtn");

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];

        // When the user clicks the button, open the modal 
        btn.onclick = function () {
            modal.style.display = "block";
        }

        // When the user clicks on <span> (x), close the modal
        span.onclick = function () {
            modal.style.display = "none";
        }

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function (event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>

</body>
</html>
