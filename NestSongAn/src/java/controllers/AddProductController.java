/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAOImpl;
import daos.QuantityProductDAOImpl;
import dtos.BranchDTO;
import dtos.CategoryDTO;
import dtos.ProductDTO;
import dtos.QuantityProductDTO;
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
@WebServlet("/add-product")
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

            //validation
            HttpSession sessionValidate = req.getSession();
            boolean check = true;
            if (name == null || "".equals(name.trim())) {
                sessionValidate.setAttribute("wrongName", "Tên sản phẩm không được rỗng");
                check = false;
//                resp.sendRedirect("AddProductController");
            }
            if (code == null || "".equals(code.trim())) {
                sessionValidate.setAttribute("wrongCode", "Code sản phẩm không được rỗng");
                check = false;
//                resp.sendRedirect("AddProductController");
            }
            if (short_description == null || "".equals(short_description.trim())) {
                sessionValidate.setAttribute("wrongShortDes", "Mô tả sản phẩm không được rỗng");
                check = false;
//                resp.sendRedirect("AddProductController");
            }
            if (full_descripion == null || "".equals(full_descripion.trim())) {
                sessionValidate.setAttribute("wrongFullDes", "Mô tả sản phẩm không được rỗng");
                check = false;
//                resp.sendRedirect("AddProductController");
            }
            if (check) {
                ProductDTO p = new ProductDTO(name, code, short_description, full_descripion, price, weight, fileName, createdDate, editedDate, category_id, quantity);
                ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());

                boolean f = dao.addProduct(p);

                HttpSession session = req.getSession();

                if (f) {
                    String path = getServletContext().getRealPath("") + "\\products";

//                System.out.println(path);
                    File file = new File(path);

                    part.write(path + File.separator + fileName);

                    session.setAttribute("succMsg", "Thêm sản phẩm thành công...");
                    //insert into quantity_product
                    ProductDAOImpl daoCheckId = new ProductDAOImpl(DBUtils.getConnection());
                    int pid = daoCheckId.checkProductId(name);
//                    System.out.println(pid);
                    QuantityProductDAOImpl daoAdd = new QuantityProductDAOImpl(DBUtils.getConnection());
                    QuantityProductDTO q = new QuantityProductDTO();
                    ProductDTO p_id = new ProductDTO(pid);
                    BranchDTO b_id = new BranchDTO(1);
                    q.setProduct_id(p_id);
                    q.setBranch_id(b_id);
                    q.setQuantity(quantity);
                    daoAdd.addProductQuantity(q);
                    //
                    QuantityProductDTO q2 = new QuantityProductDTO();
                    ProductDTO p_id2 = new ProductDTO(pid);
                    BranchDTO b_id2 = new BranchDTO(2);
                    q2.setProduct_id(p_id2);
                    q2.setBranch_id(b_id2);
                    q2.setQuantity(quantity);
                    daoAdd.addProductQuantity(q2);
                    //
                    QuantityProductDTO q3 = new QuantityProductDTO();
                    ProductDTO p_id3 = new ProductDTO(pid);
                    BranchDTO b_id3 = new BranchDTO(3);
                    q3.setProduct_id(p_id3);
                    q3.setBranch_id(b_id3);
                    q3.setQuantity(quantity);
                    daoAdd.addProductQuantity(q3);
                    //
                    //insert into quantity_product
                    resp.sendRedirect("add-product");
                } else {
                    session.setAttribute("failedMsg", "Có lỗi trên hệ thống...");
                    resp.sendRedirect("add-product");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resp.sendRedirect("add-product");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/staff/add_product.jsp").forward(req, resp);
    }

}
