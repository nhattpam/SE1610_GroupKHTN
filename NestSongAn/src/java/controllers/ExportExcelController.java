/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAOImpl;
import dtos.UsersDTO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
        response.setContentType("appication/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=UserList.xls");

        String filePath = "d:/UserList.xls";
        File myFile = new File(filePath);
        HSSFWorkbook wb = new HSSFWorkbook();
        UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());
        try {
            List<UsersDTO> list = dao.getUserList();
            HSSFSheet sheet = wb.createSheet("new sheet");
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell((short) 0).setCellValue("User ID");
            rowhead.createCell((short) 1).setCellValue("Full Name");
            rowhead.createCell((short) 3).setCellValue("E-mail");
            rowhead.createCell((short) 7).setCellValue("Phone");
            int i = 1;
            for (UsersDTO rs : list) {
                HSSFRow row = sheet.createRow((short) i);
                row.createCell((short) 0).setCellValue(Integer.toString(rs.getUser_id()));
                row.createCell((short) 1).setCellValue(rs.getFull_name());
                row.createCell((short) 3).setCellValue(rs.getEmail());
                row.createCell((short) 7).setCellValue(rs.getPhone());
                i++;
            }
            FileOutputStream fileOut = new FileOutputStream(myFile);
            wb.write(fileOut);
            fileOut.close();
            return;
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
