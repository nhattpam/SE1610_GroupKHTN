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
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style1.css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
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
                <div class="row">
                    <div class="col-xl-8 m-auto order-xl-1">
                        <div class="card bg-secondary shadow">
                            <div class="card-header bg-white border-0">
                                <div class="row align-items-center">
                                    <div class="col-8">
                                        <h3 class="mb-0">Update new password</h3>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body">
                                <form action="EditPassword" method="POST">
                                    <div class="pl-lg-4">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group focused">
                                                    <label class="form-control-label" for="input-address">Mật khẩu hiện tại</label>
                                                    <input type="hidden" name="uid" value="${inform.user_id}" readonly="">
                                                    <input name="pass" class="form-control form-control-alternative" placeholder="Password" type="password">
                                                    <c:if test="${ not empty wrongPassword }">
                                                        <p class="text-danger" style="color: red;">${wrongPassword}</p> 
                                                        <p class="text-danger" style="color: red;">${missPassword}</p> 
                                                        <c:remove var="wrongPassword" scope="session"/>
                                                    </c:if> 
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="form-group focused">
                                                    <label class="form-control-label" for="input-address">Mật khẩu mới</label>
                                                    <input name="newpass" class="form-control form-control-alternative" placeholder="Password" type="password">
                                                    <c:if test="${ not empty wrongPassword }">
                                                        <p class="text-danger" style="color: red;">${wrongPassword}</p> 
                                                        <c:remove var="wrongPassword" scope="session"/>
                                                    </c:if> 
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="form-group focused">
                                                    <label class="form-control-label" for="input-address">Nhập lại mật khẩu mới</label>
                                                    <input name="confpass" class="form-control form-control-alternative" placeholder="Password" type="password">
                                                    <c:if test="${ not empty wrongPassword }">
                                                        <p class="text-danger" style="color: red;">${wrongPassword}</p> 
                                                        <p class="text-danger" style="color: red;">${Passworderror}</p> 
                                                        <c:remove var="wrongPassword" scope="session"/>
                                                    </c:if> 
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group focused"><a href="forgotPassword" style="color: #6a0e13;">Quên mật khẩu?</a></div>
                                    </div>
                                    <hr class="my-4">
                                    <div class="col-12 text-center">
                                        <input type="submit" class="btn btn-sm btn-primary" value="Save">
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
