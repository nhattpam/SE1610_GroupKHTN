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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    @Override
    public List<FeedbackDTO> viewAllfeedback() {
        List<FeedbackDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT feedback_id,feedback,u.user_name,u.user_id,fb.create_date,product_id FROM feedback fb inner join users u on fb.user_id = u.user_id\n"
                        + "Order by feedback_id DESC";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    UsersDTO user = new UsersDTO();
                    user.setUser_id(rs.getInt(4));
                    user.setUser_name(rs.getString(3));
                    ProductDTO pro = new ProductDTO(rs.getInt("product_id"));
                    FeedbackDTO fe = new FeedbackDTO(rs.getInt("feedback_id"), rs.getString("feedback"), user, rs.getString("create_date"), pro);
                    list.add(fe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<FeedbackDTO> pagingFeedback(int index) {
        List<FeedbackDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT feedback_id,feedback,u.user_name,u.user_id,fb.create_date,product_id FROM feedback fb inner join users u on fb.user_id = u.user_id\n"
                        + "Order by feedback_id DESC\n"
                        + "OFFSET ? ROWS FETCH NEXT 2 ROWS ONLY";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, (index - 1) * 2);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    UsersDTO user = new UsersDTO();
                    user.setUser_id(rs.getInt(4));
                    user.setUser_name(rs.getString(3));
                    ProductDTO pro = new ProductDTO(rs.getInt("product_id"));
                    FeedbackDTO fe = new FeedbackDTO(rs.getInt("feedback_id"), rs.getString("feedback"), user, rs.getString("create_date"), pro);
                    list.add(fe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int getTotalFeedback() {
        String sql = "SELECT COUNT (feedback_id) from feedback";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public List<FeedbackDTO> viewFeedbackProduct(int product_id) {
         List<FeedbackDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT feedback_id,feedback,u.full_name,u.user_id,fb.create_date,product_id FROM feedback fb inner join users u on fb.user_id = u.user_id\n"
                        +"WHERE product_id = ?\n"
                        + "Order by feedback_id DESC\n";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, product_id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    UsersDTO user = new UsersDTO();
                    user.setUser_id(rs.getInt(4));
                    user.setFull_name(rs.getString(3));
                    ProductDTO pro = new ProductDTO(rs.getInt("product_id"));
                    FeedbackDTO fe = new FeedbackDTO(rs.getInt("feedback_id"), rs.getString("feedback"), user, rs.getString(5), pro);
                    list.add(fe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
