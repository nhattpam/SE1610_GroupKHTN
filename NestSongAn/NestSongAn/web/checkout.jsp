<%-- 
    Document   : checkout
    Created on : Sep 19, 2022, 9:43:28 AM
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
        <title>Thông Tin Thanh Toán</title>

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
            .breadcrumbs {

            }

            .breadcrumbs .breadcrumb {
                background:transparent;
                margin-bottom: 75px;
                padding-left: 0;
            }

            .breadcrumbs .breadcrumb li a {
                background: #6a0e13;
                color: #FFFFFF;
                padding: 3px 7px;
            }

            .breadcrumbs .breadcrumb li a:after {
                content:"";
                height:auto;
                width: auto;
                border-width: 8px;
                border-style: solid;
                border-color:transparent transparent transparent #6a0e13;
                position: absolute;
                top: 11px;
                left:48px;

            }

            .breadcrumbs .breadcrumb > li + li:before {
                content: " ";
            }

            #cart_items .cart_info {
                border: 1px solid #E6E4DF;
                margin-bottom: 50px
            }


            #cart_items .cart_info .cart_menu {
                background: #6a0e13;
                color: #fff;
                font-size: 16px;
                font-family: 'Roboto', sans-serif;
                font-weight: normal;
            }

            #cart_items .cart_info .table.table-condensed thead tr {
                height: 51px;
            }


            #cart_items .cart_info .table.table-condensed tr {
                border-bottom: 1px solid#F7F7F0
            }

            #cart_items .cart_info .table.table-condensed tr:last-child {
                border-bottom: 0
            }

            .cart_info table tr td {
                border-top: 0 none;
                vertical-align: inherit;
            }


            #cart_items .cart_info .image {
                padding-left: 30px;
            }


            #cart_items .cart_info .cart_description h4 {
                margin-bottom: 0
            }

            #cart_items .cart_info .cart_description h4 a {
                color: #363432;
                font-family: 'Roboto',sans-serif;
                font-size: 20px;
                font-weight: normal;

            }

            #cart_items .cart_info .cart_description p {
                color:#696763
            }


            #cart_items .cart_info .cart_price p {
                color:#696763;
                font-size: 18px
            }


            #cart_items .cart_info .cart_total_price {
                color: #6a0e13;
                font-size: 24px;
            }

            .cart_product {
                display: block;
                margin: 15px -70px 10px 25px;
            }

            .cart_quantity_button a {
                background:#F0F0E9;
                color: #696763;
                display: inline-block;
                font-size: 16px;
                height: 28px;
                overflow: hidden;
                text-align: center;
                width: 35px;
                float: left;
            }


            .cart_quantity_input {
                color: #696763;
                float: left;
                font-size: 16px;
                text-align: center;
                font-family: 'Roboto',sans-serif;

            }


            .cart_delete  {
                display: block;
                margin-right: -12px;
                overflow: hidden;
            }


            .cart_delete a {
                background:#6a0e13;
                color: #FFFFFF;
                padding: 5px 7px;
                font-size: 16px
            }

            .cart_delete a:hover {
                background:#FE980F
            }

        </style>
    </head>

    <body>
        <jsp:include page="header.jsp" />
        <section id="cart_items">
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <li><a href="index.jsp">Trang Chủ</a></li>
                        <li class="active">Thanh Toán</li>
                    </ol>
                </div><!--/breadcrums-->


                <div class="shopper-informations">
                    <div class="row">
                        <div class="col-sm-3">
                            <div class="shopper-info">
                                <p>Thông Tin Thanh Toán</p>
                                <form>
                                    <p>Địa chỉ giao hàng</p>
                                    <textarea name="message"  placeholder="" rows="5"></textarea>
                                    <p>Phương thức thanh toán</p>
                                    <input type="text">
                                    <select name="phuong_thuc_thanh_toan">
                                        <option value="Thanh toán khi nhận hàng">Thanh toán khi nhận hàng</option>
                                        <option value="Chuyển khoản ngân hàng">Chuyển khoản ngân hàng</option>
                                    </select><br>
                                    <input type="submit" value="Xác nhận thanh toán" class="btn btn-primary">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="review-payment">
                    <h2>Review & Payment</h2>
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
                            <tr>
                                <td colspan="4">&nbsp;</td>
                                <td colspan="2">
                                    <table class="table table-condensed total-result">
                                        <tr>
                                            <td>Cart Sub Total</td>
                                            <td>$59</td>
                                        </tr>
                                        <tr>
                                            <td>Exo Tax</td>
                                            <td>$2</td>
                                        </tr>
                                        <tr class="shipping-cost">
                                            <td>Shipping Cost</td>
                                            <td>Free</td>										
                                        </tr>
                                        <tr>
                                            <td>Total</td>
                                            <td><span>$61</span></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </section> <!--/#cart_items-->
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
