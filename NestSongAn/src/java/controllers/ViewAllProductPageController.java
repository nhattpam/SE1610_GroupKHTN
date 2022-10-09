/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAOImpl;
import dtos.CategoryDTO;
import dtos.ProductDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
@WebServlet("/shop-products")
public class ViewAllProductPageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());
        List<ProductDTO> listAllProduct = dao.getAllProduct();

        req.setAttribute("listAllProduct", listAllProduct);
        
        ProductDAOImpl dao2 = new ProductDAOImpl(DBUtils.getConnection());
        List<CategoryDTO> l = dao2.getAllCategory();

        req.setAttribute("cList", l);
        
        
        //phan trang
        ProductDAOImpl dao3 = new ProductDAOImpl(DBUtils.getConnection());
        int count = dao3.getTotalProduct();
        int endPage = count / 3; //moi trang 12 sp
        if(count % 3 != 0){
            endPage++;
        }

        //day qua shop-product
        req.setAttribute("endPage", endPage);
        //get index 
        String indexPage = req.getParameter("index");
        if(indexPage == null){
           indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        ProductDAOImpl dao4 = new ProductDAOImpl(DBUtils.getConnection());
        List<ProductDTO> listPaging = dao4.pagingProduct(index);
        req.setAttribute("listPaging", listPaging);
        

        req.getRequestDispatcher("shop_all_product.jsp").forward(req, resp);
    }

}
