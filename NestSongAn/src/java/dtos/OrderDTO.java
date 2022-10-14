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
public class OrderDTO {
    private String order_id;
    private String delivery_address;
    private String payment_method;
    private String order_date;
    private String delivery_date;
    private float total_price;
    private int status;
    private UsersDTO user_id;
    private ShipperDTO shipper_id;
    private String note;
    private LocationDTO location_id;

    public OrderDTO() {
    }

    public OrderDTO(String order_id, String order_date, int status, UsersDTO user_id) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.status = status;
        this.user_id = user_id;
    }

    

    
    

    public OrderDTO(String order_id, String delivery_address, String payment_method, String order_date, int status, UsersDTO user_id) {
        this.order_id = order_id;
        this.delivery_address = delivery_address;
        this.payment_method = payment_method;
        this.order_date = order_date;
        this.status = status;
        this.user_id = user_id;
    }
    
    
    //order totalPrice
    public OrderDTO(String order_id, String delivery_address, String payment_method, String order_date, float total_price, int status, UsersDTO user_id) {
        this.order_id = order_id;
        this.delivery_address = delivery_address;
        this.payment_method = payment_method;
        this.order_date = order_date;
        this.total_price = total_price;
        this.status = status;
        this.user_id = user_id;
    }

    
    public OrderDTO(String order_id, String delivery_address, String payment_method, String order_date, String delivery_date, float total_price, int status, UsersDTO user_id, ShipperDTO shipper_id, String note, LocationDTO location_id) {
        this.order_id = order_id;
        this.delivery_address = delivery_address;
        this.payment_method = payment_method;
        this.order_date = order_date;
        this.delivery_date = delivery_date;
        this.total_price = total_price;
        this.status = status;
        this.user_id = user_id;
        this.shipper_id = shipper_id;
        this.note = note;
        this.location_id = location_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UsersDTO getUser_id() {
        return user_id;
    }

    public void setUser_id(UsersDTO user_id) {
        this.user_id = user_id;
    }

    public ShipperDTO getShipper_id() {
        return shipper_id;
    }

    public void setShipper_id(ShipperDTO shipper_id) {
        this.shipper_id = shipper_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocationDTO getLocation_id() {
        return location_id;
    }

    public void setLocation_id(LocationDTO location_id) {
        this.location_id = location_id;
    }
    
}
