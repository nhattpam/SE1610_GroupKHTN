<%-- 
    Document   : checkout-paypal
    Created on : Nov 6, 2022, 1:38:07 PM
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
        <style>
            .buttonCheckOut{
                background: #00457C;
                color:white;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>   
        
        <div align="center">
            <h4 style="color: #00457C; font-family: Tahoma, Verdana, Segoe, sans-serif; font-weight: bold;">Đơn Hàng Của Bạn</h4>
            <br/>
            <form action="authorize_payment" method="post">
                <table>
                    <tr>
                        <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;">Mã đơn hàng</td>
                        <td><input type="text" name="product" value="${sessionScope.order_id}" readonly /></td>
                    </tr>
                    <tr>
                        <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;">Thành tiền:</td>
                        <td><input type="text" name="subtotal" value="${sessionScope.subtotal}" readonly /> VNĐ</td>
                    </tr>
                    <tr>
                        <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;">Phí vận chuyển: </td>
                        <td><input type="text" name="shipping" value="0" readonly /> VNĐ</td>
                    </tr>    
                    <tr>
                        <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;">Thuế:</td>
                        <td><input type="text" name="tax" value="0" readonly /> VNĐ</td>
                    </tr>    
                    <tr>
                        <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;">Tổng giá trị:</td>
                        <td><input type="text" name="total" value="${sessionScope.subtotal}" readonly/> VNĐ</td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Thanh toán" class="buttonCheckOut"/>
                        </td>
                    </tr>
                </table>
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
    </body>
    
</html>
