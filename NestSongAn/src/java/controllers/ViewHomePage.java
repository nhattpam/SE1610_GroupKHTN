/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAOImpl;
import dtos.ProductDTO;
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
import utils.DBUtils;

/**
 *
 * @author Admin
 */
@WebServlet("/home")
public class ViewHomePage extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());
            List<ProductDTO> list = dao.getNewProduct();
            req.setAttribute("listFeature", list);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(ViewHomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
