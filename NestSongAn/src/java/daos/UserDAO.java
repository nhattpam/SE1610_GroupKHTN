/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.GoogleDTO;

import dtos.UsersDTO;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author HUNG
 */
public interface UserDAO {

     public UsersDTO checkLogin(String username, String password) throws SQLException, NamingException;
     //hapham: function edit account
     public void editAccount(UsersDTO us) throws SQLException;
     //hapham: function view account
    public UsersDTO viewAccount(int userId) throws SQLException;
    //hapham: function view account by google login
    public GoogleDTO viewAcc(String email) throws SQLException;
    //khangtran: function register account
    public boolean userRegister(UsersDTO us);
    
    public boolean userRegister(GoogleDTO us);

    public boolean resetPassword(String password, String email) throws SQLException;
    
    public boolean checkDuplicateEmail(String email) throws SQLException;

}
