/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.FeedbackDAOImpl;
import dtos.FeedbackDTO;
import dtos.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DBUtils;

/**
 *
 * @author haph1
 */
@WebServlet(name = "ViewListOfFeedbackController", urlPatterns = {"/list-feedback"})
public class ViewListOfFeedbackController extends HttpServlet {

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
        FeedbackDAOImpl dao = new FeedbackDAOImpl(DBUtils.getConnection());
        List<FeedbackDTO> flist = dao.viewAllfeedback();
        request.setAttribute("listFeedback", flist);
        
        
        HttpSession sCheckk = request.getSession();
        
        if (sCheckk.getAttribute("USER") == null){
            response.sendRedirect("loginController");
        }else{
            UsersDTO uu = (UsersDTO) sCheckk.getAttribute("USER");
            if (uu.getRole_id().getRole().equals("staff")) {
                request.getRequestDispatcher("view/staff/list_feedback.jsp").forward(request, response);
            }
            if (uu.getRole_id().getRole().equals("shipper")) {
                response.sendRedirect("shipper-dashboard");
            }
            if (uu.getRole_id().getRole().equals("admin")) {
                response.sendRedirect("admin-dashboard");
            }
            if (uu.getRole_id().getRole().equals("customer")) {
                response.sendRedirect("home");
            }
            if (uu.getRole_id().getRole().equals("supplier")) {
                response.sendRedirect("ViewProductSupplierController");
            }
            
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
