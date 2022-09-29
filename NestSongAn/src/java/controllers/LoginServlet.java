/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAO;
import daos.UserDAOImpl;
import dtos.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DBUtils;

/**
 *
 * @author HUNG
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final String LOGIN_PAGE = "loginPage";
    private static final String HOME_PAGE ="";
    private static final String STAFF_PAGE ="staffPage";
    private static final String ADMIN_PAGE ="adminPage";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        String url=siteMaps.getProperty(LOGIN_PAGE);                                          // default to login page if error
        String errorMessage="Wrong username or password";
        try {

            //1:call DAO
            //new obj DAO && call method from DAO
            UserDAO dao = new UserDAOImpl();
            UsersDTO result = dao.checkLogin(username, password);                
            //2.process 
            if(result==null){
                request.setAttribute("LoginError", errorMessage);
            }
            if (result != null && result.getRole_id().getRole().equals("customer")) {          // Role name = customer 
                url = siteMaps.getProperty(HOME_PAGE);                                                   // to home page
            }
            if (result != null && result.getRole_id().getRole().equals("staff")) {          // Role name = staff 
                url = siteMaps.getProperty(STAFF_PAGE);                                                       // to staff page
            }
            if (result != null && result.getRole_id().getRole().equals("admin")) {             // Role id = admin 
                url = siteMaps.getProperty(ADMIN_PAGE);                                                      // to admin page
            }
            if (result != null && result.getRole_id().getRole().equals("supplier")) {          // Role id = supplier 
                url = "supplier.jsp";                                                    // to supplier page
            }if (result != null && result.getRole_id().getRole().equals("shipper")) {          // Role id = shipper 
                url = "shipper.jsp";                                                    // to shipper page
            }
            HttpSession session = request.getSession();//true
            session.setAttribute("USER", result);
        } catch (NamingException ex) {            
            log("LoginServlet_Naming" + ex.getMessage());
        } catch (SQLException ex) {
            log("LoginServlet_SQL" + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
