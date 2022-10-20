/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import utils.DBUtils;

/**
 *
 * @author HUNG
 */
public class WishLishDAOImpl implements WishListDAO {

    @Override
    public boolean addToWishLish(int userID, int productID) throws SQLException {
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
                stm=con.prepareStatement(sql);
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

}
