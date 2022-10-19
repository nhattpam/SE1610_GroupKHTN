/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
}
