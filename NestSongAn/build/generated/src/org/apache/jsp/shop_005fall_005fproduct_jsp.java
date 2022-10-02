package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dtos.UsersDTO;
import dtos.ProductDTO;
import dtos.CartDTO;
import java.text.NumberFormat;
import utils.DBUtils;
import daos.ProductDAOImpl;

public final class shop_005fall_005fproduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
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
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"description\" content=\"Ogani Template\">\r\n");
      out.write("        <meta name=\"keywords\" content=\"Ogani, unica, creative, html\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("        <title>Tất Cả Sản Phẩm</title>\r\n");
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
      out.write("        <!-- Js Plugins -->\r\n");
      out.write("        <script src=\"js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.nice-select.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery-ui.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.slicknav.js\"></script>\r\n");
      out.write("        <script src=\"js/mixitup.min.js\"></script>\r\n");
      out.write("        <script src=\"js/owl.carousel.min.js\"></script>\r\n");
      out.write("        <script src=\"js/main.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <!-- Page Preloder -->\r\n");
      out.write("        <div id=\"preloder\">\r\n");
      out.write("            <div class=\"loader\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- Hero Section Begin -->\r\n");
      out.write("        <section class=\"hero hero-normal\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-3\">\r\n");
      out.write("                        <div class=\"hero__categories\">\r\n");
      out.write("                            <div class=\"hero__categories__all\" style=\"background: #6a0e13;\">\r\n");
      out.write("                                <i class=\"fa fa-bars\"></i>\r\n");
      out.write("                                <span>Danh Mục</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><a href=\"#\">Fresh Meat</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Vegetables</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Fruit & Nut Gifts</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Fresh Berries</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Ocean Foods</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Butter & Eggs</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Fastfood</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Fresh Onion</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Papayaya & Crisps</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Oatmeal</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Fresh Bananas</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-9\">\r\n");
      out.write("                        <div class=\"hero__search\">\r\n");
      out.write("                            <div class=\"hero__search__form\">\r\n");
      out.write("                                <form action=\"#\">\r\n");
      out.write("                                    <div class=\"hero__search__categories\">\r\n");
      out.write("                                        Danh Mục\r\n");
      out.write("                                        <span class=\"arrow_carrot-down\"></span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <input type=\"text\" placeholder=\"What do yo u need?\">\r\n");
      out.write("                                    <button type=\"submit\" class=\"site-btn\">TÌM KIẾM</button>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"hero__search__phone\">\r\n");
      out.write("                                <div class=\"hero__search__phone__icon\" style=\"color: #6a0e13;\">\r\n");
      out.write("                                    <i class=\"fa fa-phone\"></i>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"hero__search__phone__text\">\r\n");
      out.write("                                    <h5>+84 1235548 48</h5>\r\n");
      out.write("                                    <span>Hỗ trợ 24/7</span>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        <!-- Hero Section End -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Breadcrumb Section Begin -->\r\n");
      out.write("        <section class=\"breadcrumb-section set-bg\" data-setbg=\"img/breadcrumb.jpg\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-12 text-center\">\r\n");
      out.write("                        <div class=\"breadcrumb__text\">\r\n");
      out.write("                            <h2>Sản Phẩm Của Nest Song Ân</h2>\r\n");
      out.write("                            <div class=\"breadcrumb__option\">\r\n");
      out.write("                                <a href=\"home\">Trang chủ</a>\r\n");
      out.write("                                <span>Shop</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        <!-- Featured Section Begin -->\r\n");
      out.write("        <section class=\"featured spad\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-12\">\r\n");
      out.write("                        <div class=\"section-title\">\r\n");
      out.write("                            <h2>Tất Cả</h2>\r\n");
      out.write("                            <style type=\"text/css\">\r\n");
      out.write("                                .section-title h2:after {\r\n");
      out.write("                                    position: absolute;\r\n");
      out.write("                                    left: 0;\r\n");
      out.write("                                    bottom: -15px;\r\n");
      out.write("                                    right: 0;\r\n");
      out.write("                                    height: 4px;\r\n");
      out.write("                                    width: 80px;\r\n");
      out.write("                                    background: #6a0e13;\r\n");
      out.write("                                    content: \"\";\r\n");
      out.write("                                    margin: 0 auto;\r\n");
      out.write("                                }\r\n");
      out.write("                            </style>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"featured__controls\">\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li class=\"active\" data-filter=\"*\">All</li>\r\n");
      out.write("                                <li data-filter=\".oranges\">Oranges</li>\r\n");
      out.write("                                <li data-filter=\".fresh-meat\">Fresh Meat</li>\r\n");
      out.write("                                <li data-filter=\".vegetables\">Vegetables</li>\r\n");
      out.write("                                <li data-filter=\".fastfood\">Fastfood</li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                ");

                    UsersDTO u = (UsersDTO) session.getAttribute("USER");
                    //ProductDAOImpl productDAO = new ProductDAOImpl(DBUtils.getConnection());
                    //ProductDTO p = productDAO.getProductId(request.getParameter("product_id"));
                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMinimumIntegerDigits(0);

                    CartDTO cart = (CartDTO) session.getAttribute("cart");
                    if (cart == null) {
                        cart = new CartDTO();
                        session.setAttribute("cart", cart);
                    }
                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"row featured__filter\">\r\n");
      out.write("                    ");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
      _jspx_th_c_forEach_0.setParent(null);
      _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listAllProduct}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      _jspx_th_c_forEach_0.setVar("l");
      int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
      try {
        int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
        if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                        <div class=\"col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat\">\r\n");
            out.write("                            <div class=\"featured__item\">\r\n");
            out.write("\r\n");
            out.write("                                <div class=\"featured__item__pic set-bg\" data-setbg=\"products/");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${l.photo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("                                    <ul class=\"featured__item__pic__hover\">\r\n");
            out.write("                                        <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\r\n");
            out.write("                                        <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\r\n");
            out.write("                                        ");

                                            if (u == null){
            out.write("\r\n");
            out.write("                                                <li><a href=\"login.jsp\"><i class=\"fa fa-shopping-cart\"></i></a></li>\r\n");
            out.write("                                            ");
} else {
            out.write("\r\n");
            out.write("                                                <li><a href=\"add-cart?command=insert&product_id=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${l.product_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("&cartID=");
            out.print( System.currentTimeMillis());
            out.write("\"><i class=\"fa fa-shopping-cart\"></i></a></li>\r\n");
            out.write("                                            ");
}
                                        
            out.write("\r\n");
            out.write("                                        \r\n");
            out.write("                                    </ul>\r\n");
            out.write("                                </div>\r\n");
            out.write("                                <div class=\"featured__item__text\">\r\n");
            out.write("                                    <h6><a href=\"detail?product_id=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${l.product_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${l.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</a></h6>\r\n");
            out.write("                                    <h5>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${l.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</h5>\r\n");
            out.write("                                </div>\r\n");
            out.write("\r\n");
            out.write("                            </div>\r\n");
            out.write("                        </div>\r\n");
            out.write("                    ");
            int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_forEach_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_forEach_0.doFinally();
        _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        <!-- Featured Section End -->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
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
