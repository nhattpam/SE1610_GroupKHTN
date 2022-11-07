/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.LocationDTO;
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

    //addOrderOffline
    public void addOrderOffline(OrderDTO od) {
        String sql = "INSERT INTO [order] (order_id,user_id,delivery_address,payment_method,order_date,total_price,status,note,location_id,delivery_date) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//            LocationDTO
            ps.setString(1, od.getOrder_id());
            ps.setInt(2, od.getUser_id().getUser_id());
            ps.setString(3, od.getDelivery_address());
            ps.setString(4, od.getPayment_method());
            ps.setString(5, od.getOrder_date());
            ps.setFloat(6, od.getTotal_price());
            ps.setInt(7, od.getStatus());
            ps.setString(8, od.getNote());
            ps.setInt(9, od.getLocation_id().getLocation_id());
            ps.setString(10, od.getDelivery_date());

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
                String sql = "SELECT u.full_name, u.user_name, u.email, u.phone, o.order_date, o.status, o.order_id, o.user_id,o.location_id\n"
                        + "FROM [order] o inner join users u on o.user_id = u.user_id\n"
                        + "Order by o.order_id DESC";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    LocationDTO location = new LocationDTO(rs.getInt(9));
                    UsersDTO user = new UsersDTO(rs.getInt(8), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                    String orderid = rs.getString(7);
                    int status = rs.getInt(6);
                    String order_date = rs.getString(5);
                    OrderDTO uoder = new OrderDTO(orderid, order_date, status, user, location);
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

    //edit shipper id
    @Override
    public void editShipperid(String order_id, int index) {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE [order]\n"
                        + "SET [shipper_id]=?\n"
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

    public void editDeliveryDay(String order_id, String index) {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE [order]\n"
                        + "SET [delivery_date]=?\n"
                        + "WHERE order_id LIKE ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, index);
                ps.setString(2, order_id);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
// edit order status

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

    @Override
    public List<OrderDTO> viewOrderDeliveryList(int index) throws SQLException {
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
                        + "WHERE o.status = 6 and o.shipper_id = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, index);
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
//Minh Thanh

    @Override
    public List<OrderDTO> viewOrderList() throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrderDTO> result = new ArrayList<>();

        OrderDTO o = null;
        UsersDTO u = null;
        LocationDTO l = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT u.full_name,u.phone,o.delivery_address, o.total_price,o.status,o.order_id, l.name\n"
                        + "                        FROM  users u inner join [order] o on u.user_id = o.user_id\n"
                        + "										inner join location l on l.location_id = o.location_id\n"
                        + "                        WHERE o.status = 2";
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
                    l = new LocationDTO();
                    l.setName(rs.getString(7));
                    OrderDTO odr = new OrderDTO(order_id, delivery_address, total_price, status, u,l);
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

    //income
    @Override
    public float viewIncome() {
        try {
            String sql = "SELECT SUM(total_price) AS income\n"
                    + "FROM [order]\n"
                    + "WHERE status = 3 ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getFloat(1);
            }

        } catch (Exception e) {
        }
        return 0;

    }

    @Override
    //khang tran: function view list order deliverired
    public List<OrderDTO> vỉewDeliveriedOrders() {
        List<OrderDTO> list = new ArrayList<>();
        LocationDTO lo = null;
        try {
            String sql = "SELECT o.order_id, o.delivery_address,\n"
                    + " o.order_date, o.delivery_date,\n"
                    + " o.total_price, o.user_id, l.name\n"
                    + "FROM [order] o INNER JOIN location l\n"
                    + "ON o.location_id = l.location_id\n"
                    + "WHERE status = 3";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderDTO o = new OrderDTO();
                o.setOrder_id(rs.getString("order_id"));
                o.setDelivery_address(rs.getString("delivery_address"));
                o.setOrder_date(rs.getString("order_date"));
                o.setDelivery_date(rs.getString("delivery_date"));
                o.setTotal_price(rs.getFloat("total_price"));
                UsersDTO u = new UsersDTO();
                u.setUser_id(rs.getInt("user_id"));
                o.setUser_id(u);
                lo = new LocationDTO();
                lo.setName(rs.getString("name"));
                o.setLocation_id(lo);
                list.add(o);

            }

        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public void editLocationOrder(String order_id, int index) {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE [order] SET location_id = ? WHERE order_id LIKE ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, index);
                ps.setString(2, order_id);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<LocationDTO> getLocation() {
        List<LocationDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT location_id, name FROM location";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    LocationDTO loate = new LocationDTO(rs.getInt("location_id"), rs.getString("name"));
                    list.add(loate);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int getLocation(int location_id) {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT location_id FROM location WHERE location_id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, location_id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt("location_id");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public List<OrderDTO> viewCompleOrder() throws SQLException {
        List<OrderDTO> result = new ArrayList<>();
        OrderDTO o = null;
        UsersDTO u = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT u.full_name, u.phone, \n"
                        + " o.delivery_address, o.total_price\n"
                        + ",o.status,o.order_id\n"
                        + "FROM users u inner join [order] o on u.user_id = o.user_id\n"
                        + "WHERE o.status = 3";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    u = new UsersDTO();
                    u.setFull_name(rs.getString(1));
                    u.setPhone(rs.getString(2));
                    float total_price = rs.getFloat(4);
                    String delivery_address = rs.getString(3);
                    int status = rs.getInt(5);
                    String order_id = rs.getString(6);
                    OrderDTO od = new OrderDTO(order_id, delivery_address, total_price, status, u);
                    result.add(od);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int getTotalDeliveryByStatus(int status) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 0;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select COUNT(*) as number\n"
                        + "from [order]\n"
                        + "where status=? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, status);                
                rs = stm.executeQuery();
                while (rs.next()) {
                    result = rs.getInt("number");
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

    public OrderDAOImpl() {
    }

    @Override
    public float GetOrderTotalPrice(String order_id) {
        String sql = "SELECT total_price FROM [order] where order_id = '" + order_id + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getFloat(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    @Override//status = 3
    public int getCountSuccOrder() {
        String sql = "SELECT COUNT(*) as sp\n"
                + "FROM [order]\n"
                + "where status = 3";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //return ve ket qua int (boi vi no chi tra ve 1 so nguyen)
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0; //neu khong co ket qua thi tra ve 0
    }

    @Override
    public int getCountFailOrder() {//status = 5
        String sql = "SELECT COUNT(*) as sp\n"
                + "FROM [order]\n"
                + "where status = 5";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //return ve ket qua int (boi vi no chi tra ve 1 so nguyen)
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0; //neu khong co ket qua thi tra ve 0
    }

    @Override
    public int getPendingOrder() {//status = 2

        String sql = "SELECT COUNT(*) as sp\n"
                + "FROM [order]\n"
                + "where status = 2";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //return ve ket qua int (boi vi no chi tra ve 1 so nguyen)
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0; //neu khong co ket qua thi tra ve 0
    }

}
