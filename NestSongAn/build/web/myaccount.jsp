<%-- 
    Document   : myaccount
    Created on : Sep 27, 2022, 2:13:11 PM
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tài Khoản Của Tôi</title>
        <link rel="stylesheet" href="css/style1.css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
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
        <div class="main-content">
            <div class="container mt-7">
                <!-- Table -->
                <a href="home" class="mb-5">Trang chủ</a>
                <div class="row">
                    <div class="col-xl-8 m-auto order-xl-1">
                        <div class="card bg-secondary">
                            <div class="card-header bg-white border-0">
                                <div class="row align-items-center">
                                    <div class="col-8">
                                        <h3 class="mb-0">Tài khoản của tôi</h3>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body bg-light">
                                <form action="EditProfile" method="POST">
                                    <h6 class="heading-small text-muted mb-4">Thông tin người dùng</h6>
                                    <c:if test="${ not empty succMsg }">
                                        <h5 class="text-center text-success" style="color: green;">${succMsg}</h5>
                                        <c:remove var="succMsg" scope="session"/>
                                    </c:if>
                                    <div class="pl-lg-4">
                                        <div class="row">
                                            <input type="hidden" name="uid" value="${inform.user_id}">
                                            <div class="col-lg-6">
                                                <div class="form-group focused">
                                                    <label class="form-control-label">Tên đầy đủ</label>
                                                    <input type="text" name="fullname" class="form-control form-control-alternative" placeholder="Full Name" value="${inform.full_name}">
                                                    <c:if test="${ not empty wrongFullName }">
                                                        <p class="text-danger" style="color: red;">${wrongFullName}</p>   
                                                        <c:remove var="wrongFullName" scope="session"/>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    <label class="form-control-label">Tên người dùng</label>
                                                    <input type="text" name="username" class="form-control form-control-alternative" placeholder="User Name" value="${inform.user_name}">
                                                    <c:if test="${ not empty wrongUser_name }">
                                                        <p class="text-danger" style="color: red;">${wrongUser_name}</p>     
                                                        <c:remove var="wrongUser_name" scope="session"/>
                                                    </c:if>  
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <div class="form-group focused">
                                                    <label class="form-control-label">Số Điện Thoại</label>
                                                    <input type="text" name="phone" class="form-control form-control-alternative" placeholder="Phone Number" value="${inform.phone}">
                                                    <c:if test="${ not empty wrongPhone }">
                                                        <p class="text-danger" style="color: red;">${wrongPhone}</p>   
                                                        <c:remove var="wrongPhone" scope="session"/>
                                                    </c:if>   
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group focused">
                                                    <label class="form-control-label">Mật Khẩu</label><br>
                                                    <a href="EditPassword?uid=${inform.user_id}" class="btn btn-lg btn-dark btn-block signin-btn">Thay đổi mật khẩu</a><br>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr class="my-4">
                                    <!-- Address -->
                                    <h6 class="heading-small text-muted mb-4">Email liên hệ</h6>
                                    <div class="pl-lg-4">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group focused">
                                                    <label class="form-control-label" for="input-address">Địa chỉ Email</label>
                                                    <input name="email" class="form-control form-control-alternative" placeholder="Email Address" value="${inform.email}" type="email" readonly="">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr class="my-4">
                                    <div class="col-12 text-center">
                                        <input type="submit" class="btn btn-sm btn-dark btn-block signin-btn" value="Lưu thay đổi">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="footer">
            <div class="row align-items-center justify-content-xl-between">
                <div class="col-xl-6 m-auto text-center">
                    <div class="copyright">
                        <p>Made with <a href="https://www.creative-tim.com/product/argon-dashboard" target="_blank">Argon Dashboard</a> by Creative Tim</p>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>
