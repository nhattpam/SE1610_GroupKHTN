package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class feature_005fproduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <!-- Featured Section Begin -->\n");
      out.write("        <section class=\"featured spad\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <div class=\"section-title\">\n");
      out.write("                            <h2>Featured Product</h2>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"featured__controls\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li class=\"active\" data-filter=\"*\">All</li>\n");
      out.write("                                <li data-filter=\".oranges\">Oranges</li>\n");
      out.write("                                <li data-filter=\".fresh-meat\">Fresh Meat</li>\n");
      out.write("                                <li data-filter=\".vegetables\">Vegetables</li>\n");
      out.write("                                <li data-filter=\".fastfood\">Fastfood</li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row featured__filter\">\n");
      out.write("                    <div class=\"col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat\">\n");
      out.write("                        <div class=\"featured__item\">\n");
      out.write("                            <div class=\"featured__item__pic set-bg\" data-setbg=\"img/featured/feature-1.jpg\">\n");
      out.write("                                <ul class=\"featured__item__pic__hover\">\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"featured__item__text\">\n");
      out.write("                                <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                <h5>$30.00</h5>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3 col-md-4 col-sm-6 mix vegetables fastfood\">\n");
      out.write("                        <div class=\"featured__item\">\n");
      out.write("                            <div class=\"featured__item__pic set-bg\" data-setbg=\"img/featured/feature-2.jpg\">\n");
      out.write("                                <ul class=\"featured__item__pic__hover\">\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"featured__item__text\">\n");
      out.write("                                <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                <h5>$30.00</h5>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3 col-md-4 col-sm-6 mix vegetables fresh-meat\">\n");
      out.write("                        <div class=\"featured__item\">\n");
      out.write("                            <div class=\"featured__item__pic set-bg\" data-setbg=\"img/featured/feature-3.jpg\">\n");
      out.write("                                <ul class=\"featured__item__pic__hover\">\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"featured__item__text\">\n");
      out.write("                                <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                <h5>$30.00</h5>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3 col-md-4 col-sm-6 mix fastfood oranges\">\n");
      out.write("                        <div class=\"featured__item\">\n");
      out.write("                            <div class=\"featured__item__pic set-bg\" data-setbg=\"img/featured/feature-4.jpg\">\n");
      out.write("                                <ul class=\"featured__item__pic__hover\">\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"featured__item__text\">\n");
      out.write("                                <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                <h5>$30.00</h5>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3 col-md-4 col-sm-6 mix fresh-meat vegetables\">\n");
      out.write("                        <div class=\"featured__item\">\n");
      out.write("                            <div class=\"featured__item__pic set-bg\" data-setbg=\"img/featured/feature-5.jpg\">\n");
      out.write("                                <ul class=\"featured__item__pic__hover\">\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"featured__item__text\">\n");
      out.write("                                <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                <h5>$30.00</h5>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3 col-md-4 col-sm-6 mix oranges fastfood\">\n");
      out.write("                        <div class=\"featured__item\">\n");
      out.write("                            <div class=\"featured__item__pic set-bg\" data-setbg=\"img/featured/feature-6.jpg\">\n");
      out.write("                                <ul class=\"featured__item__pic__hover\">\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"featured__item__text\">\n");
      out.write("                                <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                <h5>$30.00</h5>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3 col-md-4 col-sm-6 mix fresh-meat vegetables\">\n");
      out.write("                        <div class=\"featured__item\">\n");
      out.write("                            <div class=\"featured__item__pic set-bg\" data-setbg=\"img/featured/feature-7.jpg\">\n");
      out.write("                                <ul class=\"featured__item__pic__hover\">\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"featured__item__text\">\n");
      out.write("                                <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                <h5>$30.00</h5>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3 col-md-4 col-sm-6 mix fastfood vegetables\">\n");
      out.write("                        <div class=\"featured__item\">\n");
      out.write("                            <div class=\"featured__item__pic set-bg\" data-setbg=\"img/featured/feature-8.jpg\">\n");
      out.write("                                <ul class=\"featured__item__pic__hover\">\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"featured__item__text\">\n");
      out.write("                                <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                <h5>$30.00</h5>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Featured Section End -->\n");
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
