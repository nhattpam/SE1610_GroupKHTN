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
@WebServlet("/yen-hu")
public class ViewCategory1Controller extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //category
        ProductDAOImpl dao2 = new ProductDAOImpl(DBUtils.getConnection());
        List<CategoryDTO> l = dao2.getAllCategory();

        req.setAttribute("cList", l);
        
        //phan trang
        
        ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());
        int count = dao.getTotalProductByCategory1();
        int endPage = count / 3; //moi trang 12 sp
        if (count % 3 != 0) {
            endPage++;
        }
        
        req.setAttribute("endPage", endPage);
        
        String indexPage = req.getParameter("index");
        if(indexPage == null){
           indexPage = "1";
        }
        
        int index = Integer.parseInt(indexPage);
        ProductDAOImpl dao4 = new ProductDAOImpl(DBUtils.getConnection());
        List<ProductDTO> listPaging = dao4.pagingProductByCategory(index, 1);
        req.setAttribute("listPaging", listPaging);
        
        //check empty cart
        HttpSession sCart = req.getSession();
        CartDTO cart = (CartDTO) sCart.getAttribute("cart");
        if (cart == null) {
            cart = new CartDTO();
            sCart.setAttribute("cart", cart);
        }
        
        
        req.getRequestDispatcher("category/yen-hu.jsp").forward(req, resp);
    }
    
}
