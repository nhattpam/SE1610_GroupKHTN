/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.QuantityProductDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface QuantityProductDAO {
    //get branch name
    public QuantityProductDTO getBranch(int product_id, int branch_id);
    //count product has quantity < 5
    public int getQuantityProduct();
    //sub the quantity after buy
    public QuantityProductDTO subQuantityAfterBuy(int quantity, int product_id, int branch_id);
    
     //insert into quantity_product
    public void addProductQuantity(QuantityProductDTO q);
    
    public List<QuantityProductDTO> getProduct() throws SQLException;
    
    public List<QuantityProductDTO> getProductbyquantity();
    
    public boolean importProduct(int quantity, int productID, int branchID) throws SQLException;
}
