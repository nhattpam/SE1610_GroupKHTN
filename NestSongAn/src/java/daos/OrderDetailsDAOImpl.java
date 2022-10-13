/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.OrderDTO;
import dtos.OrderDetailsDTO;
import dtos.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<OrderDetailsDTO> getOrderDetails(String order_id) {
        List<OrderDetailsDTO> list = new ArrayList<>();

        try {
            String sql = "SELECT order_details_id, quantity, total_price, product_id\n"
                    + "FROM order_details where order_id = '" + order_id + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductDTO p = new ProductDTO(rs.getInt("product_id"));
                OrderDetailsDTO od = new OrderDetailsDTO();
                od.setOrder_details_id(rs.getInt("order_details_id"));
                od.setQuantity(rs.getInt("quantity"));
                od.setTotal_price(rs.getFloat("total_price"));
                od.setProduct_id(p);
                
                list.add(od);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
