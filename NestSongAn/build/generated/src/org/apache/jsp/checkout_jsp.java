package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.NumberFormat;
import java.util.TreeMap;
import dtos.ProductDTO;
import dtos.CartDTO;
import dtos.UsersDTO;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> \r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"description\" content=\"Ogani Template\">\r\n");
      out.write("        <meta name=\"keywords\" content=\"Ogani, unica, creative, html\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("        <title>Thông Tin Thanh Toán</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- Google Font -->\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Css Styles -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/elegant-icons.css\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/nice-select.css\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/jquery-ui.min.css\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/slicknav.min.css\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\">\r\n");
      out.write("        <style>\r\n");
      out.write("            .breadcrumbs {\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .breadcrumbs .breadcrumb {\r\n");
      out.write("                background:transparent;\r\n");
      out.write("                margin-bottom: 75px;\r\n");
      out.write("                padding-left: 0;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .breadcrumbs .breadcrumb li a {\r\n");
      out.write("                background: #6a0e13;\r\n");
      out.write("                color: #FFFFFF;\r\n");
      out.write("                padding: 3px 7px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .breadcrumbs .breadcrumb li a:after {\r\n");
      out.write("                content:\"\";\r\n");
      out.write("                height:auto;\r\n");
      out.write("                width: auto;\r\n");
      out.write("                border-width: 8px;\r\n");
      out.write("                border-style: solid;\r\n");
      out.write("                border-color:transparent transparent transparent #6a0e13;\r\n");
      out.write("                position: absolute;\r\n");
      out.write("                top: 11px;\r\n");
      out.write("                left:48px;\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .breadcrumbs .breadcrumb > li + li:before {\r\n");
      out.write("                content: \" \";\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            #cart_items .cart_info {\r\n");
      out.write("                border: 1px solid #E6E4DF;\r\n");
      out.write("                margin-bottom: 50px\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            #cart_items .cart_info .cart_menu {\r\n");
      out.write("                background: #6a0e13;\r\n");
      out.write("                color: #fff;\r\n");
      out.write("                font-size: 16px;\r\n");
      out.write("                font-family: 'Roboto', sans-serif;\r\n");
      out.write("                font-weight: normal;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            #cart_items .cart_info .table.table-condensed thead tr {\r\n");
      out.write("                height: 51px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            #cart_items .cart_info .table.table-condensed tr {\r\n");
      out.write("                border-bottom: 1px solid#F7F7F0\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            #cart_items .cart_info .table.table-condensed tr:last-child {\r\n");
      out.write("                border-bottom: 0\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .cart_info table tr td {\r\n");
      out.write("                border-top: 0 none;\r\n");
      out.write("                vertical-align: inherit;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            #cart_items .cart_info .image {\r\n");
      out.write("                padding-left: 30px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            #cart_items .cart_info .cart_description h4 {\r\n");
      out.write("                margin-bottom: 0\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            #cart_items .cart_info .cart_description h4 a {\r\n");
      out.write("                color: #363432;\r\n");
      out.write("                font-family: 'Roboto',sans-serif;\r\n");
      out.write("                font-size: 20px;\r\n");
      out.write("                font-weight: normal;\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            #cart_items .cart_info .cart_description p {\r\n");
      out.write("                color:#696763\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            #cart_items .cart_info .cart_price p {\r\n");
      out.write("                color:#696763;\r\n");
      out.write("                font-size: 18px\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            #cart_items .cart_info .cart_total_price {\r\n");
      out.write("                color: #6a0e13;\r\n");
      out.write("                font-size: 24px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .cart_product {\r\n");
      out.write("                display: block;\r\n");
      out.write("                margin: 15px -70px 10px 25px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .cart_quantity_button a {\r\n");
      out.write("                background:#F0F0E9;\r\n");
      out.write("                color: #696763;\r\n");
      out.write("                display: inline-block;\r\n");
      out.write("                font-size: 16px;\r\n");
      out.write("                height: 28px;\r\n");
      out.write("                overflow: hidden;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                width: 35px;\r\n");
      out.write("                float: left;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            .cart_quantity_input {\r\n");
      out.write("                color: #696763;\r\n");
      out.write("                float: left;\r\n");
      out.write("                font-size: 16px;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                font-family: 'Roboto',sans-serif;\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            .cart_delete  {\r\n");
      out.write("                display: block;\r\n");
      out.write("                margin-right: -12px;\r\n");
      out.write("                overflow: hidden;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            .cart_delete a {\r\n");
      out.write("                background:#6a0e13;\r\n");
      out.write("                color: #FFFFFF;\r\n");
      out.write("                padding: 5px 7px;\r\n");
      out.write("                font-size: 16px\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .cart_delete a:hover {\r\n");
      out.write("                background:#FE980F\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("        ");

            if(session.getAttribute("USER") == null){
                response.sendRedirect("loginController");
            }
            else {
                CartDTO cart = (CartDTO) session.getAttribute("cart");
            if (cart == null) {
                cart = new CartDTO();
                session.setAttribute("cart", cart);
            }
            TreeMap<ProductDTO, Integer> list = cart.getList();
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(0);
        
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <section id=\"cart_items\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"breadcrumbs\">\r\n");
      out.write("                    <ol class=\"breadcrumb\">\r\n");
      out.write("                        <li><a href=\"index.jsp\">Trang Chủ</a></li>\r\n");
      out.write("                        <li class=\"active\">Thanh Toán</li>\r\n");
      out.write("                    </ol>\r\n");
      out.write("                </div><!--/breadcrums-->\r\n");
      out.write("\r\n");
      out.write("                <div class=\"content-wrapper \" style=\"margin-bottom: 50px;\">\r\n");
      out.write("                    <div class=\"container \">\r\n");
      out.write("                        <div class=\"row crd-ho\">\r\n");
      out.write("                            <div class=\"col-md-6 offset-md-3\">\r\n");
      out.write("                                <div class=\"card\">\r\n");
      out.write("                                    <div class=\"card-body\">\r\n");
      out.write("                                        <h4 class=\"text-center\">Thông Tin Đặt Hàng</h4><br>\r\n");
      out.write("                                        <form action=\"checkout\" method=\"post\">\r\n");
      out.write("                                            <input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"id\">\r\n");
      out.write("                                            <div class=\"form-row\">\r\n");
      out.write("                                                <div class=\"col-6\" >\r\n");
      out.write("                                                    <select name=\"branch_id\">\r\n");
      out.write("                                                        <option selected>--Chọn Miền-- </option>\r\n");
      out.write("                                                        <option value=\"1\">Miền Bắc </option>\r\n");
      out.write("                                                        <option value=\"2\">Miền Trung</option>\r\n");
      out.write("                                                        <option value=\"3\">Miền Nam</option>\r\n");
      out.write("                                                    </select>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"col-6\">\r\n");
      out.write("                                                    <select name=\"province\" class=\"form-select selectpicker\">\r\n");
      out.write("                                                        <option selected=\"\">--Tỉnh/Thành Phố--</option>\r\n");
      out.write("                                                        <option value=\"Hoà Bình\">Hoà Bình</option>\r\n");
      out.write("                                                        <option value=\"Sơn La\">Sơn La</option>\r\n");
      out.write("                                                        <option value=\"Điện Biên\">Điện Biên</option>\r\n");
      out.write("                                                        <option value=\"Lai Châu\">Lai Châu</option>\r\n");
      out.write("                                                        <option value=\"Lào Cai\">Lào Cai</option>\r\n");
      out.write("                                                        <option value=\"Yên Bái\">Yên Bái</option>\r\n");
      out.write("                                                        <option value=\"Phú Thọ\">Phú Thọ</option>\r\n");
      out.write("                                                        <option value=\"Hà Giang\">Hà Giang</option>\r\n");
      out.write("                                                        <option value=\"Tuyên Quang\">Tuyên Quang</option>\r\n");
      out.write("                                                        <option value=\"Cao Bằng\">Cao Bằng</option>\r\n");
      out.write("                                                        <option value=\"Bắc Kạn\">Bắc Kạn</option>\r\n");
      out.write("                                                        <option value=\"Thái Nguyên\">Thái Nguyên</option>\r\n");
      out.write("                                                        <option value=\"Lạng Sơn\">Lạng Sơn</option>\r\n");
      out.write("                                                        <option value=\"Bắc Giang\">Bắc Giang</option>\r\n");
      out.write("                                                        <option value=\"Quảng Ninh\">Quảng Ninh</option>\r\n");
      out.write("                                                        <option value=\"Hà Nội\">Hà Nội</option>\r\n");
      out.write("                                                        <option value=\"Bắc Ninh\">Bắc Ninh</option>\r\n");
      out.write("                                                        <option value=\"Hà Nam\">Hà Nam</option>\r\n");
      out.write("                                                        <option value=\"Hải Dương\">Hải Dương</option>\r\n");
      out.write("                                                        <option value=\"Hải Phòng\">Hải Phòng</option>\r\n");
      out.write("                                                        <option value=\"Hưng Yên\">Hưng Yên</option>\r\n");
      out.write("                                                        <option value=\"Nam Định\">Nam Định</option>\r\n");
      out.write("                                                        <option value=\"Thái Bình\">Thái Bình</option>\r\n");
      out.write("                                                        <option value=\"Vĩnh Phúc\">Vĩnh Phúc</option>\r\n");
      out.write("                                                        <option value=\"Ninh Bình\">Ninh Bình</option>\r\n");
      out.write("                                                        <option value=\"Thanh Hoá\">Thanh Hoá</option>\r\n");
      out.write("                                                        <option value=\"Nghệ An\">Nghệ An</option>\r\n");
      out.write("                                                        <option value=\"Hà Tĩnh\">Hà Tĩnh</option>\r\n");
      out.write("                                                        <option value=\"Quảng Bình\">Quảng Bình</option>\r\n");
      out.write("                                                        <option value=\"Quảng Trị\">Quảng Trị</option>\r\n");
      out.write("                                                        <option value=\"Thừa Thiên Huế\">Thừa Thiên Huế</option>\r\n");
      out.write("                                                        <option value=\"Đà Nẵng\">Đà Nẵng</option>\r\n");
      out.write("                                                        <option value=\"Quảng Nam\">Quảng Nam</option>\r\n");
      out.write("                                                        <option value=\"Quảng Nam\">Quảng Nam</option>\r\n");
      out.write("                                                        <option value=\"Quảng Ngãi\">Quảng Ngãi</option>\r\n");
      out.write("                                                        <option value=\"Bình Định\">Bình Định</option>\r\n");
      out.write("                                                        <option value=\"Phú Yên\">Phú Yên</option>\r\n");
      out.write("                                                        <option value=\"Khánh Hoà\">Khánh Hoà</option>\r\n");
      out.write("                                                        <option value=\"Ninh Thuận\">Ninh Thuận</option>\r\n");
      out.write("                                                        <option value=\"Bình Thuận\">Bình Thuận</option>\r\n");
      out.write("                                                        <option value=\"Kon Tum\">Kon Tum</option>\r\n");
      out.write("                                                        <option value=\"Gia Lai\">Gia Lai</option>\r\n");
      out.write("                                                        <option value=\"Đắk Lắk\">Đắk Lắk</option>\r\n");
      out.write("                                                        <option value=\"Đắk Nông\">Đắk Nông</option>\r\n");
      out.write("                                                        <option value=\"Lâm Đồng\">Lâm Đồng</option>\r\n");
      out.write("                                                        <option value=\"TP Hồ Chí Minh\">TP Hồ Chí Minh</option>\r\n");
      out.write("                                                        <option value=\"Bà Rịa Vũng Tàu\">Bà Rịa Vũng Tàu</option>\r\n");
      out.write("                                                        <option value=\"Bình Dương\">Bình Dương</option>\r\n");
      out.write("                                                        <option value=\"Bình Phước\">Bình Phước</option>\r\n");
      out.write("                                                        <option value=\"Đồng Nai\">Đồng Nai</option>\r\n");
      out.write("                                                        <option value=\"Tây Ninh\">Tây Ninh</option>\r\n");
      out.write("                                                        <option value=\"An Giang\">An Giang</option>\r\n");
      out.write("                                                        <option value=\"Bạc Liêu\">Bạc Liêu</option>\r\n");
      out.write("                                                        <option value=\"Bến Tre\">Bến Tre</option>\r\n");
      out.write("                                                        <option value=\"Cà Mau\">Cà Mau</option>\r\n");
      out.write("                                                        <option value=\"Cần Thơ\">Cần Thơ</option>\r\n");
      out.write("                                                        <option value=\"Đồng Tháp\">Đồng Tháp</option>\r\n");
      out.write("                                                        <option value=\"Hậu Giang\">Hậu Giang</option>\r\n");
      out.write("                                                        <option value=\"Kiên Giang\">Kiên Giang</option>\r\n");
      out.write("                                                        <option value=\"Long An\">Long An</option>\r\n");
      out.write("                                                        <option value=\"Sóc Trăng\">Sóc Trăng</option>\r\n");
      out.write("                                                        <option value=\"Tiền Giang\">Tiền Giang</option>\r\n");
      out.write("                                                        <option value=\"Trà Vinh\">Trà Vinh</option>\r\n");
      out.write("                                                        <option value=\"Vĩnh Long\">Vĩnh Long</option>\r\n");
      out.write("                                                    </select>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div> \r\n");
      out.write("                                            <br>\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <input name=\"delivery_address\" type=\"text\" class=\"form-control\" id=\"exampleInputPassword1\" required=\"required\" placeholder=\"Địa chỉ chi tiết\">\r\n");
      out.write("                                            </div> \r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <select name=\"payment_method\">\r\n");
      out.write("                                                    <option selected=\"\">--Phương Thức Thanh Toán--</option>\r\n");
      out.write("                                                    <option value=\"cod\">Thanh toán khi nhận hàng</option>\r\n");
      out.write("                                                </select><br>\r\n");
      out.write("                                            </div> \r\n");
      out.write("                                            <div  class=\"container-fluid\">\r\n");
      out.write("                                                <input type=\"submit\" value=\"Xác nhận thanh toán\" class=\"btn btn-danger\"\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                        </form>\r\n");
      out.write("                                    </div> \r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                       ");

                                for (Map.Entry<ProductDTO, Integer> ds : list.entrySet()) {
                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td class=\"cart_product\">\r\n");
      out.write("                                    <a href=\"\"><img src=\"products/");
      out.print( ds.getKey().getPhoto());
      out.write("\" alt=\"\" style=\"width: 50px; height: 60px;\"></a>\r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td class=\"cart_description\">\r\n");
      out.write("                                    <h4><a href=\"\">");
      out.print( ds.getKey().getName());
      out.write("</a></h4>\r\n");
      out.write("                                    <p>Code: ");
      out.print( ds.getKey().getCode());
      out.write("</p>\r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td class=\"cart_price\">\r\n");
      out.write("                                    <p>");
      out.print( nf.format(ds.getKey().getPrice()));
      out.write(" VNĐ</p>\r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td class=\"cart_quantity\">\r\n");
      out.write("                                    <div class=\"cart_quantity_button\">\r\n");
      out.write("                                        <a class=\"cart_quantity_up\" href=\"add-cart?command=plus&product_id=");
      out.print( ds.getKey().getProduct_id());
      out.write("&cartID=");
      out.print(System.currentTimeMillis());
      out.write("\"> + </a>\r\n");
      out.write("                                        <input class=\"cart_quantity_input\" type=\"text\" value=\"");
      out.print( ds.getValue());
      out.write("\" autocomplete=\"off\" size=\"2\" disabled=\"\">\r\n");
      out.write("                                        <a class=\"cart_quantity_down\" href=\"add-cart?command=sub&product_id=");
      out.print( ds.getKey().getProduct_id());
      out.write("&cartID=");
      out.print(System.currentTimeMillis());
      out.write("\"> - </a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td class=\"cart_total\">\r\n");
      out.write("                                    <p class=\"cart_total_price\">");
      out.print( nf.format(ds.getValue() * ds.getKey().getPrice()));
      out.write(" VNĐ</p>\r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td class=\"cart_delete\">\r\n");
      out.write("                                    <a class=\"cart_quantity_delete\" href=\"add-cart?command=remove&product_id=");
      out.print( ds.getKey().getProduct_id());
      out.write("&cartID=");
      out.print(System.currentTimeMillis());
      out.write("\"><i class=\"fa fa-times\"></i></a>\r\n");
      out.write("                                </td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("\r\n");
      out.write("                            ");

                                }
                            
      out.write("                     \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </section> <!--/#cart_items-->\r\n");
      out.write("        ");

            }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Js Plugins -->\r\n");
      out.write("        <script src=\"js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.nice-select.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery-ui.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.slicknav.js\"></script>\r\n");
      out.write("        <script src=\"js/mixitup.min.js\"></script>\r\n");
      out.write("        <script src=\"js/owl.carousel.min.js\"></script>\r\n");
      out.write("        <script src=\"js/main.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
}
