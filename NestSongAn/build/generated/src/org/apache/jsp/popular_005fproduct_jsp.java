package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class popular_005fproduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        \r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"col-lg-4 col-md-6\">\r\n");
      out.write("            <div class=\"latest-product__text\">\r\n");
      out.write("                <h4>Top Rated Products</h4>\r\n");
      out.write("                <div class=\"latest-product__slider owl-carousel\">\r\n");
      out.write("                    <div class=\"latest-prdouct__slider__item\">\r\n");
      out.write("                        <a href=\"#\" class=\"latest-product__item\">\r\n");
      out.write("                            <div class=\"latest-product__item__pic\">\r\n");
      out.write("                                <img src=\"img/latest-product/lp-1.jpg\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"latest-product__item__text\">\r\n");
      out.write("                                <h6>Crab Pool Security</h6>\r\n");
      out.write("                                <span>$30.00</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href=\"#\" class=\"latest-product__item\">\r\n");
      out.write("                            <div class=\"latest-product__item__pic\">\r\n");
      out.write("                                <img src=\"img/latest-product/lp-2.jpg\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"latest-product__item__text\">\r\n");
      out.write("                                <h6>Crab Pool Security</h6>\r\n");
      out.write("                                <span>$30.00</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href=\"#\" class=\"latest-product__item\">\r\n");
      out.write("                            <div class=\"latest-product__item__pic\">\r\n");
      out.write("                                <img src=\"img/latest-product/lp-3.jpg\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"latest-product__item__text\">\r\n");
      out.write("                                <h6>Crab Pool Security</h6>\r\n");
      out.write("                                <span>$30.00</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"latest-prdouct__slider__item\">\r\n");
      out.write("                        <a href=\"#\" class=\"latest-product__item\">\r\n");
      out.write("                            <div class=\"latest-product__item__pic\">\r\n");
      out.write("                                <img src=\"img/latest-product/lp-1.jpg\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"latest-product__item__text\">\r\n");
      out.write("                                <h6>Crab Pool Security</h6>\r\n");
      out.write("                                <span>$30.00</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href=\"#\" class=\"latest-product__item\">\r\n");
      out.write("                            <div class=\"latest-product__item__pic\">\r\n");
      out.write("                                <img src=\"img/latest-product/lp-2.jpg\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"latest-product__item__text\">\r\n");
      out.write("                                <h6>Crab Pool Security</h6>\r\n");
      out.write("                                <span>$30.00</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href=\"#\" class=\"latest-product__item\">\r\n");
      out.write("                            <div class=\"latest-product__item__pic\">\r\n");
      out.write("                                <img src=\"img/latest-product/lp-3.jpg\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"latest-product__item__text\">\r\n");
      out.write("                                <h6>Crab Pool Security</h6>\r\n");
      out.write("                                <span>$30.00</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-lg-4 col-md-6\">\r\n");
      out.write("            <div class=\"latest-product__text\">\r\n");
      out.write("                <h4>Review Products</h4>\r\n");
      out.write("                <div class=\"latest-product__slider owl-carousel\">\r\n");
      out.write("                    <div class=\"latest-prdouct__slider__item\">\r\n");
      out.write("                        <a href=\"#\" class=\"latest-product__item\">\r\n");
      out.write("                            <div class=\"latest-product__item__pic\">\r\n");
      out.write("                                <img src=\"img/latest-product/lp-1.jpg\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"latest-product__item__text\">\r\n");
      out.write("                                <h6>Crab Pool Security</h6>\r\n");
      out.write("                                <span>$30.00</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href=\"#\" class=\"latest-product__item\">\r\n");
      out.write("                            <div class=\"latest-product__item__pic\">\r\n");
      out.write("                                <img src=\"img/latest-product/lp-2.jpg\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"latest-product__item__text\">\r\n");
      out.write("                                <h6>Crab Pool Security</h6>\r\n");
      out.write("                                <span>$30.00</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href=\"#\" class=\"latest-product__item\">\r\n");
      out.write("                            <div class=\"latest-product__item__pic\">\r\n");
      out.write("                                <img src=\"img/latest-product/lp-3.jpg\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"latest-product__item__text\">\r\n");
      out.write("                                <h6>Crab Pool Security</h6>\r\n");
      out.write("                                <span>$30.00</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"latest-prdouct__slider__item\">\r\n");
      out.write("                        <a href=\"#\" class=\"latest-product__item\">\r\n");
      out.write("                            <div class=\"latest-product__item__pic\">\r\n");
      out.write("                                <img src=\"img/latest-product/lp-1.jpg\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"latest-product__item__text\">\r\n");
      out.write("                                <h6>Crab Pool Security</h6>\r\n");
      out.write("                                <span>$30.00</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href=\"#\" class=\"latest-product__item\">\r\n");
      out.write("                            <div class=\"latest-product__item__pic\">\r\n");
      out.write("                                <img src=\"img/latest-product/lp-2.jpg\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"latest-product__item__text\">\r\n");
      out.write("                                <h6>Crab Pool Security</h6>\r\n");
      out.write("                                <span>$30.00</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href=\"#\" class=\"latest-product__item\">\r\n");
      out.write("                            <div class=\"latest-product__item__pic\">\r\n");
      out.write("                                <img src=\"img/latest-product/lp-3.jpg\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"latest-product__item__text\">\r\n");
      out.write("                                <h6>Crab Pool Security</h6>\r\n");
      out.write("                                <span>$30.00</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
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
