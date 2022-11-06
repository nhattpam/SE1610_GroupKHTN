/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.RegisterAccountController.getSHA;
import static controllers.RegisterAccountController.toHexString;
import daos.OrderDAOImpl;
import daos.OrderDetailsDAOImpl;
import daos.QuantityProductDAOImpl;
import daos.UserDAOImpl;
import dtos.CartDTO;
import dtos.LocationDTO;
import dtos.OrderDTO;
import dtos.OrderDetailsDTO;
import dtos.ProductDTO;
import dtos.UserRoleDTO;
import dtos.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DBUtils;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "OfflineCheckoutController", urlPatterns = {"/checkout-offline"})
public class OfflineCheckoutController extends HttpServlet {
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
////        GoogleDTO us = (GoogleDTO) session.getAttribute("USERG");
//
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
            if (uu.getRole_id().getRole().equals("customer")) {
                 response.sendRedirect("home");
            }
            if (uu.getRole_id().getRole().equals("admin")) {
                response.sendRedirect("admin-dashboard");
            }
            if (uu.getRole_id().getRole().equals("supplier")) {
                response.sendRedirect("ViewProductSupplierController");
            }
            if (uu.getRole_id().getRole().equals("shipper")) {
                response.sendRedirect("shipper-dashboard");
            }if (uu.getRole_id().getRole().equals("staff")) {
                request.getRequestDispatcher("view/staff/checkout-offline.jsp").forward(request, response);
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
            
            HttpSession sCheckLocation = request.getSession();
            int getLocation_id = 0;
            if((int) sCheckLocation.getAttribute("branch_id") == 1){
                getLocation_id = 1;
            }
            if((int) sCheckLocation.getAttribute("branch_id") == 2){
                getLocation_id = 2;
            }
            if((int) sCheckLocation.getAttribute("branch_id") == 3){
                getLocation_id = 3;
            }
            LocationDTO location_id = new LocationDTO(getLocation_id);
            
            String full_name = request.getParameter("full_name");
            String phone = request.getParameter("phone");
            String address = request.getParameter("delivery_address");
            
            String delivery_address = address + ", " + request.getParameter("province");
            
            String payment_method = "truc-tiep";
            
            HttpSession sessin = request.getSession();
            
            double tt = (double) sessin.getAttribute("TotalPriceAll");
            
            float total = (float) tt;
            
            HttpSession keepInput = request.getSession();
            keepInput.setAttribute("full_name", full_name);
            keepInput.setAttribute("phone", phone);
            keepInput.setAttribute("province", request.getParameter("province"));
            keepInput.setAttribute("delivery_address", address);
            keepInput.setAttribute("payment_method", payment_method);
            
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("cart");
            
            Date now = new Date();
            SimpleDateFormat x = new SimpleDateFormat();
            String order_date = x.format(now);
            String delivery_date = x.format(now);
            
            HttpSession sessionValidate = request.getSession();
            boolean check = true;
            
            Pattern fullNameCheck = Pattern.compile("^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+$");
            if (full_name == null || "".equals(full_name.trim())) { //k chứa dấu cách đầu dòng và bắt buộc phải có cả chữ chứ k được mỗi dáu cách
                sessionValidate.setAttribute("wrongFullName", "Họ và tên không được trống và không chứa kí tự đặc biệt");
                check = false;
            }
            
            if (!full_name.matches(fullNameCheck.pattern())) {
                sessionValidate.setAttribute("wrongFullName", "Họ và tên không được trống và không chứa kí tự đặc biệt");
                check = false;
            }
            
            //check sdt
            Pattern phoneCheck = Pattern.compile("^[0][0-9]{9}$");
            if (!phone.matches(phoneCheck.pattern())) { // dấu ! là phủ định có nghĩa là k đúng định dạng
                sessionValidate.setAttribute("wrongPhone", "Số điện thoại phải bắt đầu là số 0 và dài 10 kí tự");
                check = false;
            }
            
            
            if (address == null || "".equals(address.trim())) {
                sessionValidate.setAttribute("wrongAddress", "Địa chỉ không được rỗng");
                check = false;
            }
            
            //check duplicate
            UserDAOImpl daoCheckDup = new UserDAOImpl(DBUtils.getConnection());
            if (daoCheckDup.checkDuplicatePhone(phone)) {
                sessionValidate.setAttribute("wrongPhone", "Số điện thoại đã tồn tại!");
                check = false;
            }
            
            if (check && !request.getParameter("province").equals("chooseCity")) {
                try {
                    Date date = new Date();
                    String order_id = "" + date.getTime();
                    
                    //create account auto
                    UserDAOImpl daoCreate = new UserDAOImpl(DBUtils.getConnection());
                    UserRoleDTO role_id = new UserRoleDTO(1);
                    String password = toHexString(getSHA(phone));
                    UsersDTO uCreate = new UsersDTO(full_name, phone, password, phone, 1, order_date, order_date, role_id);
                    
//                    System.out.println("day la create: " + uCreate);
                    daoCreate.userRegisterOffline(uCreate);
                    UsersDTO user_id1 = daoCreate.getUserIdByPhone(phone);
                    
                    System.out.println("DAADY: " + user_id1.getUser_id());
                    
                    
                    
                    OrderDTO od = new OrderDTO(order_id, delivery_address, payment_method, order_date, delivery_date, total, 3, user_id1, "offline", location_id);
                    
                    od.setOrder_id(order_id);
                    orderDAO.addOrderOffline(od);
                    
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
                    response.sendRedirect("offline-order?bid=" + sessin.getAttribute("branch_id") +"");
                    session.setAttribute("succMsg", "Tạo hoá đơn thành công");
                    
                    
                }catch(Exception ex){
                }
            } else{
                response.sendRedirect("checkout-offline?bid=" + sessin.getAttribute("branch_id") + "");
            }
            
            
            
        } catch (Exception e) {
        }
        
        
    }

     //hàm mã hóa sha256
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
    //hàm mã hóa sha256
}
