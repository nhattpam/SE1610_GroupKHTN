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

            int status = 1; //0: tai khoan in-active: khong hoat dong

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
            Pattern fullNameCheck = Pattern.compile("^[A-Za-z???????????????????????????????????????????????????????????????????????????????????????????-??? ]+$");
            if (full_name == null || "".equals(full_name.trim())) { //k ch???a d???u c??ch ?????u d??ng v?? b???t bu???c ph???i c?? c??? ch??? ch??? k ???????c m???i d??u c??ch
                sessionValidate.setAttribute("wrongFullName", "H??? v?? t??n kh??ng ???????c tr???ng v?? kh??ng ch???a k?? t??? ?????c bi???t");
                check = false;
            }
            if (!full_name.matches(fullNameCheck.pattern())) {
                sessionValidate.setAttribute("wrongFullName", "H??? v?? t??n kh??ng ???????c tr???ng v?? kh??ng ch???a k?? t??? ?????c bi???t");
                check = false;
            }
            //check username
            Pattern userNameCheck = Pattern.compile("^[A-Za-z0-9]+$");
            if (user_name == null || "".equals(user_name.trim())) { //k ch???a d???u c??ch ?????u d??ng v?? b???t bu???c ph???i c?? c??? ch??? ch??? k ???????c m???i d??u c??ch
                sessionValidate.setAttribute("wrongUser_name", "T??n ????ng nh???p kh??ng ???????c tr???ng v?? kh??ng ch???a k?? t??? ?????c bi???t");
                check = false;
            }
            if (!user_name.matches(userNameCheck.pattern())) {
                sessionValidate.setAttribute("wrongUser_name", "T??n ????ng nh???p kh??ng ???????c tr???ng v?? kh??ng ch???a k?? t??? ?????c bi???t v?? d???u c??ch");
                check = false;
            }
            //check sdt
            Pattern phoneCheck = Pattern.compile("^[0][0-9]{9}$");
            if (!phone.matches(phoneCheck.pattern())) { // d???u ! l?? ph??? ?????nh c?? ngh??a l?? k ????ng ?????nh d???ng
                sessionValidate.setAttribute("wrongPhone", "S??? ??i???n tho???i ph???i b???t ?????u l?? s??? 0 v?? d??i 10 k?? t???");
                check = false;
            }
            //check Mk + SHA256 hashcode
            if (password == null || "".equals(password.trim()) || password.length() < 6) { //k ch???a d???u c??ch ?????u d??ng v?? b???t bu???c ph???i c?? c??? ch??? ch??? k ???????c m???i d??u c??ch
                sessionValidate.setAttribute("wrongPassword", "M???t kh???u kh??ng ???????c tr???ng v?? ????? d??i ph???i l???n h??n 6 k?? t???");
                check = false;
            }

            //check duplicate
            UserDAOImpl daoCheckDup = new UserDAOImpl(DBUtils.getConnection());
            if (daoCheckDup.checkDuplicateEmail(email)) {
                sessionValidate.setAttribute("wrongEmail", "Email ???? t???n t???i!");
                check = false;
            }
            if (daoCheckDup.checkDuplicatePhone(phone)) {
                sessionValidate.setAttribute("wrongPhone", "S??? ??i???n tho???i ???? t???n t???i!");
                check = false;
            }
            if (daoCheckDup.checkDuplicateUserName(user_name)) {
                sessionValidate.setAttribute("wrongUser_name", "T??i kho???n ???? t???n t???i!");
                check = false;
            }
            if (check) {
                String checkPassword = toHexString(getSHA(password));
                UsersDTO us = new UsersDTO(full_name, user_name, checkPassword, email, phone, status, create_date, edited_date, role_id);
                keepInput.setAttribute("fulltopping", us);
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
                Transport.send(message);
                RequestDispatcher dispatcher = null;
                dispatcher = req.getRequestDispatcher("registerotp.jsp");
                req.setAttribute("message", "M?? OTP ???? ???????c g???i t???i email c???a b???n");
                //request.setAttribute("connection", con);
                keepInput.setAttribute("otp", otpvalue);
                dispatcher.forward(req, resp);
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

    //h??m m?? h??a sha256
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
    //h??m m?? h??a sha256

}
