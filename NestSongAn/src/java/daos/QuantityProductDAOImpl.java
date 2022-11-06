/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.BranchDTO;
import dtos.CategoryDTO;
import dtos.ProductDTO;
import dtos.QuantityProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class QuantityProductDAOImpl implements QuantityProductDAO {

    private Connection conn;

    public QuantityProductDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public QuantityProductDAOImpl() {
    }

    //get branch name
    @Override
    public QuantityProductDTO getBranch(int product_id, int branch_id) {
        ProductDTO p = new ProductDTO();
        BranchDTO b = new BranchDTO();
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

    //sub the quantity after buy
    @Override
    public QuantityProductDTO subQuantityAfterBuy(int quantity, int product_id, int branch_id) {
        ProductDTO p = new ProductDTO();
        BranchDTO b = new BranchDTO();
        QuantityProductDTO q = new QuantityProductDTO();

        try {
            String sql = "UPDATE quantity_product\n"
                    + "SET quantity = quantity - '" + quantity + "'"
                    + "WHERE product_id = ? and branch_id = ?";

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

    //Hung
    @Override
    public List<QuantityProductDTO> getProduct() throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<QuantityProductDTO> result = new ArrayList<QuantityProductDTO>();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT p.product_id, p.name, p.code, p.weight, p.price, p.photo, p.category_id, c.name as category_name, qp.branch_id, qp.quantity,b.name as branch_name\n"
                        + "FROM product p inner JOIN category c\n"
                        + "on p.category_id=c.category_id\n"
                        + "inner JOIN quantity_product qp\n"
                        + "on p.product_id=qp.product_id\n"
                        + "inner JOIN branch b\n"
                        + "on qp.branch_id=b.branch_id";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    CategoryDTO categoryDTO = new CategoryDTO(rs.getInt("category_id"), rs.getString("category_name"));
                    ProductDTO productDTO
                            = new ProductDTO(rs.getInt("product_id"), rs.getString("name"), rs.getString("code"),
                                    rs.getFloat("price"), rs.getInt("weight"), rs.getString("photo"), categoryDTO);
                    BranchDTO branchDTO = new BranchDTO(rs.getInt("branch_id"), rs.getString("branch_name"));
                    QuantityProductDTO quantityProductDTO = new QuantityProductDTO(productDTO, branchDTO, rs.getInt("quantity"));
                    result.add(quantityProductDTO);
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
    public List<QuantityProductDTO> getProductbyquantity() {
        List<QuantityProductDTO> result = new ArrayList<QuantityProductDTO>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT p.product_id, p.name, p.code, p.weight, p.price, p.photo, p.category_id, c.name as category_name, qp.branch_id, qp.quantity,b.name as branch_name\n"
                        + "FROM product p inner JOIN category c\n"
                        + "on p.category_id=c.category_id\n"
                        + "inner JOIN quantity_product qp\n"
                        + "on p.product_id=qp.product_id\n"
                        + "inner JOIN branch b\n"
                        + "on qp.branch_id=b.branch_id\n"
                        + "WHERE qp.quantity < 5";
                PreparedStatement stm = conn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    CategoryDTO categoryDTO = new CategoryDTO(rs.getInt("category_id"), rs.getString("category_name"));
                    ProductDTO productDTO
                            = new ProductDTO(rs.getInt("product_id"), rs.getString("name"), rs.getString("code"),
                                    rs.getFloat("price"), rs.getInt("weight"), rs.getString("photo"), categoryDTO);
                    BranchDTO branchDTO = new BranchDTO(rs.getInt("branch_id"), rs.getString("branch_name"));
                    QuantityProductDTO quantityProductDTO = new QuantityProductDTO(productDTO, branchDTO, rs.getInt("quantity"));
                    result.add(quantityProductDTO);
                }
            }
        } catch (Exception e) {

        }
        return result;
    }

    //Hung
    @Override
    public boolean importProduct(int quantity, int productID, int branchID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Update quantity_product\n"
                        + "Set quantity=quantity+?\n"
                        + "Where product_id=? and branch_id=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setInt(2, productID);
                stm.setInt(3, branchID);
                int i = stm.executeUpdate();
                if (i > 0) {
                    result = true;
                }
            }
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
    //insert into quantity_product
    public void addProductQuantity(QuantityProductDTO q) {

        try {
            String sql = "INSERT INTO quantity_product (product_id, branch_id, quantity)\n"
                    + "VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, q.getProduct_id().getProduct_id());
            ps.setInt(2, q.getBranch_id().getBranch_id());
            ps.setInt(3, q.getQuantity());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getQuantityProduct() {
        int result = 0;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT COUNT (*) from quantity_product WHERE quantity < 5";
                PreparedStatement stm = conn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    result = rs.getInt(1);
                }
            }
        } catch (Exception e) {

        }
        return result;
    }
    
    //List product with branch and quantity
    public List<QuantityProductDTO> listProductWithQuantity(int branch_id){
        List<QuantityProductDTO> listProduct = new ArrayList<>();;
        
        QuantityProductDTO q = null;
        ProductDTO p = null;
        BranchDTO b = null;
        String sql = "SELECT p.product_id, p.name, p.category_id, p.code, p.create_date, p.edit_date, p.full_description, p.short_description, p.photo, p.price, p.weight, q.quantity, b.branch_id \n"
                + "FROM quantity_product q \n"
                + "INNER JOIN product p ON q.product_id = p.product_id\n"
                + "INNER JOIN branch b ON b.branch_id = q.branch_id\n"
                + "WHERE q.branch_id = " + branch_id + "";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //product
                p = new ProductDTO();
                CategoryDTO c = new CategoryDTO(rs.getInt("category_id"));
                p.setProduct_id(rs.getInt("product_id"));
                p.setName(rs.getString("name"));
                p.setCode(rs.getString("code"));
                p.setCreate_date(rs.getString("create_date"));
                p.setEdit_date(rs.getString("edit_date"));
                p.setFull_description(rs.getString("full_description"));
                p.setShort_description(rs.getString("short_description"));
                p.setPhoto(rs.getString("photo"));
                p.setPrice(rs.getFloat("price"));
                p.setWeight(rs.getInt("weight"));
                p.setCategory_id(c);
               
                //branch
                b = new BranchDTO(rs.getInt("branch_id"));
                //quantity
                q = new QuantityProductDTO();
                q.setProduct_id(p);
                q.setBranch_id(b);
                q.setQuantity(rs.getInt("quantity"));
                listProduct.add(q);
            }
        } catch (Exception e) {
        }
        return listProduct;
    }
}
