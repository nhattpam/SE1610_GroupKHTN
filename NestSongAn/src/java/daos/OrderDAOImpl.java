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
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class OrderDAOImpl implements OrderDAO {

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
                    UsersDTO user = new UsersDTO(rs.getInt(8), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
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

    @Override
    public OrderDTO getOderdetail(String order_id) {
        OrderDTO o = new OrderDTO();

        try {
            String sql = "SELECT delivery_address, payment_method from [order] where order_id LIKE ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, order_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                o.setDelivery_address(rs.getString("delivery_address"));
                o.setPayment_method(rs.getString("payment_method"));
            }
        } catch (SQLException ex) {
        }
        return o;
    }

    @Override
    public void editOrderStatus(String order_id, int index) {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE [order]\n"
                        + "SET [status]=?\n"
                        + "WHERE order_id LIKE ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, index);
                ps.setString(2, order_id);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Minh Thanh
    @Override
    public List<OrderDTO> viewOrderList() throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrderDTO> result = new ArrayList<>();
        
        OrderDTO o = null;
        UsersDTO u = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT u.full_name,u.phone,\n"
                        + "       o.delivery_address, o.total_price\n"
                        + "      ,o.status,o.order_id\n"
                        + "FROM  users u inner join [order] o on u.user_id = o.user_id\n"
                        + "WHERE o.status = 2";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    u = new UsersDTO();
                    u.setFull_name(rs.getString(1));
                    u.setPhone(rs.getString(2));
                    float total_price = rs.getFloat(4);
                    String delivery_address = rs.getString(3);
                    int status = rs.getInt(5);
                    String order_id = rs.getString(6);
                    OrderDTO odr = new OrderDTO(order_id, delivery_address, total_price, status, u);
                    result.add(odr);
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
}
