/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAOImpl;
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
//        int value = Integer.parseInt(request.getParameter("otp"));
        HttpSession session = request.getSession();
//        int otp = (int) session.getAttribute("otp");
        String email = (String) session.getAttribute("email");
        RequestDispatcher dispatcher = null;
        int status = 1;
        try {
////            if (value == otp) {
                UserDAOImpl dao = new UserDAOImpl();
                dao.updateStatus(status, email);
                request.setAttribute("status", "success");
                response.sendRedirect("LoginServlet");
                dispatcher.forward(request, response);

////            } else {
//                request.setAttribute("message", "wrong otp");
//
//                dispatcher = request.getRequestDispatcher("RegisterOTP.jsp");
//                dispatcher.forward(request, response);

//            }
        } catch (Exception e) {

        }
    }
}
