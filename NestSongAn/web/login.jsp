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
        <title>Đăng Nhập</title>

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
            a:hover,
            a:focus {
                text-decoration: none;
                outline: none;
            }
        </style>
        <style>
            body {
                color: #434343;
                background: #dfe7e9;
                font-family: 'Varela Round', sans-serif;
            }
            .form-control {
                font-size: 16px;
                transition: all 0.4s;
                box-shadow: none;
            }
            .form-control:focus {
                border-color: #5cb85c;
            }
            .form-control, .btn {
                border-radius: 50px;
                outline: none !important;
            }
            .signin-form {
                width: 400px;
                margin: 0 auto;
                padding: 30px 0;
            }
            .signin-form form {
                border-radius: 10px;
                margin-bottom: 20px;
                background: url('img/login.jpg') no-repeat center center fixed;
                box-shadow: 0px 2px 2px 2px;
                padding: 40px;
            }
            .signin-form a {
                color: #5cb85c;
            }    
            .signin-form h2 {
                text-align: center;
                font-size: 34px;
                margin: 10px 0 15px;
            }
            .signin-form .hint-text {
                color: #999;
                text-align: center;
                margin-bottom: 20px;
            }
            .signin-form .form-group {
                margin-bottom: 20px;
            }
            .signin-form .btn {        
                font-size: 18px;
                line-height: 26px;        
                font-weight: bold;
                text-align: center;
            }
            .signin-form .small {
                font-size: 13px;
            }
            .btn signin-btn {
                text-align: center;
                /*border-color: #6a0e13;*/
                background: #6a0e13 !important;
                /*transition: all 0.4s;*/
            }
            .signin-btn:hover {
                background: #6a0e13;
                /*opacity: 0.8;*/
            }
            .or-seperator {
                margin: 50px 0 15px;
                text-align: center;
                border-top: 1px solid #e0e0e0;
            }
            .or-seperator b {
                padding: 10 40px;
                width: 40px;
                height: 40px;
                font-size: 16px;
                text-align: center;
                line-height: 40px;
                background: #fff;
                display: inline-block;
                border: 1px solid #e0e0e0;
                border-radius: 50%;
                position: relative;
                top: -22px;
                z-index: 1;
            }
            .social-btn .btn {
                color: #fff;
                margin: 0px 0 20px 10px;
                font-size: 15px;
                width: 55px;
                height: 55px;
                line-height: 45px;
                border-radius: 50%;
                font-weight: normal;
                text-align: center;
                border: none;
                transition: all 0.4s;
            }	
            .social-btn .btn:first-child {
                margin-left: 0;
            }
            .social-btn .btn:hover {
                opacity: 0.8;
            }
            .social-btn .btn-primary {
                background: #507cc0;
            }
            .social-btn .btn-info {
                background: #64ccf1;
            }
            .social-btn .btn-danger {
                background: #df4930;
            }
            .social-btn .btn i {
                font-size: 20px;
            }
            body{
                background:url('img/login.jpg') no-repeat center center fixed;
                -webkit-background-size:cover;
                -moz-background-size:cover;
                -o-background-size: cover;
                background-size: cover;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>   
        <div class="signin-form">
            <form action="loginController" method="post">
                <c:if test="${ not empty succMsg }">
                    <h5 class="text-center text-success">${succMsg}</h5>
                    <c:remove var="succMsg" scope="session"/>
                </c:if>
                <c:if test="${ not empty success }">
                    <h5 class="text-center text-success">${success}</h5>
                    <c:remove var="success" scope="session"/>
                </c:if>
                <c:if test="${ not empty LoginError }">
                    <h5 class="text-center text-danger">${LoginError}</h5>
                </c:if>
                    <c:if test="${ not empty inactive }">
                    <h5 class="text-center text-danger">${inactive}</h5>
                </c:if>
                <h2 style="font-weight: bold; color:#6a0e13;">Đăng nhập</h2>
                <p class="hint-text">Đăng nhập với tài khoản google</p>
                <div class="social-btn text-center">
                    <!--<a href="#" class="btn btn-primary btn-lg" title="Facebook"><i class="fa fa-facebook"></i></a>-->
                    <!--<a href="#" class="btn btn-info btn-lg" title="Twitter"><i class="fa fa-twitter"></i></a>-->
                    <a href="https://accounts.google.com/o/oauth2/auth?scope=email profile&redirect_uri=http://localhost:8080/NestSongAn/login-google&response_type=code
                       &client_id=34728737226-pshthan6um4e9qkcndvrrmvhr1b9mqqp.apps.googleusercontent.com&approval_prompt=force" class="btn btn-danger btn-lg" title="Google"><i class="fa fa-google"></i></a>
                </div>
                <!--<div class="or-seperator"><b></b></div>-->
                <div class="form-group">
                    <input type="text" class="form-control input-lg" name="txtUsername" placeholder="Tên đăng nhập" required="required">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control input-lg" name="txtPassword" placeholder="Mật khẩu" required="required">
                </div>  
                <div class="form-group">
                    <button type="submit" class="btn btn-danger btn-lg btn-block signin-btn" style="background: #6a0e13 !important;">Đăng nhập</button>
                </div>
                <div class="text-center small"><a href="forgotPassword" style="color: #6a0e13;">Quên mật khẩu?</a></div>
            </form>
            <div class="text-center small">Chưa có tài khoản <a href="RegisterAccountController" style="color: #6a0e13;">Đăng ký ngay</a></div>
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
