/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Admin
 */
public class WishListDTO {
    private int quantity;
    private UsersDTO user_id;
    private ProductDTO product_id;

    public WishListDTO() {
    }

    public WishListDTO(int quantity, UsersDTO user_id, ProductDTO product_id) {
        this.quantity = quantity;
        this.user_id = user_id;
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UsersDTO getUser_id() {
        return user_id;
    }

    public void setUser_id(UsersDTO user_id) {
        this.user_id = user_id;
    }

    public ProductDTO getProduct_id() {
        return product_id;
    }

    public void setProduct_id(ProductDTO product_id) {
        this.product_id = product_id;
    }
    
    
}
