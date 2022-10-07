/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Administrator
 */
public class GoogleDTO {
    private String id;
    private String email;
    private String name;
    private int status;
    private String create_date;
    private String edit_date;
    private UserRoleDTO role_id;

    // getter-setter
    public GoogleDTO() {
    }


    public GoogleDTO(String email, String name) {
        this.email = email;
        this.name = name;
    }
    
    public GoogleDTO(String email, String name, int status, String create_date, String edit_date, UserRoleDTO role_id) {
        this.email = email;
        this.name = name;
        this.status = status;
        this.create_date = create_date;
        this.edit_date = edit_date;
        this.role_id = role_id;
    }


    public GoogleDTO(String id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
    public GoogleDTO(String id, String email, String name, int status, String create_date, String edit_date, UserRoleDTO role_id) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.status = status;
        this.create_date = create_date;
        this.edit_date = edit_date;
        this.role_id = role_id;
    }

    public UserRoleDTO getRole_id() {
        return role_id;
    }

    public void setRole_id(UserRoleDTO role_id) {
        this.role_id = role_id;
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

    @Override
    public String toString() {
        return "GoogleDTO{" + "id=" + id + ", email=" + email + ", name=" + name + ", status=" + status + ", create_date=" + create_date + ", edit_date=" + edit_date + ", role_id=" + role_id + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
