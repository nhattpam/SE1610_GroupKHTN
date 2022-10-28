<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Quản Trị Viên</title>
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jqvmap/jqvmap.min.css">
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
    </head>
    <body class="hold-transition sidebar-mini layout-fixed">
        <div class="wrapper">

            <!-- Navbar -->
            <nav class="main-header navbar navbar-expand navbar-white navbar-light">
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
                            Logout
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

                            <li class="nav-item">
                                <a href="admin-dashboard" class="nav-link">
                                    <i class="nav-icon fas fa-th"></i>
                                    <p>
                                        Thống Kê
                                    </p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="manage-user" class="nav-link">
                                    <i class="nav-icon fas fa-th"></i>
                                    <p>
                                        Quản Lý Người Dùng
                                    </p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="CreateStaffAccount" class="nav-link">
                                    <i class="nav-icon fas fa-th"></i>
                                    <p>
                                        Tạo nhân viên mới
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
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <!--<h1>Widgets</h1>-->
                            </div>
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="admin-dashboard">Thống Kê</a></li>
                                    <!--<li class="breadcrumb-item active">Quản Lý Người Dùng</li>-->
                                </ol>
                            </div>
                        </div>
                    </div><!-- /.container-fluid -->
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="container-fluid">
                        <!--<h5 class="mb-2">Quản Lý Người Dùng</h5>-->
                        <div class="row">
                            <div class="col-md-12">
                                <h5>Sản phẩm bán chạy</h5>
                                <div class="row crd-ho">
                                    <table class="table table-striped">
                                        <thead class="bg-dark text-white">
                                            <tr>
                                                <th scope="col">Id</th>
                                                <th scope="col">Mã sản phẩm</th>
                                                <th scope="col">Ảnh</th>
                                                <th scope="col">Tên sản phẩm</th>
                                                <th scope="col">Giá</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${listHotSelling}" var="l">
                                                <tr>
                                                    <td>${l.product_id.product_id}</td>
                                                    <td>${l.product_id.code}</td>
                                                    <td><img src="products/${l.product_id.photo}" style="width: 50px; height: 50px;"></td>
                                                    <td>${l.product_id.name}</td>
                                                    <td>
                                                        <fmt:formatNumber type="number" groupingUsed="true" value="${l.product_id.price}" /> VNĐ
                                                    </td>

                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <h5>Doanh thu cửa hàng</h5>
                                <h6 style="color: green; font-weight: bold;"><fmt:formatNumber type="number" groupingUsed="true" value="${income}" /> VNĐ</h6>
                                <div>
                                    <h4>Thống kê tháng ${currentMonth}</h4>
                                    <c:remove var="currentMonth" scope="session"></c:remove>
                                    <h5>Đơn hàng đã giao</h5>
                                    <h6 style="color: green; font-weight: bold;">${successOrder}</h6>
                                    <c:remove var="successOrder" scope="session"></c:remove>
                                    <h5>Đơn hàng đang chờ</h5>
                                    <h6 style="color: green; font-weight: bold;">${waitOrder}</h6>
                                    <c:remove var="waitOrder" scope="session"></c:remove>
                                </div>                            </div>

                            <!-- /.col -->
                        </div>
                        <!-- /.row -->
                    </div>
                </section>
            </div>
        </div>

        <!-- /.content-wrapper -->
        <footer class="main-footer">
            <strong>Copyright &copy; 2014-2019 <a href="">KHTN</a>.</strong>
            All rights reserved.
            <div class="float-right d-none d-sm-inline-block">
                <b>Version</b> 3.0.4
            </div>
        </footer>

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
</body>
</html>
