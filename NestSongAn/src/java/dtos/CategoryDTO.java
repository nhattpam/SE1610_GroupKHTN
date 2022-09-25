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
public class CategoryDTO {
    private int category_id;
    private String name;
    private String big_category;

    public CategoryDTO() {
    }
    
    public CategoryDTO(int category_id) {
        this.category_id = category_id;
    }
    

    public CategoryDTO(int category_id, String name, String big_category) {
        this.category_id = category_id;
        this.name = name;
        this.big_category = big_category;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBig_category() {
        return big_category;
    }

    public void setBig_category(String big_category) {
        this.big_category = big_category;
    }
    
}
