/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.OrderDTO;
import dtos.UsersDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class OrderDAOImpl implements OrderDAO{
    private Connection conn;

    public OrderDAOImpl(Connection conn) {
        this.conn = conn;
    }

     //nhattpam: function checkout
    @Override
    public void addOrder(OrderDTO od) {
        String sql = "INSERT INTO [order] (order_id,user_id,delivery_address,payment_method,order_date,total_price,status) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, od.getOrder_id());
            ps.setInt(2, od.getUser_id().getUser_id());
            ps.setString(3, od.getDelivery_address());
            ps.setString(4, od.getPayment_method());
            ps.setString(5, od.getOrder_date());
            ps.setFloat(6, od.getTotal_price());
            ps.setInt(7, od.getStatus());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public List<OrderDTO> viewUserOrder() throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrderDTO> result = new ArrayList<>();
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT u.full_name, u.user_name, u.email, u.phone, o.order_date, o.status, o.order_id, o.user_id\n"
                        + "FROM [order] o inner join users u on o.user_id = u.user_id";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    UsersDTO user = new UsersDTO(rs.getInt(8),rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                    String orderid = rs.getString(7);
                    int status = rs.getInt(6);
                    String order_date = rs.getString(5);
                    OrderDTO uoder = new OrderDTO(orderid, order_date, status, user);
                    result.add(uoder);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    public static void main(String[] args){
        try {
            OrderDAOImpl od = new OrderDAOImpl(DBUtils.getConnection());
            List<OrderDTO> o = od.viewUserOrder();
            for (OrderDTO orderDTO : o) {
                System.out.println(orderDTO.getUser_id().getUser_name()+", "+orderDTO.getUser_id().getFull_name()+", "+
                        orderDTO.getUser_id().getPhone()+", "+orderDTO.getUser_id().getEmail()+", "+ orderDTO.getOrder_date());
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
