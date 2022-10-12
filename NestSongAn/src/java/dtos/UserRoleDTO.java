/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class UserRoleDTO implements Serializable{
    private int role_id;
    private String role;

    public UserRoleDTO() {
    }

    public UserRoleDTO(int role_id) {
        this.role_id = role_id;
    }

    public UserRoleDTO(String role) {
        this.role = role;
    }
    
    
    

    public UserRoleDTO(int role_id, String role) {
        this.role_id = role_id;
        this.role = role;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
