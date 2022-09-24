/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Admin
 */
public class ProductDTO implements Comparable<ProductDTO> {

    private int product_id;
    private String name;
    private String code;
    private String short_description;
    private String full_description;
    private boolean is_hot_selling;
    private boolean is_out_standing;
    private boolean is_latest;
    private float price;
    private String photo;
    private String create_date;
    private String edit_date;
    private CategoryDTO category_id;
    private int quantity;
    private SupplierDTO supplier_id;

    public ProductDTO() {
    }

    public ProductDTO(int product_id, String name, String code, String short_description, String full_description, boolean is_hot_selling, boolean is_out_standing, boolean is_latest, float price, String photo, String create_date, String edit_date, CategoryDTO category_id, int quantity, SupplierDTO supplier_id) {
        this.product_id = product_id;
        this.name = name;
        this.code = code;
        this.short_description = short_description;
        this.full_description = full_description;
        this.is_hot_selling = is_hot_selling;
        this.is_out_standing = is_out_standing;
        this.is_latest = is_latest;
        this.price = price;
        this.photo = photo;
        this.create_date = create_date;
        this.edit_date = edit_date;
        this.category_id = category_id;
        this.quantity = quantity;
        this.supplier_id = supplier_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getFull_description() {
        return full_description;
    }

    public void setFull_description(String full_description) {
        this.full_description = full_description;
    }

    public boolean isIs_hot_selling() {
        return is_hot_selling;
    }

    public void setIs_hot_selling(boolean is_hot_selling) {
        this.is_hot_selling = is_hot_selling;
    }

    public boolean isIs_out_standing() {
        return is_out_standing;
    }

    public void setIs_out_standing(boolean is_out_standing) {
        this.is_out_standing = is_out_standing;
    }

    public boolean isIs_latest() {
        return is_latest;
    }

    public void setIs_latest(boolean is_latest) {
        this.is_latest = is_latest;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getEdit_date() {
        return edit_date;
    }

    public void setEdit_date(String edit_date) {
        this.edit_date = edit_date;
    }

    public CategoryDTO getCategory_id() {
        return category_id;
    }

    public void setCategory_id(CategoryDTO category_id) {
        this.category_id = category_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SupplierDTO getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(SupplierDTO supplier_id) {
        this.supplier_id = supplier_id;
    }

    @Override
    public int compareTo(ProductDTO p) {
//        return Integer.parseInt(this.product_id) - Integer.parseInt(p.product_id);
        return 0;
    }

}
