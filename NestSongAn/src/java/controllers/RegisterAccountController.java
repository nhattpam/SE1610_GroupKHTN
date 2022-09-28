/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAOImpl;
import dtos.UserRoleDTO;
import dtos.UsersDTO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.servlet.ServletContext;
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
//khangtran: function register account
@WebServlet("/RegisterAccountController")
public class RegisterAccountController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        //
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        try {
            String full_name = req.getParameter("full_name");
            String user_name = req.getParameter("user_name");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            int status = 1; //1: tai khoan active: dang hoat dong

            Date now = new Date();
            SimpleDateFormat x = new SimpleDateFormat();
            String create_date = x.format(now);

            String edited_date = null;

            UserRoleDTO role_id = new UserRoleDTO(1);
            UsersDTO us = new UsersDTO(full_name, user_name, password, email, phone, status, create_date, edited_date, role_id);

            UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());

            boolean f = dao.userRegister(us);

            HttpSession session = req.getSession();

            if (f) {
                session.setAttribute("succMsg", "Đăng ký tài khoản thành công...");
                resp.sendRedirect(siteMaps.getProperty("registerPage"));
            } else {
                session.setAttribute("failedMsg", "Đăng ký tài khoản không thành công...");
                resp.sendRedirect(siteMaps.getProperty("registerPage"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
