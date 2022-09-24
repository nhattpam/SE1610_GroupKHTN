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
public class UserDAO implements Serializable {

    public UsersDTO checkLogin(String username, String password) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UsersDTO result = null;
        try {
            //1. Make connection
            con=DBUtils.getConnection();                            
            //2. sql statement
            if (con != null) {
                String sql = "Select full_name, user_name, email, phone, r.role_id, role " 
                        + "From users u, user_role r "
                        + "Where user_name = ? "
                        + "And password = ? "
                        + "and u.role_id = r.role_id";
                //3.create statement obj
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4.execute querry
                rs = stm.executeQuery();
                //5.process result
                if (rs.next()) {
                    String fullname=rs.getString("full_name");
                    String email = rs.getString("email");
                    String phone=rs.getString("phone");
                    int roleId = rs.getInt("role_id");
                    String role=rs.getString("role");
                    result = new UsersDTO(fullname, username, email, phone, new UserRoleDTO(roleId, role));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
