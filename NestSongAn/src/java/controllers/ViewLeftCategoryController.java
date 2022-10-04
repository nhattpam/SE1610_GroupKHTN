/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAOImpl;
import dtos.CategoryDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
@WebServlet("/left-category")
public class ViewLeftCategoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());
        List<CategoryDTO> cList = dao.getAllCategory();

        req.setAttribute("cList", cList);

//        req.getRequestDispatcher("category.jsp").forward(req, resp);
        RequestDispatcher view = req.getRequestDispatcher("/category.jsp");
        view.include(req, resp);
        

    }

}
