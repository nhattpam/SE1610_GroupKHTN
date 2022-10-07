/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.ProductDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProductDAO {
    
    //nhattpham: function add product
    public boolean addProduct(ProductDTO p);
    //hapham: function delete product
    public void deleteProduct(int pid) throws SQLException;
    
    //quoc khang: function View All Product List
    public List<ProductDTO> getAllProduct();
    
    //nhattpam: get ma sp de add to cart
    public ProductDTO getProductId(int product_id);
    
    //nhatpam: get tat ca san pham cho viec edit product
     public List<ProductDTO> getAllListProduct();
}