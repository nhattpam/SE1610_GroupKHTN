package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class product_005fdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Chi Tiết Sản Phẩm</title>\r\n");
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
      out.write("                            <div class=\"hero__categories__all\">\r\n");
      out.write("                                <i class=\"fa fa-bars\"></i>\r\n");
      out.write("                                <span>All departments</span>\r\n");
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
      out.write("                                        All Categories\r\n");
      out.write("                                        <span class=\"arrow_carrot-down\"></span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <input type=\"text\" placeholder=\"What do yo u need?\">\r\n");
      out.write("                                    <button type=\"submit\" class=\"site-btn\">SEARCH</button>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"hero__search__phone\">\r\n");
      out.write("                                <div class=\"hero__search__phone__icon\">\r\n");
      out.write("                                    <i class=\"fa fa-phone\"></i>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"hero__search__phone__text\">\r\n");
      out.write("                                    <h5>+65 11.188.888</h5>\r\n");
      out.write("                                    <span>support 24/7 time</span>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        <!-- Hero Section End -->\r\n");
      out.write("        <section class=\"hero hero-normal\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-3\">\r\n");
      out.write("                        <div class=\"hero__categories\">\r\n");
      out.write("                            <div class=\"hero__categories__all\">\r\n");
      out.write("                                <i class=\"fa fa-bars\"></i>\r\n");
      out.write("                                <span>All departments</span>\r\n");
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
      out.write("                                        All Categories\r\n");
      out.write("                                        <span class=\"arrow_carrot-down\"></span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <input type=\"text\" placeholder=\"What do yo u need?\">\r\n");
      out.write("                                    <button type=\"submit\" class=\"site-btn\">SEARCH</button>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"hero__search__phone\">\r\n");
      out.write("                                <div class=\"hero__search__phone__icon\">\r\n");
      out.write("                                    <i class=\"fa fa-phone\"></i>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"hero__search__phone__text\">\r\n");
      out.write("                                    <h5>+65 11.188.888</h5>\r\n");
      out.write("                                    <span>support 24/7 time</span>\r\n");
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
      out.write("                            <h2>Vegetable’s Package</h2>\r\n");
      out.write("                            <div class=\"breadcrumb__option\">\r\n");
      out.write("                                <a href=\"./index.html\">Home</a>\r\n");
      out.write("                                <a href=\"./index.html\">Vegetables</a>\r\n");
      out.write("                                <span>Vegetable’s Package</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        <!-- Breadcrumb Section End -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Product Details Section Begin -->\r\n");
      out.write("        <section class=\"product-details spad\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-6 col-md-6\">\r\n");
      out.write("                        <div class=\"product__details__pic\">\r\n");
      out.write("                            <div class=\"product__details__pic__item\">\r\n");
      out.write("                                <img class=\"product__details__pic__item--large\"\r\n");
      out.write("                                     src=\"img/product/details/product-details-1.jpg\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"product__details__pic__slider owl-carousel\">\r\n");
      out.write("                                <img data-imgbigurl=\"img/product/details/product-details-2.jpg\"\r\n");
      out.write("                                     src=\"img/product/details/thumb-1.jpg\" alt=\"\">\r\n");
      out.write("                                <img data-imgbigurl=\"img/product/details/product-details-3.jpg\"\r\n");
      out.write("                                     src=\"img/product/details/thumb-2.jpg\" alt=\"\">\r\n");
      out.write("                                <img data-imgbigurl=\"img/product/details/product-details-5.jpg\"\r\n");
      out.write("                                     src=\"img/product/details/thumb-3.jpg\" alt=\"\">\r\n");
      out.write("                                <img data-imgbigurl=\"img/product/details/product-details-4.jpg\"\r\n");
      out.write("                                     src=\"img/product/details/thumb-4.jpg\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-6 col-md-6\">\r\n");
      out.write("                        <div class=\"product__details__text\">\r\n");
      out.write("                            <h3>Vetgetable’s Package</h3>\r\n");
      out.write("                            <div class=\"product__details__rating\">\r\n");
      out.write("                                <i class=\"fa fa-star\"></i>\r\n");
      out.write("                                <i class=\"fa fa-star\"></i>\r\n");
      out.write("                                <i class=\"fa fa-star\"></i>\r\n");
      out.write("                                <i class=\"fa fa-star\"></i>\r\n");
      out.write("                                <i class=\"fa fa-star-half-o\"></i>\r\n");
      out.write("                                <span>(18 reviews)</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"product__details__price\">$50.00</div>\r\n");
      out.write("                            <p>Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a. Vestibulum ac diam sit amet quam\r\n");
      out.write("                                vehicula elementum sed sit amet dui. Sed porttitor lectus nibh. Vestibulum ac diam sit amet\r\n");
      out.write("                                quam vehicula elementum sed sit amet dui. Proin eget tortor risus.</p>\r\n");
      out.write("                            <div class=\"product__details__quantity\">\r\n");
      out.write("                                <div class=\"quantity\">\r\n");
      out.write("                                    <div class=\"pro-qty\">\r\n");
      out.write("                                        <input type=\"text\" value=\"1\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <a href=\"#\" class=\"primary-btn\">ADD TO CARD</a>\r\n");
      out.write("                            <a href=\"#\" class=\"heart-icon\"><span class=\"icon_heart_alt\"></span></a>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><b>Availability</b> <span>In Stock</span></li>\r\n");
      out.write("                                <li><b>Shipping</b> <span>01 day shipping. <samp>Free pickup today</samp></span></li>\r\n");
      out.write("                                <li><b>Weight</b> <span>0.5 kg</span></li>\r\n");
      out.write("                                <li><b>Share on</b>\r\n");
      out.write("                                    <div class=\"share\">\r\n");
      out.write("                                        <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\r\n");
      out.write("                                        <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\r\n");
      out.write("                                        <a href=\"#\"><i class=\"fa fa-instagram\"></i></a>\r\n");
      out.write("                                        <a href=\"#\"><i class=\"fa fa-pinterest\"></i></a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-12\">\r\n");
      out.write("                        <div class=\"product__details__tab\">\r\n");
      out.write("                            <ul class=\"nav nav-tabs\" role=\"tablist\">\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a class=\"nav-link active\" data-toggle=\"tab\" href=\"#tabs-1\" role=\"tab\"\r\n");
      out.write("                                       aria-selected=\"true\">Description</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a class=\"nav-link\" data-toggle=\"tab\" href=\"#tabs-2\" role=\"tab\"\r\n");
      out.write("                                       aria-selected=\"false\">Information</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a class=\"nav-link\" data-toggle=\"tab\" href=\"#tabs-3\" role=\"tab\"\r\n");
      out.write("                                       aria-selected=\"false\">Reviews <span>(1)</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                            <div class=\"tab-content\">\r\n");
      out.write("                                <div class=\"tab-pane active\" id=\"tabs-1\" role=\"tabpanel\">\r\n");
      out.write("                                    <div class=\"product__details__tab__desc\">\r\n");
      out.write("                                        <h6>Products Infomation</h6>\r\n");
      out.write("                                        <p>Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.\r\n");
      out.write("                                            Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus. Vivamus\r\n");
      out.write("                                            suscipit tortor eget felis porttitor volutpat. Vestibulum ac diam sit amet quam\r\n");
      out.write("                                            vehicula elementum sed sit amet dui. Donec rutrum congue leo eget malesuada.\r\n");
      out.write("                                            Vivamus suscipit tortor eget felis porttitor volutpat. Curabitur arcu erat,\r\n");
      out.write("                                            accumsan id imperdiet et, porttitor at sem. Praesent sapien massa, convallis a\r\n");
      out.write("                                            pellentesque nec, egestas non nisi. Vestibulum ac diam sit amet quam vehicula\r\n");
      out.write("                                            elementum sed sit amet dui. Vestibulum ante ipsum primis in faucibus orci luctus\r\n");
      out.write("                                            et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam\r\n");
      out.write("                                            vel, ullamcorper sit amet ligula. Proin eget tortor risus.</p>\r\n");
      out.write("                                        <p>Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Lorem\r\n");
      out.write("                                            ipsum dolor sit amet, consectetur adipiscing elit. Mauris blandit aliquet\r\n");
      out.write("                                            elit, eget tincidunt nibh pulvinar a. Cras ultricies ligula sed magna dictum\r\n");
      out.write("                                            porta. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus\r\n");
      out.write("                                            nibh. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a.\r\n");
      out.write("                                            Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui. Sed\r\n");
      out.write("                                            porttitor lectus nibh. Vestibulum ac diam sit amet quam vehicula elementum\r\n");
      out.write("                                            sed sit amet dui. Proin eget tortor risus.</p>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"tab-pane\" id=\"tabs-2\" role=\"tabpanel\">\r\n");
      out.write("                                    <div class=\"product__details__tab__desc\">\r\n");
      out.write("                                        <h6>Products Infomation</h6>\r\n");
      out.write("                                        <p>Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.\r\n");
      out.write("                                            Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus.\r\n");
      out.write("                                            Vivamus suscipit tortor eget felis porttitor volutpat. Vestibulum ac diam\r\n");
      out.write("                                            sit amet quam vehicula elementum sed sit amet dui. Donec rutrum congue leo\r\n");
      out.write("                                            eget malesuada. Vivamus suscipit tortor eget felis porttitor volutpat.\r\n");
      out.write("                                            Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Praesent\r\n");
      out.write("                                            sapien massa, convallis a pellentesque nec, egestas non nisi. Vestibulum ac\r\n");
      out.write("                                            diam sit amet quam vehicula elementum sed sit amet dui. Vestibulum ante\r\n");
      out.write("                                            ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;\r\n");
      out.write("                                            Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula.\r\n");
      out.write("                                            Proin eget tortor risus.</p>\r\n");
      out.write("                                        <p>Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Lorem\r\n");
      out.write("                                            ipsum dolor sit amet, consectetur adipiscing elit. Mauris blandit aliquet\r\n");
      out.write("                                            elit, eget tincidunt nibh pulvinar a. Cras ultricies ligula sed magna dictum\r\n");
      out.write("                                            porta. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus\r\n");
      out.write("                                            nibh. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a.</p>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"tab-pane\" id=\"tabs-3\" role=\"tabpanel\">\r\n");
      out.write("                                    <div class=\"product__details__tab__desc\">\r\n");
      out.write("                                        <h6>Products Infomation</h6>\r\n");
      out.write("                                        <p>Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.\r\n");
      out.write("                                            Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus.\r\n");
      out.write("                                            Vivamus suscipit tortor eget felis porttitor volutpat. Vestibulum ac diam\r\n");
      out.write("                                            sit amet quam vehicula elementum sed sit amet dui. Donec rutrum congue leo\r\n");
      out.write("                                            eget malesuada. Vivamus suscipit tortor eget felis porttitor volutpat.\r\n");
      out.write("                                            Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Praesent\r\n");
      out.write("                                            sapien massa, convallis a pellentesque nec, egestas non nisi. Vestibulum ac\r\n");
      out.write("                                            diam sit amet quam vehicula elementum sed sit amet dui. Vestibulum ante\r\n");
      out.write("                                            ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;\r\n");
      out.write("                                            Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula.\r\n");
      out.write("                                            Proin eget tortor risus.</p>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        <!-- Product Details Section End -->\r\n");
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