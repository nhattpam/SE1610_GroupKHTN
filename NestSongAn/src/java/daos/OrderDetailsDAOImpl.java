/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.OrderDetailsDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Admin
 */
public class OrderDetailsDAOImpl implements OrderDetailsDAO{
    
    private Connection conn;

    public OrderDetailsDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addOrderDetails(OrderDetailsDTO ods) {
        String sql = "INSERT INTO order_details (order_id,product_id,total_price,quantity) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(2, ods.getProduct_id().getProduct_id());
            ps.setFloat(3, ods.getTotal_price());
            ps.setString(1, ods.getOrder_id().getOrder_id());
            ps.setInt(4, ods.getQuantity());
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
