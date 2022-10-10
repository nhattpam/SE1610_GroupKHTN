/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.RegisterAccountController.getSHA;
import static controllers.RegisterAccountController.toHexString;
import daos.UserDAO;
import daos.UserDAOImpl;
import dtos.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author haph1
 */
public class EditProfileController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int uid = Integer.parseInt(request.getParameter("uid"));
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        try {
            HttpSession session = request.getSession();
            HttpSession sessionValidate = request.getSession();
            Pattern fullNameCheck = Pattern.compile("^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+$");
            boolean check = true;
            if (fullname == null || "".equals(fullname.trim())) { //k chứa dấu cách đầu dòng và bắt buộc phải có cả chữ chứ k được mỗi dáu cách
                sessionValidate.setAttribute("wrongFullName", "Họ và tên không được trống và không chứa kí tự đặc biệt");
                check = false;
            }
            if (!fullname.matches(fullNameCheck.pattern())) {
                sessionValidate.setAttribute("wrongFullName", "Họ và tên không được trống và không chứa kí tự đặc biệt");
                check = false;
            }
            Pattern userNameCheck = Pattern.compile("^[A-Za-z0-9]+$");
            if (username == null || "".equals(username.trim())) { //k chứa dấu cách đầu dòng và bắt buộc phải có cả chữ chứ k được mỗi dáu cách
                sessionValidate.setAttribute("wrongUser_name", "Tên đăng nhập không được trống và không chứa kí tự đặc biệt");
                check = false;
            }
            if (!username.matches(userNameCheck.pattern())) {
                sessionValidate.setAttribute("wrongUser_name", "Tên đăng nhập không được trống và không chứa kí tự đặc biệt và dấu cách");
                check = false;
            }
            Pattern phoneCheck = Pattern.compile("^[0][0-9]{9}$");
            if (!phone.matches(phoneCheck.pattern())) { // dấu ! là phủ định có nghĩa là k đúng định dạng
                sessionValidate.setAttribute("wrongPhone", "Số điện thoại phải bắt đầu là số 0 và dài 10 kí tự");
                check = false;
            }
            
            if (check) {
//                String checkPassword = toHexString(getSHA(password));
                
                UserDAOImpl user = new UserDAOImpl();
                UsersDTO us = new UsersDTO(uid, fullname, username, email, phone);
                user.editAccount(us);
                session.setAttribute("succMsg", "Cập nhập tài khoản thành công...");
            }
            response.sendRedirect("MyProfile?uid=" + uid);

        } catch (SQLException ex) {
            Logger.getLogger(MyProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

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
