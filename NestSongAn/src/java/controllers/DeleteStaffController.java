/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAOImpl;
import java.io.IOException;
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
@WebServlet("/delete-staff")
public class DeleteStaffController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //check id != null
        int id = (req.getParameter("uid") != null ? Integer.parseInt(req.getParameter("uid")) : 0);
        
        UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());
        dao.deteleStaffAccount(id);
        resp.sendRedirect("manage-user");
    }
    
}
