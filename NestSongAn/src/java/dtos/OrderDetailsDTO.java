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
public class OrderDetailsDTO {
    private int order_details_id;
    private int quantity;
    private float total_price;
    private ProductDTO product_id;
    private OrderDTO order_id;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(OrderDTO order_id, ProductDTO product_id, float total_price, int quantity) {
        this.quantity = quantity;
        this.total_price = total_price;
        this.product_id = product_id;
        this.order_id = order_id;
    }
    

    public OrderDetailsDTO(int order_details_id, int quantity, float total_price, ProductDTO product_id, OrderDTO order_id) {
        this.order_details_id = order_details_id;
        this.quantity = quantity;
        this.total_price = total_price;
        this.product_id = product_id;
        this.order_id = order_id;
    }

    public int getOrder_details_id() {
        return order_details_id;
    }

    public void setOrder_details_id(int order_details_id) {
        this.order_details_id = order_details_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public ProductDTO getProduct_id() {
        return product_id;
    }

    public void setProduct_id(ProductDTO product_id) {
        this.product_id = product_id;
    }

    public OrderDTO getOrder_id() {
        return order_id;
    }

    public void setOrder_id(OrderDTO order_id) {
        this.order_id = order_id;
    }
    
    
}
