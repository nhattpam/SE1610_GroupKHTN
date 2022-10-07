/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAOImpl;
import dtos.ProductDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
@WebServlet("/edit-page")
public class ViewEditProductPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("product_id") != null) {
            int id = (request.getParameter("product_id") != null ? Integer.parseInt(request.getParameter("product_id")) : 0);

            ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());
            ProductDTO product = new ProductDTO();
            product = dao.getProductId(id);

            request.setAttribute("p", product);

        }
        RequestDispatcher rd = request.getRequestDispatcher("view/staff/edit_product.jsp");
        rd.forward(request, response);
    }

}
