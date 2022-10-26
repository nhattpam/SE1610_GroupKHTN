<%-- 
    Document   : feedback
    Created on : Oct 26, 2022, 1:59:39 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đánh Giá Sản Phẩm</title>
        <!-- Google Font -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <style>
            body{
                background:url('img/signup.jpg') no-repeat center center fixed;
                -webkit-background-size:cover;
                -moz-background-size:cover;
                -o-background-size: cover;
                background-size: cover;
            }
            textarea{
                 background:url('img/signup.jpg') no-repeat center center fixed;
            }
        </style>
    </head>
    <body>
        <div class="container mt-20">
            <div class="row mt-20">
                <div class="col-md-12" style="margin-top: 180px; margin-left:200px ">
                    <form action="AddFeedback" method="POST">
                        <div class="form-outline mt-20">
                            <input type="hidden" name="uid" value="${uid}">
                            <input type="hidden" name="pid" value="${pid}"> 
                            <textarea class="textarea is-danger" placeholder="Đánh giá của bạn giúp chúng tôi phát triển!" type="textarea" class="form-control" id="textAreaExample2" name="feedback" rows="10" cols="50"></textarea>
                            <label class="form-label" for="textAreaExample2"></label>
                        </div>
                        <button type="input" class="btn btn-danger" style="background: #6a0e13 !important; color: white">Đánh giá</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
