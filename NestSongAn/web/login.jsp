<%-- 
    Document   : login
    Created on : Sep 19, 2022, 9:42:17 AM
    Author     : Admin
--%>

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
    </head>
    <body>
        <jsp:include page="header.jsp"/>   
        <div class="container mb-3">
            <c:if test="${ not empty LoginError }">
                <h5 class="text-center text-danger">${LoginError}</h5>
            </c:if>
            <form action="loginController" method="POST">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Username</label>
                    <input type="text" class="form-control" name="txtUsername" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" class="form-control" name="txtPassword" id="exampleInputPassword1">
                </div>
                <button type="submit" value="Login" class="btn btn-primary">Đăng nhập</button>
                <br/>
                <a href="https://accounts.google.com/o/oauth2/auth?scope=email profile&redirect_uri=http://localhost:8080/NestSongAn/login-google&response_type=code
                   &client_id=34728737226-pshthan6um4e9qkcndvrrmvhr1b9mqqp.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>
            </form>
            <a href="forgotPassword.jsp">Forgot password?</a>
            <br/>
            <a href="RegisterAccountController">Bạn chưa có tài khoản? Đăng ký ngay.</a>
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
