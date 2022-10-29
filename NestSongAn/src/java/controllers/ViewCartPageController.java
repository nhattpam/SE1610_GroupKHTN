/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.QuantityProductDAOImpl;
import dtos.CartDTO;
import dtos.ProductDTO;
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
        session.setAttribute("list", list);
//            System.out.println(req.getAttribute("list"));
 
        float totalSum = 0;
        req.setAttribute("totalSum", totalSum);
        
        QuantityProductDAOImpl daoQ = new QuantityProductDAOImpl(DBUtils.getConnection());
//        int branch_id =Integer.parseInt(req.getParameter("bid"));
        int branch_id1 = (int) session.getAttribute("branch_id");
//        System.out.println("request: " + branch_id);
//        System.out.println("session: " + branch_id1);
        
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }

}
