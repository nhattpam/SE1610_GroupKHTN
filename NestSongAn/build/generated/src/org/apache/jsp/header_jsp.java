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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"description\" content=\"Ogani Template\">\n");
      out.write("        <meta name=\"keywords\" content=\"Ogani, unica, creative, html\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <title>Ogani | Template</title>\n");
      out.write("\n");
      out.write("        <!-- Google Font -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Css Styles -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/elegant-icons.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/nice-select.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/jquery-ui.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/slicknav.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\">\n");
      out.write("        <!-- Js Plugins -->\n");
      out.write("        <script src=\"js/jquery-3.3.1.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.nice-select.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery-ui.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.slicknav.js\"></script>\n");
      out.write("        <script src=\"js/mixitup.min.js\"></script>\n");
      out.write("        <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Humberger Begin -->\n");
      out.write("        <div class=\"humberger__menu__overlay\"></div>\n");
      out.write("        <div class=\"humberger__menu__wrapper\">\n");
      out.write("            <div class=\"humberger__menu__logo\">\n");
      out.write("                <a href=\"#\"><img src=\"img/logo.png\" alt=\"\"></a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"humberger__menu__cart\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i> <span>1</span></a></li>\n");
      out.write("                    <li><a href=\"#\"><i class=\"fa fa-shopping-bag\"></i> <span>3</span></a></li>\n");
      out.write("                </ul>\n");
      out.write("                <div class=\"header__cart__price\">item: <span>$150.00</span></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"humberger__menu__widget\">\n");
      out.write("                <div class=\"header__top__right__language\">\n");
      out.write("                    <img src=\"img/language.png\" alt=\"\">\n");
      out.write("                    <div>English</div>\n");
      out.write("                    <span class=\"arrow_carrot-down\"></span>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"#\">Spanis</a></li>\n");
      out.write("                        <li><a href=\"#\">English</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"header__top__right__auth\">\n");
      out.write("                    <a href=\"#\"><i class=\"fa fa-user\"></i> Login</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <nav class=\"humberger__menu__nav mobile-menu\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"active\"><a href=\"./index.html\">Home</a></li>\n");
      out.write("                    <li><a href=\"./shop-grid.html\">Shop</a></li>\n");
      out.write("                    <li><a href=\"#\">Pages</a>\n");
      out.write("                        <ul class=\"header__menu__dropdown\">\n");
      out.write("                            <li><a href=\"./shop-details.html\">Shop Details</a></li>\n");
      out.write("                            <li><a href=\"./shoping-cart.html\">Shoping Cart</a></li>\n");
      out.write("                            <li><a href=\"./checkout.html\">Check Out</a></li>\n");
      out.write("                            <li><a href=\"./blog-details.html\">Blog Details</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"./blog.html\">Blog</a></li>\n");
      out.write("                    <li><a href=\"./contact.html\">Contact</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("            <div id=\"mobile-menu-wrap\"></div>\n");
      out.write("            <div class=\"header__top__right__social\">\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-linkedin\"></i></a>\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-pinterest-p\"></i></a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"humberger__menu__contact\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><i class=\"fa fa-envelope\"></i> hello@colorlib.com</li>\n");
      out.write("                    <li>Free Shipping for all Order of $99</li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Humberger End -->\n");
      out.write("\n");
      out.write("        <!-- Header Section Begin -->\n");
      out.write("        <header class=\"header\">\n");
      out.write("            <div class=\"header__top\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-6 col-md-6\">\n");
      out.write("                            <div class=\"header__top__left\">\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><i class=\"fa fa-envelope\"></i> hello@colorlib.com</li>\n");
      out.write("                                    <li>Free Shipping for all Order of $99</li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-lg-6 col-md-6\">\n");
      out.write("                            <div class=\"header__top__right\">\n");
      out.write("                                <div class=\"header__top__right__social\">\n");
      out.write("                                    <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                                    <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("                                    <a href=\"#\"><i class=\"fa fa-linkedin\"></i></a>\n");
      out.write("                                    <a href=\"#\"><i class=\"fa fa-pinterest-p\"></i></a>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"header__top__right__language\">\n");
      out.write("                                    <img src=\"img/language.png\" alt=\"\">\n");
      out.write("                                    <div>English</div>\n");
      out.write("                                    <span class=\"arrow_carrot-down\"></span>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"#\">Spanis</a></li>\n");
      out.write("                                        <li><a href=\"#\">English</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"header__top__right__auth\">\n");
      out.write("                                    <a href=\"#\"><i class=\"fa fa-user\"></i> Login</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-3\">\n");
      out.write("                        <div class=\"header__logo\">\n");
      out.write("                            <a href=\"./index.html\"><img src=\"img/logo.png\" alt=\"\"></a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("                        <nav class=\"header__menu\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li class=\"active\"><a href=\"./index.html\">Home</a></li>\n");
      out.write("                                <li><a href=\"./shop-grid.html\">Shop</a></li>\n");
      out.write("                                <li><a href=\"#\">Pages</a>\n");
      out.write("                                    <ul class=\"header__menu__dropdown\">\n");
      out.write("                                        <li><a href=\"./shop-details.html\">Shop Details</a></li>\n");
      out.write("                                        <li><a href=\"./shoping-cart.html\">Shoping Cart</a></li>\n");
      out.write("                                        <li><a href=\"./checkout.html\">Check Out</a></li>\n");
      out.write("                                        <li><a href=\"./blog-details.html\">Blog Details</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"./blog.html\">Blog</a></li>\n");
      out.write("                                <li><a href=\"./contact.html\">Contact</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3\">\n");
      out.write("                        <div class=\"header__cart\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\"><i class=\"fa fa-heart\"></i> <span>1</span></a></li>\n");
      out.write("                                <li><a href=\"#\"><i class=\"fa fa-shopping-bag\"></i> <span>3</span></a></li>\n");
      out.write("                            </ul>\n");
      out.write("                            <div class=\"header__cart__price\">item: <span>$150.00</span></div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"humberger__open\">\n");
      out.write("                    <i class=\"fa fa-bars\"></i>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <!-- Header Section End -->\n");
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
}
