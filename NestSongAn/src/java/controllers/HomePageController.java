/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAOImpl;
import dtos.ProductDTO;
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
@WebServlet("/trang-chu")
public class HomePageController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int branch_id = (req.getParameter("bid") != null ? Integer.parseInt(req.getParameter("bid")) : 0);
        
//        System.out.println(branch_id);
        
        HttpSession sBrand = req.getSession();
        sBrand.setAttribute("branch_id", branch_id); //session branch
        
//        System.out.println(sBrand.getAttribute("branch_id"));

        try {
            ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());
            List<ProductDTO> list = dao.getNewProduct();
            req.setAttribute("listFeature", list);
            HttpSession sCheckk = req.getSession();
        if (sCheckk.getAttribute("USER") == null) {
            req.getRequestDispatcher("trang_chu.jsp").forward(req, resp);
        } else {
            //redirect if not customer
            HttpSession sessionn = req.getSession();
            UsersDTO uu = (UsersDTO) sessionn.getAttribute("USER");
//            System.out.println("DDya la: " + uu.getRole_id().getRole());
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
                req.getRequestDispatcher("trang_chu.jsp").forward(req, resp);
            }
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        req.getRequestDispatcher("trang_chu.jsp").forward(req, resp);
    }
    
}
