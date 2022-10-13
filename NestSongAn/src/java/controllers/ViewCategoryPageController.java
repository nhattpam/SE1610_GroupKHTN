/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet("/danh-muc")
public class ViewCategoryPageController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int cateId = Integer.parseInt(req.getParameter("cateId"));
        if(cateId == 1){
            req.setAttribute("cateId", cateId);
            resp.sendRedirect("yen-hu");
        } else if(cateId == 2){
            resp.sendRedirect("yen-tinh-che");
        } else if(cateId == 3){
            resp.sendRedirect("yen-tuoi");
        } else if(cateId == 4){
            resp.sendRedirect("yen-tho-con-long");
        } else if(cateId == 5){
            resp.sendRedirect("chan-to-yen");
        } else if(cateId == 6){
            resp.sendRedirect("nuoc-yen");
        } else if(cateId == 7){
            resp.sendRedirect("to-yen-huyet");
        } else if(cateId == 8){
            resp.sendRedirect("to-yen-hong");
        }
        
//        System.out.println(cateId);
    }
    
}
