/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.GoogleDTO;

import dtos.UsersDTO;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author HUNG
 */
public interface UserDAO {

    public UsersDTO checkLogin(String username, String password) throws SQLException, NamingException;
    //hapham: function edit account

    public void editAccount(UsersDTO us, String edited_date) throws SQLException;
    //hapham: function view account

    public UsersDTO viewAccount(int userId) throws SQLException;
    
    //hapham: function view account by google login
    public GoogleDTO viewAcc(String email) throws SQLException;

    //check password
    public boolean checkPassword(String username, String password) throws SQLException;

    //update password
    public void editPassword(int userId, String password) throws SQLException;

    //khangtran: function register account
    public boolean userRegister(UsersDTO us);

    public boolean userRegister(GoogleDTO us);

    public boolean resetPassword(String password, String email) throws SQLException;

    public boolean checkDuplicateEmail(String email) throws SQLException;

    public boolean checkDuplicatePhone(String phone) throws SQLException;

    public boolean checkDuplicateUserName(String username) throws SQLException;

    //
    public UsersDTO viewAccountByEmail(String email) throws SQLException;

    //insert phone to google account
    public void addPhoneToGoogleAccount(UsersDTO us);

    public List<UsersDTO> getUserList();
    
    public List<UsersDTO> getStaffList();
    
    //khang tran: function view list user in admin
     public List<UsersDTO> getAllListUser();
    //hapham: function search account by name
     public List<UsersDTO> searchByName(String fullname);
     
     //nhattpham: get phone by email gg
    public UsersDTO getPhone(String email);
    
    //khang tran: function delete staff account
    public void deteleStaffAccount(int user_id);
    
    public boolean updateStatus(int status, String email) throws SQLException;
    
    public UsersDTO viewAccountStaff(int userId) throws SQLException;
}
