/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.OrderDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
}
