/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author HUNG
 */
public class ImportInvoiceDTO {
        private int invoiceId;
        private BranchDTO branch;
        private ProductDTO product;
        private int quantity;
        private String importDate;

    public ImportInvoiceDTO() {
    }

    public ImportInvoiceDTO(int invoiceId, BranchDTO branch, ProductDTO product, int quantity, String importDate) {
        this.invoiceId = invoiceId;
        this.branch = branch;
        this.product = product;
        this.quantity = quantity;
        this.importDate = importDate;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BranchDTO getBranch() {
        return branch;
    }

    public void setBranch(BranchDTO branch) {
        this.branch = branch;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }
        
}
