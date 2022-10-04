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
@WebServlet("/editProduct")
public class EditProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            int id = (request.getParameter("product_id") != null ? Integer.parseInt(request.getParameter("product_id")) : 0);

            System.out.println(id);
            String name = request.getParameter("name");
            String code = request.getParameter("code");
            String short_description = request.getParameter("short_description");
            String full_descripion = request.getParameter("full_descripion");
            float price = Float.parseFloat(request.getParameter("price"));
            int weight = Integer.parseInt(request.getParameter("weight"));
            //take img path
            Part part = request.getPart("img");
            String fileName = part.getSubmittedFileName();
            Date now = new Date();
            SimpleDateFormat x = new SimpleDateFormat();
            String editedDate = x.format(now);

            CategoryDTO category_id = new CategoryDTO(Integer.parseInt(request.getParameter("category_id")));

//            ProductDTO product = new ProductDTO(id, name, code, short_description, full_descripion, price, weight, code, editedDate, category_id);
            ProductDTO product = new ProductDTO();
            product.setProduct_id(id);
            product.setName(name);
            product.setCode(code);
            product.setShort_description(short_description);
            product.setFull_description(full_descripion);
            product.setPrice(price);
            product.setWeight(weight);
            product.setEdit_date(editedDate);
            product.setCategory_id(category_id);
            product.setPhoto(fileName);

            //validation
            HttpSession sessionValidate = request.getSession();
            boolean check = true;
            if (name == null || "".equals(name.trim())) {
                sessionValidate.setAttribute("wrongName", "Tên sản phẩm không được rỗng");
                check = false;
            }
            if (code == null || "".equals(code.trim())) {
                sessionValidate.setAttribute("wrongCode", "Code sản phẩm không được rỗng");
                check = false;
            }
            if (short_description == null || "".equals(short_description.trim())) {
                sessionValidate.setAttribute("wrongShortDes", "Mô tả sản phẩm không được rỗng");
                check = false;
            }
            if (full_descripion == null || "".equals(full_descripion.trim())) {
                sessionValidate.setAttribute("wrongFullDes", "Mô tả sản phẩm không được rỗng");
                check = false;
            }

            if (check) {
                HttpSession session = request.getSession();
                ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());
                boolean f = dao.editProduct(product);
                if (f) {
                    String path = getServletContext().getRealPath("") + "\\products";

                    System.out.println(path);
                    File file = new File(path);

                    part.write(path + File.separator + fileName);
                    response.sendRedirect("list-products");
                    System.out.println("ok");
                } else {
                    session.setAttribute("failedMsg", "Có lỗi trên hệ thống");
                    response.sendRedirect("list-products");
                    System.out.println("fail");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            response.sendRedirect("edit-page?product_id=" + request.getParameter("product_id"));
        }
    }

}
