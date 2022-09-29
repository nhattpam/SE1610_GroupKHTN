<%-- 
    Document   : login
    Created on : Sep 19, 2022, 9:42:17 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Đăng ký</title>

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
    </head>
    <body>
        <jsp:include page="header.jsp" />



        <div class="container mb-3">
            <form action="RegisterController" method="post">
               
                <h4>Đăng Ký tài khoản</h4>
                <c:if test="${ not empty succMsg }">
                    <h5 class="text-center text-success">${succMsg}</h5>
                    <c:remove var="succMsg" scope="session"/>
                </c:if>

                <c:if test="${ not empty failedMsg }">
                    <h5 class="text-center text-danger">${failedMsg}</h5>
                    <c:remove var="failedMsg" scope="session"/>
                </c:if>

                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Họ và tên</label>
                    <c:if test="${ not empty wrongFullName }">
                        <p class="text-danger">${wrongFullName}</p>
                        <c:remove var="wrongFullName" scope="session"/>
                    </c:if>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" name="full_name">
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Tên đăng nhập</label>
                    <c:if test="${ not empty wrongUser_name }">
                        <p class="text-danger">${wrongUser_name}</p>
                        <c:remove var="wrongUser_name" scope="session"/>
                    </c:if>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" name="user_name">
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Số điện thoại</label>
                    <c:if test="${ not empty wrongPhone }">
                        <p class="text-danger">${wrongPhone}</p>
                        <c:remove var="wrongPhone" scope="session"/>
                    </c:if>
                    <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" name="phone">
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Địa chỉ email</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" name="email">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Mật khẩu</label>
                    <c:if test="${ not empty wrongPassword }">
                        <p class="text-danger">${wrongPassword}</p>
                        <c:remove var="wrongPassword" scope="session"/>
                    </c:if>
                    <input type="password" class="form-control" id="exampleInputPassword1"  required="" name="password">
                </div>

                <button type="submit" class="btn btn-primary">Đăng ký</button>
            </form>
        </div>
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
</html>
