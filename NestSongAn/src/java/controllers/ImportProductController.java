/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ImportInvoiceDAOImpl;
import daos.ProductDAOImpl;
import daos.QuantityProductDAOImpl;
import dtos.BranchDTO;
import dtos.ProductDTO;
import dtos.QuantityProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DBUtils;

/**
 *
 * @author HUNG
 */
@WebServlet(name = "ImportProductController", urlPatterns = {"/ImportProductController"})
public class ImportProductController extends HttpServlet {

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
        String url = "view/supplier/import_product.jsp";
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int product_id = Integer.parseInt(request.getParameter("product_id"));
        int branch_id = Integer.parseInt(request.getParameter("branch_id"));
        try {
            //
            QuantityProductDAOImpl quantityProductDAOImpl = new QuantityProductDAOImpl();
            ImportInvoiceDAOImpl importInvoiceDAOImpl=new ImportInvoiceDAOImpl();
            //
            boolean result=quantityProductDAOImpl.importProduct(quantity, product_id, branch_id);
            result=importInvoiceDAOImpl.addNewInvoice(quantity, product_id, branch_id);
            if (result==true) {
                request.setAttribute("succMsg", "Nhập hàng thành công");
            }else{
                request.setAttribute("failedMsg", "Nhập hàng không thành công");
            }
        } catch (SQLException ex) {
            log("SQL EX ImportProduct "+ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        int product_id = Integer.parseInt(request.getParameter("product_id"));
        int branch_id = Integer.parseInt(request.getParameter("branch_id"));
        String branch_name = request.getParameter("branch_name");
        String url = "view/supplier/import_product.jsp";
        try {
            Connection conn = DBUtils.getConnection();
            ProductDTO productDTO;
            BranchDTO branchDTO = new BranchDTO(branch_id, branch_name);

            ProductDAOImpl productDAOImpl = new ProductDAOImpl(conn);
            productDTO = productDAOImpl.getProductId(product_id);

            request.setAttribute("product", productDTO);
            request.setAttribute("branch", branchDTO);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
