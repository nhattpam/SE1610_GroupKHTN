package controllers;

import static controllers.EditPasswordController.getSHA;
import static controllers.EditPasswordController.toHexString;
import daos.UserDAO;
import daos.UserDAOImpl;
import dtos.UsersDTO;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DBUtils;

/**
 * Servlet implementation class ResetPasswordController
 */
@WebServlet("/resetPassword")
public class ResetPasswordController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String newPassword = request.getParameter("password");
        String confPassword = request.getParameter("confPassword");
        RequestDispatcher dispatcher = null;
        String email = (String) session.getAttribute("email");
        if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
            try {
                String checkPassword = toHexString(getSHA(newPassword));
                UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());
                boolean reset = dao.resetPassword(checkPassword, email);
                if (reset) {
                    request.setAttribute("status", "resetSuccess");
                    dispatcher = request.getRequestDispatcher("login.jsp");
                } else {
                    request.setAttribute("status", "resetFailed");
                    dispatcher = request.getRequestDispatcher("error.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                dispatcher.forward(request, response);
            }
        }
    }
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
