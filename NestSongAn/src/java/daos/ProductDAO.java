/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.CategoryDTO;
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
    
    //nhatpam: function View all product (staff)
     public List<ProductDTO> getAllListProduct();
     
     //nhatpham: function edit product
    public boolean editProduct(ProductDTO p);
    
    public List<CategoryDTO> getAllCategory();
    
    //khang tran: function search by character
    public List<ProductDTO> getProductBySearch(String character);
    //hapham: funtion get new product
    public List<ProductDTO> getNewProduct() throws SQLException;

    //1. dem so luong sp trong db
    public int getTotalProduct();
    
    //pagingProduct
    public List<ProductDTO> pagingProduct(int index);
    
    //list paging by category
    public List<ProductDTO> pagingProductByCategory(int index, int categoryId);
    
    //1. dem so luong sp trong db
    public int getTotalProductByCategory1();
    
    //hung: sort by price descending
    public List<ProductDTO> getProductDesc() throws SQLException;
    public List<ProductDTO> getProductDesc(int categoryId) throws SQLException ;
    //Hung sort product by price asc
    public List<ProductDTO> getProductAsc() throws SQLException;
    public List<ProductDTO> getProductAsc(int categoryId) throws SQLException ;
}
