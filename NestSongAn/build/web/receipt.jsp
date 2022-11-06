<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Paypal</title>

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
        <style type="text/css">
            table { border: 0; }
            table td { padding: 5px; }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/> 
        <div align="center">
            <h4 style="color: #00457C; font-family: Tahoma, Verdana, Segoe, sans-serif; font-weight: bold;">Giao dịch thành công. Cảm ơn đã sử dụng dịch vụ!</h4>
            <br/>
            <h2 style="color: #00457C; font-family: Tahoma, Verdana, Segoe, sans-serif; font-weight: bold;">Biên Lai:</h2>
            <table>
                <tr>
                    <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;"><b>Người thanh toán: </b></td>
                    <td>${payer.firstName} ${payer.lastName}</td>      
                </tr>
                <tr>
                    <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;"><b>Mô tả: </b></td>
                    <td>${transaction.description}</td>
                </tr>
                <tr>
                    <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;"><b>Thành tiền: </b></td>
                    <td>${transaction.amount.details.subtotal} VNĐ</td>
                </tr>
                <tr>
                    <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;"><b>Phí vận chuyển: </b></td>
                    <td>${transaction.amount.details.shipping} VNĐ</td>
                </tr>
                <tr>
                    <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;"><b>Thuế:</b></td>
                    <td>${transaction.amount.details.tax} VNĐ</td>
                </tr>
                <tr>
                    <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;"><b>Tổng</b></td>
                    <td>${transaction.amount.total} VNĐ</td>
                </tr>                    
            </table>
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
    </body>
</html>