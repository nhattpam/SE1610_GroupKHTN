/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.FeedbackDAOImpl;
import daos.OrderDAOImpl;
import dtos.OrderDTO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DBUtils;

/**
 *
 * @author haph1
 */
public class AddFeedbackController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String oid = request.getParameter("orderid");
        int uid = Integer.parseInt(request.getParameter("uid"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        try {
            OrderDAOImpl dao = new OrderDAOImpl(DBUtils.getConnection());
            List<OrderDTO> check = dao.viewCompleOrder();
            if(!check.isEmpty()){
            String feedback = request.getParameter("feedback");
            Date now = new Date();
            SimpleDateFormat x = new SimpleDateFormat();
            String createdDate = x.format(now);
            FeedbackDAOImpl fed = new FeedbackDAOImpl(DBUtils.getConnection());
            fed.addFeedback(feedback, uid, createdDate, pid);
            response.sendRedirect("detail?product_id=" + pid);
            }else{
                request.setAttribute("feedbackE", "Bạn chỉ được đánh giá sau khi mua sản phẩm!!!");
                response.sendRedirect("order-details?order_id="+oid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
