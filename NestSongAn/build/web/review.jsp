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
            .buttonCheckOut{
                background: #00457C;
                color:white;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/> 
        <div align="center">
            <h4 style="color: #00457C; font-family: Tahoma, Verdana, Segoe, sans-serif; font-weight: bold;">Giao dịch thành công!</h4>
            <form action="execute_payment" method="post">
                <table>
                    <tr>
                        <td colspan="2" style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;"><b>Chi tiết giao dịch:</b></td>
                        <td>
                            <input type="hidden" name="paymentId" value="${param.paymentId}" />
                            <input type="hidden" name="PayerID" value="${param.PayerID}" />
                        </td>
                    </tr>
<!--                    <tr>
                        <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;">Mô tả</td>
                        <td>${transaction.description}</td>
                    </tr>-->
                    <tr>
                        <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;">Thành tiền:</td>
                        <td>${transaction.amount.details.subtotal} USD</td>
                    </tr>
                    <tr>
                        <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;">Phí vận chuyển</td>
                        <td>${transaction.amount.details.shipping} USD</td>
                    </tr>
                    <tr>
                        <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;">Thuế:</td>
                        <td>${transaction.amount.details.tax} USD</td>
                    </tr>
                    <tr>
                        <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;">Tổng giá trị:</td>
                        <td>${transaction.amount.total} USD</td>
                    </tr>
                    <tr><td><br/></td></tr>
                    <tr>
                        <td colspan="2" style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;"><b>Thông tin người thanh toán:</b></td>
                    </tr>
                    <tr>
                        <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;">Họ:</td>
                        <td>${payer.firstName}</td>
                    </tr>
                    <tr>
                        <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;">Tên:</td>
                        <td>${payer.lastName}</td>
                    </tr>
                    <tr>
                        <td style="color: #0079C1; font-family: Tahoma, Verdana, Segoe, sans-serif;">Email:</td>
                        <td>${payer.email}</td>
                    </tr>

                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Hoàn thành" class="buttonCheckOut"/>
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