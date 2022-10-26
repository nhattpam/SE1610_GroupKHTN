/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAOImpl;
import dtos.CartDTO;
import dtos.CategoryDTO;
import dtos.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "SortPriceController", urlPatterns = {"/SortPriceController"})
public class SortPriceController extends HttpServlet {

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
        String url = "shop_all_product.jsp";
        //load category for shop_all_product.jsp
        ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());
        List<CategoryDTO> cList = dao.getAllCategory();
        request.setAttribute("cList", cList);
        //get para        
        String categoryID = request.getParameter("cateId");
        String sortMode = request.getParameter("sort");
        //init result list        
        //get page index, create new index if null
        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        try {
            // neu k sort => view product by category
            if (sortMode != null) {
                int sort = Integer.parseInt(sortMode);//sort=1 asc, sort=2 desc
                if (categoryID != null) {
                    int cateId = Integer.parseInt(categoryID);
                    int count = dao.getCountByCategory(cateId);
                    int endPage = count / 3;
                    if (count % 3 != 0) {
                        endPage++;
                    }
                    request.setAttribute("endPageS", endPage);
                    //load result
                    if (sort == 1) {
                        List<ProductDTO> listPaging = dao.getProductAsc(cateId, index);
                        request.setAttribute("listPaging", listPaging);
                        request.setAttribute("sort", sort);
                        request.setAttribute("cateId", cateId);
                    }
                    if (sort == 2) {
                        List<ProductDTO> listPaging = dao.getProductDesc(cateId, index);
                        request.setAttribute("listPaging", listPaging);
                        request.setAttribute("sort", sort);
                        request.setAttribute("cateId", cateId);
                    }
                } else {
                    int count = dao.getTotalProduct();
                    int endPage = count / 3;
                    if (count % 3 != 0) {
                        endPage++;
                    }
                    request.setAttribute("endPageS", endPage);
                    if (sort == 1) {
                        List<ProductDTO> listPaging = dao.getProductAsc(index);
                        request.setAttribute("listPaging", listPaging);
                        request.setAttribute("sort", sort);
                    } else {
                        List<ProductDTO> listPaging = dao.getProductDesc(index);
                        request.setAttribute("listPaging", listPaging);
                        request.setAttribute("sort", sort);
                    }
                }
            } else {
                if (categoryID != null) {
                    int cateId = Integer.parseInt(categoryID);
                    int count = dao.getCountByCategory(cateId);
                    int endPage = count / 3;
                    if (count % 3 != 0) {
                        endPage++;
                    }
                    request.setAttribute("endPageS", endPage);
                    List<ProductDTO> listPaging = dao.pagingProductByCategory(index, cateId);
                    request.setAttribute("listPaging", listPaging);
                    request.setAttribute("cateId", cateId);
                }
            }

            //check empty cart
            HttpSession sCart = request.getSession();
            CartDTO cart = (CartDTO) sCart.getAttribute("cart");
            if (cart == null) {
                cart = new CartDTO();
                sCart.setAttribute("cart", cart);
            }
        } catch (Exception e) {

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
