/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.OrderDTO;
import dtos.OrderDetailsDTO;
import dtos.ProductDTO;
import dtos.UsersDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
public class OrderDetailsDAOImpl implements OrderDetailsDAO {

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
            String sql = "SELECT od.order_details_id, od.quantity, od.total_price, p.name\n"
                    + " FROM order_details od INNER JOIN product p \n"
                    + " ON od.product_id = p.product_id\n"
                    + " where od.order_id like '" + order_id + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductDTO p = new ProductDTO(rs.getString("name"));
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

    public List<OrderDetailsDTO> viewOrderDetails(String order_id) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrderDetailsDTO> result = new ArrayList<>();
        ProductDTO pro = null;
        OrderDTO o = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT p.name, od.quantity, od.total_price, o.delivery_address, o.payment_method, od.order_details_id, od.order_id, od.product_id\n"
                        + "FROM order_details od inner join product p on od.product_id = p.product_id\n"
                        + "					  inner join [order] o on od.order_id = o.order_id\n"
                        + "WHERE o.order_id = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, order_id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    pro = new ProductDTO();
                    pro.setName(rs.getString(1));
                    o = new OrderDTO();
                    o.setOrder_id(order_id);
                    o.setDelivery_address(rs.getString(4));
                    o.setPayment_method(rs.getString(5));
                    int quantity = rs.getInt(2);
                    float total_price = rs.getFloat(3);
                    int order_details_id = rs.getInt(6);
                    int product_id = rs.getInt(8);
                    OrderDetailsDTO ord = new OrderDetailsDTO(order_details_id, quantity, total_price, pro, o);
                    result.add(ord);
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
    //hot selling
    public List<OrderDetailsDTO> viewHotSelling(){
        List<OrderDetailsDTO> list = new ArrayList<>();
        OrderDetailsDTO od = null;
        ProductDTO p = null;
        try {
            String sql = "SELECT o.product_id,p.code,p.photo, p.name, p.price , COUNT(o.product_id) AS HotSelling \n"
                    + "FROM order_details o INNER JOIN product p\n"
                    + "ON o.product_id = p.product_id\n"
                    + "GROUP BY o.product_id,p.code, p.photo, p.name, p.price\n"
                    + "HAVING COUNT(o.product_id) > 5\n"
                    + "";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                od = new OrderDetailsDTO();
                p = new ProductDTO();
                p.setCode(rs.getString("code"));
                p.setProduct_id(rs.getInt("product_id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getFloat("price"));
                p.setPhoto(rs.getString("photo"));
                od.setProduct_id(p);
                list.add(od);
            }
        } catch (Exception e) {
        }
        return list;
    }

    

}
