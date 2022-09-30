package controllers;

import daos.UserDAO;
import daos.UserDAOImpl;
import dtos.UsersDTO;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DBUtils;

/**
 * Servlet implementation class ResetPasswordController
 */
@WebServlet("/resetPassword")
public class ResetPasswordController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String newPassword = request.getParameter("password");
        String confPassword = request.getParameter("confPassword");
        RequestDispatcher dispatcher = null;
        String email = (String) session.getAttribute("email");
        if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
            try {

                UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());
                boolean reset = dao.resetPassword(newPassword, email);
                if (reset) {
                    request.setAttribute("status", "resetSuccess");
                    dispatcher = request.getRequestDispatcher("login.jsp");
                } else {
                    request.setAttribute("status", "resetFailed");
                    dispatcher = request.getRequestDispatcher("error.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                dispatcher.forward(request, response);
            }
        }
    }

}
