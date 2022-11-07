<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@page import="dtos.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Tạo Đơn Hàng</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/all.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Tempusdominus Bbootstrap 4 -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
        <!-- JQVMap -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}//plugins/jqvmap/jqvmap.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">
        <!-- overlayScrollbars -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
        <!-- Daterange picker -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
        <!-- summernote -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/summernote/summernote-bs4.css">
        <!-- Google Font: Source Sans Pro -->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
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
                background: #F0F0E9;
                color: #696763;
                display: inline-block;
                font-size: 16px;
                height: 28px;
                overflow: hidden;
                text-align: center;
                width: 20px;
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

            #button{
                background: #6a0e13;
                color: white;
            }

        </style>
    </head>
    <body class="hold-transition sidebar-mini layout-fixed">
        <div class="wrapper">

            <!-- Navbar -->
            <nav class="main-header navbar navbar-expand navbar-white navbar-light">
                <div class="navbar-nav ml-auto">
                     <a href="offline-order?bid=${sessionScope.branch_id}"><i class="fa fa-list fa-2x text-dark" aria-hidden="true"></i></a>
                </div>
               
<!--                 Left navbar links 
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
                    </li>
                    <li class="nav-item d-none d-sm-inline-block">
                        <a href="index3.html" class="nav-link">Home</a>
                    </li>
                    <li class="nav-item d-none d-sm-inline-block">
                        <a href="#" class="nav-link">Contact</a>
                    </li>
                </ul>-->

<!--                 SEARCH FORM 
                <form class="form-inline ml-3">
                    <div class="input-group input-group-sm">
                        <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                        <div class="input-group-append">
                            <button class="btn btn-navbar" type="submit">
                                <i class="fas fa-search"></i>
                            </button>
                        </div>
                    </div>
                </form>-->

                <!-- Right navbar links -->
                <ul class="navbar-nav ml-auto">
                    <!-- Messages Dropdown Menu -->
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="LogoutServlet">
                             Đăng xuất
                        </a>
<!--                        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                            <a href="#" class="dropdown-item">
                                 Message Start 
                                <div class="media">
                                    <img src="dist/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle">
                                    <div class="media-body">
                                        <h3 class="dropdown-item-title">
                                            Brad Diesel
                                            <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                                        </h3>
                                        <p class="text-sm">Call me whenever you can...</p>
                                        <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                                    </div>
                                </div>
                                 Message End 
                            </a>
                            <div class="dropdown-divider"></div>
                            <a href="#" class="dropdown-item">
                                 Message Start 
                                <div class="media">
                                    <img src="dist/img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
                                    <div class="media-body">
                                        <h3 class="dropdown-item-title">
                                            John Pierce
                                            <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                                        </h3>
                                        <p class="text-sm">I got your message bro</p>
                                        <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                                    </div>
                                </div>
                                 Message End 
                            </a>
                            <div class="dropdown-divider"></div>
                            <a href="#" class="dropdown-item">
                                 Message Start 
                                <div class="media">
                                    <img src="dist/img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
                                    <div class="media-body">
                                        <h3 class="dropdown-item-title">
                                            Nora Silvester
                                            <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                                        </h3>
                                        <p class="text-sm">The subject goes here</p>
                                        <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                                    </div>
                                </div>
                                 Message End 
                            </a>
                            <div class="dropdown-divider"></div>
                            <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
                        </div>-->
                    </li>
                    <!-- Notifications Dropdown Menu -->
<!--                    <li class="nav-item dropdown">
                        <a class="nav-link" data-toggle="dropdown" href="#">
                            <i class="far fa-bell"></i>
                            <span class="badge badge-warning navbar-badge">15</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                            <span class="dropdown-item dropdown-header">15 Notifications</span>
                            <div class="dropdown-divider"></div>
                            <a href="#" class="dropdown-item">
                                <i class="fas fa-envelope mr-2"></i> 4 new messages
                                <span class="float-right text-muted text-sm">3 mins</span>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a href="#" class="dropdown-item">
                                <i class="fas fa-users mr-2"></i> 8 friend requests
                                <span class="float-right text-muted text-sm">12 hours</span>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a href="#" class="dropdown-item">
                                <i class="fas fa-file mr-2"></i> 3 new reports
                                <span class="float-right text-muted text-sm">2 days</span>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
                        </div>
                    </li>-->
<!--                    <li class="nav-item">
                        <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                            <i class="fas fa-th-large"></i>
                        </a>
                    </li>-->
                </ul>
            </nav>
            <!-- /.navbar -->

            <!-- Main Sidebar Container -->
            <aside class="main-sidebar sidebar-dark-primary elevation-4">
                <!-- Sidebar -->
                <div class="sidebar">
                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                        <div class="image">
                            <img src="${pageContext.request.contextPath}/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
                        </div>
                        <div class="info">
                            <a href="#" class="d-block">${sessionScope.USER.full_name}</a>
                        </div>
                    </div>

                    <!-- Sidebar Menu -->
                    <nav class="mt-2">
                        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                            <!-- Add icons to the links using the .nav-icon class
                                 with font-awesome or any other icon font library -->

<!--                            <li class="nav-item">
                                <a href="staff-dashboard" class="nav-link">
                                    <i class="nav-icon fas fa-th"></i>
                                    <p>
                                        Thống Kê
                                    </p>
                                </a>
                            </li>-->
                            <li class="nav-item">
                                <a href="add-product" class="nav-link">
                                    <i class="nav-icon fas fa-th"></i>
                                    <p>
                                        Thêm Sản Phẩm
                                    </p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="list-products" class="nav-link">
                                    <i class="nav-icon fas fa-th"></i>
                                    <p>
                                        Danh Sách Sản Phẩm
                                    </p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="list-orders" class="nav-link">
                                    <i class="nav-icon fas fa-th"></i>
                                    <p>
                                        Danh Sách Đặt Hàng
                                    </p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="list-feedback" class="nav-link">
                                    <i class="nav-icon fas fa-th"></i>
                                    <p>
                                        Danh Sách Đánh Giá Sản Phẩm
                                    </p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="offline-order" class="nav-link">
                                    <i class="nav-icon fas fa-th"></i>
                                    <p>
                                        Tạo Đơn Hàng
                                    </p>
                                </a>
                            </li>
                        </ul>
                    </nav>
                    <!-- /.sidebar-menu -->
                </div>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper " style="margin-bottom: 50px;">
                    <div class="container">
                        <div class="row crd-ho">
                            <div class="col-md-6 offset-md-3" style="margin-top: 10px;">
                                <c:if test="${not empty user }">
                                    <div class="card">
                                        <div class="card-body">
                                            <c:if test="${ not empty notiCheckout }">
                                                <h5 class="text-center text-danger">${notiCheckout}</h5>
                                                <c:remove var="notiCheckout" scope="session"/>
                                            </c:if>
                                            <h4 class="text-center" style="color: #6a0e13; font-weight: bolder;font-family: Tahoma, Verdana, Segoe, sans-serif;">Thông Tin Thanh Toán</h4><br>


                                            <form action="checkout-offline?bid=${sessionScope.branch_id}" method="post">
                                                <!--<input type="hidden" value="${user.user_id}" name="id">-->
                                                <c:if test="${ not empty wrongFullName }">
                                                    <p class="text-danger">${wrongFullName}</p>   
                                                    <c:remove var="wrongFullName" scope="session"/>
                                                </c:if>
                                                <div class="form-group" style="font-weight: bold;">
                                                    Họ và tên<input name="full_name" type="text" class="form-control" id="exampleInputPassword1" value="${full_name}" >
                                                </div> 
                                                    <c:if test="${ not empty wrongPhone }">
                                                        <p class="text-danger">${wrongPhone}</p>   
                                                        <c:remove var="wrongPhone" scope="session"/>
                                                    </c:if>      
                                                <div class="form-group" style="font-weight: bold;">
                                                    Số điện thoại<input name="phone" type="number" class="form-control" id="exampleInputPassword1" value="${phone}" >
                                                </div> 
                                                

                                                <div  class="form-group">
                                                    <input type="submit" value="Xác nhận thanh toán" class="btn btn-custom btn-lg btn-block" id="button">
                                                </div>

                                            </form>
                                        </div> 
                                    </div>
                                </c:if>


                            </div>
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
                                    <c:set var="TotalPriceAll" scope="session" value="0" />
                                    <c:forEach items="${requestScope.list}" var="map">
                                        <tr>
                                            <td class="cart_product">
                                                <a href=""><img src="products/${map.key.photo}" alt="" style="width: 50px; height: 60px;"></a>
                                            </td>
                                            <td class="cart_description">
                                                <h4><a href="">${map.key.name}</a></h4>
                                                <p>Code: ${map.key.code}</p>
                                            </td>
                                            <td class="cart_price">
                                                <p><fmt:formatNumber type="number" groupingUsed="true" value="${map.key.price}" /> VNĐ</p>
                                            </td>
                                            <td class="cart_quantity">
                                                <div class="cart_quantity_button">
                                                    <a class="cart_quantity_up" href="add-cart-offline?command=plus&product_id=${map.key.product_id}&cartID=${System.currentTimeMillis()}"> + </a>
                                                    <input class="cart_quantity_input" type="text" value="${map.value}" autocomplete="off" size="2" disabled="">
                                                    <a class="cart_quantity_down" href="add-cart-offline?command=sub&product_id=${map.key.product_id}&cartID=${System.currentTimeMillis()}"> - </a>
                                                </div>
                                            </td>
                                            <td class="cart_total">
                                                <c:set var="TotalPriceAll" scope="session" value="${TotalPriceAll+(map.value * map.key.price)}" />
                                                <p><fmt:formatNumber type="number" groupingUsed="true" value="${map.key.price * map.value}" /> VNĐ</p>
                                            </td>
                                            <td class="cart_delete">
                                                <a class="cart_quantity_delete" href="add-cart-offline?command=remove&product_id=${map.key.product_id}&cartID=${System.currentTimeMillis()}"><i class="fa fa-times"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>


                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td style="font-weight: bold;">Tiền tạm tính: </td>
                                        <td style="color: green; font-size: large; font-weight: bold;"><fmt:formatNumber type="number" groupingUsed="true" value="${TotalPriceAll}" /> VNĐ</td>
                                    </tr>
                                </tbody>

                            </table>

                        </div>

                    </div>
                </div>

            <!-- /.content-wrapper -->
<!--            <footer class="main-footer">
                <strong>Copyright &copy; 2014-2019 <a href="">KHTN</a>.</strong>
                All rights reserved.
                <div class="float-right d-none d-sm-inline-block">

                    <form action="ExcelController">
                        <input type="submit" name="action" value="Export Product to Excel">
                    </form>
                    <b>Version</b> 3.0.4
                </div>
            </footer>-->

            <!-- Control Sidebar -->
            <aside class="control-sidebar control-sidebar-dark">
                <!-- Control sidebar content goes here -->
            </aside>
            <!-- /.control-sidebar -->
        </div>
        <!-- ./wrapper -->

        <!-- jQuery -->
        <script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
        <!-- jQuery UI 1.11.4 -->
        <script src="${pageContext.request.contextPath}/plugins/jquery-ui/jquery-ui.min.js"></script>
        <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
        <script>
            $.widget.bridge('uibutton', $.ui.button);
        </script>
        <!-- Bootstrap 4 -->
        <script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- ChartJS -->
        <script src="${pageContext.request.contextPath}/plugins/chart.js/Chart.min.js"></script>
        <!-- Sparkline -->
        <script src="${pageContext.request.contextPath}/plugins/sparklines/sparkline.js"></script>
        <!-- JQVMap -->
        <script src="${pageContext.request.contextPath}/plugins/jqvmap/jquery.vmap.min.js"></script>
        <script src="${pageContext.request.contextPath}/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
        <!-- jQuery Knob Chart -->
        <script src="${pageContext.request.contextPath}/plugins/jquery-knob/jquery.knob.min.js"></script>
        <!-- daterangepicker -->
        <script src="${pageContext.request.contextPath}/plugins/moment/moment.min.js"></script>
        <script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
        <!-- Tempusdominus Bootstrap 4 -->
        <script src="${pageContext.request.contextPath}/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
        <!-- Summernote -->
        <script src="${pageContext.request.contextPath}/plugins/summernote/summernote-bs4.min.js"></script>
        <!-- overlayScrollbars -->
        <script src="${pageContext.request.contextPath}/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
        <!-- AdminLTE App -->
        <script src="${pageContext.request.contextPath}/dist/js/adminlte.js"></script>
        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="${pageContext.request.contextPath}/dist/js/pages/dashboard.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="${pageContext.request.contextPath}/dist/js/demo.js"></script>
        <script>
    $('#myModal').on('shown.bs.modal', function () {
        $('#myInput').trigger('focus');
    });
    $('#exampleModal').modal({
  show: true
})
        </script>
    </body>
</html>
