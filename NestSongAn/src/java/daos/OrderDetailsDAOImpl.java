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

    public static void main(String[] args) {
        try {
            OrderDAOImpl od = new OrderDAOImpl(DBUtils.getConnection());
            List<OrderDTO> o = od.viewUserOrder();
            for (OrderDTO orderDTO : o) {
                System.out.println(orderDTO.getUser_id().getUser_name() + ", " + orderDTO.getUser_id().getFull_name() + ", "
                        + orderDTO.getUser_id().getPhone() + ", " + orderDTO.getUser_id().getEmail());
                System.out.println("--------------");
                OrderDetailsDAOImpl dao = new OrderDetailsDAOImpl(DBUtils.getConnection());
                List<OrderDetailsDTO> oda = dao.viewOrderDetails(orderDTO.getOrder_id());
                for (OrderDetailsDTO orderDetailsDTO : oda) {
                    System.out.println(orderDetailsDTO.getProduct_id().getName()+", "+orderDetailsDTO.getOrder_id().getDelivery_address()+", "+orderDetailsDTO.getOrder_id().getPayment_method()
                    +", "+ orderDetailsDTO.getQuantity()+", "+ orderDetailsDTO.getTotal_price());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
