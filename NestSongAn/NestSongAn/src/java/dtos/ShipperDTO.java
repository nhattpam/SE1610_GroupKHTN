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
public class ShipperDTO {
    private int shipper_id;
    private String user_name;
    private String password;

    public ShipperDTO() {
    }

    public ShipperDTO(int shipper_id, String user_name, String password) {
        this.shipper_id = shipper_id;
        this.user_name = user_name;
        this.password = password;
    }

    public int getShipper_id() {
        return shipper_id;
    }

    public void setShipper_id(int shipper_id) {
        this.shipper_id = shipper_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
