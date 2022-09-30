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
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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

    private static final String ADD_PRODUCT_PAGE = "addProductPage";

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
            HttpSession session = req.getSession();
            boolean check = true;
            if (name == null || "".equals(name.trim())) {
                session.setAttribute("wrongName", "Tên sản phẩm không được rỗng");
                check = false;
//                resp.sendRedirect("AddProductController");
            }
            if (code == null || "".equals(code.trim())) {
                session.setAttribute("wrongCode", "Code sản phẩm không được rỗng");
                check = false;
//                resp.sendRedirect("AddProductController");
            }
            if (short_description == null || "".equals(short_description.trim())) {
                session.setAttribute("wrongShortDes", "Mô tả sản phẩm không được rỗng");
                check = false;
//                resp.sendRedirect("AddProductController");
            }
            if (full_descripion == null || "".equals(full_descripion.trim())) {
                session.setAttribute("wrongFullDes", "Mô tả sản phẩm không được rỗng");
                check = false;
//                resp.sendRedirect("AddProductController");
            }
            if (check) {
                ProductDTO p = new ProductDTO(name, code, short_description, full_descripion, price, weight, fileName, createdDate, editedDate, category_id, quantity);
                ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());

                boolean f = dao.addProduct(p);

                if (f) {
                    String path = getServletContext().getRealPath("") + "\\products";

//                System.out.println(path);
                    File file = new File(path);

                    part.write(path + File.separator + fileName);

                    session.setAttribute("succMsg", "Thêm sản phẩm thành công...");
                }
            } else {
                session.setAttribute("failedMsg", "Có lỗi trên hệ thống...");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RequestDispatcher rd = req.getRequestDispatcher(ADD_PRODUCT_PAGE);
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        req.getRequestDispatcher(siteMaps.getProperty(ADD_PRODUCT_PAGE)).forward(req, resp);
    }

}
