/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.SQLException;


/**
 *
 * @author Admin
 */
public interface ImportInvoiceDAO {
   //Hung: add new import invoice to import_invoice table
    public boolean addNewInvoice(int quantity, int productID, int branchID)throws SQLException;
}
