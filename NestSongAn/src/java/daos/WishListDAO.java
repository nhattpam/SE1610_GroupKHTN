/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.SQLException;

/**
 *
 * @author HUNG
 */
public interface WishListDAO {
    //Hung: add item to wishlist
    public boolean addToWishLish(int userID, int productID) throws SQLException;
}
