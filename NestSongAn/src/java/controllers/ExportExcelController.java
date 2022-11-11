/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAOImpl;
import daos.UserDAOImpl;
import dtos.ProductDTO;
import dtos.UsersDTO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import utils.DBUtils;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "ExcelController", urlPatterns = {"/ExcelController"})
public class ExportExcelController extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        HSSFWorkbook wb = new HSSFWorkbook();
        UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());
        ProductDAOImpl daop = new ProductDAOImpl(DBUtils.getConnection());

        HSSFSheet sheet = wb.createSheet("Sheet");
        HSSFRow rowhead = sheet.createRow((short) 0);

        int i = 1;
        try {
            String action = request.getParameter("action");
            if ("Export All User to Excel".equals(action)) {
                List<UsersDTO> list = dao.getAllListUser();
                rowhead.createCell((short) 0).setCellValue("User ID");
                rowhead.createCell((short) 1).setCellValue("Full Name");
                rowhead.createCell((short) 3).setCellValue("E-mail");
                rowhead.createCell((short) 7).setCellValue("Phone");

                for (UsersDTO rs : list) {
                    HSSFRow row = sheet.createRow((short) i);
                    row.createCell((short) 0).setCellValue(Integer.toString(rs.getUser_id()));
                    row.createCell((short) 1).setCellValue(rs.getFull_name());
                    row.createCell((short) 3).setCellValue(rs.getEmail());
                    row.createCell((short) 7).setCellValue(rs.getPhone());
                    i++;
                }
                FileOutputStream fileOut = new FileOutputStream("d:/UserList.xls");
                wb.write(fileOut);
                fileOut.close();
                response.sendRedirect("manage-user");
            } else if ("Export Product to Excel".equals(action)) {
                List<ProductDTO> listProduct = daop.getAllListProduct();
                rowhead.createCell((short) 0).setCellValue("Product ID");
                rowhead.createCell((short) 1).setCellValue("Product Name");
                rowhead.createCell((short) 4).setCellValue("Code");
                rowhead.createCell((short) 5).setCellValue("Weight");
                rowhead.createCell((short) 6).setCellValue("Price");
                rowhead.createCell((short) 7).setCellValue("Create Date");
                rowhead.createCell((short) 9).setCellValue("Edit Date");
                for (ProductDTO rs : listProduct) {
                    HSSFRow row = sheet.createRow((short) i);
                    row.createCell((short) 0).setCellValue(Integer.toString(rs.getProduct_id()));
                    row.createCell((short) 1).setCellValue(rs.getName());
                    row.createCell((short) 4).setCellValue(rs.getCode());
                    row.createCell((short) 5).setCellValue(Integer.toString(rs.getWeight()));
                    row.createCell((short) 6).setCellValue(Float.toString(rs.getPrice()));
                    row.createCell((short) 7).setCellValue((rs.getCreate_date()));
                    row.createCell((short) 9).setCellValue((rs.getEdit_date()));
                    i++;
                }

                FileOutputStream fileOut = new FileOutputStream("d:/ProductList.xls");
                wb.write(fileOut);
                fileOut.close();
                response.sendRedirect("list-products");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            System.out.println(e);
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
