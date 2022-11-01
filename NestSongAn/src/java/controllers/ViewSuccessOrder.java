/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.OrderDAOImpl;
import daos.OrderDetailsDAOImpl;
import dtos.OrderDTO;
import dtos.OrderDetailsDTO;
import dtos.UsersDTO;
import java.io.IOException;
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
 * @author Admin
 */
@WebServlet("/success-order")
public class ViewSuccessOrder extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           HttpSession session = req.getSession();
           String order_id = (String)session.getAttribute("order_id");
           req.setAttribute("order_id", order_id);
//          System.out.println("order_id: " + order_id);
          OrderDetailsDAOImpl dao = new OrderDetailsDAOImpl(DBUtils.getConnection());
          List<OrderDetailsDTO> od = dao.getOrderDetails(order_id);
          req.setAttribute("od", od);
          
           OrderDAOImpl dao2 = new OrderDAOImpl(DBUtils.getConnection());
           float total_price = dao2.GetOrderTotalPrice(order_id);
           req.setAttribute("total_price", total_price);
           HttpSession sCheckk = req.getSession();
        if (sCheckk.getAttribute("USER") == null) {
            req.getRequestDispatcher("view/customer/success_order.jsp").forward(req, resp);
        } else {
            //redirect if not customer
            HttpSession sessionn = req.getSession();
            UsersDTO uu = (UsersDTO) sessionn.getAttribute("USER");
//            System.out.println("DDya la: " + uu.getRole_id().getRole());
            if (uu.getRole_id().getRole().equals("staff")) {
                resp.sendRedirect("staff-dashboard");
            }
            if (uu.getRole_id().getRole().equals("admin")) {
                resp.sendRedirect("admin-dashboard");
            }
            if (uu.getRole_id().getRole().equals("supplier")) {
                resp.sendRedirect("ViewProductSupplierController");
            }
            if (uu.getRole_id().getRole().equals("shipper")) {
                resp.sendRedirect("shipper-dashboard");
            }if (uu.getRole_id().getRole().equals("customer")) {
                req.getRequestDispatcher("view/customer/success_order.jsp").forward(req, resp);
            }
        }
        
        
    }
    
}
