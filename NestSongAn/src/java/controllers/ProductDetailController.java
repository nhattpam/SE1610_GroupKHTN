/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.FeedbackDAOImpl;
import daos.ProductDAOImpl;
import daos.QuantityProductDAOImpl;
import dtos.CartDTO;
import dtos.CategoryDTO;
import dtos.FeedbackDTO;
import java.util.List;
import dtos.ProductDTO;
import dtos.QuantityProductDTO;
import dtos.UsersDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DBUtils;

/**
 *
 * @author duong
 */
@WebServlet("/detail")
public class ProductDetailController extends HttpServlet {

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
        int product_id = Integer.parseInt(request.getParameter("product_id"));
        ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());
        ProductDTO p = dao.getProductId(product_id);
        request.setAttribute("detail", p);
        
         //hien thi category
        ProductDAOImpl categoryDAO = new ProductDAOImpl(DBUtils.getConnection());
        List<CategoryDTO> listCategory = categoryDAO.getAllCategory();
        
        request.setAttribute("CList", listCategory); //ban qua detail
        
        //view all feedback
        FeedbackDAOImpl fedao = new FeedbackDAOImpl(DBUtils.getConnection());
        List<FeedbackDTO> felist = fedao.viewFeedbackProduct(product_id);
        request.setAttribute("listFeedback", felist);
        
        //phan trang
        int count = fedao.getTotalFeedback();
        int endpage = count/2;
        if(count%2 !=0){
            endpage++;
        }
        request.setAttribute("enpage", endpage);
        //get index
        String indexPage = request.getParameter("index");
        if(indexPage == null){
           indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        List<FeedbackDTO> felist1 = fedao.pagingFeedback(index);
        request.setAttribute("listPage", felist1);
        //lastest product
        ProductDAOImpl daoLastest = new ProductDAOImpl(DBUtils.getConnection());
        
        List<ProductDTO> listLastest = daoLastest.getAllProductLastest();
        request.setAttribute("listLastest", listLastest);
        //popular product
        ProductDAOImpl daop = new ProductDAOImpl(DBUtils.getConnection());
        List<ProductDTO> listPopular = daop.viewPopularProduct();
        request.setAttribute("listPopular", listPopular);
        //check cart
        HttpSession sCart = request.getSession();
        CartDTO cart = (CartDTO) sCart.getAttribute("cart");
        if (cart == null) {
            cart = new CartDTO();
            sCart.setAttribute("cart", cart);
        }
//        System.out.println(cart);
        
        //check branch
        HttpSession sBranch = request.getSession();
        
        QuantityProductDAOImpl daoQuantity = new QuantityProductDAOImpl(DBUtils.getConnection());
        //get branch id session
        QuantityProductDTO q = daoQuantity.getBranch(product_id, (int) sBranch.getAttribute("branch_id"));
        
        request.setAttribute("q", q);
        
        
        
        request.getRequestDispatcher("product_details.jsp").forward(request, response);
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
        if (sCheckk.getAttribute("USER") == null) {
            processRequest(request, response);
        } else {
            //redirect if not customer
            HttpSession sessionn = request.getSession();
            UsersDTO uu = (UsersDTO) sessionn.getAttribute("USER");
//            System.out.println("DDya la: " + uu.getRole_id().getRole());
            if (uu.getRole_id().getRole().equals("staff")) {
                response.sendRedirect("staff-dashboard");
            }
            if (uu.getRole_id().getRole().equals("admin")) {
                response.sendRedirect("admin-dashboard");
            }
            if (uu.getRole_id().getRole().equals("supplier")) {
                response.sendRedirect("ViewProductSupplierController");
            }
            if (uu.getRole_id().getRole().equals("shipper")) {
                response.sendRedirect("shipper-dashboard");
            }if (uu.getRole_id().getRole().equals("customer")) {
                 processRequest(request, response);
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
