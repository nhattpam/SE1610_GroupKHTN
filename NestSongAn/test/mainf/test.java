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
import daos.QuantityProductDAOImpl;
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
          UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());
          int product_id = 19;
          FeedbackDAOImpl fedao = new FeedbackDAOImpl(DBUtils.getConnection());
        List<FeedbackDTO> felist = fedao.viewFeedbackProduct(product_id);
        for (FeedbackDTO feedbackDTO : felist) {
            System.out.println(feedbackDTO.getFeedback());
        }
        List<UsersDTO> listFullStaff = dao.getStaffList();
        System.out.println(listFullStaff);
    }
}
