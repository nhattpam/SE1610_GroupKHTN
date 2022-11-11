/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.OrderDAOImpl;
import daos.OrderDetailsDAOImpl;
import daos.QuantityProductDAOImpl;
import dtos.CartDTO;
import dtos.GoogleDTO;
import dtos.OrderDTO;
import dtos.OrderDetailsDTO;
import dtos.ProductDTO;
import dtos.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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
@WebServlet(name = "CheckoutController", urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {

    private OrderDAOImpl orderDAO = new OrderDAOImpl(DBUtils.getConnection());
    private OrderDetailsDAOImpl orderDetailsDAO = new OrderDetailsDAOImpl(DBUtils.getConnection());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        UsersDTO u = (UsersDTO) session.getAttribute("USER");
//        GoogleDTO us = (GoogleDTO) session.getAttribute("USERG");

        request.setAttribute("user", u);

//        request.setAttribute("usergg", us);
        CartDTO cart = (CartDTO) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartDTO();
            session.setAttribute("cart", cart);
        }
        TreeMap<ProductDTO, Integer> list = cart.getList();
        request.setAttribute("list", list);
        
        float totalSum= 0f;
        
        HttpSession sCheckk = request.getSession();
        if (sCheckk.getAttribute("USER") == null) {
            response.sendRedirect("loginController");
        } else {
            //redirect if not customer
            HttpSession sessionn = request.getSession();
            UsersDTO uu = (UsersDTO) sessionn.getAttribute("USER");
//            System.out.println("DDya la: " + uu.getRole_id().getRole());
            if (uu.getRole_id().getRole().equals("staff")) {
                 response.sendRedirect("list-products");
            }
            if (uu.getRole_id().getRole().equals("admin")) {
                response.sendRedirect("admin-dashboard");
            }
            if (uu.getRole_id().getRole().equals("supplier")) {
                response.sendRedirect("ViewProductSupplierController");
            }
            if (uu.getRole_id().getRole().equals("shipper")) {
                response.sendRedirect("shipper-dashboard");
            }if (uu.getRole_id().getRole().equals("customer")) {
                request.getRequestDispatcher("checkout.jsp").forward(request, response);
            }
        }
        
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

//        int branch_id = Integer.parseInt(request.getParameter("branch_id"));
            String address = request.getParameter("delivery_address");
//        System.out.println(address);
            String delivery_address = address + ", " + request.getParameter("province");
            String payment_method = request.getParameter("payment_method");
//        System.out.println("User_id: " + getUser_id + ", " + "branch: " + branch_id + ", " + "Address: " +delivery_address + ", " + "Phương thức thanh toán: " + payment_method);
//            System.out.println("User_id: " + getUser_id + ", " + "Address: " + delivery_address + ", " + "Phương thức thanh toán: " + payment_method);

            HttpSession sessin = request.getSession();
//            float totalPrice = (float) sessin.getAttribute("TotalPriceAll");
//            System.out.println(totalPrice);
//            System.out.println(sessin.getAttribute("TotalPriceAll"));
            
            double tt = (double) sessin.getAttribute("TotalPriceAll");
//            System.out.println("this is tt: " + tt);
            
            float total = (float) tt;
//            System.out.println("this is t1: " + total);
             HttpSession keepInput = request.getSession();
//            keepInput.setAttribute("phone", phone);
            keepInput.setAttribute("province", request.getParameter("province"));
            keepInput.setAttribute("delivery_address", address);
            keepInput.setAttribute("payment_method", payment_method);


            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("cart");

//            System.out.println(cart.getList() + "\n");

            Date now = new Date();
            SimpleDateFormat x = new SimpleDateFormat();
            String order_date = x.format(now);

            HttpSession sessionValidate = request.getSession();
            boolean check = true;
            if (address == null || "".equals(address.trim())) {
                sessionValidate.setAttribute("wrongAddress", "Địa chỉ không được rỗng");
                check = false;
            }
            if (check && !request.getParameter("province").equals("chooseCity") && !request.getParameter("payment_method").equals("choosePay")) {
                try {
                    OrderDTO od = null;
                    Date date = new Date();
                    String order_id = "" + date.getTime();
                    if(request.getParameter("payment_method").equals("cod")){
                        payment_method = "cod";
                    } 
                    if(request.getParameter("payment_method").equals("paypal")){
                        payment_method = "paypal";
                        HttpSession sPayPal = request.getSession();
                        sPayPal.setAttribute("order_id", order_id);
                        sPayPal.setAttribute("subtotal", total);
                        response.sendRedirect("checkout-paypal");
                    }
                    
                    od = new OrderDTO(order_id, delivery_address, payment_method, order_date, total, 1, user_id);

                    //status = 1: order pending
                    od.setOrder_id(order_id);
                    orderDAO.addOrder(od);

                    TreeMap<ProductDTO, Integer> list = cart.getList();
                    for (Map.Entry<ProductDTO, Integer> ds : list.entrySet()) {
                        ProductDTO p = new ProductDTO();
                        p.setProduct_id(ds.getKey().getProduct_id());
                        orderDetailsDAO.addOrderDetails(new OrderDetailsDTO(od, p, ds.getKey().getPrice(), ds.getValue()));
//              
                        HttpSession getUid = request.getSession();
//        
                        QuantityProductDAOImpl dao3 = new QuantityProductDAOImpl(DBUtils.getConnection());
                        dao3.subQuantityAfterBuy(ds.getValue(), ds.getKey().getProduct_id(), (int) getUid.getAttribute("branch_id"));
                    }
                    session.removeAttribute("cart");
                    session.removeAttribute("numlist");
                    session.setAttribute("order_id", od.getOrder_id());
                    if(request.getParameter("payment_method").equals("cod")){
                        response.sendRedirect("success-order");
                    }
//                    response.sendRedirect("success-order");

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            else{
                session.setAttribute("notiCheckout", "Vui lòng kiểm tra lại tỉnh/thành phố hoặc phương thức thanh toán");
            }
        } catch (Exception e) {
        } finally{
            response.sendRedirect("checkout");
        }

    }

}
