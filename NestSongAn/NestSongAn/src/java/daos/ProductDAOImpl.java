/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.CategoryDTO;
import dtos.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ProductDAOImpl implements ProductDAO {

    private Connection conn;

    public ProductDAOImpl(Connection conn) {
        this.conn = conn;
    }

    //nhatpham: function Them san pham
    @Override
    public boolean addProduct(ProductDTO p) {
        boolean f = false;

        try {
            String sql = "INSERT INTO product (name,code,short_description,full_description,price,weight,photo,create_date,edit_date,category_id,quantity) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getCode());
            ps.setString(3, p.getShort_description());
            ps.setString(4, p.getFull_description());
            ps.setFloat(5, p.getPrice());
            ps.setFloat(6, p.getWeight());
            ps.setString(7, p.getPhoto());
            ps.setString(8, p.getCreate_date());
            ps.setString(9, p.getEdit_date());
            ps.setInt(10, p.getCategory_id().getCategory_id());
            ps.setInt(11, p.getQuantity());

            int i = ps.executeUpdate();
            if (i > 0) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    //khang tran: function View All Product List
    @Override
    public List<ProductDTO> getAllProduct() {

        List<ProductDTO> list = new ArrayList<>();

        try {
            String sql = "select product_id, photo, name, price from product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductDTO p = new ProductDTO();
                p.setProduct_id(rs.getInt("product_id"));
                p.setPhoto(rs.getString("photo"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getFloat("price"));
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public ProductDTO getProductId(int product_id) {
        ProductDTO p = new ProductDTO();

        try {
            String sql = "SELECT product_id, name, code, short_description, full_description, weight, price, photo, category_id, quantity FROM product WHERE product_id = ?";
//            String sql = "SELECT product_id, name, code, short_description, full_description, weight, price, photo, category_id, quantity FROM product WHERE product_id = '" + product_id + "'";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, product_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CategoryDTO category_id = new CategoryDTO(rs.getInt("category_id"));
                p.setProduct_id(rs.getInt("product_id"));
                p.setCategory_id(category_id);
                p.setName(rs.getString("name"));
                p.setCode(rs.getString("code"));
                p.setShort_description(rs.getString("short_description"));
                p.setFull_description(rs.getString("full_description"));
                p.setWeight(rs.getInt("weight"));
                p.setPhoto(rs.getString("photo"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getFloat("price"));
            }
        } catch (SQLException ex) {
        }
        return p;
    }

    //nhatpam: function View all product (staff)
    @Override
    public List<ProductDTO> getAllListProduct() {
        List<ProductDTO> list = new ArrayList<>();

        try {
            String sql = "SELECT product_id,name,code,short_description,full_description,weight,price,create_date,photo,category_id,edit_date FROM product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductDTO p = new ProductDTO();
                CategoryDTO category_id = new CategoryDTO(rs.getInt("category_id"));
                p.setProduct_id(rs.getInt("product_id"));
                p.setName(rs.getString("name"));
                p.setCode(rs.getString("code"));
                p.setShort_description(rs.getString("short_description"));
                p.setFull_description(rs.getString("full_description"));
                p.setWeight(rs.getInt("weight"));
                p.setPrice(rs.getFloat("price"));
                p.setCreate_date(rs.getString("create_date"));
                p.setPhoto(rs.getString("photo"));
                p.setEdit_date(rs.getString("edit_date"));
                p.setCategory_id(category_id);

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void editProduct1(ProductDTO p) {

        try {
            String sql = "UPDATE product set name=?,code=? WHERE product_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getCode());
            ps.setInt(3, p.getProduct_id());

            ps.executeUpdate();
     

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //nhatpham: function edit product
    @Override
    public boolean editProduct(ProductDTO p) {
        boolean f = false;
        try {
            String sql = "UPDATE product set name=?,code=?,short_description=?,full_description=?,weight=?,price=?,"
                    + "photo=?,edit_date=?,category_id=? WHERE product_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getCode());
            ps.setString(3, p.getShort_description());
            ps.setString(4, p.getFull_description());
            ps.setInt(5, p.getWeight());
            ps.setFloat(6, p.getPrice());
            ps.setString(7, p.getPhoto());
            ps.setString(8, p.getEdit_date());
            ps.setInt(9, p.getCategory_id().getCategory_id());
            ps.setInt(10, p.getProduct_id());

            int i = ps.executeUpdate();
            
            if(i == 1){
                f = true;
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
         List<CategoryDTO> list = new ArrayList<>();

        try {
            String sql = "SELECT category_id,name from category";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CategoryDTO c = new CategoryDTO();
                c.setCategory_id(rs.getInt("category_id"));
                c.setName(rs.getString("name"));
                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}