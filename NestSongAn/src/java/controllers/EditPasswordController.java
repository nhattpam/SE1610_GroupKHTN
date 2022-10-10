/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DBUtils;

/**
 *
 * @author haph1
 */

public class EditPasswordController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            int uid = Integer.parseInt(request.getParameter("uid"));
            UserDAO user = new UserDAOImpl();
            UsersDTO profile = user.viewAccount(uid);
            request.setAttribute("inform", profile);
            request.getRequestDispatcher("editpassword.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MyProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String password = request.getParameter("pass");
        String newpassword = request.getParameter("newpass");
        String confpassword = request.getParameter("confpass");
        HttpSession session = request.getSession();
        HttpSession sessionValidate = request.getSession();
        int uid = Integer.parseInt(request.getParameter("uid"));
        boolean check = true;
        if (password == null || "".equals(password.trim())) { //k chứa dấu cách đầu dòng và bắt buộc phải có cả chữ chứ k được mỗi dáu cách
            check = false;
        }

        if (newpassword == null || "".equals(newpassword.trim())) { //k chứa dấu cách đầu dòng và bắt buộc phải có cả chữ chứ k được mỗi dáu cách
            check = false;
        }

        if (confpassword == null || "".equals(confpassword.trim())) { //k chứa dấu cách đầu dòng và bắt buộc phải có cả chữ chứ k được mỗi dáu cách\
            check = false;
        }
        if (!newpassword.equals(confpassword)) {
            check = false;
        }
        if (check) {
            try {
                String checkPassword = toHexString(getSHA(password));
                String checkNewPassword = toHexString(getSHA(newpassword));
                UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());
                boolean result = dao.checkPassword(checkPassword);
                if (result) {
                    dao.editPassword(uid, checkNewPassword);
                    response.sendRedirect("MyProfile?uid=" + uid);
                }
                response.sendRedirect("EditPassword?uid=" + uid);
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }
        response.sendRedirect("EditPassword?uid=" + uid);
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
