
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.FeedbackDAOImpl;
import daos.OrderDAOImpl;
import daos.UserDAOImpl;
import dtos.OrderDTO;
import dtos.UsersDTO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DBUtils;

/**
 *
 * @author haph1
 */
@WebServlet("/feedbackgg")
public class AddFeedbackGGController extends HttpServlet{
  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        request.setCharacterEncoding("utf-8");
//        String oid = (String) request.getAttribute("oid");
//        HttpSession session = request.getSession();
//        int uid = (int) session.getAttribute("usergg");
//        int pid = (int) request.getAttribute("pid");

        String oid = request.getParameter("oid");
        
        int uid = Integer.parseInt(request.getParameter("uid"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        HttpSession sessionValidate = request.getSession();
        try {

            OrderDAOImpl dao = new OrderDAOImpl(DBUtils.getConnection());
            List<OrderDTO> check = dao.viewCompleOrder();
            if (!check.isEmpty()) {
                String feedback = request.getParameter("feedback");
                boolean f = true;
                if (feedback == null || feedback == "") {
                    sessionValidate.setAttribute("feedbackError", "Không được để trống!!!");
                    f = false;
                    response.sendRedirect("feedback?p=" + pid + "&u=" + uid + "&o=" + oid);
                }
                if (f) {
                    Date now = new Date();
                    SimpleDateFormat x = new SimpleDateFormat();
                    String createdDate = x.format(now);
                    FeedbackDAOImpl fed = new FeedbackDAOImpl(DBUtils.getConnection());
                    fed.addFeedback(feedback, uid, createdDate, pid);
                    response.sendRedirect("detail?product_id=" + pid);
                }else{
                    System.out.println("Khum be oi");
                }
            }else{
                System.out.println("Hong be oi");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}