<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Giỏ Hàng</title>
        <link href="cs2/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <section>
            <div class="container">
                <div class="row">
                    <section id="cart_items">
                        <div class="container">
                            <div class="breadcrumbs">
                                <ol class="breadcrumb">
                                    <li><a href="index.jsp">Trang chủ</a></li>
                                    <li class="active">Giỏ hàng</li>
                                </ol>
                            </div>
                            <div class="table-responsive cart_info">
                                <table class="table table-condensed">
                                    <thead>
                                        <tr class="cart_menu">
                                            <td class="image">Item</td>
                                            <td class="description"></td>
                                            <td class="price">Price</td>
                                            <td class="quantity">Quantity</td>
                                            <td class="total">Total</td>
                                            <td></td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="cart_product">
                                                <a href=""><img src="images/cart/one.png" alt=""></a>
                                            </td>
                                            <td class="cart_description">
                                                <h4><a href="">Colorblock Scuba</a></h4>
                                                <p>Web ID: 1089772</p>
                                            </td>
                                            <td class="cart_price">
                                                <p>$59</p>
                                            </td>
                                            <td class="cart_quantity">
                                                <div class="cart_quantity_button">
                                                    <a class="cart_quantity_up" href=""> + </a>
                                                    <input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
                                                    <a class="cart_quantity_down" href=""> - </a>
                                                </div>
                                            </td>
                                            <td class="cart_total">
                                                <p class="cart_total_price">$59</p>
                                            </td>
                                            <td class="cart_delete">
                                                <a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td class="cart_product">
                                                <a href=""><img src="images/cart/two.png" alt=""></a>
                                            </td>
                                            <td class="cart_description">
                                                <h4><a href="">Colorblock Scuba</a></h4>
                                                <p>Web ID: 1089772</p>
                                            </td>
                                            <td class="cart_price">
                                                <p>$59</p>
                                            </td>
                                            <td class="cart_quantity">
                                                <div class="cart_quantity_button">
                                                    <a class="cart_quantity_up" href=""> + </a>
                                                    <input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
                                                    <a class="cart_quantity_down" href=""> - </a>
                                                </div>
                                            </td>
                                            <td class="cart_total">
                                                <p class="cart_total_price">$59</p>
                                            </td>
                                            <td class="cart_delete">
                                                <a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="cart_product">
                                                <a href=""><img src="images/cart/three.png" alt=""></a>
                                            </td>
                                            <td class="cart_description">
                                                <h4><a href="">Colorblock Scuba</a></h4>
                                                <p>Web ID: 1089772</p>
                                            </td>
                                            <td class="cart_price">
                                                <p>$59</p>
                                            </td>
                                            <td class="cart_quantity">
                                                <div class="cart_quantity_button">
                                                    <a class="cart_quantity_up" href=""> + </a>
                                                    <input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
                                                    <a class="cart_quantity_down" href=""> - </a>
                                                </div>
                                            </td>
                                            <td class="cart_total">
                                                <p class="cart_total_price">$59</p>
                                            </td>
                                            <td class="cart_delete">
                                                <a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </section> <!--/#cart_items-->
                </div>
            </div>
        </section>

        <jsp:include page="footer.jsp" />


        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
