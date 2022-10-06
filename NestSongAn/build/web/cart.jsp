<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Map"%>
<%@page import="dtos.ProductDTO"%>
<%@page import="java.util.TreeMap"%>
<%@page import="dtos.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Giỏ Hàng</title>

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

        <%
            CartDTO cart = (CartDTO) session.getAttribute("cart");
            if (cart == null) {
                cart = new CartDTO();
                session.setAttribute("cart", cart);
            }
            TreeMap<ProductDTO, Integer> list = cart.getList();
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(0);
        %>

        <section id="cart_items">
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <li><a href="home">Trang Chủ</a></li>
                        <li class="active">Giỏ Hàng</li>
                    </ol>
                </div>
                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                            <tr class="cart_menu">
                                <td class="image">Sản Phẩm</td>
                                <td class="description"></td>
                                <td class="price">Giá</td>
                                <td class="quantity">Số Lượng</td>
                                <td class="total">Tổng</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>

                            <%
                                for (Map.Entry<ProductDTO, Integer> ds : list.entrySet()) {
                            %>

                            <tr>
                                <td class="cart_product">
                                    <a href=""><img src="products/<%= ds.getKey().getPhoto()%>" alt="" style="width: 50px; height: 60px;"></a>
                                </td>
                                <td class="cart_description">
                                    <h4><a href=""><%= ds.getKey().getName()%></a></h4>
                                    <p>Code: <%= ds.getKey().getCode()%></p>
                                </td>
                                <td class="cart_price">
                                    <p><%= nf.format(ds.getKey().getPrice())%> VNĐ</p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <a class="cart_quantity_up" href="add-cart?command=plus&product_id=<%= ds.getKey().getProduct_id()%>&cartID=<%=System.currentTimeMillis()%>"> + </a>
                                        <input class="cart_quantity_input" type="text" value="<%= ds.getValue()%>" autocomplete="off" size="2" disabled="">
                                        <a class="cart_quantity_down" href="add-cart?command=sub&product_id=<%= ds.getKey().getProduct_id()%>&cartID=<%=System.currentTimeMillis()%>"> - </a>
                                    </div>
                                </td>
                                <td class="cart_total">
                                    <p class="cart_total_price"><%= nf.format(ds.getValue() * ds.getKey().getPrice())%> VNĐ</p>
                                </td>
                                <td class="cart_delete">
                                    <a class="cart_quantity_delete" href="add-cart?command=remove&product_id=<%= ds.getKey().getProduct_id()%>&cartID=<%=System.currentTimeMillis()%>"><i class="fa fa-times"></i></a>
                                </td>
                            </tr>

                            <%
                                }
                            %>
                        </tbody>

                    </table>

                </div>
                        <div  class="container-fluid mb-5" style="margin-left: 1000px; color: white">
                            <a class="btn btn-danger" href="checkout" >Thanh Toán</a>
                </div>
            </div>

        </section> <!--/#cart_items-->
    </div>
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
