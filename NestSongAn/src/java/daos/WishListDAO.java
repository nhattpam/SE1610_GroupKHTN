/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.WishListDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HUNG
 */
public interface WishListDAO {
    //Hung: add item to wishlist
    public boolean addToWishList(int userID, int productID) throws SQLException;
    //Hung: load item with paging
    public List<WishListDTO> getWishlist(int userID, int index)throws SQLException;
    //Hung: return total number of item
    public int getNumsOfItem(int userID)throws SQLException;
    //Hung: delete from wishlist
    public boolean removeFromWishList(int userID, int productID) throws SQLException;
}
