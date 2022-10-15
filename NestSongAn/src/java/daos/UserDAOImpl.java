/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.GoogleDTO;
import dtos.UserRoleDTO;
import dtos.UsersDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class UserDAOImpl implements UserDAO {

    private Connection conn;
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public UserDAOImpl() {
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
                String sql = "Select user_id, full_name, user_name, email, phone, r.role_id, role, status "
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
                    int userId = rs.getInt("user_id");
                    String fullname = rs.getString("full_name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    int roleId = rs.getInt("role_id");
                    String role = rs.getString("role");
                    int status=rs.getInt("status");
                    result = new UsersDTO(userId, fullname, username, email, phone, new UserRoleDTO(roleId, role),status);
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
            if (i > 0) {
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
                String sql = "Select full_name, user_name , email, phone\n"
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
                    result = new UsersDTO(userId, fullname, username, email, phone);
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

    @Override
    public void editAccount(UsersDTO us) throws SQLException {
        boolean f = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE users\n"
                        + "SET full_name = ?,\n"
                        + "user_name = ?,\n"
                        + "email = ?,\n"
                        + "phone = ?\n"
                        + "WHERE user_id = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, us.getFull_name());
                stm.setString(2, us.getUser_name());
                stm.setString(3, us.getEmail());
                stm.setString(4, us.getPhone());
                stm.setInt(5, us.getUser_id());
                stm.executeUpdate();
                f = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
//Minh thanh

    @Override
    public boolean userRegister(GoogleDTO us) {

        boolean f = false;

        try {
            String sql = "INSERT INTO users(email,full_name,status,create_date,edited_date,role_id) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, us.getEmail());
            ps.setString(2, us.getName());
            ps.setInt(3, us.getStatus());
            ps.setString(4, us.getCreate_date());
            ps.setString(5, us.getEdit_date());
            ps.setInt(6, us.getRole_id().getRole_id());
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
//Minh thanh 

    public boolean resetPassword(String password, String email) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                con = DBUtils.getConnection();
                String sql = ("UPDATE users SET password = ? WHERE email = ? ");
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setString(2, email);
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
//Minh thanh

    @Override
    public boolean checkDuplicateEmail(String email) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT email FROM users WHERE email =? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
        return check;
    }

    @Override
    public boolean checkDuplicateUserName(String username) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT user_name FROM users WHERE user_name =? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
        return check;
    }

    @Override
    public boolean checkDuplicatePhone(String phone) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT phone FROM users WHERE phone =? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, phone);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
        return check;
    }
//    @Override
    public boolean updateStatus(int status, String email) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE users SET status = 1 WHERE email = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();  
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
        return check;
    }

    @Override
    public GoogleDTO viewAcc(String email) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        GoogleDTO result = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select full_name\n"
                        + "from users\n"
                        + "where email = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullname = rs.getString("full_name");
                    result = new GoogleDTO(email, fullname);
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

    //test lay id gooogle
    @Override
    public UsersDTO viewAccountByEmail(String email) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UsersDTO result = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select user_id, full_name, user_name , password, email, phone from users where email = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullname = rs.getString("full_name");
                    String username = rs.getString("user_name");
                    String password = rs.getString("password");
                    int userId = rs.getInt("user_id");
                    String phone = rs.getString("phone");
                    result = new UsersDTO(userId, fullname, username, password, email, phone);
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

    //insert phone to google account
    @Override
    public void addPhoneToGoogleAccount(UsersDTO us) {

        try {
            String sql = "UPDATE users\n"
                    + "SET phone = ?\n"
                    + "WHERE user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, us.getPhone());
            ps.setInt(2, us.getUser_id());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkPassword(String username, String password) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT user_id \n"
                        + "  FROM users\n"
                        + "  WHERE user_name = ? and password = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }

    @Override
    public void editPassword(int userId, String password) throws SQLException {
        boolean f = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "  UPDATE users\n"
                        + "  SET password = ?\n"
                        + "  WHERE user_id= ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setInt(2, userId);
                stm.executeUpdate();
                f = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    //Minh Thanh
    @Override

    public List<UsersDTO> getUserList() {

        List<UsersDTO> list = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            String sql = "select user_id, full_name, email, phone from users";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new UsersDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<UsersDTO> getStaffList() {
        List<UsersDTO> list = new ArrayList<>();

        try {
            String sql = "Select user_id, full_name, email, phone, create_date, edited_date, status, r.role \n"
                    + " From users u, user_role r \n"
                    + " Where u.role_id = 2\n"
                    + " and u.role_id = r.role_id ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsersDTO u = new UsersDTO();
                UserRoleDTO role = new UserRoleDTO(rs.getString("role"));
                u.setUser_id(rs.getInt("user_id"));
                u.setFull_name(rs.getString("full_name"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                u.setCreate_date(rs.getString("create_date"));
                u.setEdit_date(rs.getString("edited_date"));
                u.setStatus(rs.getInt("status"));
                u.setRole_id(role);
                list.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //khang tran: function view list user in admin
    @Override
    public List<UsersDTO> getAllListUser() {
        List<UsersDTO> list = new ArrayList<>();

        try {
            String sql = "SELECT u.user_id, u.full_name, u.user_name,u.phone, u.email, u.create_date, u.edited_date,u.status, ur.role\n"
                    + " FROM USERS u INNER JOIN user_role ur\n"
                    + " ON u.role_id = ur.role_id\n"
                    + " ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsersDTO u = new UsersDTO();
                UserRoleDTO role = new UserRoleDTO(rs.getString("role"));
                u.setUser_id(rs.getInt("user_id"));
                u.setFull_name(rs.getString("full_name"));
                u.setUser_name(rs.getString("user_name"));
                u.setPhone(rs.getString("phone"));
                u.setEmail(rs.getString("email"));
                u.setCreate_date(rs.getString("create_date"));
                u.setEdit_date(rs.getString("edited_date"));
                u.setStatus(rs.getInt("status"));
                u.setRole_id(role);
                list.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //nhattpham: get phone by email gg
    @Override
    public UsersDTO getPhone(String email) {
        UsersDTO u = new UsersDTO();

        try {
            String sql = "select phone from users where email like '" + email + "'";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                u.setPhone(rs.getString("phone"));
            }
        } catch (SQLException ex) {
        }
        return u;
    }
    
    public UsersDTO viewAccountStaff(int userId) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UsersDTO u = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select user_id, full_name, user_name , email, phone, password\n"
                        + "from users\n"
                        + "where user_id = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, userId);
                rs = stm.executeQuery();
                if (rs.next()) {
                     u = new UsersDTO();
                     u.setFull_name(rs.getString("full_name"));
                     u.setUser_name(rs.getString("user_name"));
                     u.setEmail(rs.getString("email"));
                     u.setPhone(rs.getString("phone"));
                     u.setUser_id(rs.getInt("user_id"));
                     u.setPassword(rs.getString("password"));
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
        return u;
    }

}
