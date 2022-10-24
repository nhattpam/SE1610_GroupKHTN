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
    private String create_date;
    private UsersDTO user_id;
    private ProductDTO product_id;

    public WishListDTO() {
    }

    public WishListDTO(String create_date, UsersDTO user_id, ProductDTO product_id) {
        this.create_date = create_date;
        this.user_id = user_id;
        this.product_id = product_id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
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
