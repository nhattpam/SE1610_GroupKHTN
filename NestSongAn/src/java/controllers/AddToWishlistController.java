/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAO;
import daos.UserDAOImpl;
import daos.WishListDAOImpl;
import dtos.GoogleDTO;
import dtos.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddToWishlistController", urlPatterns = {"/AddToWishlistController"})
public class AddToWishlistController extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        UsersDTO user = (UsersDTO) session.getAttribute("USER");
        GoogleDTO userg = (GoogleDTO) session.getAttribute("USERG");
        String url = "shop-products";
        try {
            WishListDAOImpl dao = new WishListDAOImpl();
            int productID = Integer.parseInt(request.getParameter("product_id"));
            if (user != null) {
                int user_id = Integer.parseInt(request.getParameter("user_id"));                
                dao.addToWishList(user_id, productID);
            }
            if (userg!=null) {
                UserDAO userDAO=new UserDAOImpl();
                UsersDTO load =userDAO.viewAccountByEmail(userg.getEmail());
                dao.addToWishList(load.getUser_id(), productID);                        
            }

        } catch (Exception e) {

        } finally {
            response.sendRedirect(url);
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
