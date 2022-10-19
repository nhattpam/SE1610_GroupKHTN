/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAOImpl;
import dtos.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DBUtils;

/**
 *
 * @author duong
 */
@WebServlet("/manage-staff")
public class ViewManageStaffController extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());
        
        List<UsersDTO> listFullStaff = dao.getStaffList();
        
        req.setAttribute("listFullStaff", listFullStaff);
        
        
        req.getRequestDispatcher("view/admin/manage_user.jsp").forward(req, resp);
    }
    
}
