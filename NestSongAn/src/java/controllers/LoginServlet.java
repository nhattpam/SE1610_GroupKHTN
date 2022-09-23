/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAO;
import dtos.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HUNG
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        
        String url="login.jsp";                                          // default to login page if error
        try {

            //1:call DAO
            //new obj DAO && call method from DAO
            UserDAO dao = new UserDAO();
            UserDTO result = dao.checkLogin(username, password);                
            //2.process 
            if (result != null && result.getRole().getRoleName().equals("customer")) {          // Role name = customer 
                url = "homepage.jsp";                                                   // to home page

                HttpSession session = request.getSession();//true
                session.setAttribute("ACCOUNT", result);

            }
            if (result != null && result.getRole().getRoleName().equals("staff")) {          // Role name = staff 
                url = "staff.jsp";                                                       // to staff page

                HttpSession session = request.getSession();//true
                session.setAttribute("ACCOUNT", result);

            }
            if (result != null && result.getRole().getRoleName().equals("admin")) {             // Role id = admin 
                url = "admin.jsp";                                                      // to admin page

                HttpSession session = request.getSession();//true
                session.setAttribute("ACCOUNT", result);

            }
            if (result != null && result.getRole().getRoleName().equals("supplier")) {          // Role id = supplier 
                url = "supplier.jsp";                                                    // to supplier page

                HttpSession session = request.getSession();//true
                session.setAttribute("ACCOUNT", result);

            }if (result != null && result.getRole().getRoleName().equals("shipper")) {          // Role id = shipper 
                url = "shipper.jsp";                                                    // to shipper page

                HttpSession session = request.getSession();//true
                session.setAttribute("ACCOUNT", result);

            }
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
