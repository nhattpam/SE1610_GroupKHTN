/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.OrderDAOImpl;
import dtos.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DBUtils;

/**
 *
 * @author Administrator
 */
@WebServlet("/shipper-dashboard")
public class ViewShipperDashboardPageController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //sort status
        OrderDAOImpl dao = new OrderDAOImpl(DBUtils.getConnection());
        
        //statu = 2
        int pedingOrder = dao.getPendingOrder();
        request.setAttribute("pending", pedingOrder);
        //sttus = 3
        int succOrder = dao.getCountSuccOrder();
        request.setAttribute("succ", succOrder);
        //sttu = 5
        int failOrder = dao.getCountFailOrder();
        request.setAttribute("fail", failOrder); //set atribute xong bắn qua trang dashoabrd
        
        request.getRequestDispatcher("view/shipping/dashboard.jsp").forward(request, response);

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
        
        HttpSession sCheckk = request.getSession();
        if(sCheckk.getAttribute("USERG") != null){
            response.sendRedirect("home");
        }
        if (sCheckk.getAttribute("USER") == null){
            response.sendRedirect("loginController");
        }else{
            UsersDTO uu = (UsersDTO) sCheckk.getAttribute("USER");
            if (uu.getRole_id().getRole().equals("staff")) {
                response.sendRedirect("list-products");
            }
            if (uu.getRole_id().getRole().equals("shipper")) {
                processRequest(request, response);
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
