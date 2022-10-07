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
public class SupplierDTO {
    private int supplier_id;
    private String name;
    private String user_name;
    private String password;
    private String bill;

    public SupplierDTO() {
    }

    public SupplierDTO(int supplier_id, String name, String user_name, String password, String bill) {
        this.supplier_id = supplier_id;
        this.name = name;
        this.user_name = user_name;
        this.password = password;
        this.bill = bill;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }
    
}
