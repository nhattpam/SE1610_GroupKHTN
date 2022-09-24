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
public class QuantityProductDTO {
    private ProductDTO product_id;
    private BranchDTO branch_id;
    private int quantity;

    public QuantityProductDTO() {
    }

    public QuantityProductDTO(ProductDTO product_id, BranchDTO branch_id, int quantity) {
        this.product_id = product_id;
        this.branch_id = branch_id;
        this.quantity = quantity;
    }

    public ProductDTO getProduct_id() {
        return product_id;
    }

    public void setProduct_id(ProductDTO product_id) {
        this.product_id = product_id;
    }

    public BranchDTO getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(BranchDTO branch_id) {
        this.branch_id = branch_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
