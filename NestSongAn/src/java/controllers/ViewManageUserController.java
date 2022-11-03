/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAOImpl;
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
@WebServlet("/manage-user")
public class ViewManageUserController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        UserDAOImpl daoFullUser = new UserDAOImpl(DBUtils.getConnection());
        
        List<UsersDTO> listFullUser = daoFullUser.getAllListUser();
        
        req.setAttribute("listFullUser", listFullUser);
        
        
        
        HttpSession sCheckk = req.getSession();
        
        if (sCheckk.getAttribute("USER") == null){
            resp.sendRedirect("loginController");
        }else{
            UsersDTO uu = (UsersDTO) sCheckk.getAttribute("USER");
            if (uu.getRole_id().getRole().equals("staff")) {
                resp.sendRedirect("list-products");
            }
            if (uu.getRole_id().getRole().equals("shipper")) {
                resp.sendRedirect("shipper-dashboard");
            }
            if (uu.getRole_id().getRole().equals("admin")) {
                req.getRequestDispatcher("view/admin/manage_user.jsp").forward(req, resp);
            }
            if (uu.getRole_id().getRole().equals("customer")) {
                resp.sendRedirect("home");
            }
            if (uu.getRole_id().getRole().equals("supplier")) {
                resp.sendRedirect("ViewProductSupplierController");
            }
            
        }
    }
    
}
