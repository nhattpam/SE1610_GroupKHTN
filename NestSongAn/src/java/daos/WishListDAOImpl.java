/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.CategoryDTO;
import dtos.ProductDTO;
import dtos.UsersDTO;
import dtos.WishListDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author HUNG
 */
public class WishListDAOImpl implements WishListDAO {

    @Override
    public boolean addToWishList(int userID, int productID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;

        Date now = new Date();
        SimpleDateFormat x = new SimpleDateFormat();
        String create_date = x.format(now);

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Insert into wishlist(user_id,product_id,create_date)\n"
                        + "values (?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, userID);
                stm.setInt(2, productID);
                stm.setString(3, create_date);
                int i = stm.executeUpdate();
                if (i > 0) {
                    result = true;
                }
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
        return result;
    }

    @Override
    public List<WishListDTO> getWishlist(int userID, int index) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<WishListDTO> result = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select w.product_id, w.user_id, w.create_date, p.name as product_name, p.short_description, p.price,p.photo,c.category_id,c.name as category_name\n"
                        + "from wishlist w\n"
                        + "inner join product p\n"
                        + "on w.product_id=p.product_id\n"
                        + "inner join category c\n"
                        + "on p.category_id=c.category_id\n"
                        + "where user_id=? \n"
                        + "order by w.create_date desc\n"
                        + "Offset ? rows fetch next 5 rows only";
                stm = con.prepareStatement(sql);
                stm.setInt(1, userID);
                stm.setInt(2, (index - 1) * 5);
                rs = stm.executeQuery();
                while (rs.next()) {
                    CategoryDTO categoryDTO = new CategoryDTO(rs.getInt("category_id"), rs.getString("category_name"));
                    ProductDTO productDTO = new ProductDTO(rs.getInt("product_id"), rs.getString("product_name"),
                            rs.getString("short_description"), rs.getFloat("price"), rs.getString("photo"), categoryDTO);
                    UsersDTO usersDTO = new UsersDTO(rs.getInt("user_id"));
                    WishListDTO wishListDTO = new WishListDTO(rs.getString("create_date"), usersDTO, productDTO);
                    result.add(wishListDTO);
                }
            }
        } catch (Exception e) {

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
    public int getNumsOfItem(int userID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 0;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select COUNT(*) as num_rows\n"
                        + "from wishlist\n"
                        + "where user_id=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, userID);
                rs = stm.executeQuery();
                //
                while (rs.next()) {
                    result = rs.getInt("num_rows");
                }
            }
        } catch (Exception e) {

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
    public boolean removeFromWishList(int userID, int productID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Delete from wishlist\n"
                        + "where user_id=? and product_id=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, userID);
                stm.setInt(2, productID);                
                int i = stm.executeUpdate();
                if (i > 0) {
                    result = true;
                }
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
        return result;
    }
}
