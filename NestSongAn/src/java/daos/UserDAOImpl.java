/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.UserRoleDTO;
import dtos.UsersDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class UserDAOImpl implements UserDAO {

    private Connection conn;

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public UsersDTO checkLogin(String username, String password) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UsersDTO result = null;
        try {
            //1. Make connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2. sql statement
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

                    String fullname = rs.getString("full_name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    int roleId = rs.getInt("role_id");
                    String role = rs.getString("role");
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

    //khangtran: function register account
    @Override
    public boolean userRegister(UsersDTO us) {

        boolean f = false;

        try {
            String sql = "INSERT INTO users(full_name,user_name,password,email,phone,status,create_date,edited_date,role_id) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, us.getFull_name());
            ps.setString(2, us.getUser_name());
            ps.setString(3, us.getPassword());
            ps.setString(4, us.getEmail());
            ps.setString(5, us.getPhone());
            ps.setInt(6, us.getStatus());
            ps.setString(7, us.getCreate_date());
            ps.setString(8, us.getEdit_date());
            ps.setInt(9, us.getRole_id().getRole_id());
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public UsersDTO viewAccount(int userId) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UsersDTO result = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select full_name, user_name, email, phone, create_date, edited_date\n"
                        + "from users\n"
                        + "where user_id = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, userId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullname = rs.getString("full_name");
                    String username = rs.getString("user_name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String create_date = rs.getString("create_date");
                    String edited_date = rs.getString("edited_date");
                    result = new UsersDTO(userId, fullname, username, phone, email, phone, create_date, edited_date);
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

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input user_id:");
            int id = sc.nextInt();
            UserDAO user = new UserDAOImpl(DBUtils.getConnection());
            UsersDTO us = user.viewAccount(id);
            System.out.println(us.toString());
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
