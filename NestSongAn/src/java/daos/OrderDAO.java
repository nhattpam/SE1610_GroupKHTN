/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

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
    //hapham: function veiw user of order
    public List<OrderDTO> viewUserOrder() throws SQLException;
}
