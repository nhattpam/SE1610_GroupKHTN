/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainf;

import daos.FeedbackDAOImpl;
import daos.OrderDAOImpl;
import daos.OrderDetailsDAOImpl;
import daos.ProductDAOImpl;
import daos.UserDAOImpl;
import dtos.CategoryDTO;
import dtos.FeedbackDTO;
import dtos.OrderDTO;
import dtos.OrderDetailsDTO;
import dtos.ProductDTO;
import dtos.UsersDTO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class test {

    public static void main(String[] args) throws SQLException {
        ProductDAOImpl pdao = new ProductDAOImpl(DBUtils.getConnection());
        List<ProductDTO> plist = pdao.viewPopularProduct();
        for (ProductDTO productDTO : plist) {
            System.out.println(productDTO.getPhoto());
        }
       UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());
        FeedbackDAOImpl fedao = new FeedbackDAOImpl();
        List<FeedbackDTO> list = fedao.viewAllfeedback();
        List<FeedbackDTO> list1 = fedao.pagingFeedback(2);
        int i = fedao.getTotalFeedback();
       UsersDTO u = dao.viewAccountStaff(4);
       String order_id = "1665556079080";
//       
//        System.out.println(u.getEmail() + ", id: " + u.getUser_id() + ", " + u.getPassword());
        OrderDAOImpl oda = new OrderDAOImpl(DBUtils.getConnection());
        OrderDTO o = oda.getOderdetail(order_id);
//        System.out.println(o.getDelivery_address()+", "+o.getPayment_method());
        for (FeedbackDTO feedbackDTO : list) {
            System.out.println(feedbackDTO.getFeedback_id()+", "+feedbackDTO.getUser_id().getUser_name()+", "+feedbackDTO.getFeedback()+", "+feedbackDTO.getCreate_date()+
                    ", "+feedbackDTO.getProduct_id().getProduct_id()+", "+feedbackDTO.getUser_id().getUser_id());
        }
        for (FeedbackDTO feedbackDTO : list1) {
            System.out.println(feedbackDTO.getFeedback_id()+", "+feedbackDTO.getUser_id().getUser_name()+", "+feedbackDTO.getFeedback()+", "+feedbackDTO.getCreate_date()+
                    ", "+feedbackDTO.getProduct_id().getProduct_id()+", "+feedbackDTO.getUser_id().getUser_id());
        }
        System.out.println(i);
    }
}
