/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dtos.UsersDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet("/cach-bao-quan-yen-tuoi")
public class TipSongAn3Controller extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sCheckk = req.getSession();
        if (sCheckk.getAttribute("USER") == null) {
            req.getRequestDispatcher("cam-nang-song-an/cach-bao-quan-yen-tuoi.jsp").forward(req, resp);
        } else {
            //redirect if not customer
            HttpSession sessionn = req.getSession();
            UsersDTO uu = (UsersDTO) sessionn.getAttribute("USER");
//            System.out.println("DDya la: " + uu.getRole_id().getRole());
            if (uu.getRole_id().getRole().equals("staff")) {
                resp.sendRedirect("staff-dashboard");
            }
            if (uu.getRole_id().getRole().equals("admin")) {
                resp.sendRedirect("admin-dashboard");
            }
            if (uu.getRole_id().getRole().equals("supplier")) {
                resp.sendRedirect("ViewProductSupplierController");
            }
            if (uu.getRole_id().getRole().equals("shipper")) {
                resp.sendRedirect("shipper-dashboard");
            }if (uu.getRole_id().getRole().equals("customer")) {
                req.getRequestDispatcher("cam-nang-song-an/cach-bao-quan-yen-tuoi.jsp").forward(req, resp);
            }
        }
        
    }
    
}
