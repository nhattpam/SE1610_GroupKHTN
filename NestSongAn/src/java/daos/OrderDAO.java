/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.LocationDTO;
import dtos.OrderDTO;
import dtos.UsersDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface OrderDAO {
    
   //nhattpam: function checkout
    public void addOrder(OrderDTO od);
    
    //nhatpam: function view order list
    public List<OrderDTO> getAllListOrder(int user_id);
    //hapham: function view address and payment method
    public OrderDTO getOderdetail(String order_id);
    //get address
    public OrderDTO getOrderAddress(String order_id);
    //hapham: function veiw user of order
    public List<OrderDTO> viewUserOrder() throws SQLException;
    //hapham: function edit order status
    public void editOrderStatus(String order_id, int index);
    //hapham: function edit order location
    public void editLocationOrder(String order_id, int index);
    public List<LocationDTO> getLocation();
    public int getLocation(int location_id);
    public List<OrderDTO> viewOrderList() throws SQLException;
    
    //khang tran: function view list order deliverired
    public List<OrderDTO> vỉewDeliveriedOrders();
    //Hung: get number of order base on status and current month
    public int getTotalDeliveryByStatus(int status, String currentMonth) throws SQLException;
    
    //khang tran: sort order status
    //number of succes order (ship)
    public int getCountSuccOrder();
    
    public int getCountFailOrder();
    
    public int getPendingOrder();
}
