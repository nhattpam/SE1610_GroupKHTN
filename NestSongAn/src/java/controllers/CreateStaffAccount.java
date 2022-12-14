/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.RegisterAccountController.getSHA;
import static controllers.RegisterAccountController.toHexString;
import daos.UserDAOImpl;
import dtos.UserRoleDTO;
import dtos.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * @author HUNG
 */
@WebServlet(name = "CreateStaffAccount", urlPatterns = {"/CreateStaffAccount"})
public class CreateStaffAccount extends HttpServlet {

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
        String url="/view/admin/create_new_staff.jsp";
        try {
             String full_name = request.getParameter("full_name");
            String user_name = request.getParameter("user_name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());
            int status = 1; //1: tai khoan active: dang hoat dong

            Date now = new Date();
            SimpleDateFormat x = new SimpleDateFormat();
            String create_date = x.format(now);

            String edited_date = null;

            UserRoleDTO role_id = new UserRoleDTO(Integer.parseInt(request.getParameter("role_id")));
            //validation
            request.setAttribute("full_name", full_name);
            request.setAttribute("user_name", user_name);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            //check du lieu nguoi dung
            boolean check = true;
            //check fullname
            Pattern fullNameCheck = Pattern.compile("^[A-Za-z???????????????????????????????????????????????????????????????????????????????????????????-??? ]+$");
            if (full_name == null || "".equals(full_name.trim())) { //k ch???a d???u c??ch ?????u d??ng v?? b???t bu???c ph???i c?? c??? ch??? ch??? k ???????c m???i d??u c??ch
                request.setAttribute("wrongFullName", "H??? v?? t??n kh??ng ???????c tr???ng v?? kh??ng ch???a k?? t??? ?????c bi???t");
                check = false;
            }
            if (!full_name.matches(fullNameCheck.pattern())) {
                request.setAttribute("wrongFullName", "H??? v?? t??n kh??ng ???????c tr???ng v?? kh??ng ch???a k?? t??? ?????c bi???t");
                check = false;
            }
            //check username
            Pattern userNameCheck = Pattern.compile("^[A-Za-z0-9]+$");
            if (user_name == null || "".equals(user_name.trim())) { //k ch???a d???u c??ch ?????u d??ng v?? b???t bu???c ph???i c?? c??? ch??? ch??? k ???????c m???i d??u c??ch
                request.setAttribute("wrongUser_name", "T??n ????ng nh???p kh??ng ???????c tr???ng v?? kh??ng ch???a k?? t??? ?????c bi???t");
                check = false;
            }
            if (!user_name.matches(userNameCheck.pattern())) {
                request.setAttribute("wrongUser_name", "T??n ????ng nh???p kh??ng ???????c tr???ng v?? kh??ng ch???a k?? t??? ?????c bi???t v?? d???u c??ch");
                check = false;
            }
            //check sdt
            Pattern phoneCheck = Pattern.compile("^[0][0-9]{9}$");
            if (!phone.matches(phoneCheck.pattern())) { // d???u ! l?? ph??? ?????nh c?? ngh??a l?? k ????ng ?????nh d???ng
                request.setAttribute("wrongPhone", "S??? ??i???n tho???i ph???i b???t ?????u l?? s??? 0 v?? d??i 10 k?? t???");
                check = false;
            }
            //check Mk + SHA256 hashcode
            if (password == null || "".equals(password.trim()) || password.length() < 6) { //k ch???a d???u c??ch ?????u d??ng v?? b???t bu???c ph???i c?? c??? ch??? ch??? k ???????c m???i d??u c??ch
                request.setAttribute("wrongPassword", "M???t kh???u kh??ng ???????c tr???ng v?? ????? d??i ph???i l???n h??n 6 k?? t???");
                check = false;
            }

            //check duplicate
            UserDAOImpl daoCheckDup = new UserDAOImpl(DBUtils.getConnection());
            if (daoCheckDup.checkDuplicateEmail(email)) {
                request.setAttribute("wrongEmail", "Email ???? t???n t???i!");
                check = false;
            }
            if (daoCheckDup.checkDuplicatePhone(phone)) {
                request.setAttribute("wrongPhone", "S??? ??i???n tho???i ???? t???n t???i!");
                check = false;
            }
            if (daoCheckDup.checkDuplicateUserName(user_name)) {
                request.setAttribute("wrongUser_name", "T??i kho???n ???? t???n t???i!");
                check = false;
            }
            if (check) {
                String checkPassword = toHexString(getSHA(password));
                UsersDTO us = new UsersDTO(full_name, user_name, checkPassword, email, phone, status, create_date, edited_date, role_id);

                boolean result = dao.userRegister(us);
                if (result==true) {
                    url="search-account?search="+full_name;
                    response.sendRedirect(url);
                }else{
                    request.setAttribute("failedMsg", "C?? l???i tr??n h??? th???ng...");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
        
        HttpSession sCheckk = request.getSession();
        if(sCheckk.getAttribute("USERG") != null){
            response.sendRedirect("home");
        }
        if (sCheckk.getAttribute("USER") == null){
            response.sendRedirect("loginController");
        }else{
            UsersDTO uu = (UsersDTO) sCheckk.getAttribute("USER");
            if (uu.getRole_id().getRole().equals("staff")) {
                response.sendRedirect("list-products");
            }
            if (uu.getRole_id().getRole().equals("shipper")) {
                response.sendRedirect("shipper-dashboard");
            }
            if (uu.getRole_id().getRole().equals("admin")) {
                processRequest(request, response);
            }
            if (uu.getRole_id().getRole().equals("customer")) {
                response.sendRedirect("home");
            }
            if (uu.getRole_id().getRole().equals("supplier")) {
                response.sendRedirect("ViewProductSupplierController");
            }
            
        }
        
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

}
