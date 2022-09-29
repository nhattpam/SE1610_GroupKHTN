/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAOImpl;
import dtos.CategoryDTO;
import dtos.ProductDTO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
@MultipartConfig
@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        try {
            String name = req.getParameter("name");
            String code = req.getParameter("code");
            String short_description = req.getParameter("short_description");
            String full_descripion = req.getParameter("full_descripion");
            float price = Float.parseFloat(req.getParameter("price"));
            int weight = Integer.parseInt(req.getParameter("weight"));
            //take img path
            Part part = req.getPart("img");
            String fileName = part.getSubmittedFileName();

            Date now = new Date();
            SimpleDateFormat x = new SimpleDateFormat();
            String createdDate = x.format(now);

            String editedDate = null;
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            CategoryDTO category_id = new CategoryDTO(Integer.parseInt(req.getParameter("category_id")));

            ProductDTO p = new ProductDTO(name, code, short_description, full_descripion, price, weight, fileName, createdDate, editedDate, category_id, quantity);

//            System.out.println(category_id.getCategory_id());
//            System.out.println(p);
            ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());

            boolean f = dao.addProduct(p);

            HttpSession session = req.getSession();

            if (f) {
                String path = getServletContext().getRealPath("") + "\\products";

//                System.out.println(path);
                File file = new File(path);

                part.write(path + File.separator + fileName);

                session.setAttribute("succMsg", "Thêm sản phẩm thành công...");
                resp.sendRedirect("addProductPage");
            } else {
                session.setAttribute("failedMsg", "Có lỗi trên hệ thống...");
                resp.sendRedirect("addProductPage");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
