/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.ProductDTO;

/**
 *
 * @author Admin
 */
public interface ProductDAO {
    
    //nhattpham: function add product
    public boolean addProduct(ProductDTO p);
    
}
