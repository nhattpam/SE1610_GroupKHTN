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
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HUNG
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginServlet"})
public class LoginController extends HttpServlet {
    
    private static final String LOGIN_PAGE = "loginPage";
    private static final String HOME_PAGE = "";
    private static final String STAFF_PAGE = "list-products";
    private static final String ADMIN_PAGE = "ViewSuccesfulDeliveryController";
    private static final String SHIPPER_PAGE = "shipper-dashboard";
    private static final String SUPPLIER_PAGE = "ViewProductSupplierController";

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
        
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        String url = siteMaps.getProperty(LOGIN_PAGE);                                          // default to login page if error
        String errorMessage = "Ki???m tra l???i t??n ????ng nh???p ho???c m???t kh???u";
        try {
            String hashedPassword = toHexString(getSHA(password));
            //1:call DAO
            //new obj DAO && call method from DAO
            UserDAO dao = new UserDAOImpl();
            UsersDTO result = dao.checkLogin(username, hashedPassword);
            //2.process 
            HttpSession session = request.getSession();//true
            session.setAttribute("USER", result);
            if (result == null) {
                request.setAttribute("LoginError", errorMessage);
            }
            if (result != null && result.getRole_id().getRole().equals("customer")) {          // Role name = customer                                                                  
                if (result.getStatus() == 1) {
                    url = siteMaps.getProperty(HOME_PAGE);   // to home page
                    response.sendRedirect(url);
                } else {
                    request.setAttribute("inactive", "T??i kho???n n??y ???? b??? kh??a");
                    session.removeAttribute("USER");
                }
            }
            if (result != null && result.getRole_id().getRole().equals("staff")) {          // Role name = staff 
                url = STAFF_PAGE;                                                       // to staff page
                response.sendRedirect(url);
            }
            if (result != null && result.getRole_id().getRole().equals("admin")) {             // Role name = admin 
                url = ADMIN_PAGE;                                                      // to admin page
                response.sendRedirect(url);
            }
            if (result != null && result.getRole_id().getRole().equals("supplier")) {          // Role name = supplier 
                url = SUPPLIER_PAGE;                                                        // to supplier page
                response.sendRedirect(url);
            }
            if (result != null && result.getRole_id().getRole().equals("shipper")) {          // Role name = shipper 
                url = SHIPPER_PAGE;                                                     // to shipper page
                response.sendRedirect(url);
            }            
        } catch (NamingException ex) {            
            log("LoginServlet_Naming" + ex.getMessage());
        } catch (SQLException ex) {
            log("LoginServlet_SQL" + ex.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            log("HashPassword error" + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
//            response.sendRedirect(url);
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
