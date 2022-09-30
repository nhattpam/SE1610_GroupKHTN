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
     
     public void editAccount(UsersDTO us) throws SQLException;
     
    public UsersDTO viewAccount(int userId) throws SQLException;
    //khangtran: function register account
    public boolean userRegister(UsersDTO us);
    
    public boolean userRegister(GoogleDTO us);

    public boolean resetPassword(String password, String email) throws SQLException;

}