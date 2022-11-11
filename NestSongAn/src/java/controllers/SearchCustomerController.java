/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAOImpl;
import dtos.UsersDTO;
import java.io.IOException;
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
@WebServlet("/search-customer")
public class SearchCustomerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneSearch = req.getParameter("phoneSearch");

        System.out.println("sdt: " + phoneSearch);
        UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());
        UsersDTO u = dao.getUserNameByPhone(phoneSearch);
        HttpSession session = req.getSession();
        if (u != null) {
            session.setAttribute("customer_search", u.getFull_name());
            resp.sendRedirect("checkout-offline?bid=" + session.getAttribute("branch_id"));
            session.setAttribute("keepPhoneSearch", phoneSearch);
        }else{
            session.setAttribute("customer_search_empty", "Không tìm thấy khách hàng");
            resp.sendRedirect("checkout-offline?bid=" + session.getAttribute("branch_id"));
            session.setAttribute("keepPhoneSearch", phoneSearch);
        }

    }

}
