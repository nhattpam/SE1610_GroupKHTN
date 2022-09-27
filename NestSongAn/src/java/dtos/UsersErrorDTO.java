/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author duong
 */
public class UsersErrorDTO {

    private String full_nameError;
    private String emailError;
    private String phoneError;
    private String passwordError;
    private String confirmError;

    public UsersErrorDTO() {
        this.full_nameError = "";
        this.emailError = "";
        this.phoneError = "";
        this.passwordError = "";
        this.confirmError = "";
    }

    public UsersErrorDTO(String full_nameError, String emailError, String phoneError, String passwordError, String confirmError) {
        this.full_nameError = full_nameError;
        this.emailError = emailError;
        this.phoneError = phoneError;
        this.passwordError = passwordError;
        this.confirmError = confirmError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getFull_nameError() {
        return full_nameError;
    }

    public void setFull_nameError(String full_nameError) {
        this.full_nameError = full_nameError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

}

