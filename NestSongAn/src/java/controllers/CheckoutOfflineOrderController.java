/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAOImpl;
import dtos.ProductDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
 * @author duong
 */
@WebServlet("/checkout-offline")
public class CheckoutOfflineOrderController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        String[] selected = req.getParameterValues("product");

//        req.setAttribute("listCheck", selected);
        
        ArrayList<String> aList = new ArrayList<String>(Arrays.asList(selected));
        List<ProductDTO> listP = null;
        ProductDTO p = null;
        ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());
        for (String string : aList) {
            int product_id = dao.checkProductId(string);
//            System.out.println("day la id: " + product_id);
             listP = new ArrayList<ProductDTO>();
               p = new ProductDTO();
                p.setProduct_id(product_id);
                p = dao.getProductId(product_id);
                listP.add(p);
                System.out.println("day la listP: " + listP);
                req.setAttribute("listCHECKOUT", listP); 
                HttpSession ssss = req.getSession();
                ssss.setAttribute("listCHECKOUT", listP);
                //kêu ngài peter
        }
        
        
        req.getRequestDispatcher("view/staff/checkout-offline.jsp").forward(req, resp);
    }
}
