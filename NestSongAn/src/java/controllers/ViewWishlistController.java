/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAO;
import daos.UserDAOImpl;
import daos.WishListDAO;
import daos.WishListDAOImpl;
import dtos.GoogleDTO;
import dtos.UsersDTO;
import dtos.WishListDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "ViewWishlist", urlPatterns = {"/ViewWishlist"})
public class ViewWishlistController extends HttpServlet {

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
        String url = "wishlist.jsp";
        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        try {
            //get user
            UsersDTO user = (UsersDTO) session.getAttribute("USER");
            GoogleDTO userg = (GoogleDTO) session.getAttribute("USERG");
            //call dao
            WishListDAO wishListDAO = new WishListDAOImpl();
            //for normal user
            if (user != null) {
                //count item in wishlist
                int count = wishListDAO.getNumsOfItem(user.getUser_id());
                // set number of page
                int endPage = count / 5;
                if (endPage % 5 != 0) {
                    endPage++;
                }
                //load list
                List<WishListDTO> list = wishListDAO.getWishlist(user.getUser_id(), index);  
                for (WishListDTO wishListDTO : list) {
                    System.out.println(wishListDTO.getProduct_id().toString()); 
                }
                request.setAttribute("list", list);
                request.setAttribute("endPage", endPage);
            }
            // for google user
            if (userg != null) {
                //call dao
                UserDAO userDAO = new UserDAOImpl();
                //load user id from DB
                UsersDTO processDTO = userDAO.viewAccountByEmail(userg.getEmail());
                //count item in wishlist
                int count = wishListDAO.getNumsOfItem(processDTO.getUser_id());
                // set number of page
                int endPage = count / 5;
                if (endPage % 5 != 0 ) {
                    endPage++;
                }
                //load list
                List<WishListDTO> list = wishListDAO.getWishlist(processDTO.getUser_id(), index);

                request.setAttribute("list", list);
                request.setAttribute("endPage", endPage);
            }
        } catch (Exception e) {

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
