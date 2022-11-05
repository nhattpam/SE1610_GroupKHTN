/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAOImpl;
import daos.QuantityProductDAOImpl;
import dtos.CartDTO;
import dtos.ProductDTO;
import dtos.QuantityProductDTO;
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
 * @author duong
 */
@WebServlet("/offline-order")
public class OfflineOrderController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession sBranch = req.getSession();
//        ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());
        QuantityProductDAOImpl dao = new QuantityProductDAOImpl(DBUtils.getConnection());
        
//        List<ProductDTO> listProduct = dao.getAllListProduct();
        List<QuantityProductDTO> listProduct = dao.listProductWithQuantity((int) sBranch.getAttribute("branch_id"));
        
        req.setAttribute("listProduct", listProduct);
        
        //check empty cart
        HttpSession sCart = req.getSession();
        CartDTO cart = (CartDTO) sCart.getAttribute("cart");
        if (cart == null) {
            cart = new CartDTO();
            sCart.setAttribute("cart", cart);
        }
        
        req.getRequestDispatcher("view/staff/offline_order.jsp").forward(req, resp);
    }
    
}
