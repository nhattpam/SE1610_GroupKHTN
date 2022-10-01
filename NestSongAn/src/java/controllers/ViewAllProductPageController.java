/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAOImpl;
import dtos.ProductDTO;
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
@WebServlet("/shop-products")
public class ViewAllProductPageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());
        List<ProductDTO> listAllProduct = dao.getAllProduct();

        req.setAttribute("listAllProduct", listAllProduct);

        ProductDAOImpl productDAO = new ProductDAOImpl(DBUtils.getConnection());
        ProductDTO p = productDAO.getProductId(req.getParameter("product_id"));

        req.getRequestDispatcher("shop_all_product.jsp").forward(req, resp);
    }

}
