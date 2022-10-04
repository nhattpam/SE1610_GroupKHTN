/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.CategoryDTO;
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
    
    //nhattpam: get ma sp de add to cart
    public ProductDTO getProductId(int product_id);
    
    //nhatpam: function View all product (staff)
     public List<ProductDTO> getAllListProduct();
     
     //nhatpham: function edit product
    public boolean editProduct(ProductDTO p);
    
    public List<CategoryDTO> getAllCategory();
}
