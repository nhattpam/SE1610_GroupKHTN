/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.OrderDAOImpl;
import dtos.OrderDTO;
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
@WebServlet("/my-order")
public class ViewHistoryOrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OrderDAOImpl dao = new OrderDAOImpl(DBUtils.getConnection());

        int user_id = (req.getParameter("uid") != null ? Integer.parseInt(req.getParameter("uid")) : 0);
        
//        System.out.println(user_id);

        List<OrderDTO> list = dao.getAllListOrder(user_id);
        req.setAttribute("listOrder", list);

        
        //get user and gg
        HttpSession session = req.getSession();
        UsersDTO u = (UsersDTO) session.getAttribute("USER");
        req.setAttribute("user", u);
        
        req.getRequestDispatcher("view/customer/my_order.jsp").forward(req, resp);
    }

}
