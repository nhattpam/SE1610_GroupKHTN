/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainf;

import daos.ProductDAOImpl;
import daos.UserDAOImpl;
import dtos.CategoryDTO;
import dtos.ProductDTO;
import dtos.UsersDTO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class test {

    public static void main(String[] args) {
        UserDAOImpl dao = new UserDAOImpl(DBUtils.getConnection());
        
        ProductDAOImpl dao1 = new ProductDAOImpl(DBUtils.getConnection());
        int i = dao1.getTotalProductByCategory();
        System.out.println(i);
    }
}
