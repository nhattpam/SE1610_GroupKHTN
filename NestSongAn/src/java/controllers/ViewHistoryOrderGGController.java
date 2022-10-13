/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.OrderDAOImpl;
import daos.UserDAOImpl;
import dtos.GoogleDTO;
import dtos.OrderDTO;
import dtos.UsersDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet("/my-order-gg")
public class ViewHistoryOrderGGController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        GoogleDTO us = (GoogleDTO) session.getAttribute("USERG");

//        System.out.println(us.getEmail());

        UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());

        UsersDTO u;
        try {
            u = dao.viewAccountByEmail(us.getEmail());
//            System.out.println(u.getUser_id());

            HttpSession s1 = req.getSession();

            s1.setAttribute("usergg", u);

            //get order list
            int user_id = u.getUser_id();
//            System.out.println(user_id);
            
             OrderDAOImpl dao2 = new OrderDAOImpl(DBUtils.getConnection());

            List<OrderDTO> list = dao2.getAllListOrder(user_id);
            req.setAttribute("listOrder", list);

            req.getRequestDispatcher("view/customer/my_order.jsp").forward(req, resp);

        } catch (SQLException ex) {
            Logger.getLogger(ViewHistoryOrderGGController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
