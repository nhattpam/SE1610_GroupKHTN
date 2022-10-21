package org.apache.jsp.view.shipping;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.NumberFormat;
import java.util.List;
import dtos.ProductDTO;

public final class manage_005forder_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> \n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>Danh Sách Người Dùng</title>\n");
      out.write("        <!-- Tell the browser to be responsive to screen width -->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <!-- Font Awesome -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/fontawesome-free/css/all.min.css\">\n");
      out.write("        <!-- Ionicons -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css\">\n");
      out.write("        <!-- Tempusdominus Bbootstrap 4 -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css\">\n");
      out.write("        <!-- iCheck -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/icheck-bootstrap/icheck-bootstrap.min.css\">\n");
      out.write("        <!-- JQVMap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("//plugins/jqvmap/jqvmap.min.css\">\n");
      out.write("        <!-- Theme style -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/dist/css/adminlte.min.css\">\n");
      out.write("        <!-- overlayScrollbars -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/overlayScrollbars/css/OverlayScrollbars.min.css\">\n");
      out.write("        <!-- Daterange picker -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/daterangepicker/daterangepicker.css\">\n");
      out.write("        <!-- summernote -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/summernote/summernote-bs4.css\">\n");
      out.write("        <!-- Google Font: Source Sans Pro -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body class=\"hold-transition sidebar-mini layout-fixed\">\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("\n");
      out.write("            <!-- Navbar -->\n");
      out.write("            <nav class=\"main-header navbar navbar-expand navbar-white navbar-light\">\n");
      out.write("                <!-- Left navbar links -->\n");
      out.write("                <ul class=\"navbar-nav\">\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" data-widget=\"pushmenu\" href=\"#\" role=\"button\"><i class=\"fas fa-bars\"></i></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item d-none d-sm-inline-block\">\n");
      out.write("                        <a href=\"index3.html\" class=\"nav-link\">Home</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item d-none d-sm-inline-block\">\n");
      out.write("                        <a href=\"#\" class=\"nav-link\">Contact</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("                <!-- SEARCH FORM -->\n");
      out.write("                <form class=\"form-inline ml-3\">\n");
      out.write("                    <div class=\"input-group input-group-sm\">\n");
      out.write("                        <input class=\"form-control form-control-navbar\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\n");
      out.write("                        <div class=\"input-group-append\">\n");
      out.write("                            <button class=\"btn btn-navbar\" type=\"submit\">\n");
      out.write("                                <i class=\"fas fa-search\"></i>\n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                <!-- Right navbar links -->\n");
      out.write("                <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                    <!-- Messages Dropdown Menu -->\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                            <i class=\"far fa-comments\"></i>\n");
      out.write("                            <span class=\"badge badge-danger navbar-badge\">3</span>\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu dropdown-menu-lg dropdown-menu-right\">\n");
      out.write("                            <a href=\"#\" class=\"dropdown-item\">\n");
      out.write("                                <!-- Message Start -->\n");
      out.write("                                <div class=\"media\">\n");
      out.write("                                    <img src=\"dist/img/user1-128x128.jpg\" alt=\"User Avatar\" class=\"img-size-50 mr-3 img-circle\">\n");
      out.write("                                    <div class=\"media-body\">\n");
      out.write("                                        <h3 class=\"dropdown-item-title\">\n");
      out.write("                                            Brad Diesel\n");
      out.write("                                            <span class=\"float-right text-sm text-danger\"><i class=\"fas fa-star\"></i></span>\n");
      out.write("                                        </h3>\n");
      out.write("                                        <p class=\"text-sm\">Call me whenever you can...</p>\n");
      out.write("                                        <p class=\"text-sm text-muted\"><i class=\"far fa-clock mr-1\"></i> 4 Hours Ago</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- Message End -->\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a href=\"#\" class=\"dropdown-item\">\n");
      out.write("                                <!-- Message Start -->\n");
      out.write("                                <div class=\"media\">\n");
      out.write("                                    <img src=\"dist/img/user8-128x128.jpg\" alt=\"User Avatar\" class=\"img-size-50 img-circle mr-3\">\n");
      out.write("                                    <div class=\"media-body\">\n");
      out.write("                                        <h3 class=\"dropdown-item-title\">\n");
      out.write("                                            John Pierce\n");
      out.write("                                            <span class=\"float-right text-sm text-muted\"><i class=\"fas fa-star\"></i></span>\n");
      out.write("                                        </h3>\n");
      out.write("                                        <p class=\"text-sm\">I got your message bro</p>\n");
      out.write("                                        <p class=\"text-sm text-muted\"><i class=\"far fa-clock mr-1\"></i> 4 Hours Ago</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- Message End -->\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a href=\"#\" class=\"dropdown-item\">\n");
      out.write("                                <!-- Message Start -->\n");
      out.write("                                <div class=\"media\">\n");
      out.write("                                    <img src=\"dist/img/user3-128x128.jpg\" alt=\"User Avatar\" class=\"img-size-50 img-circle mr-3\">\n");
      out.write("                                    <div class=\"media-body\">\n");
      out.write("                                        <h3 class=\"dropdown-item-title\">\n");
      out.write("                                            Nora Silvester\n");
      out.write("                                            <span class=\"float-right text-sm text-warning\"><i class=\"fas fa-star\"></i></span>\n");
      out.write("                                        </h3>\n");
      out.write("                                        <p class=\"text-sm\">The subject goes here</p>\n");
      out.write("                                        <p class=\"text-sm text-muted\"><i class=\"far fa-clock mr-1\"></i> 4 Hours Ago</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- Message End -->\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a href=\"#\" class=\"dropdown-item dropdown-footer\">See All Messages</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <!-- Notifications Dropdown Menu -->\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                            <i class=\"far fa-bell\"></i>\n");
      out.write("                            <span class=\"badge badge-warning navbar-badge\">15</span>\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu dropdown-menu-lg dropdown-menu-right\">\n");
      out.write("                            <span class=\"dropdown-item dropdown-header\">15 Notifications</span>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a href=\"#\" class=\"dropdown-item\">\n");
      out.write("                                <i class=\"fas fa-envelope mr-2\"></i> 4 new messages\n");
      out.write("                                <span class=\"float-right text-muted text-sm\">3 mins</span>\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a href=\"#\" class=\"dropdown-item\">\n");
      out.write("                                <i class=\"fas fa-users mr-2\"></i> 8 friend requests\n");
      out.write("                                <span class=\"float-right text-muted text-sm\">12 hours</span>\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a href=\"#\" class=\"dropdown-item\">\n");
      out.write("                                <i class=\"fas fa-file mr-2\"></i> 3 new reports\n");
      out.write("                                <span class=\"float-right text-muted text-sm\">2 days</span>\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a href=\"#\" class=\"dropdown-item dropdown-footer\">See All Notifications</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" data-widget=\"control-sidebar\" data-slide=\"true\" href=\"#\" role=\"button\">\n");
      out.write("                            <i class=\"fas fa-th-large\"></i>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("            <!-- /.navbar -->\n");
      out.write("\n");
      out.write("            <!-- Main Sidebar Container -->\n");
      out.write("            <aside class=\"main-sidebar sidebar-dark-primary elevation-4\">\n");
      out.write("                <!-- Sidebar -->\n");
      out.write("                <div class=\"sidebar\">\n");
      out.write("                    <!-- Sidebar user panel (optional) -->\n");
      out.write("                    <div class=\"user-panel mt-3 pb-3 mb-3 d-flex\">\n");
      out.write("                        <div class=\"image\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/dist/img/user2-160x160.jpg\" class=\"img-circle elevation-2\" alt=\"User Image\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"info\">\n");
      out.write("                            <a href=\"#\" class=\"d-block\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.USER.full_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <!-- Sidebar Menu -->\n");
      out.write("                    <nav class=\"mt-2\">\n");
      out.write("                        <ul class=\"nav nav-pills nav-sidebar flex-column\" data-widget=\"treeview\" role=\"menu\" data-accordion=\"false\">\n");
      out.write("                            <!-- Add icons to the links using the .nav-icon class\n");
      out.write("                                 with font-awesome or any other icon font library -->\n");
      out.write("\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a href=\"admin-dashboard\" class=\"nav-link\">\n");
      out.write("                                    <i class=\"nav-icon fas fa-th\"></i>\n");
      out.write("                                    <p>\n");
      out.write("                                        Thống Kê\n");
      out.write("                                    </p>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a href=\"manage-shipper\" class=\"nav-link\">\n");
      out.write("                                    <i class=\"nav-icon fas fa-th\"></i>\n");
      out.write("                                    <p>\n");
      out.write("                                        Quản Lý Đơn Hàng\n");
      out.write("                                    </p>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("                    <!-- /.sidebar-menu -->\n");
      out.write("                </div>\n");
      out.write("                <!-- /.sidebar -->\n");
      out.write("            </aside>\n");
      out.write("\n");
      out.write("            <!-- Content Wrapper. Contains page content -->\n");
      out.write("            <div class=\"content-wrapper\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"row crd-ho\">\n");
      out.write("                        <table class=\"table table-striped\">\n");
      out.write("                            <thead class=\"bg-dark text-white\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <th scope=\"col\">Tên</th>\n");
      out.write("                                    <th scope=\"col\">Email</th>\n");
      out.write("                                    <th scope=\"col\">Trạng thái</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            <!-- /.content-wrapper -->\n");
      out.write("            <footer class=\"main-footer\">\n");
      out.write("                <strong>Copyright &copy; 2014-2019 <a href=\"\">KHTN</a>.</strong>\n");
      out.write("                All rights reserved.\n");
      out.write("                <div class=\"float-right d-none d-sm-inline-block\">\n");
      out.write("                    <form action=\"ExcelController\">\n");
      out.write("                        <input type=\"submit\" name=\"action\" value=\"Export All User to Excel\">\n");
      out.write("                    </form>\n");
      out.write("                    <b>Version</b> 3.0.4\n");
      out.write("                </div>\n");
      out.write("            </footer>\n");
      out.write("\n");
      out.write("            <!-- Control Sidebar -->\n");
      out.write("            <aside class=\"control-sidebar control-sidebar-dark\">\n");
      out.write("                <!-- Control sidebar content goes here -->\n");
      out.write("            </aside>\n");
      out.write("            <!-- /.control-sidebar -->\n");
      out.write("        </div>\n");
      out.write("        <!-- ./wrapper -->\n");
      out.write("\n");
      out.write("        <!-- jQuery -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/jquery/jquery.min.js\"></script>\n");
      out.write("        <!-- jQuery UI 1.11.4 -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/jquery-ui/jquery-ui.min.js\"></script>\n");
      out.write("        <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->\n");
      out.write("        <script>\n");
      out.write("            $.widget.bridge('uibutton', $.ui.button);\n");
      out.write("        </script>\n");
      out.write("        <!-- Bootstrap 4 -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <!-- ChartJS -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/chart.js/Chart.min.js\"></script>\n");
      out.write("        <!-- Sparkline -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/sparklines/sparkline.js\"></script>\n");
      out.write("        <!-- JQVMap -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/jqvmap/jquery.vmap.min.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/jqvmap/maps/jquery.vmap.usa.js\"></script>\n");
      out.write("        <!-- jQuery Knob Chart -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/jquery-knob/jquery.knob.min.js\"></script>\n");
      out.write("        <!-- daterangepicker -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/moment/moment.min.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/daterangepicker/daterangepicker.js\"></script>\n");
      out.write("        <!-- Tempusdominus Bootstrap 4 -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js\"></script>\n");
      out.write("        <!-- Summernote -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/summernote/summernote-bs4.min.js\"></script>\n");
      out.write("        <!-- overlayScrollbars -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js\"></script>\n");
      out.write("        <!-- AdminLTE App -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/dist/js/adminlte.js\"></script>\n");
      out.write("        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/dist/js/pages/dashboard.js\"></script>\n");
      out.write("        <!-- AdminLTE for demo purposes -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/dist/js/demo.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listShip}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("l");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                    <tr>\n");
          out.write("                                        <td>\n");
          out.write("                                            ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${l.user_id.full_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                                        </td>\n");
          out.write("                                        <td>\n");
          out.write("                                            ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${l.user_id.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                                        </td>\n");
          out.write("                                        \n");
          out.write("                                        <td>\n");
          out.write("                                            ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${l.status}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                                        </td>\n");
          out.write("                                    </tr>\n");
          out.write("                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
