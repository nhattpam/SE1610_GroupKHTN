/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.OrderDTO;
import dtos.OrderDetailsDTO;
import dtos.UserRoleDTO;
import dtos.UsersDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<OrderDTO> getAllListOrder(int user_id) {
        List<OrderDTO> list = new ArrayList<>();

        try {
            String sql = "SELECT order_id, order_date, total_price, status, delivery_address\n"
                    + "FROM [order] WHERE user_id LIKE '" + user_id + "' Order by order_date desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderDTO o = new OrderDTO();
                o.setOrder_id(rs.getString("order_id"));
                o.setOrder_date(rs.getString("order_date"));
                o.setTotal_price(rs.getFloat("total_price"));
                o.setStatus(rs.getInt("status"));
                o.setDelivery_address(rs.getString("delivery_address"));
//                UsersDTO u = new UsersDTO(rs.getInt("user_id"));
//                o.setUser_id(u);
                list.add(o);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public OrderDTO getOrderAddress(String order_id) {
        OrderDTO o = new OrderDTO();

        try {
            String sql = "SELECT delivery_address from [order] where order_id LIKE '" + order_id + "'";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                o.setDelivery_address(rs.getString("delivery_address"));
            }
        } catch (SQLException ex) {
        }
        return o;
    }
    
}
