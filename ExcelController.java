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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.util.CellRangeAddress;
import utils.DBUtils;

/**
 *
 * @author Administrator
 */
@WebServlet("/TestController")
public class ExcelController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
//            Merge code neu muon thu tu lan luot la firstCol, firstRow, lastCol, lastRow
//            Region region = new Region((short)0,(short)1,(short)0,(short)2);
//            Region region2 = new Region((short)0,(short)3,(short)0,(short)6);
//            Region region3 = new Region((short)0,(short)7,(short)0,(short)10);
//            sheet.addMergedRegion(region);
//            sheet.addMergedRegion(region2);
//            sheet.addMergedRegion(region3);
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
}
