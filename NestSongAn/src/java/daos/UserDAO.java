/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.UserRoleDTO;
import dtos.UsersDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author HUNG
 */
public interface UserDAO{
    
     //khangtran: function register account
    public boolean userRegister(UsersDTO us);

     public UsersDTO checkLogin(String username, String password) throws SQLException, NamingException;
}
