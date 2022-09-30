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
    private boolean verified_email;
    private String name;
    private String given_name;
    private String family_name;
    private int status;
    private String create_date;
    private String edit_date;
    private String phone;
    private int role;

    // getter-setter
    public GoogleDTO() {
    }

    public GoogleDTO(String email, String name,int status, String create_date, String edit_date) {
        this.email = email;
        this.name = name;
        this.status = status;
        this.create_date = create_date;
        this.edit_date = edit_date;
//        this.role = role;
    }

    public GoogleDTO(String id, String email, boolean verified_email, String name, String given_name, String family_name, int status, String create_date, String edit_date, String phone, int role) {
        this.id = id;
        this.email = email;
        this.verified_email = verified_email;
        this.name = name;
        this.given_name = given_name;
        this.family_name = family_name;
        this.status = status;
        this.create_date = create_date;
        this.edit_date = edit_date;
        this.phone = phone;
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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

    @Override
    public String toString() {
        return "GoogleDTO{" + "id=" + id + ", email=" + email + ", verified_email=" + verified_email + ", name=" + name + ", given_name=" + given_name + ", family_name=" + family_name + ", status=" + status + ", create_date=" + create_date + ", edit_date=" + edit_date + '}';
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

    public boolean isVerified_email() {
        return verified_email;
    }

    public void setVerified_email(boolean verified_email) {
        this.verified_email = verified_email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }
}
