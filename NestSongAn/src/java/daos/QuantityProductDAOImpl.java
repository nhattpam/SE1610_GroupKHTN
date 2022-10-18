/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.BranchDTO;
import dtos.ProductDTO;
import dtos.QuantityProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class QuantityProductDAOImpl {
    private Connection conn;

    public QuantityProductDAOImpl(Connection conn) {
        this.conn = conn;
    }
    
    //get branch name
    public QuantityProductDTO getBranch(int product_id, int branch_id) {
        ProductDTO p = new ProductDTO();
        BranchDTO b = new  BranchDTO();
        QuantityProductDTO q = new QuantityProductDTO();

        try {
            String sql = "SELECT q.branch_id, b.name, q.product_id, p.name,p.photo, p.price,p.weight, q.quantity from quantity_product q INNER JOIN product p ON q.product_id = p.product_id\n"
                    + "	INNER JOIN branch b ON q.branch_id = b.branch_id where q.product_id = ? and q.branch_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, product_id);
            ps.setInt(2, branch_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setBranch_id(rs.getInt("branch_id"));
                b.setName(rs.getString("name"));
                p.setProduct_id(rs.getInt("product_id"));
                p.setName(rs.getString("name"));
                p.setPhoto(rs.getString("photo"));
                p.setPrice(rs.getFloat("price"));
                p.setWeight(rs.getInt("weight"));
                q.setBranch_id(b);
                q.setProduct_id(p);
                q.setQuantity(rs.getInt("quantity"));
                
                
            }
        } catch (SQLException ex) {
        }
        return q;
    }
}
