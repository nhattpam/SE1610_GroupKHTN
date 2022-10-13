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
@WebServlet("/order-details")
public class ViewHistoryOrderDetailController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
         String order_id = req.getParameter("order_id");
         
//         System.out.println(order_id);
         
         OrderDetailsDAOImpl dao = new OrderDetailsDAOImpl(DBUtils.getConnection());
           
        
        List<OrderDetailsDTO> list = dao.getOrderDetails(order_id);
        
        req.setAttribute("listOrderDetail", list);
        
        HttpSession session = req.getSession();
        UsersDTO u = (UsersDTO) session.getAttribute("USER");
        
        
//        System.out.println(u);
        
        
        //get order_id
        req.setAttribute("order_id", order_id);
        
        
        //get address
        OrderDAOImpl dao3 = new OrderDAOImpl(DBUtils.getConnection());
        
        OrderDTO o = dao3.getOrderAddress(order_id);
        
        String address = o.getDelivery_address();
        
//        System.out.println(address);
        
        req.setAttribute("address", address);
        
        
        
        
        req.getRequestDispatcher("view/customer/order_details.jsp").forward(req, resp);
    }
    
}
