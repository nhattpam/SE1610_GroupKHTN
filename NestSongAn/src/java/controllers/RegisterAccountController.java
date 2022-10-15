/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAOImpl;
import daos.UserDAOImpl;
import dtos.UserRoleDTO;
import dtos.UsersDTO;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
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
//khangtran: function register account
@WebServlet("/RegisterAccountController")
public class RegisterAccountController extends HttpServlet {

    private final static String MyEmail = "system.khtnholdings@gmail.com";
    private final static String MyEmailPass = "ucdvvemszkiufhqi";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");

        try {
            String full_name = req.getParameter("full_name");
            String user_name = req.getParameter("user_name");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());

            HttpSession keepInput = req.getSession();
            keepInput.setAttribute("full_name", full_name);
            keepInput.setAttribute("user_name", user_name);
            keepInput.setAttribute("phone", phone);
            keepInput.setAttribute("email", email);

            int status = 0; //0: tai khoan in-active: khong hoat dong

            Date now = new Date();
            SimpleDateFormat x = new SimpleDateFormat();
            String create_date = x.format(now);

            String edited_date = null;

            UserRoleDTO role_id = new UserRoleDTO(1);
//            boolean checkDuplicateEmail = dao.checkDuplicateEmail((String) req.getAttribute("email"));
//            boolean checkDuplicateUserName = dao.checkDuplicateEmail((String) req.getAttribute("user_name"));
//            boolean checkDuplicatePhone = dao.checkDuplicateEmail((String) req.getAttribute("phone"));

            //validation
            HttpSession sessionValidate = req.getSession();
            //check du lieu nguoi dung
            boolean check = true;
            //check fullname
            Pattern fullNameCheck = Pattern.compile("^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+$");
            if (full_name == null || "".equals(full_name.trim())) { //k chứa dấu cách đầu dòng và bắt buộc phải có cả chữ chứ k được mỗi dáu cách
                sessionValidate.setAttribute("wrongFullName", "Họ và tên không được trống và không chứa kí tự đặc biệt");
                check = false;
            }
            if (!full_name.matches(fullNameCheck.pattern())) {
                sessionValidate.setAttribute("wrongFullName", "Họ và tên không được trống và không chứa kí tự đặc biệt");
                check = false;
            }
            //check username
            Pattern userNameCheck = Pattern.compile("^[A-Za-z0-9]+$");
            if (user_name == null || "".equals(user_name.trim())) { //k chứa dấu cách đầu dòng và bắt buộc phải có cả chữ chứ k được mỗi dáu cách
                sessionValidate.setAttribute("wrongUser_name", "Tên đăng nhập không được trống và không chứa kí tự đặc biệt");
                check = false;
            }
            if (!user_name.matches(userNameCheck.pattern())) {
                sessionValidate.setAttribute("wrongUser_name", "Tên đăng nhập không được trống và không chứa kí tự đặc biệt và dấu cách");
                check = false;
            }
            //check sdt
            Pattern phoneCheck = Pattern.compile("^[0][0-9]{9}$");
            if (!phone.matches(phoneCheck.pattern())) { // dấu ! là phủ định có nghĩa là k đúng định dạng
                sessionValidate.setAttribute("wrongPhone", "Số điện thoại phải bắt đầu là số 0 và dài 10 kí tự");
                check = false;
            }
            //check Mk + SHA256 hashcode
            if (password == null || "".equals(password.trim()) || password.length() < 6) { //k chứa dấu cách đầu dòng và bắt buộc phải có cả chữ chứ k được mỗi dáu cách
                sessionValidate.setAttribute("wrongPassword", "Mật khẩu không được trống và độ dài phải lớn hơn 6 kí tự");
                check = false;
            }

            //check duplicate
            UserDAOImpl daoCheckDup = new UserDAOImpl(DBUtils.getConnection());
            if (daoCheckDup.checkDuplicateEmail(email)) {
                sessionValidate.setAttribute("wrongEmail", "Email đã tồn tại!");
                check = false;
            }
            if (daoCheckDup.checkDuplicatePhone(phone)) {
                sessionValidate.setAttribute("wrongPhone", "Số điện thoại đã tồn tại!");
                check = false;
            }
            if (daoCheckDup.checkDuplicateUserName(user_name)) {
                sessionValidate.setAttribute("wrongUser_name", "Tài khoản đã tồn tại!");
                check = false;
            }
            if (check) {
                String checkPassword = toHexString(getSHA(password));
                UsersDTO us = new UsersDTO(full_name, user_name, checkPassword, email, phone, status, create_date, edited_date, role_id);

                int otpvalue = 0;
                Random rand = new Random();
                otpvalue = rand.nextInt(1255650);

                String to = email;// change accordingly
                // Get the session object
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");
                Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(MyEmail, MyEmailPass);// Put your email
                        // id and
                        // password here
                    }
                });
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(email));// change accordingly
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("Verify Email");
                message.setText("Your OTP is: " + otpvalue);
                // send message

                String htmlContent = "Your Link is: <a href=\""
                        + "http://localhost:8080/NestSongAn/VerifyOTP\""
                        + ">Xác nhận tài khoản</a>";
                // send message
                message.setContent(htmlContent, "text/html; charset=utf-8");
                Transport.send(message);
                resp.sendRedirect("LoginServlet");
                boolean result = dao.userRegister(us);
                if (result == true) {
                    keepInput.setAttribute("succMsg", "Vui lòng đăng nhập email để kích hoạt tài khoản.");
                    // sending otp

                } else {
                    resp.sendRedirect("RegisterAccountController");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resp.sendRedirect("RegisterAccountController");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        
//        HttpSession keepInput = req.getSession();
//        String full_name = (String) keepInput.getAttribute("full_name");
//        String user_name = (String) keepInput.getAttribute("user_name");
//        String phone = (String) keepInput.getAttribute("phone");
//        String email = (String) keepInput.getAttribute("email");

        req.getRequestDispatcher("register.jsp").forward(req, resp);
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
