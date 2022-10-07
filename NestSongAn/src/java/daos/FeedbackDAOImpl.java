/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.FeedbackDTO;
import dtos.ProductDTO;
import dtos.UsersDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author haph1
 */
public class FeedbackDAOImpl implements FeedbackDAO {

    private Connection conn;
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public FeedbackDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public FeedbackDAOImpl() {
    }

    @Override
    public boolean addFeedback(String feedback, int user_id, String create_date, int product_id) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO feedback(feedback,user_id,create_date,product_id) VALUES (?,?,?,?)";
                stm = con.prepareStatement(sql);
//                stm.setString(1, fb.getFeedback());
//                stm.setInt(2, fb.getUser_id().getUser_id());
//                stm.setString(3, fb.getCreate_date());
//                stm.setInt(4, fb.getProduct_id().getProduct_id());
                stm.setString(1, feedback);
                stm.setInt(2, user_id);
                stm.setString(3, create_date);
                stm.setInt(4, product_id);
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public static void main(String[] args) {
        String feedback = "haefas";
        int uid = 9;
        int pid = 6;
        Date now = new Date();
        SimpleDateFormat x = new SimpleDateFormat();
        String createdDate = x.format(now);
        FeedbackDAOImpl fe = new FeedbackDAOImpl(DBUtils.getConnection());
        try {
            fe.addFeedback(feedback, uid, createdDate, pid);
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
