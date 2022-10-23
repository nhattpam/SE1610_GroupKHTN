/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.OrderDAOImpl;
import dtos.OrderDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
@WebServlet("/deliveried-order")
public class DeliveriedOrderController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        OrderDAOImpl daoDeliveryOrder = new OrderDAOImpl(DBUtils.getConnection());
        
        List<OrderDTO> list = daoDeliveryOrder.vỉewDeliveriedOrders();
        
        req.setAttribute("listDeliveryOrrder", list);
        
        req.getRequestDispatcher("view/shipping/deliveried_order.jsp").forward(req, resp);
    }
    
}
