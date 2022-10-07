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
@WebServlet("/list-products")
public class ViewListProductStaffController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());
        
        List<ProductDTO> listProduct = dao.getAllListProduct();
        
        req.setAttribute("listProduct", listProduct);
        
        req.getRequestDispatcher("view/staff/list_products.jsp").forward(req, resp);
    }
    
}
