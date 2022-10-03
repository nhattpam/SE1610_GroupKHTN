/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.ProductDTO;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProductDAO {
    
    //nhattpham: function add product
    public boolean addProduct(ProductDTO p);
    
    
    //quoc khang: function View All Product List
    public List<ProductDTO> getAllProduct();
<<<<<<< Updated upstream
=======
    
    //nhattpam: get ma sp de add to cart
    public ProductDTO getProductId(int product_id);
    
    //nhatpam: get tat ca san pham cho viec edit product
     public List<ProductDTO> getAllListProduct();
     
     //nhatpam:  edit product
     public boolean editProduct(ProductDTO p);
     
     public ProductDTO getProductIdForEdit(int product_id);
     
>>>>>>> Stashed changes
}
