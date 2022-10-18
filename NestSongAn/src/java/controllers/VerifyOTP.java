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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "VerifyOTP", urlPatterns = {"/VerifyOTP"})
public class VerifyOTP extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int value = Integer.parseInt(request.getParameter("otp"));
        HttpSession session = request.getSession();
        int otp = (int) session.getAttribute("otp");
        RequestDispatcher dispatcher = null;
        UsersDTO us = (UsersDTO) session.getAttribute("fulltopping");
        try {
            if (value == otp) {
                UserDAOImpl dao = new UserDAOImpl();
                System.out.println(us);
                boolean result = dao.userRegister(us);
                if (result) {
                    session.setAttribute("success", "Dang ki thanh cong!!!");
                    response.sendRedirect("LoginServlet");
                } else {
                    response.sendRedirect("RegisterAccountController");
                }
            } else {
                request.setAttribute("status", "resetFailed");
                dispatcher = request.getRequestDispatcher("error.jsp");
            }
        } catch (Exception e) {

        }
    }
}
