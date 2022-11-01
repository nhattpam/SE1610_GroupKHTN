/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.QuantityProductDTO;

/**
 *
 * @author Admin
 */
public interface QuantityProductDAO {
    //get branch name
    public QuantityProductDTO getBranch(int product_id, int branch_id);
    //get product has quantity < 5

   
    //count product has quantity < 5
    public int getQuantityProduct();
    //sub the quantity after buy
    public QuantityProductDTO subQuantityAfterBuy(int quantity, int product_id, int branch_id);
    
     //insert into quantity_product
    public void addProductQuantity(QuantityProductDTO q);
}
