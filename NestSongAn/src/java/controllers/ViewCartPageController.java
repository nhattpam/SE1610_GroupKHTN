/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.QuantityProductDAOImpl;
import dtos.CartDTO;
import dtos.ProductDTO;
import dtos.UsersDTO;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
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
@WebServlet("/my-cart")
public class ViewCartPageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        CartDTO cart = (CartDTO) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartDTO();
            session.setAttribute("cart", cart);
        }
        TreeMap<ProductDTO, Integer> list = cart.getList();
        req.setAttribute("list", list);
        session.setAttribute("numlist", list);
//            System.out.println(req.getAttribute("list"));
 
        float totalSum = 0;
        req.setAttribute("totalSum", totalSum);
        
        QuantityProductDAOImpl daoQ = new QuantityProductDAOImpl(DBUtils.getConnection());
//        int branch_id =Integer.parseInt(req.getParameter("bid"));
        int branch_id1 = (int) session.getAttribute("branch_id");
//        System.out.println("request: " + branch_id);
//        System.out.println("session: " + branch_id1);

HttpSession sCheckk = req.getSession();
        if (sCheckk.getAttribute("USER") == null) {
             req.getRequestDispatcher("cart.jsp").forward(req, resp);
        } else {
            //redirect if not customer
            HttpSession sessionn = req.getSession();
            UsersDTO uu = (UsersDTO) sessionn.getAttribute("USER");
            System.out.println("DDya la: " + uu.getRole_id().getRole());
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
                 req.getRequestDispatcher("cart.jsp").forward(req, resp);
            }
        }
        
       
    }

}
