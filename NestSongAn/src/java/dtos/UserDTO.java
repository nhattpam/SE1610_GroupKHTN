/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author HUNG
 */
public class UserDTO implements Serializable{
    private int userId;
    private String username;
    private String password;
    private String resetKey;
    private String email;
    private int status;
    private Date createDate;
    private Date editedDate;
    private RoleDTO role;

    public UserDTO(int userId, String username, String password, String resetKey, String email, int status, Date createDate, Date editedDate, RoleDTO role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.resetKey = resetKey;
        this.email = email;
        this.status = status;
        this.createDate = createDate;
        this.editedDate = editedDate;
        this.role = role;
    }

    public UserDTO() {
    }

    public UserDTO(String username, String password, String email, RoleDTO role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResetKey() {
        return resetKey;
    }

    public void setResetKey(String resetKey) {
        this.resetKey = resetKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(Date editedDate) {
        this.editedDate = editedDate;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }
    
    
}
