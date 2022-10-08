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
        <style>
            body {
                color: #999;
                background: #f5f5f5;
                font-family: 'Roboto', sans-serif;
            }
            .form-control, .form-control:focus, .input-group-addon {
                border-color: #e1e1e1;
                border-radius: 0;
            }
            .signup-form {
                width: 390px;
                margin: 0 auto;
                padding: 30px 0;
            }
            .signup-form h2 {
                color: #636363;
                margin: 0 0 15px;
                text-align: center;
            }
            .signup-form .lead {
                font-size: 14px;
                margin-bottom: 30px;
                text-align: center;
            }
            .signup-form form {		
                border-radius: 2px;
                margin-bottom: 15px;
                background: url('img/signup.jpg') no-repeat center center fixed;
                /*opacity: 0.8;*/
                border: 1px solid #f3f3f3;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .signup-form .form-group {
                margin-bottom: 20px;
            }
            .signup-form label {
                font-weight: normal;
                font-size: 13px;
            }
            .signup-form .form-control {
                min-height: 38px;
                box-shadow: none !important;
                border-width: 0 0 1px 0;
            }	
            .signup-form .input-group-addon {
                max-width: 42px;
                text-align: center;
                background: none;
                border-bottom: 1px solid #e1e1e1;
                padding-left: 5px;
            }
            .signup-form .btn, .signup-form .btn:active {        
                font-size: 16px;
                font-weight: bold;
                background: #6a0e13 !important;
                border-radius: 3px;
                border: none;
                min-width: 140px;
            }
            .signup-form .btn:hover, .signup-form .btn:focus {
                background: #6a0e13 !important;
            }
            .signup-form a {
                color: #19aa8d;
                text-decoration: none;
            }	
            .signup-form a:hover {
                text-decoration: underline;
            }
            .signup-form .fa {
                font-size: 21px;
                position: relative;
                top: 8px;
            }
            .signup-form .fa-paper-plane {
                font-size: 17px;
            }
            .signup-form .fa-check {
                color: #fff;
                left: 9px;
                top: 18px;
                font-size: 7px;
                position: absolute;
            }
            body{
                background:url('img/signup.jpg') no-repeat center center fixed;
                -webkit-background-size:cover;
                -moz-background-size:cover;
                -o-background-size: cover;
                background-size: cover;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="signup-form">	
            <form action="RegisterController" method="post">
                <c:if test="${ not empty succMsg }">
                    <h5 class="text-center text-success">${succMsg}</h5>
                    <c:remove var="succMsg" scope="session"/>
                </c:if>

                <c:if test="${ not empty failedMsg }">
                    <h5 class="text-center text-danger">${failedMsg}</h5>
                    <c:remove var="failedMsg" scope="session"/>
                </c:if>
                <h2 style="font-weight: bold; color:#6a0e13;">Đăng Ký</h2>
                <p class="lead">Những sản phẩm tuyệt vời đang đợi bạn.</p>
                
                    
                <c:if test="${ not empty wrongFullName }">
                    <p class="text-danger">${wrongFullName}</p>   
                    <c:remove var="wrongFullName" scope="session"/>
                </c:if>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                        <input type="text" class="form-control" name="full_name" placeholder="Họ và tên" required="required">
                    </div>
                </div>
                    
                    <c:if test="${ not empty wrongUser_name }">
                        <p class="text-danger">${wrongUser_name}</p>     
                        <c:remove var="wrongUser_name" scope="session"/>
                    </c:if>    
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-id-badge"></i></span>
                        <input type="text" class="form-control" name="user_name" placeholder="Tên đăng nhập" required="required">
                    </div>
                </div>
                        
                <c:if test="${ not empty wrongPhone }">
                        <p class="text-danger">${wrongPhone}</p>   
                        <c:remove var="wrongPhone" scope="session"/>
                </c:if>        
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-phone"></i></span>
                        <input type="number" class="form-control" name="phone" placeholder="Số điện thoại" required="required">
                    </div>
                </div>
                
                        
                <c:if test="${ not empty wrongEmail }">
                        <p class="text-danger">${wrongEmail}</p>  
                        <c:remove var="wrongEmail" scope="session"/>
                </c:if>        
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-paper-plane"></i></span>
                        <input type="email" class="form-control" name="email" placeholder="Địa chỉ email" required="required">
                    </div>
                </div>
                        
                <c:if test="${ not empty wrongPassword }">
                        <p class="text-danger">${wrongPassword}</p> 
                        <c:remove var="wrongPassword" scope="session"/>
                </c:if>        
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                        <input type="text" class="form-control" name="password" placeholder="Mật khẩu" required="required">
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block btn-lg">Đăng Ký</button>
                </div>
            </form>
            <div class="text-center">Đã có tài khoản? <a href="loginController" style="color: #6a0e13;">Đăng nhập</a>.</div>
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