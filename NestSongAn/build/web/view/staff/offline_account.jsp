<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Thêm Khách Hàng (Offline)</title>
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
            

            .signup-form .lead {
                font-size: 14px;
                margin-bottom: 30px;
                text-align: center;
            }

            .signup-form .form-group {
                margin-bottom: 20px;
            }
            .signup-form label {
                font-weight: normal;
                font-size: 13px;
            }
            .signup-form .form-control {
                min-height: 38px;
                box-shadow: none !important;
                border-width: 0 0 1px 0;
            }	
            
            .signup-form .btn, .signup-form .btn:active {        
                font-size: 16px;
                font-weight: bold;
                /*background: #6a0e13 !important;*/
                border-radius: 3px;
                border: none;
                min-width: 140px;
            }
            .signup-form .btn:hover, .signup-form .btn:focus {
                /*background: #6a0e13 !important;*/
            }
            .signup-form a {
                color: #19aa8d;
                text-decoration: none;
            }	
            .signup-form a:hover {
                text-decoration: underline;
            }
            .signup-form .fa {
                font-size: 21px;
                position: relative;
                top: 8px;
            }
            .signup-form .fa-paper-plane {
                font-size: 17px;
            }
           
            
        </style>
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
                                        Danh Sách đánh giá sản phẩm
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
                <div class="container">
                    <div class="row crd-ho">
                        <div class="col-md-4 offset-md-4 mt-3 ">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="text-center">Thêm Khách Hàng (Offline)</h4>

                                    <c:if test="${ not empty succMsg }">
                                        <h5 class="text-center text-success">${succMsg}</h5>
                                        <c:remove var="succMsg" scope="session"/>
                                    </c:if>

                                    <c:if test="${ not empty failedMsg }">
                                        <h5 class="text-center text-danger">${failedMsg}</h5>
                                        <c:remove var="failedMsg" scope="session"/>
                                    </c:if>
                                    <div class="signup-form">
                                        <form action="offline-account" method="post">
                                            <c:if test="${ not empty succMsg }">
                                                <h5 class="text-center text-success">${succMsg}</h5>
                                                <c:remove var="succMsg" scope="session"/>
                                            </c:if>

                                            <c:if test="${ not empty failedMsg }">
                                                <h5 class="text-center text-danger">${failedMsg}</h5>
                                                <c:remove var="failedMsg" scope="session"/>
                                            </c:if>

                                            <c:if test="${ not empty wrongFullName }">
                                                <p class="text-danger">${wrongFullName}</p>   
                                                <c:remove var="wrongFullName" scope="session"/>
                                            </c:if>
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                    <input type="text" class="form-control" name="full_name" placeholder="Họ và tên" required="required" value="${full_name}">
                                                </div>
                                            </div>

                                            <c:if test="${ not empty wrongUser_name }">
                                                <p class="text-danger">${wrongUser_name}</p>     
                                                <c:remove var="wrongUser_name" scope="session"/>
                                            </c:if>    
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-id-badge"></i></span>
                                                    <input type="text" class="form-control" name="user_name" placeholder="Tên đăng nhập" required="required" value="${user_name}">
                                                </div>
                                            </div>

                                            <c:if test="${ not empty wrongPhone }">
                                                <p class="text-danger">${wrongPhone}</p>   
                                                <c:remove var="wrongPhone" scope="session"/>
                                            </c:if>        
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-phone"></i></span>
                                                    <input type="number" class="form-control" name="phone" placeholder="Số điện thoại" required="required" value="${phone}">
                                                </div>
                                            </div>


                                            <c:if test="${ not empty wrongEmail }">
                                                <p class="text-danger">${wrongEmail}</p>  
                                                <c:remove var="wrongEmail" scope="session"/>
                                            </c:if>        
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-paper-plane"></i></span>
                                                    <input type="email" class="form-control" name="email" placeholder="Địa chỉ email" required="required" value="${email}">
                                                </div>
                                            </div>

                                            <c:if test="${ not empty wrongPassword }">
                                                <p class="text-danger">${wrongPassword}</p> 
                                                <c:remove var="wrongPassword" scope="session"/>
                                            </c:if>        
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                                    <input type="password" class="form-control" name="password" placeholder="Mật khẩu" required="required">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-dark btn-block btn-lg">Thêm</button>
                                            </div>
                                        </form>
                                    </div>


                                </div> 
                            </div>
                        </div>
                    </div>
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
