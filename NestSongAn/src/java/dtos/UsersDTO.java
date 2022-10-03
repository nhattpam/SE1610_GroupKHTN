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
public class UsersDTO implements Serializable{ 
    private int user_id;
    private String full_name;
    private String user_name;
    private String password;
    private String reset_key;
    private String email;
    private String phone;
    private int status;
    private String create_date;
    private String edit_date;
    private UserRoleDTO role_id;

    public UsersDTO() {
    }

    public UsersDTO(int user_id, String full_name, String user_name, String password, String email, String phone) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    public UsersDTO(int user_id, String full_name, String user_name, String password, String email, String phone, String create_date, String edit_date) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.create_date = create_date;
        this.edit_date = edit_date;
    }
    

    public UsersDTO(String full_name, String user_name, String password, String email, String phone, int status, String create_date, String edit_date, UserRoleDTO role_id) {
        this.full_name = full_name;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.create_date = create_date;
        this.edit_date = edit_date;
        this.role_id = role_id;
    }
    
    
    
    public UsersDTO(int user_id ,String full_name, String user_name, String email, String phone, UserRoleDTO role_id) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.user_name = user_name;
        this.email = email;
        this.phone = phone;
        this.role_id = role_id;
    }
    public UsersDTO(String user_name, String full_name, String email, String phone, String password){
        this.user_name = user_name;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    
    public UsersDTO(int user_id, String full_name, String user_name, String password, String reset_key, String email, String phone, int status, String create_date, String edit_date, UserRoleDTO role_id) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.user_name = user_name;
        this.password = password;
        this.reset_key = reset_key;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.create_date = create_date;
        this.edit_date = edit_date;
        this.role_id = role_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
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

    public String getReset_key() {
        return reset_key;
    }

    public void setReset_key(String reset_key) {
        this.reset_key = reset_key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getEdit_date() {
        return edit_date;
    }

    public void setEdit_date(String edit_date) {
        this.edit_date = edit_date;
    }

    public UserRoleDTO getRole_id() {
        return role_id;
    }

    public void setRole_id(UserRoleDTO role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "UsersDTO{" + "full_name=" + full_name + ", user_name=" + user_name + ", password=" + password + ", email=" + email + ", phone=" + phone + ", status=" + status + ", create_date=" + create_date + ", edit_date=" + edit_date + ", role_id=" + role_id.getRole_id() + '}';
    }
    
    
}
