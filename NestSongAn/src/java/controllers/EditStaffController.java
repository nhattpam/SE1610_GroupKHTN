/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAOImpl;
import dtos.UsersDTO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * @author Admin
 */
@WebServlet("/edit-staff")
public class EditStaffController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        try {
            int uid = (req.getParameter("uid") != null ? Integer.parseInt(req.getParameter("uid")) : 0);
            String full_name = req.getParameter("full_name");
            String user_name = req.getParameter("user_name");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            req.setAttribute("user_id", uid);
            req.setAttribute("full_name", full_name);
            req.setAttribute("user_name", user_name);
            req.setAttribute("phone", phone);
            req.setAttribute("email", email);
            req.getRequestDispatcher("view/admin/edit_staff.jsp").forward(req, resp);
//            System.out.println(uid);

//            UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());
//            UsersDTO u = dao.viewAccountStaff(uid);
//            System.out.println(u.getUser_id()+ ", " + u.getFull_name() + ". " + u.getUser_name() + ". " + u.getEmail() + ", " + u.getPhone());
//            req.setAttribute("u", u);
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("view/admin/edit_staff.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println(full_name + user_name + phone + email + password);
        try {
            int uid = (req.getParameter("user_id") != null ? Integer.parseInt(req.getParameter("user_id")) : 0);
//            System.out.println(uid);

            String full_name = req.getParameter("full_name");
            String user_name = req.getParameter("user_name");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
//            String password = req.getParameter("password");

            UserDAOImpl daoEdit = new UserDAOImpl(DBUtils.getConnection());

            //gán mái ng dùng nhập vô 1 object user
            UsersDTO u = new UsersDTO();
            u.setFull_name(full_name);
            u.setUser_name(user_name);
//            u.setPassword(password);
            u.setPhone(phone);
            u.setEmail(email);
            u.setUser_id(uid);
            HttpSession session = req.getSession();
            HttpSession sessionValidate = req.getSession();
            Pattern fullNameCheck = Pattern.compile("^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+$");
            boolean check = true;
            if (full_name == null || "".equals(full_name.trim())) { //k chứa dấu cách đầu dòng và bắt buộc phải có cả chữ chứ k được mỗi dáu cách
                sessionValidate.setAttribute("wrongFullName", "Họ và tên không được trống và không chứa kí tự đặc biệt");
                check = false;
            }
            if (!full_name.matches(fullNameCheck.pattern())) {
                sessionValidate.setAttribute("wrongFullName", "Họ và tên không được trống và không chứa kí tự đặc biệt");
                check = false;
            }
            Pattern userNameCheck = Pattern.compile("^[A-Za-z0-9]+$");
            if (user_name == null || "".equals(user_name.trim())) { //k chứa dấu cách đầu dòng và bắt buộc phải có cả chữ chứ k được mỗi dáu cách
                sessionValidate.setAttribute("wrongUser_name", "Tên đăng nhập không được trống và không chứa kí tự đặc biệt");
                check = false;
            }
            if (!user_name.matches(userNameCheck.pattern())) {
                sessionValidate.setAttribute("wrongUser_name", "Tên đăng nhập không được trống và không chứa kí tự đặc biệt và dấu cách");
                check = false;
            }
            Pattern phoneCheck = Pattern.compile("^[0][0-9]{9}$");
            if (!phone.matches(phoneCheck.pattern())) { // dấu ! là phủ định có nghĩa là k đúng định dạng
                sessionValidate.setAttribute("wrongPhone", "Số điện thoại phải bắt đầu là số 0 và dài 10 kí tự");
                check = false;
            }  
            if(check){
                Date now = new Date();
                SimpleDateFormat x = new SimpleDateFormat();
                String edited_date = x.format(now);
                daoEdit.editAccount(u, edited_date);
                session.setAttribute("succMsg", "Cập nhập tài khoản thành công...");
            } else{
                 resp.sendRedirect("edit-staff?uid="+ uid + "&full_name="+ full_name +"&user_name="+ user_name +"&phone="+ phone +"&email=" + email+  "");
            }
            //update xong thì quay lại trang manage-user
            resp.sendRedirect("manage-user");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
