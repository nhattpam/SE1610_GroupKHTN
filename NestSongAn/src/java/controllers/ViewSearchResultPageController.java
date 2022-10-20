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
import java.util.List;
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
 * @author Admin
 */
@WebServlet("/search-result")
public class ViewSearchResultPageController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        ProductDAOImpl searchDAO = new ProductDAOImpl(DBUtils.getConnection());
        
        //get character tu nguoi dung
        String character = req.getParameter("character");
        
        System.out.println(character);
        
        List<ProductDTO> listSearch = searchDAO.getProductBySearch(character);
        if(!listSearch.isEmpty() && !character.equals("")){

            req.setAttribute("listSearch", listSearch);

        }else{
        //in
        session.setAttribute("wrongSearch", "Không tìm thấy kết quả!");
        }
        //hien thi category
        ProductDAOImpl categoryDAO = new ProductDAOImpl(DBUtils.getConnection());
        List<CategoryDTO> listCategory = categoryDAO.getAllCategory();
        
        req.setAttribute("CList", listCategory); //ban qua search.jsp
        
        //check empty cart
        HttpSession sCart = req.getSession();
        CartDTO cart = (CartDTO) sCart.getAttribute("cart");
        if (cart == null) {
            cart = new CartDTO();
            sCart.setAttribute("cart", cart);
        }
        System.out.println(cart);
        
        req.getRequestDispatcher("search.jsp").forward(req, resp);
        
    }
    
}
