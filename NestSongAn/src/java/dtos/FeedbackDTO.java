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
public class FeedbackDTO {
    private int feedback_id;
    private String feedback;
    private UsersDTO user_id;
    private String create_date;
    private ProductDTO product_id;

    public FeedbackDTO() {
    }

    public FeedbackDTO(int feedback_id, String feedback, UsersDTO user_id, String create_date, ProductDTO product_id) {
        this.feedback_id = feedback_id;
        this.feedback = feedback;
        this.user_id = user_id;
        this.create_date = create_date;
        this.product_id = product_id;
    }

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public UsersDTO getUser_id() {
        return user_id;
    }

    public void setUser_id(UsersDTO user_id) {
        this.user_id = user_id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public ProductDTO getProduct_id() {
        return product_id;
    }

    public void setProduct_id(ProductDTO product_id) {
        this.product_id = product_id;
    }
    
}
