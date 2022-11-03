/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.BranchDTO;
import dtos.CategoryDTO;
import dtos.ImportInvoiceDTO;
import dtos.ProductDTO;
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
 * @author Admin
 */
public class ImportInvoiceDAOImpl implements ImportInvoiceDAO {

    @Override
    public boolean addNewInvoice(int quantity, int productID, int branchID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        Date now = new Date();
        SimpleDateFormat x = new SimpleDateFormat();
        String create_date = x.format(now);
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "insert into import_invoice(branch_id,product_id,quantity,import_date)\n"
                        + "values (?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, branchID);
                stm.setInt(2, productID);
                stm.setInt(3, quantity);
                stm.setString(4, create_date);
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

    public List<ImportInvoiceDTO> getInvoice() throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs=null;
        List<ImportInvoiceDTO> result = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT p.product_id, p.name, p.code, p.weight, p.price, p.photo,\n"
                        + "p.category_id, c.name as category_name,\n"
                        + "ip.import_invoice_id, ip.quantity, ip.import_date, b.branch_id, b.name as branch_name\n"
                        + "FROM import_invoice ip inner join product p \n"
                        + "on ip.product_id=p.product_id\n"
                        + "inner JOIN category c\n"
                        + "on p.category_id=c.category_id\n"
                        + "inner join branch b\n"
                        + "on ip.branch_id=b.branch_id";
                stm = con.prepareStatement(sql);
                rs=stm.executeQuery();
                while (rs.next()) {
                    CategoryDTO categoryDTO= new CategoryDTO(rs.getInt("category_id"), rs.getString("category_name"));
                    ProductDTO productDTO=new ProductDTO(rs.getInt("product_id"), rs.getString("name"), rs.getString("code"),
                            rs.getFloat("price"), rs.getInt("weight"), rs.getString("photo"), categoryDTO);
                    BranchDTO branchDTO =new BranchDTO(rs.getInt("branch_id"), rs.getString("branch_name"));
                    ImportInvoiceDTO importInvoiceDTO=new ImportInvoiceDTO(rs.getInt("import_invoice_id"), branchDTO, productDTO, rs.getInt("quantity"), rs.getString("import_date"));
                    result.add(importInvoiceDTO);
                }
            }
        } finally {
            if (rs!=null) {
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
}
