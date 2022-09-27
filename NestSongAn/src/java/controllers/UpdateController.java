/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAO;
import daos.UserDAOImpl;
import dtos.UsersDTO;
import dtos.UsersErrorDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DBUtils;

/**
 *
 * @author duong
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = null;
        String full_name = request.getParameter("full_name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        String user_name = request.getParameter("user_name");
        try {
            UsersErrorDTO userError = new UsersErrorDTO();
            boolean check = true;
            if (full_name.length() > 10 || full_name.length() < 5) {
                userError.setFull_nameError("Fullname lenghth must be [5,10]");
                check = false;
            }
            if (email.length() > 10 || email.length() < 5) {
                userError.setEmailError("Email lenghth must be [5,10]");
                check = false;
            }
            if (phone.length() > 10 || phone.length() < 5) {
                userError.setPhoneError("Phone lenghth must be [5,10]");
                check = false;
            }
            if (password.length() > 10 || password.length() < 5) {
                userError.setPhoneError("Password lenghth must be [5,10]");
                check = false;
            }
            if (!password.equals(confirm)) {
                userError.setConfirmError("Two password dont match");
                check = false;
            }
            if (check) {
                UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());
                UsersDTO dto = new UsersDTO(user_name, full_name, email, phone, "");
                boolean checkDuplicateEmail = dao.checkDuplicateEmail(email);
                if (checkDuplicateEmail) {
                    userError.setEmailError("Duplicate Email: " + email);
                    request.setAttribute("Email_Error", userError);
                } else {
                    boolean update = dao.updateUser(dto);
                    if (update) {
                        request.setAttribute("status", "updateSuccess");
                        dispatcher = request.getRequestDispatcher("login.jsp");
                    } else {
                        request.setAttribute("status", "resetSuccess");
                        dispatcher = request.getRequestDispatcher("error.jsp");
                    }
                }
            }
        } catch (Exception e) {
            log("Error at UpdateController: " + e.toString());
        } finally {
            dispatcher.forward(request, response);
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

}
