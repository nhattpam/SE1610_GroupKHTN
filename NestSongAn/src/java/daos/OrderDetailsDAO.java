/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.OrderDetailsDTO;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface OrderDetailsDAO {
    //nhattpam: function checkout
    public void addOrderDetails(OrderDetailsDTO ods);
    
    //nhatpam: function view detail order
    public List<OrderDetailsDTO> getOrderDetails(String order_id);
}
