/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.OrderDAOImpl;
import daos.OrderDetailsDAOImpl;
import daos.UserDAOImpl;
import dtos.CartDTO;
import dtos.GoogleDTO;
import dtos.OrderDTO;
import dtos.OrderDetailsDTO;
import dtos.ProductDTO;
import dtos.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
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
@WebServlet(name = "CheckoutGoogleController", urlPatterns = {"/checkoutgg"})
public class CheckoutGoogleController extends HttpServlet {

    private OrderDAOImpl orderDAO = new OrderDAOImpl(DBUtils.getConnection());
    private OrderDetailsDAOImpl orderDetailsDAO = new OrderDetailsDAOImpl(DBUtils.getConnection());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        GoogleDTO us = (GoogleDTO) session.getAttribute("USERG");

//        request.setAttribute("usergg", us);
        System.out.println(us.getEmail());

        UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());

        try {
            UsersDTO u = dao.viewAccountByEmail(us.getEmail());
            System.out.println(u.getUser_id());

            HttpSession s1 = request.getSession();

            s1.setAttribute("usergg", u);
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        } catch (Exception e) {
        }

//        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        try {
            int getUser_id = (request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0);
            UsersDTO user_id = new UsersDTO(getUser_id);

            String phone = request.getParameter("phone");
            UsersDTO uPhone = new UsersDTO();
            UserDAOImpl daoPhone = new UserDAOImpl(DBUtils.getConnection());
            uPhone.setUser_id(getUser_id);
            uPhone.setPhone(phone);
            daoPhone.addPhoneToGoogleAccount(uPhone);

//        int branch_id = Integer.parseInt(request.getParameter("branch_id"));
            String address = request.getParameter("delivery_address");
            String delivery_address = address + ", " + request.getParameter("province");
            String payment_method = request.getParameter("payment_method");
//        System.out.println("User_id: " + getUser_id + ", " + "branch: " + branch_id + ", " + "Address: " +delivery_address + ", " + "Phương thức thanh toán: " + payment_method);
            System.out.println("User_id: " + getUser_id + ", " + "Address: " + delivery_address + ", " + "Phương thức thanh toán: " + payment_method);

            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("cart");

            System.out.println(cart.getList() + "\n");

            Date now = new Date();
            SimpleDateFormat x = new SimpleDateFormat();
            String order_date = x.format(now);

            HttpSession sessin = request.getSession();
            float totalPrice = (float) sessin.getAttribute("TotalPrice");
            System.out.println(totalPrice);

            HttpSession sessionValidate = request.getSession();
            boolean check = true;
            if (address == null || "".equals(address.trim())) {
                sessionValidate.setAttribute("wrongAddress", "Địa chỉ không được rỗng");
                check = false;
            }

            if (check) {
                try {
                    Date date = new Date();
                    String order_id = "" + date.getTime();
                    OrderDTO od = new OrderDTO(order_id, delivery_address, payment_method, order_date, totalPrice, 1, user_id);

                    //status = 1: order pending
                    od.setOrder_id(order_id);
                    orderDAO.addOrder(od);

                    TreeMap<ProductDTO, Integer> list = cart.getList();
                    for (Map.Entry<ProductDTO, Integer> ds : list.entrySet()) {
                        ProductDTO p = new ProductDTO();
                        p.setProduct_id(ds.getKey().getProduct_id());
                        orderDetailsDAO.addOrderDetails(new OrderDetailsDTO(od, p, ds.getKey().getPrice(), ds.getValue()));
                    }
                    session.removeAttribute("cart");
                    response.sendRedirect("success-order");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
        } finally{
            response.sendRedirect("checkout");
        }

    }

}
