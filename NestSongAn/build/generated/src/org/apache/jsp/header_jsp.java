package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"description\" content=\"Ogani Template\">\r\n");
      out.write("        <meta name=\"keywords\" content=\"Ogani, unica, creative, html\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("        <title>Ogani | Template</title>\r\n");
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
      out.write("        <!-- Humberger Begin -->\r\n");
      out.write("        <div class=\"humberger__menu__overlay\"></div>\r\n");
      out.write("        <div class=\"humberger__menu__wrapper\">\r\n");
      out.write("            <div class=\"humberger__menu__logo\">\r\n");
      out.write("                <a href=\"#\"><img src=\"img/logo.png\" alt=\"\"></a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"humberger__menu__cart\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i> <span>1</span></a></li>\r\n");
      out.write("                    <li><a href=\"#\"><i class=\"fa fa-shopping-bag\"></i> <span>3</span></a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <div class=\"header__cart__price\">item: <span></span></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"humberger__menu__widget\">\r\n");
      out.write("                <div class=\"header__top__right__language\">\r\n");
      out.write("                    <img src=\"img/language.png\" alt=\"\">\r\n");
      out.write("                    <div>English</div>\r\n");
      out.write("                    <span class=\"arrow_carrot-down\"></span>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"#\">Spanis</a></li>\r\n");
      out.write("                        <li><a href=\"#\">English</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"header__top__right__auth\">\r\n");
      out.write("                    <a href=\"#\"><i class=\"fa fa-user\"></i> Login</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <nav class=\"humberger__menu__nav mobile-menu\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li class=\"active\"><a href=\"./index.html\">Home</a></li>\r\n");
      out.write("                    <li><a href=\"./shop-grid.html\">Shop</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Pages</a>\r\n");
      out.write("                        <ul class=\"header__menu__dropdown\">\r\n");
      out.write("                            <li><a href=\"./shop-details.html\">Shop Details</a></li>\r\n");
      out.write("                            <li><a href=\"./shoping-cart.html\">Shoping Cart</a></li>\r\n");
      out.write("                            <li><a href=\"./checkout.html\">Check Out</a></li>\r\n");
      out.write("                            <li><a href=\"./blog-details.html\">Blog Details</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li><a href=\"./blog.html\">Blog</a></li>\r\n");
      out.write("                    <li><a href=\"./contact.html\">Contact</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </nav>\r\n");
      out.write("            <div id=\"mobile-menu-wrap\"></div>\r\n");
      out.write("            <div class=\"header__top__right__social\">\r\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\r\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\r\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-linkedin\"></i></a>\r\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-pinterest-p\"></i></a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"humberger__menu__contact\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><i class=\"fa fa-envelope\"></i> hello@colorlib.com</li>\r\n");
      out.write("                    <li>Free Shipping for all Order of $99</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Humberger End -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Header Section Begin -->\r\n");
      out.write("        <header class=\"header\">\r\n");
      out.write("            <div class=\"header__top\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-6 col-md-6\">\r\n");
      out.write("                            <div class=\"header__top__left\">\r\n");
      out.write("                                <ul>\r\n");
      out.write("                                    <li><i class=\"fa fa-envelope\"></i> hello@colorlib.com</li>\r\n");
      out.write("                                    <li>Free Shipping for all Order of $99</li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-6 col-md-6\">\r\n");
      out.write("                            <div class=\"header__top__right\">\r\n");
      out.write("                                <div class=\"header__top__right__social\">\r\n");
      out.write("                                    <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\r\n");
      out.write("                                    <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\r\n");
      out.write("                                    <a href=\"#\"><i class=\"fa fa-linkedin\"></i></a>\r\n");
      out.write("                                    <a href=\"#\"><i class=\"fa fa-pinterest-p\"></i></a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"header__top__right__language\">\r\n");
      out.write("                                    <img src=\"img/language.png\" alt=\"\">\r\n");
      out.write("                                    <div>English</div>\r\n");
      out.write("                                    <span class=\"arrow_carrot-down\"></span>\r\n");
      out.write("                                    <ul>\r\n");
      out.write("                                        <li><a href=\"#\">Spanis</a></li>\r\n");
      out.write("                                        <li><a href=\"#\">English</a></li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"header__top__right__auth\">\r\n");
      out.write("                                    <a href=\"#\"><i class=\"fa fa-user\"></i> Login</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-3\">\r\n");
      out.write("                        <div class=\"header__logo\">\r\n");
      out.write("                            <a href=\"./index.html\"><img src=\"img/logo.png\" alt=\"\"></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("                        <nav class=\"header__menu\">\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li class=\"active\"><a href=\"./index.html\">Home</a></li>\r\n");
      out.write("                                <li><a href=\"./shop-grid.html\">Shop</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Pages</a>\r\n");
      out.write("                                    <ul class=\"header__menu__dropdown\">\r\n");
      out.write("                                        <li><a href=\"./shop-details.html\">Shop Details</a></li>\r\n");
      out.write("                                        <li><a href=\"./shoping-cart.html\">Shoping Cart</a></li>\r\n");
      out.write("                                        <li><a href=\"./checkout.html\">Check Out</a></li>\r\n");
      out.write("                                        <li><a href=\"./blog-details.html\">Blog Details</a></li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li><a href=\"./blog.html\">Blog</a></li>\r\n");
      out.write("                                <li><a href=\"./contact.html\">Contact</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </nav>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-3\">\r\n");
      out.write("                        <div class=\"header__cart\">\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><a href=\"#\"><i class=\"fa fa-heart\"></i> <span>1</span></a></li>\r\n");
      out.write("                                <li><a href=\"#\"><i class=\"fa fa-shopping-bag\"></i> <span>3</span></a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                            <div class=\"header__cart__price\">item: <span>$150.00</span></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"humberger__open\">\r\n");
      out.write("                    <i class=\"fa fa-bars\"></i>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("        <!-- Header Section End -->\r\n");
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
