/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainf;

import daos.ProductDAOImpl;
import dtos.CategoryDTO;
import dtos.ProductDTO;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class test {
    public static void main(String[] args) {
        ProductDAOImpl dao = new ProductDAOImpl(DBUtils.getConnection());
        
        List<CategoryDTO> list = dao.getAllCategory();
        for (CategoryDTO object : list) {
            System.out.println(object);
        }
    }
}
