package controllers;

import daos.UserDAOImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dtos.GoogleDTO;
import dtos.UserRoleDTO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import utils.DBUtils;
import utils.GoogleUtils;

@WebServlet("/login-google")
public class Tester extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Tester() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
        if (code == null || code.isEmpty()) {
            dis.forward(request, response);
        } else {
            String accessToken = GoogleUtils.getToken(code);
            GoogleDTO googlePojo = GoogleUtils.getUserInfo(accessToken);
            request.setAttribute("id", googlePojo.getId());
            request.setAttribute("USER", googlePojo.getName());
            request.setAttribute("email", googlePojo.getEmail());
            request.setAttribute("verified", googlePojo.isVerified_email());
            request.setAttribute("givenname", googlePojo.getGiven_name());
            request.setAttribute("familyname", googlePojo.getFamily_name());
            int status = 1; //1: tai khoan active: dang hoat dong

            Date now = new Date();
            SimpleDateFormat x = new SimpleDateFormat();
            String create_date = x.format(now);

            String edited_date = null;

//            int role = 1;
            GoogleDTO us = new GoogleDTO((String) request.getAttribute("email"), (String) request.getAttribute("USER"),status, create_date, edited_date);

            UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());

            boolean f = dao.userRegister(us);

            HttpSession session = request.getSession();

            if (f) {
                session.setAttribute("succMsg", "Đăng ký tài khoản thành công...");
                response.sendRedirect("register.jsp");
            } else {
                session.setAttribute("failedMsg", "Đăng ký tài khoản không thành công...");
                response.sendRedirect("register.jsp");
            }
            dis.forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
