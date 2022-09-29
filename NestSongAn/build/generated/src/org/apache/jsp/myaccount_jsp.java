package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myaccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style1.css\">\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700\" rel=\"stylesheet\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"main-content\">\r\n");
      out.write("            <div class=\"container mt-7\">\r\n");
      out.write("                <!-- Table -->\r\n");
      out.write("                <a href=\"#\" class=\"mb-5\">My Account Card</a>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-xl-8 m-auto order-xl-1\">\r\n");
      out.write("                        <div class=\"card bg-secondary shadow\">\r\n");
      out.write("                            <div class=\"card-header bg-white border-0\">\r\n");
      out.write("                                <div class=\"row align-items-center\">\r\n");
      out.write("                                    <div class=\"col-8\">\r\n");
      out.write("                                        <h3 class=\"mb-0\">My account</h3>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-4 text-right\">\r\n");
      out.write("                                        <button class=\"btn btn-sm btn-primary\">Settings</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("                                <form>\r\n");
      out.write("                                    <h6 class=\"heading-small text-muted mb-4\">User information</h6>\r\n");
      out.write("                                    <div class=\"pl-lg-4\">\r\n");
      out.write("                                        <div class=\"row\">\r\n");
      out.write("                                            <div class=\"col-lg-6\">\r\n");
      out.write("                                                <div class=\"form-group focused\">\r\n");
      out.write("                                                    <label class=\"form-control-label\" for=\"input-username\">Full Name</label>\r\n");
      out.write("                                                    <input type=\"text\" id=\"input-username\" class=\"form-control form-control-alternative\" placeholder=\"Username\" value=\"lucky.jesse\">\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-lg-6\">\r\n");
      out.write("                                                <div class=\"form-group\">\r\n");
      out.write("                                                    <label class=\"form-control-label\" for=\"input-email\">Username</label>\r\n");
      out.write("                                                    <input type=\"email\" id=\"input-email\" class=\"form-control form-control-alternative\" placeholder=\"jesse@example.com\">\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"row\">\r\n");
      out.write("                                            <div class=\"col-lg-6\">\r\n");
      out.write("                                                <div class=\"form-group focused\">\r\n");
      out.write("                                                    <label class=\"form-control-label\" for=\"input-first-name\">Phone Number</label>\r\n");
      out.write("                                                    <input type=\"text\" id=\"input-first-name\" class=\"form-control form-control-alternative\" placeholder=\"Phone Number\" value=\"Lucky\">\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-lg-6\">\r\n");
      out.write("                                                <div class=\"form-group focused\">\r\n");
      out.write("                                                    <label class=\"form-control-label\" for=\"input-last-name\">Password</label>\r\n");
      out.write("                                                    <input type=\"password\" id=\"input-last-name\" class=\"form-control form-control-alternative\" placeholder=\"Password\" value=\"Jesse\">\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <hr class=\"my-4\">\r\n");
      out.write("                                    <!-- Address -->\r\n");
      out.write("                                    <h6 class=\"heading-small text-muted mb-4\">Contact information</h6>\r\n");
      out.write("                                    <div class=\"pl-lg-4\">\r\n");
      out.write("                                        <div class=\"row\">\r\n");
      out.write("                                            <div class=\"col-md-12\">\r\n");
      out.write("                                                <div class=\"form-group focused\">\r\n");
      out.write("                                                    <label class=\"form-control-label\" for=\"input-address\">Email Address</label>\r\n");
      out.write("                                                    <input id=\"input-address\" class=\"form-control form-control-alternative\" placeholder=\"Email Address\" value=\"Bld Mihail Kogalniceanu, nr. 8 Bl 1, Sc 1, Ap 09\" type=\"text\">\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <hr class=\"my-4\">\r\n");
      out.write("                                    \r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <footer class=\"footer\">\r\n");
      out.write("            <div class=\"row align-items-center justify-content-xl-between\">\r\n");
      out.write("                <div class=\"col-xl-6 m-auto text-center\">\r\n");
      out.write("                    <div class=\"copyright\">\r\n");
      out.write("                        <p>Made with <a href=\"https://www.creative-tim.com/product/argon-dashboard\" target=\"_blank\">Argon Dashboard</a> by Creative Tim</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </footer>\r\n");
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
